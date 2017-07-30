package io.evilcorp.step00;

import java.util.*;

public class Step00Imperative implements Step00Interface {

    private static final List<String> ELENCO_UOMINI = Arrays.asList("Tizio", "Caio", "Sempronio", "Mevio", "Filano", "Calpurnio");
    private static final List<String> ELENCO_DONNE = Arrays.asList("Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara");

    // Stampare 1,2,3
    @Override
    public String stampa123(){
        StringJoiner joiner = new StringJoiner(", ");
        for(Integer i=1; i<=3; i++){
            joiner.add(i.toString());
        }
        return joiner.toString();
    }

    // Stampare i numeri pari tra 1 e 10
    @Override
    public String pariMinoriCento(){
        StringJoiner joiner = new StringJoiner(", ");
        for(Integer i=1; i<=100; i+=2){
            joiner.add(i.toString());
        }
        return joiner.toString();
    }

    // Stampare i multipli di 7 tra 1 e 100
    @Override
    public String multipliSetteMinoriCento(){
        StringJoiner joiner = new StringJoiner(", ");
        for(Integer i=1; i<=100; i+=7){
            joiner.add(i.toString());
        }
        return joiner.toString();
    }

    // Dall'elenco degli uomini, stampare quelli che cominciano per "C"
    @Override
    public String inizianoPerC(){
        List<String> uomini = ELENCO_UOMINI;
        StringJoiner joiner = new StringJoiner(", ");
        for(String uomo : uomini){
            if(uomo.startsWith("C")){
                joiner.add(uomo);
            }
        }
        return joiner.toString();
    }

    // Calcolare la media dei multipli di 8 compresi tra 1 e 100
    @Override
    public Double mediaMultipliOtto(){
        int numeroMultipli = 0;
        double sommaMultipli = 0;
        for(int i=8; i<=100; i+=8){
            numeroMultipli++;
            sommaMultipli += i;
        }
        return sommaMultipli / numeroMultipli;
    }

    // Calcolare la somma dei multipli di 6 compresi tra 1 e 100
    @Override
    public int sommaMultipliSei(){
        int sommaMultipli = 0;
        for(int i=6; i<=100; i+=6){
            sommaMultipli += i;
        }
        return sommaMultipli;
    }

    // Dall'elenco degli uomini, ordinarli e stamparli.
    @Override
    public String ordinamentoEStampa(){
        List<String> uomini = new ArrayList<>();
        Collections.copy(uomini, ELENCO_UOMINI);

        StringJoiner joiner = new StringJoiner(", ");
        Collections.sort(uomini);
        for(String uomo : uomini){
            joiner.add(uomo);
        }
        return joiner.toString();
    }

    // Tra i numeri da 1 a 100 trovarne uno qualunque divisibile per 41 e stamparlo (usare findAny)
    @Override
    public int divisibileQuarantuno(){
        for(int i=2; i<=100; i++){
            if(i % 41 == 0){
                return i;
            }
        }
        return -1;
    }

    // Dall'elenco degli uomini, produrre la stringa che li contiene intervallati da virgola e spazio
    @Override
    public String unione(){
        List<String> uomini = ELENCO_UOMINI;
        StringJoiner joiner = new StringJoiner(", ");
        for(String uomo : uomini){
            joiner.add(uomo);
        }
        return joiner.toString();
    }

    // Dall'elenco degli uomini, creare un insieme
    @Override
    public Set<String> daStringheAInsieme(){
        List<String> uomini = ELENCO_UOMINI;
        Set<String> insiemeUomini = new HashSet(uomini);
        return insiemeUomini;
    }

    // Dall'elenco delle donne, raggruppare per la lunghezza del nome
    @Override
    public Map<Integer,List<String>> raggruppareLunghezzaNome(){
        List<String> donne = ELENCO_DONNE;
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


    // Dall'elenco delle donne, stampare solamente le lunghezze dei loro nomi
    @Override
    public String lunghezzeNomi(){
        List<String> donne = ELENCO_DONNE;
        StringJoiner joiner = new StringJoiner(", ");
        for(String donna : donne){
            Integer lunghezza = donna.length();
            joiner.add(lunghezza.toString());
        }
        return joiner.toString();
    }

    // Dall'elenco delle donne, stampare solamente le iniziali dei loro nomi
    @Override
    public String inizialiNomi(){
        List<String> donne = ELENCO_DONNE;
        StringJoiner joiner = new StringJoiner(", ");
        for(String donna : donne){
            String iniziale = donna.substring(0,1);
            joiner.add(iniziale);
        }
        return joiner.toString();
    }

}
