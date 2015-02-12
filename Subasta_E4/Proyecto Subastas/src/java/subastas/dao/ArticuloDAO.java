/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package subastas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import subastas.bean.Articulo;
import subastas.interf.ArticuloIF;
import subastas.metodo.ConnectionMySQL;

public class ArticuloDAO implements ArticuloIF {
    
    ConnectionMySQL mysql = new ConnectionMySQL();

    @Override
    public List getArtDisponiblesSinLogin(String descripcion) {
        
        Connection con = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
        String sql = "SELECT * FROM ARTICULO where descripcion=?";
        List<Articulo> lartSinLogin = new <Articulo>ArrayList();
		
		try {
			con = mysql.getConnection();
			// preparo la sentencia sql
			pstmt = con.prepareStatement(sql);
			// si hay parametros para el sql lo seteo
			
			pstmt.setString(1,descripcion);    
                        
                        // ejecuto la sentencia
			rs = pstmt.executeQuery();
			
			// proceso el resultset
			while ( rs.next() ) {
				lartSinLogin.add( new Articulo( rs.getInt("idArticulo"),
                                                        rs.getString("descripcion"),
                                                        rs.getString("comentario"),
                                                        rs.getDouble("precio base"),
                                                        rs.getString("fecha"),
                                                        rs.getInt("hora")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lartSinLogin;
    }
    

    @Override
    public void registrarArticulo(String descripcion, String comentario, double precioBase, int idusuario, String fecha, int hora) {
        Connection con = null;
		
                
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO articulo (`descripcion`, `comentario`, `fotografia`, `precio base`, `id_usuario`, `fecha`, `hora`) VALUES (?,?,?,?,?,?,?);";
				
		try {
			con = mysql.getConnection();
			pstmt = con.prepareStatement(sql);
			
		        pstmt.setString(1,descripcion);
                        pstmt.setString(2,comentario);
                        pstmt.setString(3,null);
                        pstmt.setDouble(4,precioBase);
                        pstmt.setInt(5,idusuario);
                        pstmt.setString(6,fecha);
                        pstmt.setInt(7,hora);
              		
			
			pstmt.executeUpdate();
                        
			
			// proceso el resultset
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
    }

    @Override
    public List getArtDisponiblesConLogin(String descripcion, String hora, String fecha) {
                Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
                int horaI=Integer.parseInt(hora);
                
		String sql = "SELECT * FROM ARTICULO where descripcion=? and hora=? and fecha=?";

                List<Articulo> lartConLogin = new <Articulo>ArrayList();
		
		try {
			con = mysql.getConnection();
			// preparo la sentencia sql
			pstmt = con.prepareStatement(sql);
			// si hay parametros para el sql lo seteo
			pstmt.setString(1,descripcion);
			pstmt.setInt(2,horaI);
                        pstmt.setString(3, fecha);
                        // ejecuto la sentencia
			rs = pstmt.executeQuery();
			
			// proceso el resultset
			while ( rs.next() ) {
				lartConLogin.add( new Articulo( rs.getInt("idArticulo"),
                                                        rs.getString("descripcion"),
                                                        rs.getString("comentario"),
                                                        rs.getDouble("precio base"),
                                                        rs.getString("fecha"),
                                                        rs.getInt("hora")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lartConLogin;
    }
    
}
