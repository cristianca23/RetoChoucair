package stepdefinitions;

import co.com.choucair.certification.retotecnicochoucair.questions.Validar;
import co.com.choucair.certification.retotecnicochoucair.tasks.AgregarApp;
import co.com.choucair.certification.retotecnicochoucair.tasks.Registrarse;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static co.com.choucair.certification.retotecnicochoucair.util.Constantes.TEXTO_A_COMPARAR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AppExitoStepDefinitions {

    @Managed(driver = "Appium")
    public WebDriver abrirNavegador;

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }
    @Dado("^que (.*) quiere agregar un producto en el exito$")
    public void queJuanQuiereAgregarUnProductoEnElExito(String name) {
        // Write code here that turns the phrase above into concrete actions
        OnStage.theActorCalled(name)
                .can(BrowseTheWeb.with(abrirNavegador));
    }
    @Entonces("procedera a realizar el ingreso y registro a la app con sus datos {string}, {string}")
    public void procederaARealizarElIngresoYRegistroALaAppConSusDatos(String Correo, String Contraseña) {
        // Write code here that turns the phrase above into concrete actions
        OnStage.theActorInTheSpotlight().attemptsTo(Registrarse.enElExito(Correo, Contraseña));

    }
    @Entonces("iniciara sesion para que agregar un item al carro")
    public void iniciaraSesionParaQueAgregarUnItemAlCarro() {
        // Write code here that turns the phrase above into concrete actions
        OnStage.theActorInTheSpotlight().attemptsTo(AgregarApp.producto());
    }
    @Entonces("pueda validar el item en el  carrito")
    public void puedaValidarElItemEnElCarrito() {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().should(seeThat("Producto agregado correctamente", Validar.producto(), equalTo(TEXTO_A_COMPARAR)));
    }
}
