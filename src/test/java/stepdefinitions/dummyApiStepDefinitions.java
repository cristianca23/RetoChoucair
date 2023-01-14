package stepdefinitions;

import co.com.choucair.certification.retotecnicochoucair.model.Data;
import co.com.choucair.certification.retotecnicochoucair.tasks.ConsumirDelete;
import co.com.choucair.certification.retotecnicochoucair.tasks.ConsumirGet;
import co.com.choucair.certification.retotecnicochoucair.tasks.ConsumirPost;
import co.com.choucair.certification.retotecnicochoucair.tasks.ConsumirPut;
import io.cucumber.java.ParameterType;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.choucair.certification.retotecnicochoucair.util.Constantes.CONSULTAR;
import static co.com.choucair.certification.retotecnicochoucair.util.Constantes.EMPLEADO_ESPECIFICO;


public class dummyApiStepDefinitions {

    private String name;
        @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Dado("^que (.*) necesita consultar la información de un  empleado$")
    public void queNecesitaConsultarLaInformaciónDeUnEmpleado(String name) {
        this.name = name;
        actor(name).wasAbleTo(ConsumirGet.consulta(EMPLEADO_ESPECIFICO));
        ResponseBody responde = SerenityRest.lastResponse().getBody();

        actor(name).attemptsTo(
                net.serenitybdd.screenplay.ensure.Ensure.that(SerenityRest.lastResponse().getStatusCode()).isEqualTo(200),
                Ensure.that(responde.jsonPath().get("message").toString())
                        .isEqualTo("Successfully! Record has been fetched.")
        );
    }
    @Dado("actualizara la información del empleado con  {string}, {string}, {string}")
    public void actualizaraLaInformaciónDelEmpleadoCon( String name, String salary, String age) {
        Data data = new Data();
        data.setName(name);
        data.setSalary(salary);
        data.setAge(age);
        actor(name).attemptsTo(ConsumirPut.actualiza(data));
        ResponseBody responde = SerenityRest.lastResponse().getBody();

        actor(name).attemptsTo(
                Ensure.that(SerenityRest.lastResponse().getStatusCode()).isEqualTo(200),
                Ensure.that(responde.jsonPath().get("message").toString())
                        .isEqualTo("Successfully! Record has been updated.")

        );

    }
    @Entonces("el borrara  la información de otro empleado que ya no trabaja en la empresa")
    public void elBorraraLaInformaciónDeOtroEmpleadoQueYaNoTrabajaEnLaEmpresa() {
        // Write code here that turns the phrase above into concrete actions
        actor(name).attemptsTo(ConsumirDelete.borrar());
        ResponseBody responde = SerenityRest.lastResponse().getBody();
        actor(name).attemptsTo(
                Ensure.that(SerenityRest.lastResponse().getStatusCode()).isEqualTo(200),
                Ensure.that(responde.jsonPath().get("message").toString())
                        .isEqualTo("Successfully! Record has been deleted")
        );
    }
    @Entonces("Creara un nuevo empleado para reemplazar al que salio con  los datos {string}, {string}, {string}")
    public void crearaUnNuevoEmpleadoParaReemplazarAlQueSalioConLosDatos(String name, String salary, String age) {

        Data data = new Data();
        data.setName(name);
        data.setSalary(salary);
        data.setAge(age);
        actor(name).attemptsTo(ConsumirPost.update(data));
        ResponseBody responde = SerenityRest.lastResponse().getBody();

        actor(name).attemptsTo(
                Ensure.that(SerenityRest.lastResponse().getStatusCode()).isEqualTo(200),
                Ensure.that(responde.jsonPath().get("message").toString())
                        .isEqualTo("Successfully! Record has been added.")
        );

    }
    @Entonces("consultara la información de todos los  empleados activos")
    public void consultaraLaInformaciónDeTodosLosEmpleadosActivos() {

        actor(name).attemptsTo(ConsumirGet.consulta(CONSULTAR));
        ResponseBody responde = SerenityRest.lastResponse().getBody();

        actor(name).attemptsTo(
                Ensure.that(SerenityRest.lastResponse().getStatusCode()).isEqualTo(200),
                Ensure.that(responde.jsonPath().get("message").toString())
                        .isEqualTo("Successfully! All records has been fetched.")
        );
    }

}
