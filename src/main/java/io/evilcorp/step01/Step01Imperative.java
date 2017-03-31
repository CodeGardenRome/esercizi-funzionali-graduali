package io.evilcorp.step01;

import java.util.StringJoiner;
import java.util.function.UnaryOperator;

public class Step01Imperative implements UnaryOperator<String> {
    @Override
    public String apply(String s) {
        String[] strings = s.split(" ");
        StringJoiner joiner = new StringJoiner(" ");
        for(String string : strings){
            joiner.add( string.equalsIgnoreCase("nice") ? "XXXX" : string );
        }
        return joiner.toString();
    }
}
