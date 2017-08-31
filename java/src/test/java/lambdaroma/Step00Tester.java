package lambdaroma;

import lambdaroma.katazero.KataZeroImperativo;
import lambdaroma.katazero.KataZeroInterfaccia;
import lambdaroma.katazero.KataZeroStreamEspliciti;
import org.junit.Assert;
import org.junit.Test;

public class Step00Tester {

    public void verifica(KataZeroInterfaccia daVerificare){
        Assert.assertEquals("1, 2, 3", daVerificare.kataZeroA());
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
