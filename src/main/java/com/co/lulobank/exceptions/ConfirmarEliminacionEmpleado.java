package com.co.lulobank.exceptions;

public class ConfirmarEliminacionEmpleado extends AssertionError {

    public static final String FALLO_CONFIRMACION_ELIMINACION =
            "Se encontraron datos en la confirmacion";

    public ConfirmarEliminacionEmpleado(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
