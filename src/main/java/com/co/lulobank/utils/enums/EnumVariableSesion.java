package com.co.lulobank.utils.enums;

public enum EnumVariableSesion {
    CANTIDAD_EMPLEADOS_EMPRESA("Cantidad empleados empresa"),
    ID_CLIENTE("Identificador del cliente"),
    DATOS_INGRESO_EMPLEADO("Datos cliente"),
    IDENTIFICADOR_RESPONSE_ELIMINACION("Identificador eliminacion"),
    MENSAJE_RESPONSE_CONSULTA_CLIENTE_ESPECIFICO("Response de la eliminacion del empleado"),
    RESPONSE_CLIENTE("Response ingreso cliente"),
    DATOS_EMPLEADO_ESPECIFICO("Response consulta cliente"),
    DATOS_ACTUALIZAR("Datos que se van actualizar"),
    RESPONSE_ELIMINACION_CLIENTE("Response de la eliminacion del empleado");

    private final String variableSesion;

    public String getVariableSesion() {
        return variableSesion;
    }

    EnumVariableSesion(String variableSesion) {
        this.variableSesion = variableSesion;
    }
}
