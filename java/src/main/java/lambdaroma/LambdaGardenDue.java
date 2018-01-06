package lambdaroma;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaGardenDue {

    class Cella{
        public Cella(int x, int y){
            this.x=x;
            this.y=y;
        }
        public int x,y;
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

    public Character[] generaVettore(Character[][] partita, Cella inizio, UnaryOperator<Cella> successore){
        return Stream.iterate(inizio,successore)
                .limit(partita.length * partita.length)
                .map(cella -> estrai(partita,cella))
                .filter(opt -> opt.isPresent())
                .map(opt -> opt.get())
                .toArray(size->new Character[size]);
    }
}

