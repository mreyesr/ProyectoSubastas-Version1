package subastas.dao;



import db.AccesoDB;
import subastas.metodo.ConnectionMySQL;
import static subastas.metodo.Encriptar.encriptaEnMD5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import subastas.bean.Usuario;
import subastas.interf.UsuarioIF;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Richard
 */
public class UsuarioDAO implements UsuarioIF{
    AccesoDB mysql = new AccesoDB();
    ConnectionMySQL mysql1 = new ConnectionMySQL();

    @Override
    public boolean verificarUsuario(String usuario, String passw) {
                String nickAux;
		String sql = "SELECT * FROM USUARIO";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs= null;
		boolean existe=false;
		con = mysql1.getConnection();
		usuario=usuario.toLowerCase();
			
		try {
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()){
				nickAux=rs.getString("usuario");
				
				if (usuario.equals(nickAux) && rs.getString("contraseña").equals(encriptaEnMD5(passw))){					
						existe=true;
						break;				
				} 
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
                               
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		return existe; 
        
    
    }

    @Override
    public void registrarUsuario(String dni,String nombre,String apellido,String usuario,String contraseña,String correo) {
       Connection con = null;
		int creditos = 0;
                
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO usuario (`dni`, `nombre`, `apellidos`, `usuario`, `contraseña`, `correo`) VALUES (?,?,?,?,md5(?),?);";
				
		try {
			con = mysql.getConnection();
			pstmt = con.prepareStatement(sql);
			
		        pstmt.setString(1,dni);
                        pstmt.setString(2,nombre);
                        pstmt.setString(3,apellido);
                        pstmt.setString(4,usuario.toLowerCase());
                        pstmt.setString(5,contraseña);
                        pstmt.setString(6,correo.toLowerCase());
              		
			
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
    public boolean verificarSuscripcion(String iduser) {
        boolean suscripcion=false;
        
        
        
        return suscripcion;
    
    }
    

    @Override
    public boolean verificarNickUsuario(String usuario) {
    
        String nickAux;
		String sql = "SELECT * FROM USUARIO where usuario=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs= null;
		boolean existeNick=false;
        try {
            con = mysql.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		usuario=usuario.toLowerCase();
			
		try {
			
			pstmt = con.prepareStatement(sql);
                            pstmt.setString(1, usuario);
			rs = pstmt.executeQuery();
			while(rs.next()){
                                //recupero el nickName de cada usuario registrado en la BD
				nickAux=rs.getString("usuario");
				//Si en algun punto del recorrido de la BD, el nickName que recupero de la web
                                //es igual a uno de la BD existeNick se hace true y se detiene el recorrido.
				if (usuario.equals(nickAux)){					
						existeNick=true;
						break;				
				} 		
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
                               
			} catch (SQLException e) {
				
				e.printStackTrace();
			}			
		}
		
		return existeNick;              
    }

    @Override
    public Usuario obtenerUsuario(String usuario) {
        
        Usuario bean = null;  
	  String sql = "select idusuario, dni, nombre, apellidos, usuario, contraseña, correo,credito from usuario where usuario=?";
          Connection cn = null;
	  try {
	    cn = AccesoDB.getConnection();
	    PreparedStatement pstm = cn.prepareStatement(sql);
	    pstm.setString(1, usuario);
	    
	    ResultSet rs = pstm.executeQuery();
	    if(rs.next()){
	    	bean = new Usuario();
	    	bean.setIdusuario(rs.getInt("idusuario"));
	    	bean.setDni(rs.getString("dni"));
	    	bean.setNombre(rs.getString("nombre"));
	    	bean.setApellidos(rs.getString("apellidos"));
	    	bean.setUsuario(rs.getString("usuario"));
	    	bean.setContraseña(rs.getString("contraseña"));
	    	bean.setCorreo(rs.getString("correo"));
                bean.setCredito(rs.getInt("credito"));
	    }
	    rs.close();
	    pstm.close();
	    if(bean == null){
	    	throw new SQLException("Datos incorrectos.");
	    }
    } catch (SQLException e) {
    	throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
    	throw new RuntimeException("ERROR, no se tiene acceso al servidor.");
    }finally {
    	try {
    		cn.close();
             } catch (Exception e2) {
                                }
             }

          
        return bean;

        
        
    }
   
}

