package com.co.lulobank.tasks;


import com.co.lulobank.exceptions.ConsumoServicioError;
import com.co.lulobank.models.DatosEmpleado;
import com.co.lulobank.models.ResponseEmpleado;
import com.co.lulobank.questions.CodigoRespuestaServicio;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpStatus;

import java.util.Map;

import static com.co.lulobank.exceptions.ConsumoServicioError.FALLO_CONSUMO_SERVICIO;
import static com.co.lulobank.utils.enums.EnumRecursosServicios.AGREGAR_EMPLEADO;
import static com.co.lulobank.utils.enums.EnumVariableSesion.DATOS_INGRESO_EMPLEADO;
import static com.co.lulobank.utils.enums.EnumVariableSesion.ID_CLIENTE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.CoreMatchers.equalTo;

public class IngresarEmpleadoEmpresa implements Task {

    private Map<String, String> datos;

    public IngresarEmpleadoEmpresa(Map<String, String> datos) {
        this.datos = datos;
    }

    public static IngresarEmpleadoEmpresa conLosDatos(Map<String, String> datos) {
        return instrumented(IngresarEmpleadoEmpresa.class, datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        DatosEmpleado datosEmpleado = new DatosEmpleado();
        datosEmpleado.setName(datos.get("Nombre"));
        datosEmpleado.setSalary(datos.get("Salario"));
        datosEmpleado.setAge(datos.get("Edad"));
        actor.attemptsTo(Post.to(AGREGAR_EMPLEADO.getRecurso())
                .with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .accept("gzip, deflate, br")
                        .body(datosEmpleado).log().all(true)));
        SerenityRest.lastResponse().then().log().all();
        actor.should(
                seeThat(CodigoRespuestaServicio.obtenido(), equalTo(HttpStatus.SC_OK))
                        .orComplainWith(ConsumoServicioError.class, FALLO_CONSUMO_SERVICIO));
        actor.remember(ID_CLIENTE.getVariableSesion(),
                SerenityRest.lastResponse().as(ResponseEmpleado.class).getDatosEmpleado().getId());
        actor.remember(DATOS_INGRESO_EMPLEADO.getVariableSesion(), datosEmpleado);
    }
}
