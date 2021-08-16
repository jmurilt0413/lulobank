package com.co.lulobank.exceptions;

public class SalarioEmpleadoIncorrecto extends AssertionError {

    public static final String SALARIO_EMPLEADO_INCORRECTO =
            "El salario del empleado no es igual al esperado";

    public SalarioEmpleadoIncorrecto(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
