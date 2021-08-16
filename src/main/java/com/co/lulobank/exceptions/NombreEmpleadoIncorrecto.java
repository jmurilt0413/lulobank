package com.co.lulobank.exceptions;

public class NombreEmpleadoIncorrecto extends AssertionError {

    public static final String NOMBRE_EMPLEADO_INCORRECTO =
            "El nombre del empleado no es igual al esperado";

    public NombreEmpleadoIncorrecto(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
