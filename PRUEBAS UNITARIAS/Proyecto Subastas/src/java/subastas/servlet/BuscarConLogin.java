
package subastas.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import subastas.bean.Articulo;
import subastas.dao.ArticuloDAO;
import subastas.interf.ArticuloIF;
import static subastas.metodo.ManejadorFechas.*;
import subastas.metodo.ObtenerDia;


@WebServlet(name = "BuscarConLogin", urlPatterns = {"/BuscarConLogin"})
public class BuscarConLogin extends HttpServlet {  
   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupero los parametros enviados desde el FORM
                HttpSession ses = request.getSession(true);
                
		String art = request.getParameter("articulo");
                String fecha = request.getParameter("fecha");
                String hora = request.getParameter("hora");
                
               
                Date day = new Date();
                day=deStringToDate(fecha);
                ObtenerDia d = new ObtenerDia();                
                Calendar cal  = Calendar.getInstance();
                cal.setTime(day);
                String dia = d.getDia(cal.get(Calendar.DAY_OF_WEEK));
              
               
                String diaActual = getFechaActual(); 
                int i=diferenciasDeFechas(deStringToDate(diaActual), day);
                if (i>=0){
                    System.out.println("Fecha Aceptable, aun puede parcipar en la subasta de ese articulo");
                    System.out.println(diaActual);
                    System.out.println(fecha);
                }else{
                    System.out.println("Fecha Rechazada, la subasta ya termino");
                    System.out.println(diaActual);
                }
		
		ArticuloIF a = new ArticuloDAO();
                
                List<Articulo> lArtCL = a.getArtDisponiblesConLogin(art,hora,fecha);
                
                Articulo arti = (Articulo) lArtCL.get(0);
                ses.setAttribute("articul", arti);
                
                
                ses.setAttribute("listaArtConLogin", lArtCL);
                 ses.setAttribute("fechaSubasta", fecha);
                
                RequestDispatcher rd;  
                rd = request.getRequestDispatcher("/bienvenido.jsp");
		rd.forward(request, response);
    }

    
 

}
