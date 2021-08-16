package com.co.lulobank.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data"
})
@Getter
public class ResponseEliminacionEmpleado {

    @JsonProperty("data")
    private String data;
    @JsonProperty("status")
    private String status;
    @JsonProperty("message")
    private String message;

}
