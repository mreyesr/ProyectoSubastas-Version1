<%-- 
    Document   : bienvenido
    Created on : 07/09/2014, 07:42:17 PM
    Author     : Richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="LOGIN_VALIDO" class="java.lang.String" scope="session" />
<jsp:useBean id="listaUser" class="java.util.ArrayList" scope="session" />
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
				Logueo Exitoso
			</h1>
			<div>
				<a href="#" class="filtro">
					Casa de Subastas
				</a>
				<a href="#" class="organizar">
					Participar en Subasta
				</a>
                            
                            <a href="#" class="organizar">
					Vender
				</a>

			</div>
                    
                      

		</div>
	</header>

	<nav>
		<ul class="menu">
			
		</ul>
	</nav>

	<div class="container">

		<div class="main_content">

			<div class="header">
				
			</div>

			<div class="body">
                            
                              <h2 class="titulo">Bienvenido ahora que perteneces a nuestra comunidad puedes vender o participar de una subasta :D</h2>

				<form action="######" method="post">
				    
				    <p><label for="usuario">Buscar:</label><input placeholder="Que estas buscando?" id="usuario" name="###" type="text" /><input name="commit" type="submit" value="GO!!"></p>
                                    			    
 			        </form>
                            
                                

 			</div>
 			
		</div>	 
                
	</div>      
	<footer>
            <jsp:include page="/layout/footer.jsp"/>
	</footer>

</body>
</html>