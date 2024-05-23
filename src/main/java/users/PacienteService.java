package users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import crud.CRUD;

public class PacienteService implements CRUD<Paciente> {

    Connection conn;

    public PacienteService(Connection conn){
        this.conn = conn;
    }

    @Override
    public ArrayList<Paciente> query(String column, String value) throws SQLException {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        Statement statement = this.conn.createStatement();
        String sql = "SELECT * FROM paciente WHERE " + column + " = '" + value + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            long id = resultSet.getLong("id_pac");
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            String dni = resultSet.getString("dni");
            String fechaNac = resultSet.getString("fechaNac");
            String nSeg = resultSet.getString("nSeg");
            pacientes.add(new Paciente(id, nombre, apellido, dni, fechaNac, nSeg));
        }
        statement.close();
        return pacientes;
    }

    @Override
    public ArrayList<Paciente> query(String column, long value) throws SQLException {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        Statement statement = this.conn.createStatement();
        String sql = "SELECT * FROM paciente WHERE " + column + " = " + value;
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            long id = resultSet.getLong("id_pac");
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            String dni = resultSet.getString("dni");
            String fechaNac = resultSet.getString("fechaNac");
            String nSeg = resultSet.getString("nSeg");
            pacientes.add(new Paciente(id, nombre, apellido, dni, fechaNac, nSeg));
        }
        statement.close();
        return pacientes;
    }

    private ArrayList<Paciente> _requestAll(String sql) throws SQLException{
        ArrayList<Paciente> result = new ArrayList<Paciente>();
        Statement statement = this.conn.createStatement();   

        ResultSet querySet = statement.executeQuery(sql);
        while(querySet.next()) {
            long id = querySet.getLong("id_pac");
            String nombre = querySet.getString("nombre");
            String apellido = querySet.getString("apellido");
            String dni = querySet.getString("dni");
            String fechaNac = querySet.getString("fechaNac");
            String nSeg = querySet.getString("nSeg");
            result.add(new Paciente(id, nombre, apellido, dni, fechaNac, nSeg));
        } 

        statement.close();
        return result;
    }

    @Override
    public ArrayList<Paciente> requestAll(String sortedBy) throws SQLException{
        String sql = "SELECT id_pac, nombre, apellido, dni, fechaNac, nSeg FROM paciente" + 
                     (sortedBy.length() > 0 ? (" ORDER BY " + sortedBy) : "");
        return this._requestAll(sql);
    }

    @Override
    public Paciente requestById(long id) throws SQLException {
        Paciente paciente;
        String sql = "SELECT * FROM paciente WHERE id_pac = " + id;
        Statement statement = this.conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()){
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            String dni = resultSet.getString("dni");
            String fechaNac = resultSet.getString("fechaNac");
            String nSeg = resultSet.getString("nSeg");
            paciente = new Paciente(id, nombre, apellido, dni, fechaNac, nSeg);
            statement.close();
            return paciente;
        } else {
            throw new SQLException("No se ha podido encontrar al usuario");
        }
    }

    @Override
    public long create(Paciente model) throws SQLException {
        String sql = String.format("INSERT INTO `paciente` (`nombre`, `apellido`, `dni`, `fechaNac`, `nSeg`) VALUES ('%s', '%s', '%s', '%s', '%s')",
                                    model.getNombre(), model.getApellido(), model.getDni(), model.getFechaNac(), model.getNSeg());
        Statement statement = this.conn.createStatement();

        int rows = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        if (rows == 0){
            statement.close();
            throw new SQLException("No se ha podido crear el paciente, 0 filas creadas.");
        }

        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()){
            long id = resultSet.getLong(1);
            statement.close();
            return id;
        } else {
            statement.close();
            throw new SQLException("No se ha podido crear el paciente, fallo al devolver la key.");
        }
    }

    @Override
    public int update(Paciente object) throws SQLException {
        String sql = String.format("UPDATE `paciente` SET `nombre` = '%s', `apellido`= '%s', `dni` = '%s', `fechaNac`= '%s', `nSeg`= '%s' WHERE `id_pac` = %d",
                                    object.getNombre(), object.getApellido(), object.getDni(), object.getFechaNac(), object.getNSeg(), object.getId());
        Statement statement = this.conn.createStatement();
        int affectedRows = statement.executeUpdate(sql);
        statement.close();
        if (affectedRows == 0 ){
            throw new SQLException("No se ha podido actualizar la información del paciente, 0 columnas afectadas.");
        }
        return affectedRows;
    }

    @Override
    public boolean delete(long id) throws SQLException {
        String sql = String.format("DELETE FROM `paciente` WHERE `id_pac` = %d", id);
        Statement statement = this.conn.createStatement();
        int result = statement.executeUpdate(sql);
        statement.close();
        if (result != 0){
            return true;
        } else {
            throw new SQLException("Deleting idea failed, no rows affected.");
        }
    }
}
