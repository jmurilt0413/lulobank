package com.co.lulobank.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodigoRespuestaServicio implements Question<Integer> {

    public static CodigoRespuestaServicio obtenido() {
        return new CodigoRespuestaServicio();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
}
