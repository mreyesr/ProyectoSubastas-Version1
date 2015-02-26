
package subastas.dao;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import subastas.bean.Articulo;
/**
 *
 * @author User
 */
public class ArticuloDAOTest {
    
   private Articulo articulo;
    
    @Before
    public void setUp() {
    }
  
//    @Test
    public void testGetArtDisponiblesSinLogin() {
        
        articulo= new Articulo();
        /*
    private int idArticulo;
    private String descripcion;
    private String comentario;
    //private blob fotografia;
    private double precioBase;
    private int idusuario;
    private String dia;
    private int hora;
    private String tiposubasta;
        */
        
        articulo.setDescripcion("Tv");
        
        
        
        
  //      System.out.println("getArtDisponiblesSinLogin");
        String descripcion = "Tv";
        
        ArticuloDAO instance = new ArticuloDAO();
        List expResult = null;
        List result = instance.getArtDisponiblesSinLogin(descripcion);
        
        
      //  assertEquals(expResult, result);
       
        
    }

  // @Test
    public void testRegistrarArticulo() {
        System.out.println("registrarArticulo");
         
         
        articulo= new Articulo();
        
        articulo.setDescripcion("TV");
        articulo.setComentario("Es negro");
        articulo.setPrecioBase(110.00);
        articulo.setIdusuario(11);
        articulo.setDia("2015-02-28");
        articulo.setHora(16);
        articulo.setTiposubasta("Directa");    
        
       
      
        ArticuloDAO a1 = new ArticuloDAO();          
      
        /*     
        
        a1.registrarArticulo(articulo.getDescripcion(),
                articulo.getComentario(),
                articulo.getPrecioBase(),
                articulo.getIdusuario(),
                articulo.getDia(), 
                articulo.getHora(),
                articulo.getTiposubasta());
        
          
        */  
        
        
        
       
    }

   


    
    @Test
    public void testGetArtDisponiblesConLogin() {
        
        System.out.println("getArtDisponiblesConLogin");
        articulo= new Articulo();
        
        articulo.setDescripcion("TV");
       // articulo.setComentario("Es negro");
       // articulo.setPrecioBase(110.00);
       // articulo.setIdusuario(11);
        articulo.setDia("2015-02-28");
        articulo.setHora(16);
       // articulo.setTiposubasta("Directa");    
        

        
        ArticuloDAO instance1 = new ArticuloDAO();
     
       List result = instance1.getArtDisponiblesConLogin(articulo.getDescripcion(),Integer.toString(articulo.getHora()), articulo.getDia());
        
        boolean expResult = false;
        
        
        
         String x = instance1.getClass().getSimpleName();
        System.out.print("\neee  "+x + "\n .");
        
       /* 
        assertEquals("La descripción del articulo esta mal ","TV", );
        assertEquals("La hora del articulo esta mal ","2015-02-28", );
        assertEquals("El día del articulo esta mal ",16, );
        */
    }
    
}
