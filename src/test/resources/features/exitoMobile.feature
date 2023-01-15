#language: es
  Característica: Poder realizar el registro en  la aplicación y
    posteriormente inciar sesion para poder agregar un producto al carro de compras

  @appium
  Esquema del escenario: 01 Iniciar sesion despues de registrarse para agregar un producto

    Dado que Juan quiere agregar un producto en el exito
    Entonces procedera a realizar el ingreso y registro a la app con sus datos "<Correo>", "<Contraseña>"
    Y iniciara sesion para que agregar un item al carro
    Entonces pueda validar el item en el  carrito

    Ejemplos:
    |Contraseña|  Correo |
    |  testautomationchoucair@yopmail.com | testAutomationChoucair2.  |