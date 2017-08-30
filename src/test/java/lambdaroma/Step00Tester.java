package io.evilcorp;

import io.evilcorp.step00.Step00Imperative;
import io.evilcorp.step00.Step00Interface;
import io.evilcorp.step00.Step00StreamsExplicit;
import org.junit.Assert;
import org.junit.Test;

public class Step00Tester {

    public void verifica(Step00Interface daVerificare){
        Assert.assertEquals("1, 2, 3", daVerificare.stampa123());
    }

    @Test
    public void verificaImperativo(){
        verifica(new Step00Imperative());
    }

    @Test
    public void verificaStream(){
        verifica(new Step00StreamsExplicit());
    }

}
