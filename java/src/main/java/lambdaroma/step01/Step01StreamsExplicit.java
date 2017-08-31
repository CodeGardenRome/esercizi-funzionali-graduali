package lambdaroma.step01;

import java.util.Arrays;
import java.util.function.UnaryOperator;
import static java.util.stream.Collectors.joining;

public class Step01StreamsExplicit implements UnaryOperator<String> {
    @Override
    public String apply(String s) {
        return Arrays.stream(s.split(" "))
                .map(Step01StreamsExplicit::evil)
                .collect(joining(" "));
    }

    private static String evil(String s){
        return s.equalsIgnoreCase("nice") ? "XXXX" : s;
    }
}
