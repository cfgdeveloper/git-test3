
package lletresrepetides;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LletresRepetides {

    static List<Character> vocals = Arrays.asList('a','e','i','o','u');
    static List<Character> numbers = Arrays.asList('0','1','2','3','4','5','6','7','8','9');
    static List<Character> consonant = Arrays.asList('b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z');
    static Map<Character,Integer> hits = new HashMap<>();
    
    public static void main(String[] args) {
        List<Character> name = Arrays.asList('C','a','r','l','o','s');
        List<Character> surname = Arrays.asList('F','e','r','n','a','n','d','e','z');
        
        for(char c:name) {
            switch (charType(Character.toLowerCase(c))) {
                case 0:
                    System.out.println("VOCAL");
                    break;
                case 2:
                    System.out.println("Els noms de persones no contenen números!");
                    break;
                case 1:
                    System.out.println("CONSONANT");
                    break;
                default:
                    System.out.println("Caràcter desconegut");
                    break;
            }
            
            checkCharMap(Character.toLowerCase(c));
        }
        
        System.out.println(hits);
        
        System.out.println(mergeNameSurname(name, surname));
    }
    
    /*
        return -> 0 = vocal, 1 = consonant, 2 = numero
    */
    private static int charType(char c) {
        int charType = -1;
        if (vocals.contains(c)) {
            charType = 0;
        }
        else if (numbers.contains(c)) {
            charType =  2;
        }
        else if (consonant.contains(c)){
            charType = 1;
        }
        return charType;
    }
    
    /*
        Rep una lletra del name, comproba si es troba al map.
        es troba -> aumenta el seu num de cops que s'ha trobat
        no es troba -> crea una entrada nova i li posa un valor inicial de 1
    */
    private static void checkCharMap(char c) {
        if (hits.containsKey(c)) {
            //aumentar en 1 el value associat a aquesta key
            hits.put(c,hits.get(c)+1);
        }
        else {
            //crear una key nova i posar-li un valor inicial de 1
            hits.put(c,1);
        }
    }
    
    /*
        fusiona els caracters de 2 arraylists, afegint un espai buit al mig
    */
    private static List<Character> mergeNameSurname(List<Character> name, List<Character> surname) {
        List<Character> nomComplet = new ArrayList<>();
        nomComplet.addAll(name);
        nomComplet.addAll(Arrays.asList(' '));
        nomComplet.addAll(surname);
        return nomComplet;
    }
}
