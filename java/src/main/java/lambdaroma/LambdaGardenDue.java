package lambdaroma;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class LambdaGardenDue {

    static class Cella{
        public Cella(int x, int y){
            this.x=x;
            this.y=y;
        }
        public int x,y;

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Cella))return false;
            Cella altra = (Cella)obj;
            return this.x==altra.x && this.y==altra.y;
        }

        @Override
        public String toString() {
            return "x: " + x + ", y: " + y;
        }
    }

    public Character aggrega(Character a, Character b){
        if(a=='X' && b=='X')return 'X';
        if(a=='O' && b=='O')return 'O';
        return ' ';
    }

    public char vincitore(Character[] riga){
        Optional<Character> risultato = Arrays.stream(riga).reduce(this::aggrega);
        return risultato.get();
    }

    public Cella cellaSuccessivaRighe(Cella c){
        return new Cella(c.x,c.y+1);
    }

    public Cella cellaSuccessivaColonne(Cella c){
        return new Cella(c.x+1,c.y);
    }

    public Cella cellaSuccessivaDiagonaleMaggiore(Cella c){
        return new Cella(c.x+1,c.y+1);
    }

    public Cella cellaSuccessivaDiagonaleMinore(Cella c){
        return new Cella(c.x-1,c.y+1);
    }

    Optional<Character> estrai(Character[][] partita, Cella cella){
        if(cella.x<partita.length && cella.y<partita.length) {
            return Optional.of(partita[cella.x][cella.y]);
        }else{
            return Optional.empty();
        }

    }

    public Character[] generaVettoreGen(Character[][] partita, Cella inizio, UnaryOperator<Cella> successore){
        return Stream.iterate(inizio,successore)
                .limit(partita.length * partita.length)
                .map(cella -> estrai(partita,cella))
                .filter(opt -> opt.isPresent())
                .map(opt -> opt.get())
                .toArray(size->new Character[size]);
    }

    public Character[] generaVettore(Character[][] partita, Cella inizio, UnaryOperator<Cella> successore){
        return Stream.iterate(inizio,successore)
                .limit(partita.length)
                .map(cella -> partita[cella.x][cella.y])
                .toArray(size->new Character[size]);
    }

    public Character aggregaVincitore(Character a, Character b){
        if(a=='X' && b==' ') return 'X';
        if(a==' ' && b=='X') return 'X';
        if(a=='O' && b==' ') return 'O';
        if(a==' ' && b=='O') return 'O';
        if(a==' ' && b==' ') return ' ';
        throw new IllegalArgumentException();
    }

    public Character trovaVincitoreRighe(Character[][] partita){
        Optional<Character> opt = Arrays.stream(partita)
                .map(riga -> Arrays.stream(riga))
                .map(stream->stream.reduce(this::aggrega))
                .map(optional->optional.get())
                .reduce(this::aggrega);
        return opt.get();
    }

    public Character trovaVincitore(Character[][] partita, UnaryOperator<Cella> successore){
        Optional<Character> opt = Stream.iterate(new Cella(0,0),this::cellaSuccessivaRighe)
                .limit(partita.length)
                .map(cella ->  generaVettore(partita,cella, this::cellaSuccessivaColonne))
                .map(riga -> Arrays.stream(riga))
                .map(stream->stream.reduce(this::aggrega))
                .map(optional->optional.get())
                .reduce(this::aggrega);
        return opt.get();
    }

    public Character trovaVincitoreColonne(Character[][] partita){
        return trovaVincitore(partita, this::cellaSuccessivaColonne);
    }

    public Character trovaVincitoreDiagonaleMaggiore(Character[][] partita){
        return trovaVincitore(partita, this::cellaSuccessivaDiagonaleMaggiore);
    }

    public Character trovaVincitoreDiagonaleMinore(Character[][] partita){
        return trovaVincitore(partita, this::cellaSuccessivaDiagonaleMinore);
    }

    public Character vincitoreMatrice(Character[][] partita){
        Character righe = trovaVincitoreRighe(partita);
        Character colonne = trovaVincitoreColonne(partita);
        Character diagonaleMaggiore = trovaVincitoreDiagonaleMaggiore(partita);
        Character diagonaleMinore = trovaVincitoreDiagonaleMinore(partita);
        Optional<Character> optional = Stream.of(righe,colonne,diagonaleMaggiore, diagonaleMinore)
                .reduce(this::aggregaVincitore);
        return optional.get();
    }
}

