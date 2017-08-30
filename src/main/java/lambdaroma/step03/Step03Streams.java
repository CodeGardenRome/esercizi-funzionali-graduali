package io.evilcorp.step03;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Step03Streams implements BiFunction<Set<String>, String, String> {
    @Override
    public String apply(Set<String> strings, String s) {
        return Arrays.stream(s.split(" "))
                .map(s1 -> isCensored(s1, strings) ?
                        String.join("", Collections.nCopies(s1.length(), String.valueOf("X")))
                        : s1)
                .collect(Collectors.joining(" "));
    }

    boolean isCensored(String s, Set<String> strings){
        return strings.stream()
                .anyMatch(x->s.startsWith(x));
    }
}
