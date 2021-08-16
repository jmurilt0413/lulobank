package com.co.lulobank.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.co.lulobank.utils.enums.EnumVariableSesion.MENSAJE_RESPONSE_CONSULTA_CLIENTE_ESPECIFICO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidarMensaje implements Question<String> {
    public static ValidarMensaje consulta() {
        return new ValidarMensaje();
    }

    @Override
    public String answeredBy(Actor actor) {
        return theActorInTheSpotlight().recall(MENSAJE_RESPONSE_CONSULTA_CLIENTE_ESPECIFICO.getVariableSesion());
    }
}
