package com.co.lulobank.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Mensaje implements Question<Boolean> {

    private final String mensajeEsperado;
    private final String mensajeObtenido;

    public Mensaje(String mensajeEsperado, String mensajeObtenido) {
        this.mensajeEsperado = mensajeEsperado;
        this.mensajeObtenido = mensajeObtenido;
    }

    public static Mensaje respuesta(String mensajeEsperado, String mensajeObtenido) {
        return new Mensaje(mensajeEsperado, mensajeObtenido);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        return mensajeEsperado.equals(mensajeObtenido);
    }
}
