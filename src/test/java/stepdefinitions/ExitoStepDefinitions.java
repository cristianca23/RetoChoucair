package stepdefinitions;

import co.com.choucair.certification.retotecnicochoucair.model.Producto;
import co.com.choucair.certification.retotecnicochoucair.questions.Obtener;
import co.com.choucair.certification.retotecnicochoucair.tasks.AbrirUrl;
import co.com.choucair.certification.retotecnicochoucair.tasks.Agregar;
import co.com.choucair.certification.retotecnicochoucair.tasks.Buscar;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.choucair.certification.retotecnicochoucair.ui.ExitoUserInterface.VALIDAR_PRODUCTO;


import java.util.List;

public class ExitoStepDefinitions {

    @Before
    public void iniciarTest(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que (.*) quiere ingresar a la pagina del exito$")
    public void queLuisaQuiereIngresarALaPaginaDelExito(String actor) {
        OnStage.theActorCalled(actor).wasAbleTo(AbrirUrl.exito());
    }
    @Dado("seleccionar diferentes televisores")
    public void seleccionarDiferentesTelevisores() {
        OnStage.theActorInTheSpotlight().attemptsTo(Buscar.categoriaTelevisor());
    }
    @Cuando("Luisa agrega al carrito los televisores en diferentes cantidades")
    public void luisaAgregaAlCarritoLosTelevisoresEnDiferentesCantidades() {
        OnStage.theActorInTheSpotlight().attemptsTo(Agregar.alCarrito());
    }
    @Entonces("Luisa ira a realizar la validacion de sus televisores")
    public void luisaIraARealizarLaValidacionDeSusTelevisores() {
        Actor actor = OnStage.theActorInTheSpotlight();
        List<Producto> productosRecordados = actor.recall("productos");
        List<Producto> productosCarritoCompras = actor.asksFor(Obtener.productosCarritoCompras());
        String elementText = VALIDAR_PRODUCTO.resolveFor(actor).getText().trim().substring(0,1);
        int i = 0;
        while (i <productosRecordados.size()){
            actor.attemptsTo(
                    Ensure.that(productosCarritoCompras.get(i).getValorProducto()).isSubstringOf(productosRecordados.get(i).getValorProducto()),
                    Ensure.that(productosRecordados.get(i).getNombreProducto()).isSubstringOf(productosCarritoCompras.get(i).getNombreProducto())
            );
            i = i + 1;
        }
    }

}
