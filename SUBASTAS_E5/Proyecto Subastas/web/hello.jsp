<%-- 
    Document   : hello
    Created on : 12/02/2015, 03:47:48 AM
    Author     : Richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="/layout/head.jsp"/>
    </head>
    
    <header>
		<div class="logo">
			<img src="imagenes/logo_subasta.jpg" alt="Futbol5"/>
		</div>
		<div class="titular">
			<h1 class="titulo">
				Confirmación de Registro de Artículo
			</h1>
			<div>
				<a href="#" class="filtro">
					Casa de Subastas
				</a>
				
                                <a href="/Subastas/bienvenido.jsp" class="organizar">
					Regresar
				</a>

			</div>
                    
                      

		</div>
	</header>

    
    <body>
        <h1 align="center">Tu articulo se ha registrado exitosamente</h1>
    
    </body>
    <footer>
            <jsp:include page="/layout/footer.jsp"/>
	</footer>
</html>
