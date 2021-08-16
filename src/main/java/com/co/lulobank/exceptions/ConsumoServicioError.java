package com.co.lulobank.exceptions;

public class ConsumoServicioError extends AssertionError {

    public static final String FALLO_CONSUMO_SERVICIO =
            "El servicio no respondió correctamente";

    public ConsumoServicioError(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
