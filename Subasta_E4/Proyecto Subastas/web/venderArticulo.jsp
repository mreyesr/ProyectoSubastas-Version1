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
				Completa los campos e inmediatamente subiremos tu articulo
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
			
			<div class="body">
                        <form action="VenderServlet" method="post">	   
                        <p><label for="descripcion">Que venderas??</label><input placeholder="palabra clave de tu articulo" id="descripcion" name="descripcion" type="text" /></p>
                        <p><label for="comentario">Breve descripcion</label><input placeholder="Describe tu articulo"	 id="comentario" name="comentario" type="text" /></p>
                        <p><label for="precioBase">Precio</label><input placeholder="Fija el precio"  id="precioBase" name="precioBase" type="text" /></p>
                        <p><label for="fecha">Fecha</label><input id="fecha" name="fecha" type="date" /></p>
                        <p>A que hora deseas que inicie la subasta?</p>
                        <p><label for="hora">Hora</label>	
				<select name="hora">
                                    <option value="8">8:00 am</option>
                                    <option value="10">10:00 am</option>
                                    <option value="12">12:00 am</option>
                                    <option value="14">2:00 pm</option>
                                    <option value="16">4:00 pm</option>
                                    <option value="18">6:00 pm</option>
                                    <option value="20">8:00 pm</option>
                                    <option value="22">10:00 pm</option>
                                </select>
			</p>
                                        <span class="boton"><input name="commit" type="submit" value="Vende ya!!"></span>                        
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

