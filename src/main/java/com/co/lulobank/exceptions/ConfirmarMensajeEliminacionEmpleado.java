package com.co.lulobank.exceptions;

public class ConfirmarMensajeEliminacionEmpleado extends AssertionError {

    public static final String FALLO_MENSAJE_ELIMINACION =
            "El mensaje en el campo 'message' no denota una eliminacion";

    public ConfirmarMensajeEliminacionEmpleado(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
