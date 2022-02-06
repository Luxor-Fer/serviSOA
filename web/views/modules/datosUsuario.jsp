<%-- 
    Document   : datosUsuario
    Created on : 30/01/2022, 16:07:54
    Author     : windows
--%>

<%@page import="Entidades.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="js/mostrarDatos.js" ></script>

        <title>Datos del Usuario</title>
    </head>
    <body>
        <%
            HttpSession nombre = (HttpSession) request.getSession();
            Usuarios usu = (Usuarios) nombre.getAttribute("usuario");
            String tip = ((Object) nombre.getAttribute("usuario")).getClass().getSimpleName();
        %>


        <div class="estiloHome" style="padding-left: 5%; padding-right: 5%; padding-top: 25px;">
            <form class="row g-3" id="formulario" method="POST" action="controlador?accion=guardarCambios">
                <div class="col-md-6">
                    <label for="inputCedula" class="form-label">Cedula</label>
                    <input type="text" class="form-control" id="inputCedula" name="inputCedula" value="<%= usu.getCED_USU()%>" readonly >
                </div>
                <div class="col-md-6">
                    <label for="inputDescuento" class="form-label">Descuento</label>
                    <input type="text" class="form-control" id="inputDescuento" name="inputDescuento" requiered value="<%= usu.getDES_USU()%>%" disabled>
                </div>
                <div class="col-md-6">
                    <label for="inputNombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="inputNombre" name="inputNombre" requiered value="<%= usu.getNOM_USU()%>" disabled>
                </div>
                <div class="col-md-6">
                    <label for="inputApellido" class="form-label">Apellido</label>
                    <input type="text" class="form-control" id="inputApellido" name="inputApellido"  requiered value="<%= usu.getAPE_USU()%>" disabled>
                </div>
                <div class="col-md-6">
                    <label for="inputDireccion" class="form-label">Direccion</label>
                    <input type="text" class="form-control" id="inputDireccion" name="inputDireccion" requiered  value="<%= usu.getDIR_USU()%>" disabled>
                </div>
                <div class="col-md-6">
                    <label for="inputTelefono" class="form-label">Telefono</label>
                    <input type="text" class="form-control" id="inputTelefono" name="inputTelefono" requiered value="<%= usu.getTEL_USU()%>" disabled>

                    <input type="hidden" name="btnradio" value="sucursal" >

                </div>

                <div class="col-md-10">
                    <button type="button" id="btneditar" class="btn btn-primary" >Editar</button>
                </div>
                <div class="col-md-2">
                    <button type="submit" id="guardar" name="guardar" class="btn btn-primary" disabled>Guardar Cambios</button>
                </div>
            </form>
        </div>

    </body>
</html>
