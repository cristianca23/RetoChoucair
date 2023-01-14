#language: es

  Característica: Realizar un proceso de consulta, ingreso, actualización o borrado en las
    bases de datos de los empleados de dummy

  @probarAPI
  Esquema del escenario: : : 01- Realizar un proceso de consulta, creación, actualización y borrado
    de empleados

    Dado que Juan necesita consultar la información de un  empleado
    Y actualizara la información del empleado con  "<name>", "<salary>", "<age>"
    Entonces el borrara  la información de otro empleado que ya no trabaja en la empresa
    Y Creara un nuevo empleado para reemplazar al que salio con  los datos "<name>", "<salary>", "<age>"
    Y consultara la información de todos los  empleados activos

    Ejemplos:
      |name       |salary | age|
      | test  | 123 | 23 |
