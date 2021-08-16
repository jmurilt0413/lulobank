package com.co.lulobank.tasks;



import com.co.lulobank.exceptions.ConsumoServicioError;
import com.co.lulobank.models.ResponseEmpleado;
import com.co.lulobank.questions.CodigoRespuestaServicio;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.Collections;


import static com.co.lulobank.exceptions.ConsumoServicioError.FALLO_CONSUMO_SERVICIO;
import static com.co.lulobank.utils.enums.EnumRecursosServicios.CONSULTA_EMPLEADOS_GENERAL;
import static com.co.lulobank.utils.enums.EnumVariableSesion.CANTIDAD_EMPLEADOS_EMPRESA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ConsultaEmpleados implements Task {

    public static ConsultaEmpleados generalEmmpresa() {
        return new ConsultaEmpleados();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(CONSULTA_EMPLEADOS_GENERAL.getRecurso())
                .with(requestSpecification -> requestSpecification
                        .log().all(true)));
        SerenityRest.lastResponse().then().log().all();
        actor.should(
                seeThat(CodigoRespuestaServicio.obtenido(), equalTo(HttpStatus.SC_OK))
                        .orComplainWith(ConsumoServicioError.class, FALLO_CONSUMO_SERVICIO));
        actor.remember(CANTIDAD_EMPLEADOS_EMPRESA.getVariableSesion(),
                Collections.singletonList(SerenityRest.lastResponse()
                        .as(ResponseEmpleado.class).getDatosEmpleado()).size());
        actor.remember("prueba",
                Arrays.asList(SerenityRest.lastResponse()
                        .as(ResponseEmpleado.class).getDatosEmpleado()));
        actor.remember("prueba2",
                SerenityRest.lastResponse()
                        .as(ResponseEmpleado.class));
    }
}
