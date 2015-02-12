/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package subastas.servlet;

import subastas.dao.UsuarioDAO;
import subastas.interf.UsuarioIF;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Richard
 */
public class RegistroServlet extends HttpServlet {

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                // Recupero los parametros enviados desde el FORM
                String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String user = request.getParameter("usuario");
                String correo = request.getParameter("email");
                String pass1 = request.getParameter("pass1");
                String pass2 = request.getParameter("pass2");
                
                
              
		HttpSession ses = request.getSession();
                UsuarioIF a = new UsuarioDAO();             
                
                System.out.println("serlet pe");
                
                if(a.verificarNickUsuario(user)==true){
                    ses.setAttribute("INSCRIPCION_INVALIDO_USER_REPETIDO", "Ya estan usando ese nombre de usuario. Intenta con otro");
                    RequestDispatcher rd = request.getRequestDispatcher("/registro.jsp");
                    rd.forward(request, response);
                }else if (pass1.equals(pass2)){                   
                            ses.removeAttribute("INSCRIPCION_INVALIDO_CONTRASEÑA");
                            ses.removeAttribute("INSCRIPCION_INVALIDO_USER_REPETIDO");
                            UsuarioIF ingresarU = new UsuarioDAO();
                            ingresarU.registrarUsuario(dni, nombre, apellido, user, pass1, correo);
                            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                            rd.forward(request, response);                
                       }else{
                            ses.setAttribute("INSCRIPCION_INVALIDO_CONTRASEÑA", "Las contraseña son diferentes");
                            RequestDispatcher rd = request.getRequestDispatcher("/registro.jsp");
                            rd.forward(request, response);                  
               }               
	}

}
