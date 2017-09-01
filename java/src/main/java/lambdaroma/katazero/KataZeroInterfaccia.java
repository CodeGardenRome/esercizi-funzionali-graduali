package lambdaroma.katazero;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface KataZeroInterfaccia {

    static final List<String> ELENCO_UOMINI = Arrays.asList("Tizio", "Caio", "Sempronio", "Mevio", "Filano", "Calpurnio");
    static final List<String> ELENCO_DONNE = Arrays.asList("Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara");

    List<Integer> kataZeroA();

    List<Integer> kataZeroB();

    List<Integer> kataZeroC();

    List<String> kataZeroD();

    Double kataZeroE();

    int kataZeroF();

    List<String> kataZeroG();

    int kataZeroH();

    String kataZeroI();

    Set<String> kataZeroJ();

    Map<Integer,List<String>> kataZeroK();

    List<Integer> kataZeroL();

    List<String> kataZeroM();
}
