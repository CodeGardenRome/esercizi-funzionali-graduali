package io.evilcorp.step00;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Step00Streams implements Step00Interface {

    // Filtra in modo che rimangano solo i numero minori di 100
    private static final Predicate<Integer> minoreDiCento = (Integer integer) -> integer < 100;
    private static final Function<Integer,String> daInteroAStringa = (Integer integer) -> integer.toString();
    private static final Collector<CharSequence, ?, String> puntoESpazio = Collectors.joining(", ");

    // Stampare 1,2,3
    @Override
    public String stampa123() {
        return Stream.of("1","2","3").collect(Collectors.joining(", "));
    }

    @Override
    public String pariMinoriCento() {
        UnaryOperator<Integer> unaryOperator = (Integer integer) -> integer + 2;

        Stream<Integer> streamPari = Stream.iterate(0, unaryOperator);
        Stream<Integer> pariEMinoriCento = streamPari.filter( minoreDiCento );
        Stream<String> stringhe = pariEMinoriCento.map( daInteroAStringa );
        String elenco = stringhe.collect( puntoESpazio );

        return elenco;
    }

    @Override
    public String multipliSetteMinoriCento() {
        UnaryOperator<Integer> unaryOperator = (Integer integer) -> integer + 7;

        Stream<Integer> multipliSette = Stream.iterate(0, unaryOperator);
        Stream<Integer> multipliSetteMinoriCento = multipliSette.filter( minoreDiCento );
        Stream<String> stringhe = multipliSetteMinoriCento.map(daInteroAStringa);
        String elenco = stringhe.collect(puntoESpazio);

        return null;
    }

    @Override
    public String inizianoPerC() {
        return null;
    }

    @Override
    public Double mediaMultipliOtto() {
        return null;
    }

    @Override
    public int sommaMultipliSei() {
        return 0;
    }

    @Override
    public String ordinamentoEStampa() {
        return null;
    }

    @Override
    public int divisibileQuarantuno() {
        return 0;
    }

    @Override
    public String unione() {
        return null;
    }

    @Override
    public Set<String> daStringheAInsieme() {
        return null;
    }

    @Override
    public Map<Integer, List<String>> raggruppareLunghezzaNome() {
        return null;
    }

    @Override
    public String lunghezzeNomi() {
        return null;
    }

    @Override
    public String inizialiNomi() {
        return null;
    }
}
