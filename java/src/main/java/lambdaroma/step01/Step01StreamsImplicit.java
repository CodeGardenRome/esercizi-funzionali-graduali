package lambdaroma.step01;

import java.util.Arrays;
import java.util.function.UnaryOperator;
import static java.util.stream.Collectors.joining;

public class Step01StreamsImplicit implements UnaryOperator<String> {
    @Override
    public String apply(String s) {
        return Arrays.stream(s.split(" "))
                .map( word -> word.equalsIgnoreCase("nice") ? "XXXX" : word )
                .collect(joining(" "));
    }
}
