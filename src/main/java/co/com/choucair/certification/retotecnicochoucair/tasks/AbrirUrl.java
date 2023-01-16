package co.com.choucair.certification.retotecnicochoucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Browser;
import net.serenitybdd.screenplay.actions.Open;

import static co.com.choucair.certification.retotecnicochoucair.util.Constantes.URL;

public class AbrirUrl implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(URL));
    }


    public static AbrirUrl exito(){
        return Tasks.instrumented(AbrirUrl.class);
    }
}
