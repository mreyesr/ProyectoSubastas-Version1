package subastas.interf;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Cesar
 */
public interface UsuarioIF {
    
    public boolean verificarUsuario(String usuario,String passw); 
    public void registrarUsuario(String dni,String nombre,String apellido,String user,String pass1,String correo);    
    public boolean verificarSuscripcion(String iduser);
    public boolean verificarNickUsuario(String usuario);

    
}
