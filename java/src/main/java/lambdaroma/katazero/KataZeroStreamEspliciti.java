package lambdaroma.katazero;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class KataZeroStreamEspliciti implements KataZeroInterfaccia {
    private static final Predicate<Integer> MINORE_DI_DIECI = (Integer integer) -> integer <= 10;
    private static final Predicate<Integer> MINORE_DI_CENTO = (Integer integer) -> integer <= 100;
    private static final Collector<CharSequence, ?, String> VIRGOLA_E_SPAZIO = Collectors.joining(", ");

    @Override
    public List<Integer> kataZeroA() {
        Stream<Integer> stream = Stream.of(1,2,3);
        return stream.collect(Collectors.toList());
    }

    @Override
    public List<Integer> kataZeroB() {
        UnaryOperator<Integer> unaryOperator = (Integer integer) -> integer + 2;

        Stream<Integer> streamPari = Stream.iterate(2, unaryOperator).limit(50l);
        Stream<Integer> pariEMinoriCento = streamPari.filter(MINORE_DI_DIECI);
        return pariEMinoriCento.collect(Collectors.toList());

    }


    @Override
    public List<Integer> kataZeroC() {
        UnaryOperator<Integer> unaryOperator = (Integer integer) -> integer + 7;

        Stream<Integer> multipliSette = Stream.iterate(0, unaryOperator).limit(50l);
        Stream<Integer> multipliSetteMinoriCento = multipliSette.filter(MINORE_DI_CENTO);
        return multipliSetteMinoriCento.collect(Collectors.toList());
    }

    @Override
    public List<String> kataZeroD() {
        Predicate<String> predicate = (String string) -> string.startsWith("C");

        Stream<String> stream = ELENCO_UOMINI.stream();
        Stream<String> inizianoPerC = stream.filter(predicate);
        return inizianoPerC.collect(Collectors.toList());
    }

    @Override
    public Double kataZeroE() {
        DoubleUnaryOperator multipliDiOtto = (double i) -> i + 8.0D;
        DoublePredicate verificaMinoriDiCento = (double i) -> i < 100.0D;

        DoubleStream doubleStream = DoubleStream.iterate(8, multipliDiOtto).limit(100l);
        DoubleStream minoriDiCento = doubleStream.filter(verificaMinoriDiCento);
        OptionalDouble optionalDouble = minoriDiCento.average();

        Double result = null;
        if(optionalDouble.isPresent()){
            result = optionalDouble.getAsDouble();
        }

        return result;
    }

    @Override
    public int kataZeroF() {
        IntUnaryOperator intUnaryOperator = (int i) -> i + 6;
        IntPredicate intPredicate = (int i) -> i < 1000;

        IntStream intStream = IntStream.iterate(0, intUnaryOperator).limit(1000l);
        IntStream minoriDiMille = intStream.filter(intPredicate);
        int somma = minoriDiMille.sum();

        return somma;
    }

    @Override
    public List<String> kataZeroG() {
        Stream<String> stream = ELENCO_UOMINI.stream();
        Stream<String> ordinati = stream.sorted();
        return ordinati.collect(Collectors.toList());
    }

    @Override
    public int kataZeroH() {
        IntPredicate divisibileQuarantuno = (int i) -> i % 41 == 0;

        IntStream intStream = IntStream.range(0,1000).parallel();
        IntStream divisibili = intStream.filter(divisibileQuarantuno);
        OptionalInt optionalInt = divisibili.findAny();

        int result = -1;
        if(optionalInt.isPresent()){
            result = optionalInt.getAsInt();
        }

        return result;
    }

    @Override
    public String kataZeroI() {
        Stream<String> stream = ELENCO_UOMINI.stream();
        String intervallati = stream.collect(VIRGOLA_E_SPAZIO);
        return intervallati;
    }

    @Override
    public Set<String> kataZeroJ() {
        Stream<String> stream = ELENCO_UOMINI.stream();
        Set<String> insieme = stream.collect(Collectors.toSet());
        return insieme;
    }

    @Override
    public Map<Integer, List<String>> kataZeroK() {
        Function<String, Integer> calcolaLunghezza = (String string) -> string.length();

        Stream<String> stream = ELENCO_DONNE.stream();
        Map<Integer, List<String>> map = stream.collect(Collectors.groupingBy(calcolaLunghezza));

        return map;
    }

    @Override
    public List<Integer> kataZeroL() {
        Function<String, Integer> calcolaLunghezza = (String string) -> string.length();

        Stream<String> stream = ELENCO_DONNE.stream();
        Stream<Integer> lunghezze = stream.map(calcolaLunghezza);
        return lunghezze.collect(Collectors.toList());
    }

    @Override
    public List<String> kataZeroM() {
        Function<String,String> prendiIniziale = (String string) -> string.substring(0,1);

        Stream<String> stream = ELENCO_DONNE.stream();
        Stream<String> iniziali = stream.map(prendiIniziale);
        return iniziali.collect(Collectors.toList());
    }
}
