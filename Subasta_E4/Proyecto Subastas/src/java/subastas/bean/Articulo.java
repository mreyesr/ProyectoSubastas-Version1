package subastas.bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.Serializable;


public class Articulo implements Serializable {
        
    private int idArticulo;
    private String descripcion;
    private String comentario;
    //private blob fotografia;
    private double precioBase;
    private int idusuaruio;
    private String dia;
    private int hora;

     public Articulo() {
    }

    public Articulo(int idArticulo, String descripcion, String comentario, double precioBase) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.comentario = comentario;
        this.precioBase = precioBase;
    }

    public Articulo(int idArticulo, String descripcion, String comentario, double precioBase, String dia, int hora) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.comentario = comentario;
        this.precioBase = precioBase;
        this.dia = dia;
        this.hora = hora;
    }
    
    

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getIdusuaruio() {
        return idusuaruio;
    }

    public void setIdusuaruio(int idusuaruio) {
        this.idusuaruio = idusuaruio;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
     
     

    
}
