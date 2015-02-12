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
                
              
		HttpSession ses = request.getSession();
                ArticuloIF a = new ArticuloDAO();
                
                // Le estoy seteando un idusuario cualquiera (mretis - idusuario=5 -)
                // pero se debe crear un metodo que haga un select y almacene en una variable el idusuario
                int idusuario = 5;                
                
                a.registrarArticulo(descripcion, comentario, precioBase,idusuario, fecha, hora);
                
                System.out.println("serlet pe");
                
                RequestDispatcher rd;  
                rd = request.getRequestDispatcher("/hello.jsp");
		rd.forward(request, response);                 
               }
       
    }

   

