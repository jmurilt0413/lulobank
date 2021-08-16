package com.co.lulobank.exceptions;

public class EdadEmpleadoIncorrecta extends AssertionError {

    public static final String EDAD_EMPLEADO_INCORRECTO =
            "La edad del empleado no es igual a la esperada";

    public EdadEmpleadoIncorrecta(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
