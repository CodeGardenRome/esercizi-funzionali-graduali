package io.evilcorp.step01;

import java.util.StringJoiner;
import java.util.function.UnaryOperator;

public class Step01Imperative implements UnaryOperator<String> {
    @Override
    public String apply(String s) {
        String[] words = s.split(" ");
        StringJoiner joiner = new StringJoiner(" ");
        for(String word : words){
            joiner.add( word.equalsIgnoreCase("nice") ? "XXXX" : word );
        }
        return joiner.toString();
    }
}
