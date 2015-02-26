

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>
$(document).ready(function(){
    $("#txtingreso").focus();
    $("#txtsalida").css('background-color','#FFFF11');
    $("#boton1").click(
         function() {
     
      if (isNaN($('#txtingreso').val())) {
	          $('#txtingreso').css('border-color','#FF0000');
                  alert('Tienes que ingresar numeros. Bestia !');	 
       } else {

   if (parseInt($("#txtingreso").val()) <=  parseInt($("#txtsalida").val())){
    $('#txtingreso').css('border-color','#FF0000');
   alert('El número a ingresar debe ser mayor al fijado por el último subastador'); 
    		  
    	   }else{
      
	          $("#txtsalida").val($("#txtingreso").val());
                  setInterval(function(){window.location='bienvenido.jsp';alert('habiendo pasado 10 segundos, ya tenemos ganador. Gracias por participar')},10000);
                  
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
         
        
        <h1>Empezó la subasta del Articulo </h1>
        PRECIO DE SUBASTA: <input type="text" name="txtsalida" id="txtsalida" READONLY/>
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
