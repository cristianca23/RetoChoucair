package co.com.choucair.certification.retotecnicochoucair.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
public class HelpersAImplementar {

    public static List<Integer> randomEntre(int limite, int cantidad){
        List<Integer> numerosAleatorios = new ArrayList<>();
        Random random = new Random();
        int number;
        while (numerosAleatorios.size() < cantidad){
            number = random.nextInt(limite)+1;
            if(!numerosAleatorios.contains(number) && numerosAleatorios.size() < cantidad){
                numerosAleatorios.add(number); //Arreglar los elementos faltantes para llegar a 5
            }
        }
        return numerosAleatorios;
    }

    List<Integer> indicesAleatorios = Helpers.randomEntre(10, 5);

    List<String> nombreProductos = getNombreProductos(actor, indicesAleatorios);
}
*/