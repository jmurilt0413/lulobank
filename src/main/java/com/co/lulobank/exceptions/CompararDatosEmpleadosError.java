package com.co.lulobank.exceptions;

public class CompararDatosEmpleadosError extends AssertionError {

    public static final String FALLO_COMPARACION_DATOS_EMPLEADO =
            "Los datos de ingreso no son iguales a los datos consultados";

    public CompararDatosEmpleadosError(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
