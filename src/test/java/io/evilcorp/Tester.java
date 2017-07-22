package io.evilcorp;

import io.evilcorp.step01.Step01Imperative;
import io.evilcorp.step01.Step01Javaslang;
import io.evilcorp.step01.Step01StreamsExplicit;
import io.evilcorp.step01.Step01StreamsImplicit;
import io.evilcorp.step02.Step02Imperative;
import io.evilcorp.step02.Step02Javaslang;
import io.evilcorp.step02.Step02Streams;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public class Tester {

    @Test
    public void step01(){
        step01Test(new Step01Imperative());
        step01Test(new Step01StreamsExplicit());
        step01Test(new Step01StreamsImplicit());
        step01Test(new Step01Javaslang());
    }

    @Test
    public void step02(){
        step02Test(new Step02Imperative());
        step02Test(new Step02Streams());
    }

    public void step01Test(UnaryOperator<String> unaryOperator){
        String input = "You are a nice person";
        String expected = "You are a XXXX person";
        String output = unaryOperator.apply(input);
        Assert.assertEquals(unaryOperator.getClass().toString(), expected, output);
    }

    public void step02Test(BiFunction<Set<String>, String, String> biFunction){
        String input = "Such a nice day with a bright sun, makes me happy";
        String expected = "Such a XXXX day with a bright XXX, makes me XXXXX";
        Set<String> blacklistedWords = new HashSet<String>(Arrays.asList("nice", "pony", "sun", "light", "fun", "happy", "funny", "joy"));
        String output = biFunction.apply(blacklistedWords, input);
        Assert.assertEquals(biFunction.getClass().toString(), expected, output);
    }
}
