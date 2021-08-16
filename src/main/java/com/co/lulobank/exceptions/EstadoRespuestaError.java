package com.co.lulobank.exceptions;

public class EstadoRespuestaError extends AssertionError {

    public static final String ESTADO_RESPUESTA_ERROR =
            "El estado del response no es igual al esperado";

    public EstadoRespuestaError(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
