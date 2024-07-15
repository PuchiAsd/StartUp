package model.dao.Implementacion;

import model.connection.MySqlConnection;
import model.dao.Interface.IDireccionDao;
import model.models.Direccion;

import java.sql.*;

public class DireccionDaoImp  implements IDireccionDao {
    private static final String INSERT_DIRECCION = "INSERT INTO direcciones (nombre, numero, id_usuarios) VALUES (?,?,?)";
    @Override
    public Direccion InsertDireccion(Direccion paramdireccion){
        try(Connection connection = MySqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_DIRECCION)) {

            ps.setString(1, paramdireccion.getNombre());
            ps.setInt(2, paramdireccion.getNumero());
            ps.setInt(3, paramdireccion.getId_usuario());

            // Ejecuta la inserción y nos devuelve si fue válido
            int affectedRows =  ps.executeUpdate();

            // Valida si se inserto el registro
            if(affectedRows == 0){
                throw new SQLException("Falló Insertar Direccion");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return paramdireccion;
    }
}
