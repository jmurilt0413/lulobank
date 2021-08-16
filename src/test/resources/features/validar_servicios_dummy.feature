# language: es
Característica: Ejecutar los principales verbos del API DummyResApiExample
  Yo como personal administrativo
  deseo realizar el ingreso, eliminacion y consulta de un empleado
  para garantizar el registro de los clientes en la compañia

  Antecedentes: Registrar usuario
    Dado que Juan registra el empleado con los siguientes datos
      | Nombre  | Jorge    |
      | Salario | 10000000 |
      | Edad    | 30       |

  Escenario: Consultar empleado
    Cuando consulto el empleado
    Entonces el sistema lo registra

  Escenario: Eliminar empleado
    Cuando el empleado es eliminado de la compañia
    Y consulto el empleado
    Entonces el sistema no lo registra



