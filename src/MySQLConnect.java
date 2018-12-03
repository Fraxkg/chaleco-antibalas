import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MySQLConnect {

	//DICE SI SE HIZO LA CONEXION A LA BDD
	Connection conexion = null;
	//HACER CONSULTAS
	Statement comando=null;
	//REGRESAR REGISTROS SI LOS SUBO A LA BDD
	ResultSet registros;
	
	
	
	
	//CONECCIÓN
	public Connection MySQLConnect() {

        try { 
            Class.forName("com.mysql.jdbc.Driver"); 
            String servidor = "jdbc:mysql://localhost:3306/hospital_proyecto"; 
            //DATOS DEL SERVIDOR LOCAL
            String usuario = "root";
            String pass = ""; 
            conexion = (Connection) DriverManager.getConnection(servidor, usuario, pass);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } finally {
           // JOptionPane.showMessageDialog(null, "Conexión Exitosa");
            return conexion;
        }
        	
    }
	
	//RESULTADOS
	 public ResultSet getQuery(String _query) {
	    	Statement state = null;
	    	ResultSet resultado = null;
	    	try {
	    		state = (Statement) conexion.createStatement();
	    		resultado = state.executeQuery(_query);
	    	}catch (Exception ex) {
	    		ex.printStackTrace();
	    	}
	    	return resultado;
	    }
	    
	 //
	    public void setQuery(String _query) {
	    	Statement state = null;
	    	ResultSet resultado = null;
	    	try {
	    		state = (Statement) conexion.createStatement();
	    		state.executeUpdate(_query);
	    	}catch (Exception ex) {
	    		ex.printStackTrace();
	    	} 
	    }
	
	
}

