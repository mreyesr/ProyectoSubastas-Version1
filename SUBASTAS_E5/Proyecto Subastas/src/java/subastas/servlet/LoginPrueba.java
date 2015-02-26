package subastas.servlet;

import subastas.bean.Usuario;
import subastas.dao.UsuarioDAO;
import subastas.interf.UsuarioIF;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginPrueba extends HttpServlet {

       @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                // Recupero los parametros enviados desde el FORM
                HttpSession ses = request.getSession(true);
		String user = request.getParameter("usuario");
		String pass = request.getParameter("passw");
		
		UsuarioIF a = new UsuarioDAO();
                
                //Se guarda el idUsuario para utilizarlo durante la sesion
                ses.setAttribute("idUser", user);
                
		  //si el usuario y password existen en la BD se hace esto:
		if (a.verificarUsuario(user, pass)==true){
                    //con esto se obtiene el bean y se guarda éste en la sesion.
			Usuario usuarioactual = a.obtenerUsuario(user);
                        request.getSession().setAttribute("usuarioactual", usuarioactual);
                    //y con esto se pasa a la siguiente pagina
			ses.removeAttribute("LOGIN_INVALIDO_CONTRASEÑA");
			RequestDispatcher rd = request.getRequestDispatcher("/bienvenido.jsp");
			rd.forward(request, response);
		}else{
                    //si el usuario y/o password no coinciden con el registrado eb la bd, regresa a login.jsp
                        ses.setAttribute("LOGIN_INVALIDO_CONTRASEÑA", "El usuario es incorrecto o la contraseña es incorrecta");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
	
    }   
                
    }