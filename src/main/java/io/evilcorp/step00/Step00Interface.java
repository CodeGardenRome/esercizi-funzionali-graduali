package io.evilcorp.step00;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Step00Interface {
    // Stampare 1,2,3
    String stampa123();

    // Stampare i numeri pari tra 1 e 10
    String pariMinoriCento();

    // Stampare i multipli di 7 tra 1 e 100
    String multipliSetteMinoriCento();

    // Da "Tizio", "Caio" e "Sempronio" stampare quelli che cominciano per "C"
    String inizianoPerC();

    // Calcolare la media dei multipli di 8 compresi tra 1 e 100
    Double mediaMultipliOtto();

    // Calcolare la somma dei multipli di 6 compresi tra 1 e 100
    int sommaMultipliSei();

    // Da "Tizio", "Caio" e "Sempronio" ordinarli e stamparli.
    String ordinamentoEStampa();

    // Tra i numeri da 1 a 100 trovarne uno qualunque divisibile per 41 e stamparlo (usare findAny)
    int divisibileQuarantuno();

    // Da "Tizio", "Caio" e "Sempronio" produrre la stringa "Tizio, Caio, Sempronio"
    String unione();

    // Da "Carlo", "Mario", "Alberto" creare un insieme
    Set<String> daStringheAInsieme();

    // Da "Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara" raggruppare per la lunghezza del nome
    Map<Integer,List<String>> raggruppareLunghezzaNome();

    // Da "Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara" stampare solamente le lunghezze dei loro nomi
    String lunghezzeNomi();

    // Da "Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara" stampare solamente le iniziali dei loro nomi
    String inizialiNomi();
}
