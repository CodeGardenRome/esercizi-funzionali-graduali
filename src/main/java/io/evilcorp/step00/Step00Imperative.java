package io.evilcorp.step00;

import java.util.*;

public class Step00Imperative {

    private final static String LINE_SEPARATOR = System.getProperty("line.separator");

    // Stampare 1,2,3
    public static String stampa123(){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=3; i++){
            sb.append(i).append(LINE_SEPARATOR);
        }
        return sb.toString();
    }

    // Stampare i numeri pari tra 1 e 10
    public static String pariMinoriCento(){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=100; i+=2){
            sb.append(i).append(LINE_SEPARATOR);
        }
        return sb.toString();
    }

    // Stampare i multipli di 7 tra 1 e 100
    public static String multipliSetteMinoriCento(){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=100; i+=7){
            sb.append(i).append(LINE_SEPARATOR);
        }
        return sb.toString();
    }

    // Da "Tizio", "Caio" e "Sempronio" stampare quelli che cominciano per "C"
    public static String inizianoPerC(){
        List<String> uomini = Arrays.asList("Tizio", "Caio", "Sempronio");
        StringBuilder sb = new StringBuilder();
        for(String uomo : uomini){
            if(uomo.startsWith("C")){
                sb.append(uomo).append(LINE_SEPARATOR);
            }
        }
        return sb.toString();
    }

    // Calcolare la media dei multipli di 8 compresi tra 1 e 100
    public static Double mediaMultipliOtto(){
        int numeroMultipli = 0;
        double sommaMultipli = 0;
        for(int i=8; i<=100; i+=8){
            numeroMultipli++;
            sommaMultipli += i;
        }
        return sommaMultipli / numeroMultipli;
    }

    // Calcolare la somma dei multipli di 6 compresi tra 1 e 100
    public static int sommaMultipliSei(){
        int sommaMultipli = 0;
        for(int i=6; i<=100; i+=6){
            sommaMultipli += i;
        }
        return sommaMultipli;
    }

    // Da "Tizio", "Caio" e "Sempronio" ordinarli e stamparli.
    public static String ordinamentoEStampa(){
        List<String> uomini = Arrays.asList("Tizio", "Caio", "Sempronio");
        StringBuilder sb = new StringBuilder();
        Collections.sort(uomini);
        for(String uomo : uomini){
            sb.append(uomo).append(LINE_SEPARATOR);
        }
        return sb.toString();
    }

    // Tra i numeri da 1 a 100 trovarne uno qualunque divisibile per 41 e stamparlo (usare findAny)
    public static int divisibileQuarantuno(){
        for(int i=2; i<=100; i++){
            if(i % 41 == 0){
                return i;
            }
        }
        return -1;
    }

    // Da "Tizio", "Caio" e "Sempronio" produrre la stringa "Tizio, Caio, Sempronio"
    public static String unione(){
        List<String> uomini = Arrays.asList("Tizio", "Caio", "Sempronio");
        StringJoiner joiner = new StringJoiner(", ");
        for(String uomo : uomini){
            joiner.add(uomo);
        }
        return joiner.toString();
    }

    // Da "Carlo", "Mario", "Alberto" creare un insieme
    public static Set<String> daStringheAInsieme(){
        List<String> uomini = Arrays.asList("Tizio", "Caio", "Sempronio");
        Set<String> insiemeUomini = new HashSet(uomini);
        return insiemeUomini;
    }

    // Da "Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara" raggruppare per la lunghezza del nome
    public static Map<Integer,List<String>> raggruppareLunghezzaNome(){
        List<String> donne = Arrays.asList("Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara");
        Map<Integer,List<String>> map = new HashMap<>();
        for(String donna : donne){
            int lunghezza = donna.length();
            if(map.containsKey(lunghezza)){
                List<String> list = map.get(lunghezza);
                list.add(donna);
            }else{
                List<String> list = new ArrayList<>();
                list.add(donna);
                map.put(lunghezza, list);
            }
        }
        return map;
    }


    // Da "Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara" stampare solamente le lunghezze dei loro nomi
    public static String lunghezzeNomi(){
        List<String> donne = Arrays.asList("Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara");
        StringBuilder sb = new StringBuilder();
        for(String donna : donne){
            int lunghezza = donna.length();
            sb.append(lunghezza).append(LINE_SEPARATOR);
        }
        return sb.toString();
    }

    // Da "Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara" stampare solamente le iniziali dei loro nomi
    public static String inizialiNomi(){
        List<String> donne = Arrays.asList("Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara");
        StringBuilder sb = new StringBuilder();
        for(String donna : donne){
            char iniziale = donna.charAt(0);
            sb.append(iniziale).append(LINE_SEPARATOR);
        }
        return sb.toString();
    }

}
