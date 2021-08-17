package com.co.lulobank.utils.enums;

public enum EnumVariableSesion {
    CANTIDAD_EMPLEADOS_EMPRESA("Cantidad empleados empresa"),
    DATOS_EMPLEADO_ESPECIFICO("Datos del empleado consultado"),
    DATOS_INGRESO_EMPLEADO("Informacion del cliente que se registra"),
    ID_CLIENTE("Identificador del cliente"),
    MENSAJE_RESPONSE_CONSULTA_CLIENTE_ESPECIFICO("Mensaje de la respuesta del empleado");

    private final String variableSesion;

    public String getVariableSesion() {
        return variableSesion;
    }

    EnumVariableSesion(String variableSesion) {
        this.variableSesion = variableSesion;
    }
}
