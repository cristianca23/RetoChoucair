package co.com.choucair.certification.retotecnicochoucair.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.choucair.certification.retotecnicochoucair.util.Constantes.*;

public class ConsumirGet implements Task {


    private String endPoint;

    public ConsumirGet(String endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        int i = 0;
        int statusCode = 0;
        while (i < NUMERO_MAXIMO_REINTENTOS && statusCode != 200) {
            try{
            Actor juan = actor.whoCan(CallAnApi.at(URI_API));
            juan.attemptsTo(
                    Get.resource(endPoint));
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

    public static ConsumirGet consulta(String endPoint){
        return Tasks.instrumented(ConsumirGet.class, endPoint);
    }
}
