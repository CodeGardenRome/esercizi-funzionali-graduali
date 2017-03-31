package io.evilcorp.step01;

import javaslang.collection.Array;
import javaslang.collection.List;

import java.util.function.UnaryOperator;

import static javaslang.API.For;

public class Step01Javaslang implements UnaryOperator<String> {

    @Override
    public String apply(String s) {
        return List.of(s.split(" "))
                .map(string -> string.equalsIgnoreCase("nice") ? "XXXX" : string)
                .intersperse(" ")
                .fold("", String::concat);
    }
}
