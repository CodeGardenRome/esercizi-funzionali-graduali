package lambdaroma.step01;

import io.vavr.collection.List;

import java.util.function.UnaryOperator;

public class Step01Vavr implements UnaryOperator<String> {

    @Override
    public String apply(String string) {
        return List.of(string.split(" "))
                .map(word -> word.equalsIgnoreCase("nice") ? "XXXX" : word)
                .mkString(" ");
    }
}
