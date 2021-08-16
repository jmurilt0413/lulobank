package com.co.lulobank.questions;

import com.co.lulobank.models.DatosEmpleado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class CompararDatosEmpleados implements Question<Boolean> {

    private DatosEmpleado empleadoIngreso;
    private DatosEmpleado empleadoRespuesta;

    public CompararDatosEmpleados(DatosEmpleado empleadoIngreso, DatosEmpleado empleadoRespuesta) {
        this.empleadoIngreso=empleadoIngreso;
        this.empleadoRespuesta=empleadoRespuesta;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return empleadoIngreso.equals(empleadoRespuesta);
    }


    public static CompararDatosEmpleados sonIguales(final DatosEmpleado empleadoIngreso, final DatosEmpleado empleadoRespuesta) {
        return new CompararDatosEmpleados(empleadoIngreso, empleadoRespuesta);
    }
}
