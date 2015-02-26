
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
import subastas.bean.Usuario;
import subastas.dao.ArticuloDAO;
import subastas.interf.ArticuloIF;

@WebServlet(name = "AnotarseSubasta", urlPatterns = {"/AnotarseSubasta"})
public class AnotarseSubasta extends HttpServlet {

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        HttpSession ses = request.getSession();
        
        
        Usuario usu = (Usuario)ses.getAttribute("usuarioactual");
        int idusu= (Integer)(usu.getIdusuario());
        
        List<Articulo> lArtCL = (List) ses.getAttribute("listaArtConLogin");
        Articulo art= (Articulo) lArtCL.get(0);
        int idart= (Integer)(art.getIdArticulo());
        
        
        ArticuloIF a = new ArticuloDAO();
        a.registrarTablaSubasta(idusu, idart);
        
        RequestDispatcher rd;  
                rd = request.getRequestDispatcher("/confirmacion.jsp");
		rd.forward(request, response); 
        
         
        
    }
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
