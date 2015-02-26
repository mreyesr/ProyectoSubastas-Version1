<%-- 
    Document   : inscripcion
    Created on : 07/09/2014, 06:51:08 PM
    Author     : Richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="subastas.bean.Usuario" %>    
<jsp:useBean id="INSCRIPCION_INVALIDO_CONTRASEÑA" class="java.lang.String" scope="session" />
<jsp:useBean id="INSCRIPCION_INVALIDO_USER_REPETIDO" class="java.lang.String" scope="session" />
<!DOCTYPE html>
<html lang="es">
<head>
    <jsp:include page="/layout/head.jsp"/>
</head>
<body>

	<header>
		<div class="logo">
			<img src="imagenes/logo_subasta.jpg" alt="Futbol5"/>
		</div>
		<div class="titular">
			<h1 class="titulo">
				Gracias por unirte a nuestra comunidad
			</h1>
			<div>
				<a href="/Subastas/index.jsp" class="filtro">
					Casa de Subastas
				</a>
			</div>
		</div>
	</header>

	<nav>
		<ul class="menu">
			
		</ul>
	</nav>

	<div  class="container">
		<div class="main_content">
			<div class="header">
				
				<div class="hit">¿Ya tienes una cuenta? <a href="/Subastas/login.jsp">Inicia Sesion</a>
				</div>
			</div>
			<div class="body">
                    <form action="RegistroServlet" method="post">	   
                        <p><label for="usuario">DNI</label><input placeholder="Ingresa tu DNI" id="dni" name="dni" type="text" /></p>
                        <p><label for="nombre">Nombre</label><input placeholder="Ingresa tu nombre"	 id="nombre" name="nombre" type="text" /></p>
                        <p><label for="apellido">Apellido</label><input placeholder="Ingresa tu pellido"  id="apellido" name="apellido" type="text" /></p>
                        <p><label for="usuario">Usuario</label><input placeholder="Escoge un nick_name" id="usuario" name="usuario" type="text" /></p>                        
                        <p><label for="email">E-mail</label><input placeholder="Ingresa tu correo"  id="email" name="email" type="text" /></p>
                       <p><label for="pass1">Contraseña</label><input placeholder="Ingresa una contraseña" id="pass1" name="pass1" type="password" /></p>
                        <p><label for="pass2">Confirmar Contraseña</label><input placeholder="Reingresa tu contraseña" id="pass2" name="pass2" type="password" /></p>
                        <span class="boton"><input name="commit" type="submit" value="Registrate ya!!"></span>                        
                    </form>
                     				 	
			</div>
			<div class="footer">
 				<span class="error"><%= INSCRIPCION_INVALIDO_CONTRASEÑA %></span>
                                <span class="error"><%= INSCRIPCION_INVALIDO_USER_REPETIDO %></span>
 			</div>					                
		</div>	
	</div>
              
	
	<footer>
       <jsp:include page="/layout/footer.jsp"/>
	</footer>

  
</body>
</html>

