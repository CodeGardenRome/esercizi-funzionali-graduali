package lambdaroma.step03;

import java.util.Collections;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiFunction;

public class Step03Imperative implements BiFunction<Set<String>, String, String> {
    @Override
    public String apply(Set<String> strings, String s) {
        String[] splitted = s.split(" ");
        StringJoiner joiner = new StringJoiner(" ");
        for(String chunk : splitted){
            boolean found = false;
            for(String forbidden : strings){
                if(chunk.startsWith(forbidden)){
                    joiner.add(String.join("", Collections.nCopies(chunk.length(), String.valueOf("X"))));
                    found = true;
                }
            }
            if(!found){
                joiner.add(chunk);
            }
        }
        return joiner.toString();
    }
}
