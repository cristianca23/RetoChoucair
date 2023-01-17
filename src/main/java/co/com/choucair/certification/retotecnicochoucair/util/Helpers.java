package co.com.choucair.certification.retotecnicochoucair.util;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static co.com.choucair.certification.retotecnicochoucair.ui.ExitoUserInterface.PRECIO_INDIVIDUAL;
import static co.com.choucair.certification.retotecnicochoucair.ui.ExitoUserInterface.TARGET_PRUEBA;

public class Helpers {
    private static Random random;

    static  {
        random = new Random();
    }

    public static List<String> getNombreProductos(Actor actor, List<Integer> posicionesAleatorias) {
        int i = 0;
        List<String> nombreProductos = new ArrayList<>();
        while(i<posicionesAleatorias.size()){
            actor.attemptsTo(
                    Scroll.to(TARGET_PRUEBA.of(String.valueOf(posicionesAleatorias.get(i))).waitingForNoMoreThan(Duration.ofSeconds(2))
                    ));
            nombreProductos.add(getProducto(actor, posicionesAleatorias.get(i), TARGET_PRUEBA.of(String.valueOf(posicionesAleatorias.get(i)))));
            i = i+1;
        }
        return nombreProductos;
    }

    public static String getProducto(Actor actor, int limite, Target target) {
        String producto = "";
        while (producto.length() == 0) {

            producto = actor.asksFor(Text.of(target.of(Integer.toString(limite))));
        }
        return producto;
    }

    public static String getNombreProducto(Actor actor, int limite) {
        return getProducto(actor, limite, TARGET_PRUEBA);
    }

    public static String getValorProducto(Actor actor, int limite) {
        return getProducto(actor, limite, PRECIO_INDIVIDUAL);
    }

    public static List<Integer> randomEntre(int limite, int cantidad){
        List<Integer> numerosAleatorios = new ArrayList<>();
        Random random = new Random();
        int number;
        while (numerosAleatorios.size() < cantidad){
            number = random.nextInt(limite)+1;
            if(!numerosAleatorios.contains(number) && numerosAleatorios.size() < cantidad){
                numerosAleatorios.add(number);
            }
        }
        return numerosAleatorios;
    }

    public static int generarNumeroRandom(int limite) {
        return (random.nextInt(limite) + 1);
    }






}
