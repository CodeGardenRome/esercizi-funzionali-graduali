package lambdaroma.step02;

import io.vavr.Function2;
import io.vavr.collection.CharSeq;
import io.vavr.collection.Set;

import java.util.function.UnaryOperator;

public class Step02Vavr implements Function2<Set<String>, String, String> {

    @Override
    public String apply(Set<String> censored, String text) {
        return censored.foldLeft(CharSeq.of(text),
                (txt, verboten) -> txt.replaceAll(verboten, Marked.apply(verboten))
        ).toString();
    }

    private final char marker = 'X';

    private final UnaryOperator<String> Marked = (word) -> CharSeq.repeat(marker, word.length()).toString();
}