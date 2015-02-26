

<%@page import="subastas.bean.Articulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <jsp:useBean id="listaArtConLogin" class="java.util.ArrayList" scope="session"/>
        <script>
$(document).ready(function(){
    $("#txtingreso").focus();
    $("#txtsalida").css('background-color','#FFFF11');
    $("#boton1").click(
         function() {
     
      if (isNaN($('#txtingreso').val())) {
	          $('#txtingreso').css('border-color','#FF0000');
                  alert('Tienes que ingresar numeros !');	 
       } else {

   if (parseInt($("#txtingreso").val()) <=  parseInt($("#txtsalida").val())){
    $('#txtingreso').css('border-color','#FF0000');
   alert('El número a ingresar debe ser mayor al fijado por el último subastador'); 
    		  
    	   }else{
      
	          $("#txtsalida").val($("#txtingreso").val());
                  setInterval(function(){window.location='bienvenido.jsp';alert('habiendo pasado 30 segundos, ya tenemos ganador:    ${sessionScope.usuarioactual.nombre}.   Gracias por participar')},30000);
                  
	          $("#txtingreso").val("");
          }
        }
       }
                     );

  
   
});
</script>
        
        <title>::PrincipalSubasta::</title>
        <jsp:include page="/layout/head.jsp"/>
    </head>
    
    <body>
        <header>
		<div class="logo">
			<img src="imagenes/logo_subasta.jpg" alt="Futbol5"/>
		</div>
		<div class="titular">
			<h1 class="titulo">
				Principal Subasta
			</h1>
			<div>
				<a href="#" class="filtro">
					Casa de Subastas
				</a>
				
                              
                                 <a href="/Subastas/bienvenido.jsp" class="organizar">
					Salir
				</a>
                            
                            
			</div>
                    
                      

		</div>
	</header>
         
        
        <h3>Empezó la subasta del Articulo </h3> <h1> ${sessionScope.articul.descripcion}</h1><br><br>
        
        Usuario: <b> ${sessionScope.usuarioactual.usuario}</b> <br><br><br>
        
        
        
        
        PRECIO BASE: <input type="text" name="txtsalida" id="txtsalida" VALUE="${sessionScope.articul.precioBase}" READONLY/>
        <br/>
        <br/>

        Ingrese su propuesta <input type="text" name="txtingreso" id="txtingreso"/>
        <button id="boton1"> Aceptar </button>
        <br>
        <br>
       
        <footer>
            <jsp:include page="/layout/footer.jsp"/>
	</footer>
    </body>
</html>
