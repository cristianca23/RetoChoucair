package co.com.choucair.certification.retotecnicochoucair.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;


import static co.com.choucair.certification.retotecnicochoucair.util.Constantes.*;

public class ConsumirDelete implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        int i = 0;
        int statusCode = 0;
        while (i < NUMERO_MAXIMO_REINTENTOS && statusCode != 200) {
            try{
        Actor juan=actor.whoCan(CallAnApi.at(URI_API));
        juan.attemptsTo(
                Delete.from(DELETE));
        statusCode = SerenityRest.lastResponse().statusCode();
        i++;
        if (statusCode != 200) {
            Thread.sleep(INTERVALO);
        }
    } catch (InterruptedException e){
        e.printStackTrace();
    }


}

    }

    public static ConsumirDelete borrar(){
        return Tasks.instrumented(ConsumirDelete.class);
    }
}
