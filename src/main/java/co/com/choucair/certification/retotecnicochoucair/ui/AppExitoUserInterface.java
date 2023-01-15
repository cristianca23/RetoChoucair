package co.com.choucair.certification.retotecnicochoucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.PageElement;
import org.openqa.selenium.By;

public class AppExitoUserInterface {

    public static final Target BUTTON_REGISTRARSE = Target.the("Botón para realizar el registro en la aplicación").located(By.id("com.exito.appcompania:id/AppCompatButton_ingresar"));

    public static final Target INPUT_CORREO = Target.the("Insertar el correo").located(By.id("com.exito.appcompania:id/TextInputEditText_email"));

    public static final Target INPUT_CONTRASEÑA = Target.the("Insertar Contraseña").located(By.xpath("\t\n" +
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.EditText"));

    public static final Target BUTTON_INGRESAR = Target.the("Botn ingresar").located(By.id("com.exito.appcompania:id/AppCompatButton_ingresar"));

    public static final Target BUTTON_CONFIMRA = Target.the("boton confirmar").located(By.id("com.exito.appcompania:id/AppCompatButton_registrar"));

    public static final Target LOCATION = Target.the("Localización").located(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));

    public static final Target ENVIO = Target.the("Envio a domicilio").located(By.id("com.exito.appcompania:id/appCompatImageView_item_image"));

    public static final Target CONFIRMAR_DIRECCION = Target.the("Confirmar dirección").located(By.xpath("\t\n" +
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.HorizontalScrollView/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.view.ViewGroup[1]/android.widget.ImageView"));


    public static final Target BUTTON_CONTINUAR = Target.the("Boton para continuar").located(By.id("com.exito.appcompania:id/appCompatButton_continue"));

    public static final Target INPUT_BUSCAR = Target.the("Input para buscar").located(By.id("com.exito.appcompania:id/appCompatEditText_search_data_edit"));

    public static final Target BUTTON_AGREGAR = Target.the("Agregar nevera").located(By.id("\t\n" +
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]"));

    public static final Target BUTTON_CARRITO = Target.the("Ver carrito").located(By.id("com.exito.appcompania:id/appCompatImageView_shopping_cart"));

    public static final Target COMPARAR_TEXTO = Target.the("texto elemento").located(By.id("(//android.view.View[@content-desc=\"Nevera HACEB No Frost 243 9002257\"])[2]/android.widget.TextView"));
}
