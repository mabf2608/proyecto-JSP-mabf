package users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthService implements AuthInterface{
    Connection conn = null;

    public AuthService(Connection conn){
        this.conn = conn;
    }

    @Override
    public User login(String username, String password) throws SQLException{
        //Varible conteniendo el Individuo a devolver
        User result = null;
        //Construimos la consulta a realizar
        Statement statement = this.conn.createStatement();    
        String sql = String.format("SELECT id_usu, nombre, apellido, correo FROM users WHERE username='%s' AND password='%s'", username, password);
        // Ejecución de la consulta
        ResultSet querySet = statement.executeQuery(sql);
        // Recorrido del resultado de la consulta
        if(querySet.next()) {
            //Obtenemos los datos del Individuo
            long id = querySet.getLong("id_usu");
            String nombre = querySet.getString("nombre");
            String apellido = querySet.getString("apellido");
            String correo = querySet.getString("correo");
            result = new User(id, nombre, apellido, correo, username);
        }
        //Cerramos la consulta
        statement.close();    
        //Devolvemos el individuo
        return result;
    }

    @Override
    public void logout() throws SQLException {
        throw new UnsupportedOperationException("Unimplemented method 'logout'");
    }

    @Override
    public User register(String nombre, String apellido, String correo, String password, String username) throws SQLException {
         
         Statement statement = this.conn.createStatement();    
         String sql = String.format("INSERT INTO users (nombre, apellido, correo, password, username) VALUES ('%s', '%s', '%s', '%s', '%s')",nombre, apellido, correo, password, username);
         // Ejecución de la consulta
         int affectedRows = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
         if (affectedRows == 0) {
             // Devolvemos una excepción si no se ha creado el individuo
             throw new SQLException("Creating user failed, no rows affected.");
         }
 
         //Aquí llegaremos si se ha creado satisfactoriamente el individuo
         try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
             if (generatedKeys.next()) {
                 //Devolvemos el identificador del individuo creado
                 long id = generatedKeys.getLong(1);
                 statement.close();
                 return new User(id, nombre, apellido, correo, username);
             }
             else {
                 //Aquí detectamos que hemos perdido conexión con el servidor de la
                 //base de datos y devolvemos una excepción
                 statement.close();
                 throw new SQLException("Creating user failed, no ID obtained.");
             }
         }
    }

    @Override
    public User update(long id, String nombre, String apellido, String correo, String username) throws SQLException {
        Statement statement = this.conn.createStatement();
        String sql = String.format("UPDATE users SET nombre = '%s', apellido = '%s', correo = '%s', username = '%s' WHERE id_usu = %d;", nombre, apellido, correo, username, id);
        int affectedRows = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
         if (affectedRows == 0) {
             // Devolvemos una excepción si no se ha actualizado el individuo
             throw new SQLException("Creating user failed, no rows affected.");
         }
         return new User(id, nombre, apellido, correo, username);
    }
    
}
