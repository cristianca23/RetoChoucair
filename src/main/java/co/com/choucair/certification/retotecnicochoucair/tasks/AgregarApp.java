package co.com.choucair.certification.retotecnicochoucair.tasks;

import co.com.choucair.certification.retotecnicochoucair.interaction.Esperar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static co.com.choucair.certification.retotecnicochoucair.ui.AppExitoUserInterface.*;

public class AgregarApp implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(ENVIO),
                Click.on(BUTTON_CONTINUAR),
                Enter.theValue("neveras").into(INPUT_BUSCAR).thenHit(Keys.ENTER),
                Esperar.unMomento(5),
                Click.on(BUTTON_AGREGAR),
                Click.on(BUTTON_CARRITO),
                Esperar.unMomento(5)




        );
    }

    public static Performable producto(){
        return Tasks.instrumented(AgregarApp.class);
    }
}
