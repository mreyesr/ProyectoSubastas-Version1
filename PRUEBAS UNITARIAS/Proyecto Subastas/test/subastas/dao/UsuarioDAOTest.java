package subastas.dao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import subastas.bean.Usuario;

public class UsuarioDAOTest {    
     private Usuario usuario;     
     
    // @Test 
     public void testArticulo(){
     
        usuario = new Usuario("12345678", "Lucio ", "Vaso", "a@a.com", "Gato123","gg");
        assertEquals( usuario.getDni()  ,"12345678" );
        assertEquals( usuario.getNombre(),"Lucio " );
        assertEquals( usuario.getApellidos(),"Vaso" );
        assertEquals( usuario.getCorreo(),"Gato123" );
        assertEquals( usuario.getUsuario(),"gg" );
        assertEquals( usuario.getContraseña(),"gg" );  
         
         
     }
     
     
     
  // @Test
    public void testVerificarUsuario() {
        System.out.println("verificarUsuario");
         //public Usuario(String dni, String nombre, String apellidos, String correo, String usuario, String contraseña)
        usuario = new Usuario("12345678", "Lucio ", "Vasoa", "a@a.com", "Gato123","gg");        
        String usuario = this.usuario.getUsuario();
        String passw = this.usuario.getContraseña();
        UsuarioDAO instance = new UsuarioDAO();
        boolean expResult = false;
        boolean result = instance.verificarUsuario(usuario, passw);
        assertEquals(expResult, result);
        assertTrue(usuario=="Gato123");
        assertTrue(passw=="gg"); 
    }    
  @Test
    public void testRegistrarUsuario() {
        System.out.println("registrarUsuario");
        
         usuario = new Usuario("12345678", "Lucio ", "Vaso", "Gato123", "gg","gg");          
        assertEquals( usuario.getDni()  ,"12345678" );
        assertEquals( usuario.getNombre(),"Lucio " );
        assertEquals( usuario.getApellidos(),"Vaso" );
        assertEquals( usuario.getCorreo(),"Gato123" );
        assertEquals( usuario.getUsuario(),"gg" );
        assertEquals( usuario.getContraseña(),"gg" );        
        UsuarioDAO instance = new UsuarioDAO();
        instance.registrarUsuario(usuario.getDni(),usuario.getNombre(), usuario.getApellidos(),usuario.getCorreo(), usuario.getUsuario(),usuario.getContraseña());
        //como hacer que un metodo te de los valores para controlar el assert.
        
        
        
        
        
    }

   
  //  @Test
    public void testVerificarSuscripcion() {
        System.out.println("verificarSuscripcion");
         usuario = new Usuario("12345678", "Luis ", "Cueva", "a@a.com", "Lcueva","jj");  
    
    }

    
  //  @Test
    public void testVerificarNickUsuario() {
        System.out.println("verificarNickUsuario");        
        usuario = new Usuario("12345678", "Luis ", "Cueva", "a@a.com", "Lcueva1","jj");        
        String usuario = "Lcueva1";
        UsuarioDAO v1 = new UsuarioDAO();     
        
        boolean expResult = false;
        boolean result = v1.verificarNickUsuario(usuario);
        
        
        assertEquals(expResult, result);
       
         
    }

    /**
    
     
    @Test
    public void testObtenerUsuario() {        
        usuario = new Usuario("12345678", "Luis ", "Cueva", "a@a.com", "Lcueva1","jj1");               
        System.out.println("obtenerUsuario");
       
    }
    */
}

    
    
    
    
    
    
    
    
    
    
    
   /*
    @Test
    public void testVerificarUsuario() {
        System.out.println("verificarUsuario");
        String usuario = "";
        String passw = "";
        UsuarioDAO instance = new UsuarioDAO();
        boolean expResult = false;
        boolean result = instance.verificarUsuario(usuario, passw);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testRegistrarUsuario() {
        System.out.println("registrarUsuario");
        String dni = "";
        String nombre = "";
        String apellido = "";
        String usuario = "";
        String contraseña = "";
        String correo = "";
        UsuarioDAO instance = new UsuarioDAO();
        instance.registrarUsuario(dni, nombre, apellido, usuario, contraseña, correo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testVerificarSuscripcion() {
        System.out.println("verificarSuscripcion");
        String iduser = "";
        UsuarioDAO instance = new UsuarioDAO();
        boolean expResult = false;
        boolean result = instance.verificarSuscripcion(iduser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testVerificarNickUsuario() {
        System.out.println("verificarNickUsuario");
        String usuario = "";
        UsuarioDAO instance = new UsuarioDAO();
        boolean expResult = false;
        boolean result = instance.verificarNickUsuario(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testObtenerUsuario() {
        System.out.println("obtenerUsuario");
        String usuario = "";
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = null;
        Usuario result = instance.obtenerUsuario(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
