package co.com.choucair.certification.retotecnicochoucair.tasks;

import co.com.choucair.certification.retotecnicochoucair.interaction.Esperar;
import co.com.choucair.certification.retotecnicochoucair.model.Producto;
import co.com.choucair.certification.retotecnicochoucair.util.Helpers;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ClickInteraction;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.ui.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static co.com.choucair.certification.retotecnicochoucair.ui.ExitoUserInterface.*;

public class Agregar implements Task {
    int limite = 17;
    int limite10 = 10;

    List<Producto> productos = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {
        String result;
        int cantidadProductos = 0;
        int i;
        int j;
        String valor = "";

        actor.attemptsTo(Scroll.to(SCROLL_PUNTOS));
        actor.attemptsTo(Esperar.unMomento(5));
        actor.attemptsTo(Scroll.to(SCROLL_DOMICILIOS));
        actor.attemptsTo(Esperar.unMomento(2));


        for ( i = 0; i<=0; i++){//TODO Modificar para seleccionar 5 elementos aleatorios
            int random = Helpers.generarNumeroRandom(limite-i);
           result = Helpers.getNombreProducto(actor, random);
           valor = Helpers.getValorProducto(actor, random);
            actor.attemptsTo(Click.on(adicionarProducto(result)).afterWaitingUntilEnabled());
            cantidadProductos = Helpers.generarNumeroRandom(limite10);
            for(j= 0; j < cantidadProductos - 1 ; j++){
            actor.attemptsTo(Click.on(aumentarProducto(result)));


            }
            System.out.println(i);
            Producto producto = new Producto(result, String.valueOf(cantidadProductos), valor);
            productos.add(producto);
            actor.remember("productos", productos);

        }
        List<Producto> productosRecordados = actor.recall("productos");
        System.out.println(productosRecordados);
        actor.attemptsTo(Click.on(BUTTON_CARRITO_COMPRAS),
                Esperar.unMomento(5)
                );


//        List<WebElementFacade> productosComprados = TABLE_CART_ITEMS.resolveAllFor(actor).stream().toList();
      /*  for(WebElement productosCompra: productosComprados){
            System.out.println(productosCompra.getText());
        }*/

    }






    public static Agregar alCarrito(){
        return Tasks.instrumented(Agregar.class);
    }
}
