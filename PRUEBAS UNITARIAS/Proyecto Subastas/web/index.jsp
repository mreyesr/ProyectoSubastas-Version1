<%-- 
    Document   : login
    Created on : 06/09/2014, 03:17:48 PM
    Author     : Cesar
--%>

<%@page import="subastas.bean.Articulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listaArtSinLogin" class="java.util.ArrayList" scope="session"/>
  



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

		<div class="partidos">

                    <div class="header">                        
                    </div>
                    <article class="partido">
			<div class="body">                            
                              <h2 class="titulo">Si deseas comprar o vender es necesario que crees una cuenta e inicies sesion :)</h2>			
                                <form action="BuscarSinLogin" method="post">				    
				       <p><label for="articulo"><img src="imagenes/lupa.jpg" alt="Futbol5" width='200' height='200'/>Algo en especial?</label><input placeholder="Ingrese lo q desea buscar" id="articulo" name="articulo" type="text" /></p>                                       
				      <span class="boton"><input name="commit" type="submit" value="Buscar"></span>
 				</form>
			</div> 
                     </article>
                    <article class="partido">
                        <p>
                         Puede encontrarnos en:
                        </p>
    
                         <section>                          
                                    <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d7802.745097521114!2d-76.96989332009888!3d-12.086628404627008!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xc55a9050acb093fc!2sUniversidad+de+Lima!5e0!3m2!1ses-419!2s!4v1423704687660" width="530" height="380" frameborder="0" style="border:0"></iframe>
                         </section>
                        
                    </article>
		</div>                
	</div>
    
    
    
    
    
    
        <section class="partidos">
            
                <% if (listaArtSinLogin != null ) { %> 
                <h2 class="titulo">Resultados de la busqueda: </h2>
             	<%for (int i=0; i < listaArtSinLogin.size(); i++ ) {Articulo c = (Articulo)listaArtSinLogin.get(i);%>

				<article class="partido">
					<div class="descripcion">
						<figure class="imagen">
							<img src="imagenes/articulos.jpg" />
						</figure>
						<div class="detalles">
							<h2 class="titulo">
								<%= c.getDescripcion() %>
							</h2>
							<p class="autor">
								Comentario: <span class="nombreAutor"><%= c.getComentario() %></span> &nbsp &nbsp &nbsp Precio Base: <span class="nombreAutor"><%= c.getPrecioBase() %></span>
							</p>
                                                        <p class="autor">
								Fecha: <span class="nombreAutor"><%= c.getDia() %></span> &nbsp &nbsp &nbsp &nbsp &nbsp Hora: <span class="nombreAutor"><%= c.getHora() %></span>
							</p>
							
							<p class="fecha"><strong></strong>Disponible</p>
						</div>
					</div>

					<div class="acciones">
                                            
						<div class="registro">
                            <a href="/Subastas/login.jsp" class="inscribirse">Subastar!!</a>
						</div>
						
					</div>
				
                
				 </article>
                             <%} %><% }else { %>
                	
                        <%}%>

			</section>
	<footer>
            <jsp:include page="/layout/footer.jsp"/>
	</footer>

</body>
</html>
