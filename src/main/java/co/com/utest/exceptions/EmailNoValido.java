package co.com.utest.exceptions;

public class EmailNoValido extends AssertionError{

    public final String EMAIL_EXISTENTE = "Verifique el correo electornico, este correo ya esta refistrado";
    public EmailNoValido(String message, Throwable cause) {
        super(message, cause);
    }
}
