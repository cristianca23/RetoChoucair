package co.com.choucair.certification.retotecnicochoucair.ui;

import co.com.choucair.certification.retotecnicochoucair.util.Helpers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.PageElement;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.By;

import java.util.List;

public class ExitoUserInterface {

    public static final Target BTN_BURGER = Target.the("Menu hamburguesa").located(By.id("category-menu"));
    public static final Target LBL_TECNOLOGIA = Target.the("Opcion tecnologia").located(By.id("undefined-nivel2-Tecnología"));
    public static final Target LBL_VENDIDOS = PageElement.containingText("Los más vendidos");

    public static final Target SCROLL_PUNTOS = Target.the("Scroll acumular puntos").locatedBy("(//div[@class='exito-footer-3-x-promiseBannerItem'])[2]");

    public static final Target SCROLL_DOMICILIOS = PageElement.containingText("Domicilios");

    public static final Target TARGET_PRUEBA = PageElement.locatedBy("(//span[@class='vtex-store-components-3-x-productBrand '])[{0}]");


    public static final Target BUTTON_CARRITO_COMPRAS = PageElement.withCSSClass("exito-header-3-x-minicartLink");

    public static final Target TABLE_CART_ITEMS = PageElement.locatedBy("//*[@class='table cart-items']/tbody/tr[td]");



    public static final Target VALIDAR_PRODUCTO = Target.the("Boton agregar").located(By.xpath("//*[@class='totalItems']"));

    public static final Target PRECIO_INDIVIDUAL =Target.the("Precio de cada producto").locatedBy("(//div[@class='exito-vtex-components-4-x-PricePDP'])[{0}]");
    public static Target adicionarProducto(String tituloProducto) {
       return Button.withText("Agregar").inside(PageElement.locatedBy("//*[@id='gallery-layout-container']/div").containingText(tituloProducto));
    }
    public static Target AUMENTAR = Target.the("Aumentar los productos").locatedBy("//span[contains(text(), '{0}')]/../../../.././../../../../../div[2]//div/div[2]/div/button/span[@class='shelf-exito-vtex-components-buy-button-manager-more']");

    public static Target aumentarProducto(String tituloProducto) {
        return Button.locatedBy("//button[@class='exito-vtex-components-4-x-buttonActions exito-vtex-components-4-x-productSummaryAddToCar  product-summary-add-to-car-plus']").inside(PageElement.locatedBy("//*[@id='gallery-layout-container']/div").containingText(tituloProducto));
    }

    public static final Target BUTTON_AUMENTAR = Target.the("Boton aumentar cantidad").located(By.xpath("(//*[name()='path'])[229]"));


}

