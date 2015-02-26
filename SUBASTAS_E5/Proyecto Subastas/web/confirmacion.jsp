<%-- 
    Document   : hello
    Created on : 12/02/2015, 03:47:48 AM
    Author     : Richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="subastas.bean.Articulo"%>
<jsp:useBean id="listaArtConLogin" class="java.util.ArrayList" scope="session"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>::Confirmación::</title>
         <jsp:include page="/layout/head.jsp"/>
    </head>
    <body>
        <header>
		<div class="logo">
			<img src="imagenes/logo_subasta.jpg" alt="Futbol5"/>
		</div>
		<div class="titular">
			<h1 class="titulo">
				Confirmación 
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
        <h1 align="center">Has sido anotado en la subasta de:</h1>
        
        <% if (listaArtConLogin != null ) { %>                   
             	<%for (int i=0; i < listaArtConLogin.size(); i++ ) {Articulo c = (Articulo)listaArtConLogin.get(i);%>

				<article class="partido">
					<div class="descripcion">
						
						<div class="detalles">
							<h2 align="center" class="titulo">
								<%= c.getDescripcion() %>
							</h2>
							<p align="center" class="autor">
								Comentario: <span class="nombreAutor"><%= c.getComentario() %></span>
							</p>
                                                        <p align="center" class="autor">
								Para el dia <span class="nombreAutor"><%= c.getDia() %></span> &nbsp &nbsp &nbsp &nbsp &nbsp 
                                                                <br/> <br/> A las: <span class="nombreAutor"><%= c.getHora() %></span>
							</p>
							
                                                        
							
						</div>
					</div>

					
				
                
				 </article>
                             <%} %><% }else { %>
                	
                        <%}%>
        
  
        
        <footer>
            <jsp:include page="/layout/footer.jsp"/>
	</footer>
    </body>
</html>
