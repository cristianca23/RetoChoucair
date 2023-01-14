package co.com.choucair.certification.retotecnicochoucair.tasks;

import co.com.choucair.certification.retotecnicochoucair.interaction.Esperar;
import co.com.choucair.certification.retotecnicochoucair.util.Helpers;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.choucair.certification.retotecnicochoucair.ui.ExitoUserInterface.*;

public class Buscar implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Esperar.unMomento(2));
        actor.attemptsTo(Click.on(BTN_BURGER));
        actor.attemptsTo(Click.on(LBL_TECNOLOGIA));
        actor.attemptsTo(Click.on(LBL_VENDIDOS));
    }

    public static Buscar categoriaTelevisor(){
        return Tasks.instrumented(Buscar.class);
    }
}

