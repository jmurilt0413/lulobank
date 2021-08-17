package com.co.lulobank.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "salary",
        "age",
        "id"
})
@Getter
public class DatosEmpleado {

    @JsonProperty("name")
    @JsonAlias("employee_name")
    @Setter
    private String name;
    @JsonProperty("salary")
    @JsonAlias("employee_salary")
    @Setter
    private String salary;
    @JsonProperty("age")
    @JsonAlias("employee_age")
    @Setter
    private String age;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("profile_image")
    private String profileImage;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DatosEmpleado.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("salary");
        sb.append('=');
        sb.append(((this.salary == null) ? "<null>" : this.salary));
        sb.append(',');
        sb.append("age");
        sb.append('=');
        sb.append(((this.age == null) ? "<null>" : this.age));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object responseObject) {
        if (responseObject == this) {
            return true;
        } else if ((responseObject == null) || ((responseObject instanceof DatosEmpleado) == false)) {
            return false;
        }
        DatosEmpleado rhs = ((DatosEmpleado) responseObject);
        return ((((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))
                && ((this.salary == rhs.salary) || ((this.salary != null) && this.salary.equals(rhs.salary))))
                && ((this.age == rhs.age) || ((this.age != null) && this.age.equals(rhs.age))));
    }

}
