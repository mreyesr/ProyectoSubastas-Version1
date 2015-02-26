/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package subastas.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import subastas.bean.Usuario;
import subastas.dao.ArticuloDAO;
import subastas.dao.UsuarioDAO;
import subastas.interf.ArticuloIF;
import subastas.interf.UsuarioIF;

/**
 *
 * @author Richard
 */
@WebServlet(name = "VenderServlet", urlPatterns = {"/VenderServlet"})
public class VenderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // Recupero los parametros enviados desde el FORM
                String descripcion = request.getParameter("descripcion");
		String comentario = request.getParameter("comentario");
                String precio = request.getParameter("precioBase");
                String fecha = request.getParameter("fecha");
                
                String horaIngresada = request.getParameter("hora");
                int hora = Integer.parseInt(horaIngresada);
                
                Double precioBase=Double.parseDouble(precio);
                String tiposubasta = request.getParameter("tiposubasta");
                
         //recuperando el bean almacenado en la sesion con la variable "usuarioactual" y le saco lo que necesito: su idusuario
                HttpSession ses = request.getSession();
                Usuario usuarioactual= (Usuario) ses.getAttribute("usuarioactual");
                int idusuario = usuarioactual.getIdusuario();
                   
             //empieza a llamar a la clase que hara el trabajo de inserción, y a su metodo "registrarArticulo"            
                ArticuloIF a = new ArticuloDAO();
                        
                
                a.registrarArticulo(descripcion, comentario, precioBase,idusuario, fecha, hora, tiposubasta);
                
                                            
                RequestDispatcher rd;  
                rd = request.getRequestDispatcher("/hello.jsp");
		rd.forward(request, response);                 
               }
       
    }

   

