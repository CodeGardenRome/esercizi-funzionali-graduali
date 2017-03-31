package io.evilcorp;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.UnaryOperator;

public class Tester {

    @Test
    public void step01(){
        step01Test(new Step01Imperative());
        step01Test(new Step01StreamsExplicit());
        step01Test(new Step01StreamsImplicit());
        step01Test(new Step01Javaslang());
    }

    public void step01Test(UnaryOperator<String> unaryOperator){
        String input = "You are a nice person";
        String expected = "You are a XXXX person";
        String output = unaryOperator.apply(input);
        Assert.assertEquals(unaryOperator.getClass().toString(), expected, output);
    }


}
