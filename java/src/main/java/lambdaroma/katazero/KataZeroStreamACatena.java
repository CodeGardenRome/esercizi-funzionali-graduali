package lambdaroma.katazero;

import java.util.*;
import java.util.stream.*;

/***
 * Soluzioni compatte del primo esercizio. Sono soluzioni più brevi, ma più difficili da capire.
 */
public class KataZeroStreamACatena implements KataZeroInterfaccia {

    @Override
    public List<Integer> kataZeroA() {
        return Stream.of(1,2,3)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> kataZeroB() {
        return Stream.iterate(2, i -> i + 2 )
                .limit(50l)
                .filter(i -> i <= 10)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> kataZeroC() {
        return Stream.iterate(0, i -> i + 7 )
                .limit(50l)
                .filter(i -> i < 100)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> kataZeroD() {
        return ELENCO_UOMINI.stream()
                .filter(s -> s.startsWith("C"))
                .collect(Collectors.toList());
    }

    @Override
    public Double kataZeroE() {
        return DoubleStream.iterate(8, i -> i + 8.0D)
                .limit(100l)
                .filter(i -> i < 100.0D)
                .average()
                .getAsDouble();
    }

    @Override
    public int kataZeroF() {
        return IntStream.iterate(0, i -> i + 6)
                .limit(1000l)
                .filter(i -> i < 1000)
                .sum();
    }

    @Override
    public List<String> kataZeroG() {
        return ELENCO_UOMINI.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public int kataZeroH() {
        return IntStream.range(0,1000)
                .parallel()
                .filter(i -> i % 41 == 0)
                .findAny()
                .getAsInt();
    }

    @Override
    public String kataZeroI() {
        return ELENCO_UOMINI
                .stream()
                .collect(Collectors.joining(", "));
    }

    @Override
    public Set<String> kataZeroJ() {
        return ELENCO_UOMINI.stream()
                .collect(Collectors.toSet());
    }

    @Override
    public Map<Integer, List<String>> kataZeroK() {
        return ELENCO_DONNE.stream()
                .collect(Collectors.groupingBy(s -> s.length()));
    }

    @Override
    public List<Integer> kataZeroL() {
        return ELENCO_DONNE.stream()
                .map(s -> s.length())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> kataZeroM() {
        return ELENCO_DONNE.stream()
                .map(s -> s.substring(0,1))
                .collect(Collectors.toList());
    }
}
