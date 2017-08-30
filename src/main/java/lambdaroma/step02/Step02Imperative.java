package io.evilcorp.step02;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiFunction;

public class Step02Imperative implements BiFunction<Set<String>, String, String> {

    @Override
    public String apply(Set<String> strings, String s) {
        for(String string : strings){
            String censored = String.join("", Collections.nCopies(string.length(), String.valueOf("X")));
            s = s.replaceAll(string, censored);
        }
        return s;
    }
}
