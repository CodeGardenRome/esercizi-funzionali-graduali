package io.evilcorp;

import java.util.StringJoiner;
import java.util.function.UnaryOperator;

public class Step01Imperative implements UnaryOperator<String> {
    @Override
    public String apply(String s) {
        String[] strings = s.split(" ");
        StringJoiner joiner = new StringJoiner(" ");
        for(String string : strings){
            if(string.equalsIgnoreCase("nice")){
                joiner.add("XXXX");
            }else{
                joiner.add(string);
            }
        }
        return joiner.toString();
    }
}
