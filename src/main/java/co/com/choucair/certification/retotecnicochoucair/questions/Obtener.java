package co.com.choucair.certification.retotecnicochoucair.questions;

import co.com.choucair.certification.retotecnicochoucair.interaction.Esperar;
import co.com.choucair.certification.retotecnicochoucair.model.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static co.com.choucair.certification.retotecnicochoucair.ui.ExitoUserInterface.TABLE_CART_ITEMS;
import static co.com.choucair.certification.retotecnicochoucair.ui.ExitoUserInterface.VALIDAR_PRODUCTO;

public class Obtener implements Question<List<Producto>>  {
    @Override
    public List<Producto> answeredBy(Actor actor) {



            List<Producto> productosCarroitoCompra = new ArrayList<>();
            WebElement resultTable = TABLE_CART_ITEMS.resolveFor(actor).getElement();
            List<WebElement> rows = resultTable.findElements(By.xpath("//*[@class='table cart-items']/tbody/tr[td]"));
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                Producto producto = new Producto(cells.get(1).getText().trim().replaceAll("\\n.*$", ""), cells.get(4).getText(), cells.get(3).getText().replaceAll("^.*\n\n", ""));
                productosCarroitoCompra.add(producto);


            }
        List<Producto> productosRecordados = actor.recall("productos");




            return productosCarroitoCompra;
    }

    public static Obtener productosCarritoCompras(){
        return new Obtener();
    }
}
