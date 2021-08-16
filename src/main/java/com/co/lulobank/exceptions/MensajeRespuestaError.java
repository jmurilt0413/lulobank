package com.co.lulobank.exceptions;

public class MensajeRespuestaError extends AssertionError {

    public static final String MENSAJE_RESPUESTA_ERROR =
            "El mensaje del response no es igual al esperado";

    public MensajeRespuestaError(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
