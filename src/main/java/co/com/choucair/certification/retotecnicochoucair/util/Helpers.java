package co.com.choucair.certification.retotecnicochoucair.util;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.util.HashSet;
import java.util.Random;

import static co.com.choucair.certification.retotecnicochoucair.ui.ExitoUserInterface.PRECIO_INDIVIDUAL;
import static co.com.choucair.certification.retotecnicochoucair.ui.ExitoUserInterface.TARGET_PRUEBA;

public class Helpers {

    public static String xpath = "(//span[@class='vtex-store-components-3-x-productBrand '])[%s]";
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

    public static String getValorTodosProductos(){
       return null;
    }







//    public String getNombreProducto(Actor actor, int limite){
//        String result = "";
//
//        while(result.length() == 0) {
//            int random =  Helpers.generarNumeroRandom(limite);
//            result = actor.asksFor(Text.of(TARGET_PRUEBA.of(Integer.toString(random))));
//
//        }
//        return result;
//    }
//
//    public String getValorProducto(Actor actor, int limite){
//        String valor = "";
//        while(valor.length() == 0) {
//            int random =  Helpers.generarNumeroRandom(limite);
//
//            valor = actor.asksFor(Text.of(PRECIO_INDIVIDUAL.of(Integer.toString(random))));
//        }
//        return valor;
//    }
    public static int generarNumeroRandom(int limite) {
        return (random.nextInt(limite) + 1);
    }


  /*  private Random random;
    private HashSet<Integer> generatedNumbers;
    private int limit;

    public RandomNumberGenerator(int limit) {
        this.random = new Random();
        this.generatedNumbers = new HashSet<>();
        this.limit = limit;
    }

    public int getUniqueRandom() {
        int randomNumber;
        do {
            randomNumber = random.nextInt(limit);
        } while (generatedNumbers.contains(randomNumber));
        generatedNumbers.add(randomNumber);
        return randomNumber;
    }*/




}
