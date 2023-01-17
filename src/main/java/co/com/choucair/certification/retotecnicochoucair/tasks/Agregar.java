package co.com.choucair.certification.retotecnicochoucair.tasks;

import co.com.choucair.certification.retotecnicochoucair.interaction.Esperar;
import co.com.choucair.certification.retotecnicochoucair.model.Producto;
import co.com.choucair.certification.retotecnicochoucair.util.Helpers;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static co.com.choucair.certification.retotecnicochoucair.ui.ExitoUserInterface.*;
import static co.com.choucair.certification.retotecnicochoucair.util.Helpers.getNombreProductos;

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
        List<Integer> indicesAleatorios = Helpers.randomEntre(limite, 5);
        List<String> nombreProductos = getNombreProductos(actor, indicesAleatorios);
        for (i = 0; i < nombreProductos.size(); i++) {
            result = nombreProductos.get(i);
            valor = Helpers.getValorProducto(actor, indicesAleatorios.get(i));
            actor.attemptsTo(
                    Scroll.to(TARGET_PRUEBA.of(String.valueOf(indicesAleatorios.get(i))).waitingForNoMoreThan(Duration.ofSeconds(2))
                    ));
            actor.attemptsTo(Click.on(adicionarProducto(result)));
            cantidadProductos = Helpers.generarNumeroRandom(limite10);
            for (j = 0; j < cantidadProductos - 1; j++) {
                actor.attemptsTo(Click.on(AUMENTAR.of(result)));
            }
            Producto producto = new Producto(result, String.valueOf(cantidadProductos), valor);
            productos.add(producto);
        }
        actor.remember("productos", productos);
        actor.attemptsTo(Click.on(BUTTON_CARRITO_COMPRAS),
                Esperar.unMomento(5)
        );
    }

    public static Agregar alCarrito(){
        return Tasks.instrumented(Agregar.class);
    }
}
