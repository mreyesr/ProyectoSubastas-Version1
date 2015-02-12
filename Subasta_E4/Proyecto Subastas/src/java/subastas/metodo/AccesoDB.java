
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class AccesoDB {
    public static Connection getConnection() throws SQLException{
    Connection cn = null;
    try{
      // Datos
      String driver = "com.mysql.jdbc.Driver";
      String url = "jdbc:mysql://localhost:3306/bdsubasta?user=root&password=root";
      //String user = "root";
      //String pass = "root";
      // Cargar el driver
      Class.forName(driver).newInstance();
      // Establecer la conexión
      cn = DriverManager.getConnection(url);
    }catch(SQLException e){
      throw e;
    }catch(ClassNotFoundException e){
      throw new SQLException("ERROR, no existe el driver.");
    } catch(Exception e){
      throw new SQLException("ERROR, no se tiene acceso al servidor.");
    } 
    return cn;
  }
}
