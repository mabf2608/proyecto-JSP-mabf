package users;

import java.sql.SQLException;

public interface AuthInterface {
    public User login(String username, String password) throws SQLException;
    public void logout() throws SQLException;
    public User register(String username, String nombre, String apellido, String correo, String password) throws SQLException;
    public User update(long id, String nombre, String apellido, String correo, String username) throws SQLException ;
}
