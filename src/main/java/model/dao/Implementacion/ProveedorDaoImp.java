package model.dao.Implementacion;

import model.connection.MySqlConnection;
import model.dao.Interface.IProveedorDao;
import model.models.Proveedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProveedorDaoImp implements IProveedorDao {
    private static final String INSERT_PROVEEDOR = "INSERT INTO proveedores (nombre) VALUES (?)";
    @Override
    public Proveedor InsertProveedor(Proveedor paramProveedor){
        try(Connection connection = MySqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_PROVEEDOR)) {

            ps.setString(1, paramProveedor.getNombre());

            // Ejecuta la inserción y nos devuelve si fue válido
            int affectedRows =  ps.executeUpdate();

            // Valida si se inserto el registro
            if(affectedRows == 0){
                throw new SQLException("Falló Insertar Proveedor");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return paramProveedor;
    }
}
