<%-- 
    Document   : templatePlanta
    Created on : 04/02/2022, 23:55:45
    Author     : windows
--%>

<%@page import="Entidades.Planta"%>
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
    

    <title>Equipo Alfa Buena Maravilla Onda Dinamita Escuadron Lobo </title>
    </head>
    <body>
    <% 
        HttpSession nombre = (HttpSession)request.getSession();
        Planta usu = (Planta)nombre.getAttribute("usuario");
        String tip = ((Object)nombre.getAttribute("usuario")).getClass().getSimpleName(); 
    %>
<div>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href=""> <img class="avatar" src="img/jf.jpg" alt="jf"> </a>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="controlador?accion=datosUsuario" target="ventana"><%= usu.getNOM_PLA()%></a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="controlador?accion=datosUsuario" target="ventana">Sucursales</a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="controlador?accion=datosUsuario" target="ventana">Pedidos</a>
        </li>
        
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="controlador?accion=datosUsuario" target="ventana">Articulos</a>
        </li>

      </ul>
    </div>
    <a class="btn btn-danger" id="btnLogout" href="controlador?accion=index">Logout</a>
  </div>
</nav>
</div>
    <%--
    <script>
  var boton = document.getElementById("btnLogout");
  boton.onclick = function (){
    window.location="index.php";
  }
</script>
    --%>
    <section>
        <iframe name="ventana" style="height: 100%; width: 100%"></iframe>
    </section>
  
    
    
<footer class="bg-primary" style="text-align:center; position: fixed;bottom: 0px;width: 100%;height: 35px;">
  <p ><b>Copyright © 2022 | Carisoa </b> </p>
</footer>
</body>
</html>
