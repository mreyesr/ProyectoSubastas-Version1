/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package subastas.interf;

import java.util.List;

/**
 *
 * @author Richard
 */
public interface ArticuloIF {
    public List getArtDisponiblesSinLogin(String descripcion);
    public List getArtDisponiblesConLogin(String descripcion,String hora,String fecha);
    public void registrarArticulo(String descripcion,String comentario,double precioBase,int idusuario, String fecha, int hora);
    
}
