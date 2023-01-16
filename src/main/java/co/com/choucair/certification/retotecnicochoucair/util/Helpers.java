package co.com.choucair.certification.retotecnicochoucair.util;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.util.HashSet;
import java.util.Random;

import static co.com.choucair.certification.retotecnicochoucair.ui.ExitoUserInterface.PRECIO_INDIVIDUAL;
import static co.com.choucair.certification.retotecnicochoucair.ui.ExitoUserInterface.TARGET_PRUEBA;

public class Helpers {
    private static Random random;

    static  {
        random = new Random();
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



    public static int generarNumeroRandom(int limite) {
        return (random.nextInt(limite) + 1);
    }






}
