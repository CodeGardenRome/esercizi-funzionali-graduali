package io.evilcorp.step01;

import javaslang.collection.Array;
import javaslang.collection.List;

import java.util.function.UnaryOperator;

import static javaslang.API.For;

public class Step01Javaslang implements UnaryOperator<String> {

    @Override
    public String apply(String string) {
        return List.of(string.split(" "))
                .map(word -> word.equalsIgnoreCase("nice") ? "XXXX" : word)
                .mkString(" ");
    }
}
