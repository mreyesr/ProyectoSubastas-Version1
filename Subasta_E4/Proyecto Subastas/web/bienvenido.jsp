<%-- 
    Document   : bienvenido
    Created on : 07/09/2014, 07:42:17 PM
    Author     : Richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="LOGIN_VALIDO" class="java.lang.String" scope="session" />
<jsp:useBean id="listaUser" class="java.util.ArrayList" scope="session" />
<%@page import="subastas.bean.Articulo"%>
<jsp:useBean id="listaArtConLogin" class="java.util.ArrayList" scope="session"/>
<jsp:useBean id="fechaSubasta" class="java.lang.String" scope="session"/>
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
				
                                <a href="/Subastas/venderArticulo.jsp" class="organizar">
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
                            
                              <h2 class="titulo">Bienvenido!! Ahora que perteneces a nuestra comunidad puedes vender o participar de una subasta :D</h2>

				 <form action="BuscarConLogin" method="post">				    
				       <p><label for="articulo"><img src="imagenes/subastaYa.jpg" alt="Futbol5" width='200' height='200'/>Subastar YA!!!</label><input placeholder="Que estas buscando?" id="articulo" name="articulo" type="text" /></p>
                                       <p><label for="fecha">Fecha</label><input id="fecha" name="fecha" type="date" /></p>
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
				      <span class="boton"><input name="commit" type="submit" value="Buscar"></span>
 				</form> 
                        </div>
 			
		</div>	 
                
	</div> 
    
    <section class="partidos">

                <% if (listaArtConLogin != null ) { %>                   
             	<%for (int i=0; i < listaArtConLogin.size(); i++ ) {Articulo c = (Articulo)listaArtConLogin.get(i);%>

				<article class="partido">
					<div class="descripcion">
						<figure class="imagen">
							<img src="imagenes/tv.jpg" />
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
                            <a href="#" class="inscribirse">Subastar!!</a>
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