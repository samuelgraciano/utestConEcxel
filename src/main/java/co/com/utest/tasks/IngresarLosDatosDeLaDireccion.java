package co.com.utest.tasks;

import co.com.devco.automation.mobile.actions.WaitFor;
import co.com.utest.userinterface.UtestDatosDeDireccion;

import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;

import org.openqa.selenium.Keys;



import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarLosDatosDeLaDireccion implements Task {
    private String ciudad;
    private String codigoPostal;
    private String pais;

    public IngresarLosDatosDeLaDireccion(String ciudad, String codigoPostal, String pais) {
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }

    public static IngresarLosDatosDeLaDireccion en(String ciudad, String codigoPostal, String pais) {
        return Tasks.instrumented(IngresarLosDatosDeLaDireccion.class, ciudad, codigoPostal, pais);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Enter.theValue(ciudad).into(UtestDatosDeDireccion.CIUDAD),
                WaitFor.seconds(1),
                Hit.the(Keys.ARROW_DOWN).into(UtestDatosDeDireccion.CIUDAD),
                Hit.the(Keys.ENTER).into(UtestDatosDeDireccion.CIUDAD),
                Enter.theValue(codigoPostal).into(UtestDatosDeDireccion.CODIGO_POSTAL),
                Click.on(UtestDatosDeDireccion.CLICK_ESPACIO_PAIS),
                WaitUntil.the(UtestDatosDeDireccion.PAIS.of(pais),isVisible()).forNoMoreThan(5).seconds(),
                Click.on(UtestDatosDeDireccion.BOTON_SIGUIENTE));

    }
}
