<%-- 
    Document   : home
    Created on : 04-11-2016, 05:32:57 PM
    Author     : Duoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
        <script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body style="background-image: url(img/textura3.jpg)">

        <nav class="navbar navbar-default" style="background-color: #000" >
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
        <a class="navbar-brand" href="home.jsp">Inicio</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
       <li class="dropdown">
          <a href="home.jsp" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Liga <span class="caret"></span></a>
          <ul class="dropdown-menu">
              <li><a href="ingresarLiga.jsp">Agregar Liga</a></li>
              <li><a href="eliminarLiga.jsp">Eliminar Liga</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="listarLiga.jsp">Listar Ligas</a></li>
            <li role="separator" class="divider"></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="home.jsp" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Equipo <span class="caret"></span></a>
          <ul class="dropdown-menu">
              <li><a href="ingresarEquipo.jsp">Agregar Equipo</a></li>
              <li><a href="eliminarEquipo.jsp">Eliminar Equipo</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="listarEquipo.jsp">Listar Equipos</a></li>
            <li><a href="listajugadoresPorEuipo.jsp">Listar Jugadores por Equipo</a></li>
            <li><a href="listaCantidadJugadores.jsp">Listar Cantidad de Jugadores por Equipo</a></li>


          </ul>
        </li>
        <li class="dropdown">
          <a href="home.jsp" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Jugador <span class="caret"></span></a>
          <ul class="dropdown-menu">
              <li><a href="ingresarJugador.jsp">Agregar Jugador</a></li>
              <li><a href="eliminarJugador.jsp">Eliminar Jugador</a></li>
              <li><a href="modificarJugador.jsp">Modificar Jugador</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="listarJugador.jsp">Listar Jugadores</a></li>

          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</html>
