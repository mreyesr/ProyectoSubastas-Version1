package subastas.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import subastas.dao.UsuarioDAO;
import subastas.interf.ArticuloIF;
import subastas.interf.UsuarioIF;

/**
 *
 * @author Richard
 */
@WebServlet(name = "BuscarSinLogin", urlPatterns = {"/BuscarSinLogin"})
public class BuscarSinLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                // Recupero los parametros enviados desde el FORM
                HttpSession ses = request.getSession(true);
		String art = request.getParameter("articulo");
		
		ArticuloIF a = new ArticuloDAO();
                
                List<Articulo> lArtSL = a.getArtDisponiblesSinLogin(art);
                
                ses.setAttribute("listaArtSinLogin", lArtSL);
                
                RequestDispatcher rd;  
                rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	
    }
    
    
}
