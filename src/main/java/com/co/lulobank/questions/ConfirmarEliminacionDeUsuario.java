package com.co.lulobank.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.co.lulobank.utils.enums.EnumMensajesServicios.CONSULTA_REGISTRO_ENCONTRADO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConfirmarEliminacionDeUsuario implements Question<Boolean> {

    private String mensajeEliminacion;

    public ConfirmarEliminacionDeUsuario(final String mensajeEliminacion) {
        this.mensajeEliminacion = mensajeEliminacion;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return !mensajeEliminacion.equals(theActorInTheSpotlight().recall(CONSULTA_REGISTRO_ENCONTRADO.getMensaje()));
    }

    public static Question<Boolean> exitosa(final String mensajeEliminacion) {
        return new ConfirmarEliminacionDeUsuario(mensajeEliminacion);
    }
}
