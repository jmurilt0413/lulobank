package com.co.lulobank.stepdefinitions;


import com.co.lulobank.exceptions.CompararDatosEmpleadosError;
import com.co.lulobank.exceptions.ConfirmarEliminacionEmpleado;
import com.co.lulobank.exceptions.ConfirmarMensajeEliminacionEmpleado;
import com.co.lulobank.models.DatosEmpleado;
import com.co.lulobank.questions.CompararDatosEmpleados;
import com.co.lulobank.questions.ConfirmarEliminacionDeUsuario;
import com.co.lulobank.tasks.ConsultaEmpleadoEspecifico;
import com.co.lulobank.tasks.EliminarEmpleado;
import com.co.lulobank.tasks.IngresarEmpleadoEmpresa;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.Map;

import static com.co.lulobank.exceptions.CompararDatosEmpleadosError.FALLO_COMPARACION_DATOS_EMPLEADO;
import static com.co.lulobank.exceptions.ConfirmarEliminacionEmpleado.FALLO_CONFIRMACION_ELIMINACION;
import static com.co.lulobank.exceptions.ConfirmarMensajeEliminacionEmpleado.FALLO_MENSAJE_ELIMINACION;
import static com.co.lulobank.exceptions.ConsumoServicioError.FALLO_CONSUMO_SERVICIO;
import static com.co.lulobank.utils.enums.EnumVariableSesion.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidarServiciosDummyStepDefinition {
    @Dado("que Juan registra el empleado con los siguientes datos")
    public void registrarEmpleado(Map<String, String> mapDatosCliente) {
        theActorInTheSpotlight().attemptsTo(IngresarEmpleadoEmpresa.conLosDatos(mapDatosCliente));
    }

    @Cuando("el empleado es eliminado de la compañia")
    public void eliminarEmpleado() {
        theActorInTheSpotlight().attemptsTo(EliminarEmpleado.conid(theActorInTheSpotlight()
                .recall(ID_CLIENTE.getVariableSesion())));
    }

    @Cuando("consulto el empleado")
    public void consultarEmpleado() {
        theActorInTheSpotlight().attemptsTo(ConsultaEmpleadoEspecifico.conid(theActorInTheSpotlight()
                .recall(ID_CLIENTE.getVariableSesion())));
    }

    @Entonces("el sistema lo registra")
    public void verificarRegistroEmpleado() {
        DatosEmpleado empleadoIngreso = theActorInTheSpotlight().recall(DATOS_INGRESO_EMPLEADO.getVariableSesion());
        DatosEmpleado empleadoRespuesta = theActorInTheSpotlight().recall(DATOS_EMPLEADO_ESPECIFICO.getVariableSesion());
        theActorInTheSpotlight().should(seeThat(
                CompararDatosEmpleados.sonIguales(empleadoIngreso, empleadoRespuesta)).orComplainWith(
                CompararDatosEmpleadosError.class, FALLO_COMPARACION_DATOS_EMPLEADO));

    }

    @Entonces("el sistema no lo registra")
    public void verificarEliminacionEmpleado() {
        DatosEmpleado empleadoRespuesta = theActorInTheSpotlight().recall(DATOS_EMPLEADO_ESPECIFICO.getVariableSesion());
        String mensajeEliminacion = theActorInTheSpotlight().recall(MENSAJE_RESPONSE_CONSULTA_CLIENTE_ESPECIFICO.getVariableSesion());
        theActorInTheSpotlight().should(
                seeThat(ConfirmarEliminacionDeUsuario.Exitosa(mensajeEliminacion)).orComplainWith(
                        ConfirmarMensajeEliminacionEmpleado.class, FALLO_MENSAJE_ELIMINACION),
                seeThat(CompararDatosEmpleados.sonIguales(null, empleadoRespuesta)).orComplainWith(
                        ConfirmarEliminacionEmpleado.class, FALLO_CONFIRMACION_ELIMINACION));
    }


}
