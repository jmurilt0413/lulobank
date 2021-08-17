package com.co.lulobank.exceptions;

public class ConfirmarEliminacionEmpleado extends AssertionError {

    public static final String FALLO_CONFIRMACION_ELIMINACION =
            "El campo 'data' deberia ser nulo, en cambio trae informacion";

    public ConfirmarEliminacionEmpleado(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
