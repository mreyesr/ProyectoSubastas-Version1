<%-- 
    Document   : login
    Created on : 06/09/2014, 03:17:48 PM
    Author     : Cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  



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
				Bienvenido
			</h1>
			<div>
				<a href="#" class="filtro">
					Casa de Subastas
				</a>
				<a href="/Subastas/registro.jsp" class="organizar">
					Registrate aqui
				</a>
                            
                            <a href="/Subastas/login.jsp" class="organizar">
					Iniciar Sesion
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
                            
                              <h2 class="titulo">Si deseas comprar o vender es necesario que crees una cuenta e inicies sesion :)</h2>

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
