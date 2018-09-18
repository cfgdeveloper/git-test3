
package lletresrepetides;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LletresRepetides {

    static List<Character> vocals = Arrays.asList('a','e','i','o','u');
    static List<Character> numeros = Arrays.asList('0','1','2','3','4','5','6','7','8','9');
    static Map<Character,Integer> ocurrencies = new HashMap<>();
    
    public static void main(String[] args) {
        List<Character> nom = Arrays.asList('C','a','r','l','o','s');
        List<Character> cognom = Arrays.asList('F','e','r','n','a','n','d','e','z');
        
        for(char c:nom) {
            switch (esVocal(Character.toLowerCase(c))) {
                case 0:
                    System.out.println("VOCAL");
                    break;
                case 2:
                    System.out.println("Els noms de persones no contenen números!");
                    break;
                default:
                    System.out.println("CONSONANT");
                    break;
            }
            
            comprobaLletraMap(Character.toLowerCase(c));
        }
        
        System.out.println(ocurrencies);
        
        System.out.println(fusionaNomCognom(nom, cognom));
    }
    
    /*
        return -> 0 = vocal, 1 = consonant, 2 = numero
    */
    private static int esVocal(char c) {
        if (vocals.contains(c)) {
            return 0;
        }
        else if (numeros.contains(c)) {
            return 2;
        }
        else {
            return 1;
        }
    }
    
    /*
        Rep una lletra del nom, comproba si es troba al map.
        es troba -> aumenta el seu num de cops que s'ha trobat
        no es troba -> crea una entrada nova i li posa un valor inicial de 1
    */
    private static void comprobaLletraMap(char c) {
        if (ocurrencies.containsKey(c)) {
            //aumentar en 1 el value associat a aquesta key
            ocurrencies.put(c,ocurrencies.get(c)+1);
        }
        else {
            //crear una key nova i posar-li un valor inicial de 1
            ocurrencies.put(c,1);
        }
    }
    
    /*
        fusiona els caracters de 2 arraylists, afegint un espai buit al mig
    */
    private static List<Character> fusionaNomCognom(List<Character> nom, List<Character> cognom) {
        List<Character> nomComplet = new ArrayList<>();
        nomComplet.addAll(nom);
        nomComplet.addAll(Arrays.asList(' '));
        nomComplet.addAll(cognom);
        return nomComplet;
    }
}
