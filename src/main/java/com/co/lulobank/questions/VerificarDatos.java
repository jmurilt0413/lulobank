package com.co.lulobank.questions;

import com.co.lulobank.models.DatosEmpleado;
import com.co.lulobank.models.ResponseEmpleado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificarDatos implements Question<Boolean> {

    private final DatosEmpleado datosEmpleado;
    private final ResponseEmpleado responseEmpleado;

    public VerificarDatos(DatosEmpleado datosEmpleado, ResponseEmpleado responseEmpleado) {
        this.datosEmpleado = datosEmpleado;
        this.responseEmpleado = responseEmpleado;
    }


    public static VerificarDatos consultados(DatosEmpleado datosEmpleado, ResponseEmpleado responseEmpleado) {
        return new VerificarDatos(datosEmpleado,responseEmpleado);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return null;
    }
}
