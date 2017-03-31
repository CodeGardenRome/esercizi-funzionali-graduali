package io.evilcorp.step01;

import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Step01StreamsImplicit implements UnaryOperator<String> {
    @Override
    public String apply(String s) {
        return Arrays.stream(s.split(" "))
                .map( string -> string.equalsIgnoreCase("nice") ? "XXXX" : string )
                .collect(Collectors.joining(" "));
    }
}
