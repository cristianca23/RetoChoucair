package co.com.choucair.certification.retotecnicochoucair.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.com.choucair.certification.retotecnicochoucair.ui.AppExitoUserInterface.COMPARAR_TEXTO;

public class Validar implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(COMPARAR_TEXTO).getText().trim();
    }

    public static Validar producto(){
        return new Validar();
    }
}
