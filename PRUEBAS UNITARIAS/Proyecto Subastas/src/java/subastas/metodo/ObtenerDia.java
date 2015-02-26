/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package subastas.metodo;

/**
 *
 * @author Mari
 */
public class ObtenerDia {
    public String getDia(int i){
        String dia=null;
        
        switch(i)
            { case 1: dia="Domingo";
                break;
              case 2: dia="Lunes";
                break;
              case 3: dia="Martes";
                break; 
              case 4: dia="Miercoles";
                break;
              case 5: dia="Jueves";
                break;
              case 6: dia="Viernes";
                break;
              case 7: dia="Sabado";
                break;
            };  
        return dia;
    }
        
}
