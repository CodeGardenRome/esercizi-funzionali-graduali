package io.evilcorp.step02;

import javaslang.Function2;
import javaslang.collection.Set;
import javaslang.collection.CharSeq;

import java.util.function.UnaryOperator;

public class Step02Javaslang implements Function2<Set<String>, String, String> {

    @Override
    public String apply(Set<String> censored, String text) {
    	return censored.foldLeft(CharSeq.of(text), 
    		(txt, verboten) -> txt.replaceAll(verboten, Marked.apply(verboten))
    	).toString();
    }

    private final char marker = 'X';

    private final UnaryOperator<String> Marked = (word) -> CharSeq.repeat(marker, word.length()).toString();
}
