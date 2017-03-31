package io.evilcorp.step01;

import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Step01StreamsExplicit implements UnaryOperator<String> {
    @Override
    public String apply(String s) {
        return Arrays.stream(s.split(" "))
                .map(this::mapper)
                .collect(Collectors.joining(" "))
                .toString();
    }

    private String mapper(String s){
        if(s.equals("nice")){
            return "XXXX";
        }else{
            return s;
        }
    }
}
