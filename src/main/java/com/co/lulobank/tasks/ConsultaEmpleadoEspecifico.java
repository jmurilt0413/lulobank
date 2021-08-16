package com.co.lulobank.tasks;


import com.co.lulobank.exceptions.ConsumoServicioError;
import com.co.lulobank.models.ResponseEmpleado;
import com.co.lulobank.questions.CodigoRespuestaServicio;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.hc.core5.http.HttpStatus;

import static com.co.lulobank.exceptions.ConsumoServicioError.FALLO_CONSUMO_SERVICIO;
import static com.co.lulobank.utils.enums.EnumRecursosServicios.CONSULTA_EMPLEADO;
import static com.co.lulobank.utils.enums.EnumVariableSesion.DATOS_EMPLEADO_ESPECIFICO;
import static com.co.lulobank.utils.enums.EnumVariableSesion.MENSAJE_RESPONSE_CONSULTA_CLIENTE_ESPECIFICO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.CoreMatchers.equalTo;

public class ConsultaEmpleadoEspecifico implements Task {

    public ConsultaEmpleadoEspecifico(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    private final int idEmpleado;

    public static ConsultaEmpleadoEspecifico conid(int idEmpleado) {
        return instrumented(ConsultaEmpleadoEspecifico.class, idEmpleado);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(CONSULTA_EMPLEADO.getRecurso().concat(String.valueOf(idEmpleado)))
                .with(requestSpecification -> requestSpecification
                        .log().all(true)));
        SerenityRest.lastResponse().then().log().all();
        actor.should(
                seeThat(CodigoRespuestaServicio.obtenido(), equalTo(HttpStatus.SC_OK))
                        .orComplainWith(ConsumoServicioError.class, FALLO_CONSUMO_SERVICIO));
        actor.remember(DATOS_EMPLEADO_ESPECIFICO.getVariableSesion(),
                SerenityRest.lastResponse().as(ResponseEmpleado.class).getDatosEmpleado());
        actor.remember(MENSAJE_RESPONSE_CONSULTA_CLIENTE_ESPECIFICO.getVariableSesion(),
                SerenityRest.lastResponse().as(ResponseEmpleado.class).getMessage());
    }
}
