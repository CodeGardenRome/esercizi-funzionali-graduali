package io.evilcorp.step03;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiFunction;

public class Step03Imperative implements BiFunction<Set<String>, String, String> {
    @Override
    public String apply(Set<String> strings, String s) {
        String[] splitted = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String chunk : splitted){
            boolean found = false;
            for(String forbidden : strings){

                if(chunk.startsWith(forbidden)){
                    sb.append(String.join("", Collections.nCopies(chunk.length(), String.valueOf("X"))));
                    sb.append(" ");
                    found = true;
                    break;
                }
            }
            if(!found){
                sb.append(chunk).append(" ");
            }
        }
        return sb.substring(0, sb.length()-1).toString();
    }
}
