package lambdaroma;

import lambdaroma.katazero.KataZeroImperativo;
import lambdaroma.katazero.KataZeroInterfaccia;
import lambdaroma.katazero.KataZeroStreamEspliciti;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.*;

public class VerificaKataZero {

    public void verifica(KataZeroInterfaccia daVerificare){
        assertEquals(Arrays.asList(1,2,3), daVerificare.kataZeroA());
        assertEquals(Arrays.asList(2,4,6,8,10), daVerificare.kataZeroB());
        assertEquals(Arrays.asList(0, 7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84, 91, 98), daVerificare.kataZeroC());
        assertEquals(Arrays.asList("Caio","Calpurnio"), daVerificare.kataZeroD());
        assertEquals(new Double(52), daVerificare.kataZeroE());
        assertEquals(83166, daVerificare.kataZeroF());
        assertEquals(Arrays.asList("Caio","Calpurnio","Filano", "Mevio", "Sempronio", "Tizio"),
                daVerificare.kataZeroG());
        Assert.assertTrue(daVerificare.kataZeroH() % 41 == 0);
        assertEquals("Tizio, Caio, Sempronio, Mevio, Filano, Calpurnio",
                daVerificare.kataZeroI());
        assertEquals(new HashSet<>(Arrays.asList("Tizio", "Caio", "Sempronio", "Mevio", "Filano", "Calpurnio")),
                daVerificare.kataZeroJ());

        Map<Integer,List<String>> lunghezzeNomi = new HashMap<>();
        lunghezzeNomi.put(4, Arrays.asList("Anna","Emma","Sara"));
        lunghezzeNomi.put(5, Arrays.asList("Carla","Maria"));
        lunghezzeNomi.put(6, Arrays.asList("Angela","Chiara"));
        assertEquals(lunghezzeNomi, daVerificare.kataZeroK());

        assertEquals(Arrays.asList(4,5,6,6,4,5,4), daVerificare.kataZeroL());
        assertEquals(Arrays.asList("A","C","A","C","E","M","S"), daVerificare.kataZeroM());

    }

    @Test
    public void verificaImperativo(){
        verifica(new KataZeroImperativo());
    }

    @Test
    public void verificaStream(){
        verifica(new KataZeroStreamEspliciti());
    }

}
