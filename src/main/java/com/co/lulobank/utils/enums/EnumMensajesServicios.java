package com.co.lulobank.utils.enums;

public enum EnumMensajesServicios {
    ACTUALIZACION("Successfully! Record has been updated."),
    CONSULTA_REGISTRO_ENCONTRADO("Successfully! Record has been fetched."),
    CONSULTA_REGISTRO_NO_ENCONTRADO("Successfully! The record has not been retrieved."),
    CREACION("Successfully! Record has been added."),
    ELIMINACION("Successfully! Record has been deleted");


    private final String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    EnumMensajesServicios(String recurso) {
        this.mensaje = recurso;
    }
}
