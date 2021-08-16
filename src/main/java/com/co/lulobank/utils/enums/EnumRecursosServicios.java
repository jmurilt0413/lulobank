package com.co.lulobank.utils.enums;

public enum EnumRecursosServicios {
  ACTUALIZAR_DATOS_EMPLEADO("update/"),
  AGREGAR_EMPLEADO("create"),
  CONSULTA_EMPLEADO("employee/"),
  CONSULTA_EMPLEADOS_GENERAL("employees"),
  ELIMINAR_EMPLEADO("delete/");

  private final String recurso;

  public String getRecurso() {
    return recurso;
  }

  EnumRecursosServicios(String recurso) {
    this.recurso = recurso;
  }
}
