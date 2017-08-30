package io.evilcorp.step00;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Step00StreamsExplicit implements Step00Interface {

    private static final Stream<String> STREAM_UOMINI = Stream.of("Tizio", "Caio", "Sempronio", "Mevio", "Filano", "Calpurnio");
    private static final Stream<String> STREAM_DONNE = Stream.of("Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara");

    // Filtra in modo che rimangano solo i numero minori di 100
    private static final Predicate<Integer> MINORE_DI_CENTO = (Integer integer) -> integer < 100;
    private static final Function<Integer,String> DA_INTERO_A_STRINGA = (Integer integer) -> integer.toString();
    private static final Collector<CharSequence, ?, String> VIRGOLA_E_SPAZIO = Collectors.joining(", ");

    // Stampare 1,2,3
    @Override
    public String stampa123() {
        Stream<Integer> stream = Stream.of(1,2,3);
        Stream<String> stringhe = stream.map(DA_INTERO_A_STRINGA);
        String risultato = stringhe.collect(VIRGOLA_E_SPAZIO);

        return risultato;
    }

    // Stampare i numeri pari tra 1 e 10
    @Override
    public String pariMinoriCento() {
        UnaryOperator<Integer> unaryOperator = (Integer integer) -> integer + 2;

        Stream<Integer> streamPari = Stream.iterate(0, unaryOperator);
        Stream<Integer> pariEMinoriCento = streamPari.filter( MINORE_DI_CENTO );
        Stream<String> stringhe = pariEMinoriCento.map( DA_INTERO_A_STRINGA );
        String elenco = stringhe.collect(VIRGOLA_E_SPAZIO);

        return elenco;
    }


    // Stampare i multipli di 7 tra 1 e 100
    @Override
    public String multipliSetteMinoriCento() {
        UnaryOperator<Integer> unaryOperator = (Integer integer) -> integer + 7;

        Stream<Integer> multipliSette = Stream.iterate(0, unaryOperator);
        Stream<Integer> multipliSetteMinoriCento = multipliSette.filter( MINORE_DI_CENTO );
        Stream<String> stringhe = multipliSetteMinoriCento.map(DA_INTERO_A_STRINGA);
        String elenco = stringhe.collect(VIRGOLA_E_SPAZIO);

        return elenco;
    }

    // Dall'elenco degli uomini, restituire quelli che cominciano per "C"
    @Override
    public String inizianoPerC() {
        Predicate<String> predicate = (String string) -> string.startsWith("C");

        Stream<String> stream = STREAM_UOMINI;
        Stream<String> inizianoPerC = stream.filter(predicate);
        String risultato = inizianoPerC.collect(VIRGOLA_E_SPAZIO);

        return risultato;
    }

    // Calcolare la media dei multipli di 8 compresi tra 1 e 100
    @Override
    public Double mediaMultipliOtto() {
        IntUnaryOperator multipliDiOtto = (int i) -> i + 8;
        IntPredicate verificaMinoriDiCento = (int i) -> i < 100;

        IntStream intStream = IntStream.iterate(0, multipliDiOtto);
        IntStream minoriDiCento = intStream.filter(verificaMinoriDiCento);
        OptionalDouble optionalDouble = minoriDiCento.average();

        Double result = null;
        if(optionalDouble.isPresent()){
            result = optionalDouble.getAsDouble();
        }

        return result;
    }

    // Calcolare la somma dei multipli di 6 compresi tra 1 e 100
    @Override
    public int sommaMultipliSei() {
        IntUnaryOperator intUnaryOperator = (int i) -> i + 6;
        IntPredicate intPredicate = (int i) -> i < 100;

        IntStream intStream = IntStream.iterate(0, intUnaryOperator);
        IntStream minoriDiCento = intStream.filter(intPredicate);
        int somma = minoriDiCento.sum();

        return somma;
    }

    // Dall'elenco degli uomini, ordinarli alfabeticamente e restituire.
    @Override
    public String ordinamentoEStampa() {
        Stream<String> stream = STREAM_UOMINI;
        Stream<String> ordinati = stream.sorted();
        String risultato = ordinati.collect(VIRGOLA_E_SPAZIO);
        return risultato;
    }

    // Tra i numeri da 1 a 100 trovarne uno qualunque divisibile per 41 e stamparlo
    @Override
    public int divisibileQuarantuno() {
        IntPredicate divisibileQuarantuno = (int i) -> i % 41 == 0;

        IntStream intStream = IntStream.range(0,100);
        IntStream divisibili = intStream.filter(divisibileQuarantuno);
        OptionalInt optionalInt = divisibili.findAny();

        int result = -1;
        if(optionalInt.isPresent()){
            result = optionalInt.getAsInt();
        }

        return result;
    }

    // Dall'elenco degli uomini, produrre la stringa che li contiene intervallati da virgola e spazio
    @Override
    public String unione() {
        Stream<String> stream = STREAM_UOMINI;
        String intervallati = stream.collect(VIRGOLA_E_SPAZIO);
        return intervallati;
    }

    // Dall'elenco degli uomini, creare un insieme
    @Override
    public Set<String> daStringheAInsieme() {
        Stream<String> stream = STREAM_UOMINI;
        Set<String> insieme = stream.collect(Collectors.toSet());
        return insieme;
    }

    // Dall'elenco delle donne, raggruppare per la lunghezza del nome
    @Override
    public Map<Integer, List<String>> raggruppareLunghezzaNome() {
        Function<String, Integer> calcolaLunghezza = (String string) -> string.length();

        Stream<String> stream = STREAM_DONNE;
        Map<Integer, List<String>> map = stream.collect(Collectors.groupingBy(calcolaLunghezza));

        return map;
    }

    // Dall'elenco delle donne, stampare solamente le lunghezze dei loro nomi
    @Override
    public String lunghezzeNomi() {
        Function<String, Integer> calcolaLunghezza = (String string) -> string.length();

        Stream<String> stream = STREAM_DONNE;
        Stream<Integer> lunghezze = stream.map(calcolaLunghezza);
        Stream<String> lunghezzeStringa = lunghezze.map(DA_INTERO_A_STRINGA);
        String risultato = lunghezzeStringa.collect(VIRGOLA_E_SPAZIO);

        return risultato;
    }

    // Dall'elenco delle donne, stampare solamente le iniziali dei loro nomi
    @Override
    public String inizialiNomi() {
        Function<String,String> prendiIniziale = (String string) -> string.substring(0,1);

        Stream<String> stream = STREAM_DONNE;
        Stream<String> iniziali = stream.map(prendiIniziale);
        String risultato = iniziali.collect(VIRGOLA_E_SPAZIO);

        return risultato;
    }
}
