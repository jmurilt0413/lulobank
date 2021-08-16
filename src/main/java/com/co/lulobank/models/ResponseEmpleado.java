package com.co.lulobank.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "data",
        "message"
})
@Getter
public class ResponseEmpleado {

    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    @Setter
    private DatosEmpleado datosEmpleado;
    @JsonProperty("message")
    private String message;
}
