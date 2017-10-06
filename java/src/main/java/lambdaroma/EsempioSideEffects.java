package lambdaroma;

public class EsempioSideEffects {
    int addendoA, addendoB, somma;

    public void somma(){
        somma = addendoA + addendoB;
    }

    public int getAddendoA() { return addendoA; }

    public void setAddendoA(int addendoA) { this.addendoA = addendoA; }

    public int getAddendoB() { return addendoB; }

    public void setAddendoB(int addendoB) { this.addendoB = addendoB; }

    public int getSomma() { return somma; }

    public void setSomma(int somma) { this.somma = somma; }
}
