package lambdaroma;

import lambdaroma.step01.Step01Imperative;
import lambdaroma.step01.Step01Vavr;
import lambdaroma.step01.Step01StreamsExplicit;
import lambdaroma.step01.Step01StreamsImplicit;
import lambdaroma.step02.Step02Imperative;
import lambdaroma.step02.Step02Streams;
import lambdaroma.step03.Step03Imperative;
import lambdaroma.step03.Step03Streams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

@Tag("fast")
public class Step01to03Test {

    @Test
    public void step01(){
        step01Test(new Step01Imperative());
        step01Test(new Step01StreamsExplicit());
        step01Test(new Step01StreamsImplicit());
        step01Test(new Step01Vavr());
    }

    @Test
    public void step02(){
        step02Test(new Step02Imperative());
        step02Test(new Step02Streams());
    }

    @Test
    public void step03(){
        step03Test(new Step03Imperative());
        step03Test(new Step03Streams());
    }

    public void step01Test(UnaryOperator<String> unaryOperator){
        String input = "You are a nice person";
        String expected = "You are a XXXX person";
        String output = unaryOperator.apply(input);
        Assertions.assertEquals(unaryOperator.getClass().toString(), expected, output);
    }

    public void step02Test(BiFunction<Set<String>, String, String> biFunction){
        String input = "Such a nice day with a bright sun, makes me happy";
        String expected = "Such a XXXX day with a bright XXX, makes me XXXXX";
        Set<String> blacklistedWords = new HashSet<String>(Arrays.asList("nice", "pony", "sun", "light", "fun", "happy", "funny", "joy"));
        String output = biFunction.apply(blacklistedWords, input);
        Assertions.assertEquals(biFunction.getClass().toString(), expected, output);
    }

    public void step03Test(BiFunction<Set<String>, String, String> biFunction){
        String input = "You are so friendly!";
        String expected = "You are so XXXXXXXXX";
        Set<String> blacklistedWords = new HashSet<String>(Arrays.asList("friend", "nice", "pony", "sun", "light", "fun", "happy", "funny", "joy"));
        String output = biFunction.apply(blacklistedWords, input);
        Assertions.assertEquals(biFunction.getClass().toString(), expected, output);
    }
}
