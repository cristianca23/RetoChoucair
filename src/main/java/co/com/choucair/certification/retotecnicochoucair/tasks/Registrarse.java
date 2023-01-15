package co.com.choucair.certification.retotecnicochoucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.time.Duration;

import static co.com.choucair.certification.retotecnicochoucair.ui.AppExitoUserInterface.*;
import static co.com.choucair.certification.retotecnicochoucair.util.Constantes.INTERVALO;
import static co.com.choucair.certification.retotecnicochoucair.util.Constantes.INTERVALO_CARGA_APP;

public class Registrarse implements Task {
    private String contraseña, correo;

    public Registrarse(String contraseña, String correo) {
        this.contraseña = contraseña;
        this.correo = correo;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            Thread.sleep(INTERVALO_CARGA_APP);
            actor.attemptsTo(Click.on(BUTTON_REGISTRARSE),
                    Enter.theValue(correo).into(INPUT_CORREO.waitingForNoMoreThan(Duration.ofSeconds(2))),
                    Enter.theValue(contraseña).into(INPUT_CONTRASEÑA.waitingForNoMoreThan(Duration.ofSeconds(2))),
                    Click.on(BUTTON_INGRESAR.waitingForNoMoreThan(Duration.ofSeconds(3))),
                    Click.on(LOCATION.waitingForNoMoreThan(Duration.ofSeconds(3)))
            );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static Performable enElExito(String contraseña, String correo){
        return Tasks.instrumented(Registrarse.class, contraseña,correo );
    }
}
