package com.co.lulobank.tasks;


import com.co.lulobank.exceptions.ConsumoServicioError;
import com.co.lulobank.models.ResponseEliminacionEmpleado;
import com.co.lulobank.questions.CodigoRespuestaServicio;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import org.apache.http.HttpStatus;

import static com.co.lulobank.exceptions.ConsumoServicioError.FALLO_CONSUMO_SERVICIO;
import static com.co.lulobank.utils.enums.EnumRecursosServicios.ELIMINAR_EMPLEADO;
import static com.co.lulobank.utils.enums.EnumVariableSesion.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.CoreMatchers.equalTo;

public class EliminarEmpleado implements Task {

    public EliminarEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    private final int idEmpleado;

    public static EliminarEmpleado conid(int idEmpleado) {
        return instrumented(EliminarEmpleado.class, idEmpleado);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(ELIMINAR_EMPLEADO.getRecurso().concat(String.valueOf(idEmpleado)))
                .with(requestSpecification -> requestSpecification
                        .accept("gzip, deflate, br")
                        .log().all(true)));
        SerenityRest.lastResponse().then().log().all();
        actor.should(
                seeThat(CodigoRespuestaServicio.obtenido(), equalTo(HttpStatus.SC_OK))
                        .orComplainWith(ConsumoServicioError.class, FALLO_CONSUMO_SERVICIO));
    }
}
