package io.evilcorp.step02;

import java.util.Arrays;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

public class Step02Streams implements BiFunction<Set<String>, String,  String> {
    @Override
    public String apply(Set<String> strings, String s) {
        return Arrays.stream(s.split(" "))
                .map(s1 -> isCensored(s1, strings) ? censor(s1) : s1)
                .collect(Collectors.joining(" "));
    }

    String censor(String s){
        IntUnaryOperator intUnaryOperator = (i)-> Character.isAlphabetic(i) ? 'X' : i;
        return s.chars()
                .map(intUnaryOperator)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    boolean isCensored(String s, Set<String> strings){
        s = s.replaceAll("[^a-zA-Z]", "");
        return strings.contains(s);
    }

}
