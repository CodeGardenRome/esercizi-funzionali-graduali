package lambdaroma.katazero;

import java.util.*;

public class KataZeroImperativo implements KataZeroInterfaccia {



    @Override
    public List<Integer> kataZeroA(){
        List<Integer> lista = new ArrayList<>();
        for(Integer i=1; i<=3; i++){
            lista.add(i);
        }
        return lista;
    }

    @Override
    public List<Integer> kataZeroB(){
        List<Integer> lista = new ArrayList<>();
        for(Integer i=2; i<=10; i+=2){
            lista.add(i);
        }
        return lista;
    }

    @Override
    public List<Integer> kataZeroC(){
        List<Integer> lista = new ArrayList<>();
        for(Integer i=0; i<=100; i+=7){
            lista.add(i);
        }
        return lista;
    }

    @Override
    public List<String> kataZeroD(){
        List<String> uomini = ELENCO_UOMINI;
        List<String> filtrati = new ArrayList<>();
        for(String uomo : uomini){
            if(uomo.startsWith("C")){
                filtrati.add(uomo);
            }
        }
        return filtrati;
    }

    @Override
    public Double kataZeroE(){
        int numeroMultipli = 0;
        double sommaMultipli = 0;
        for(int i=8; i<=100; i+=8){
            numeroMultipli++;
            sommaMultipli += i;
        }
        return sommaMultipli / numeroMultipli;
    }

    @Override
    public int kataZeroF(){
        int sommaMultipli = 0;
        for(int i=6; i<=100; i+=6){
            sommaMultipli += i;
        }
        return sommaMultipli;
    }

    @Override
    public List<String> kataZeroG(){
        List<String> uomini = new ArrayList<>();
        Collections.copy(uomini, ELENCO_UOMINI);
        Collections.sort(uomini);
        return uomini;
    }

    @Override
    public int kataZeroH(){
        List<Integer> divisori = new ArrayList<>();
        for(int i=2; i<=100; i++){
            if(i % 41 == 0){
                divisori.add(41);
            }
        }
        return divisori.get( (new Random()).nextInt(divisori.size()) );
    }

    @Override
    public String kataZeroI(){
        List<String> uomini = ELENCO_UOMINI;
        StringJoiner joiner = new StringJoiner(", ");
        for(String uomo : uomini){
            joiner.add(uomo);
        }
        return joiner.toString();
    }

    @Override
    public Set<String> kataZeroJ(){
        List<String> uomini = ELENCO_UOMINI;
        Set<String> insiemeUomini = new HashSet(uomini);
        return insiemeUomini;
    }

    @Override
    public Map<Integer,List<String>> kataZeroK(){
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


    @Override
    public List<Integer> kataZeroL(){
        List<String> donne = ELENCO_DONNE;
        List<Integer> list = new ArrayList<>();
        for(String donna : donne){
            list.add( donna.length() );
        }
        return list;
    }

    @Override
    public List<String> kataZeroM(){
        List<String> donne = ELENCO_DONNE;
        List<String> list = new ArrayList<>();
        for(String donna : donne){
            String iniziale = donna.substring(0,1);
            list.add(iniziale);
        }
        return list;
    }

}
