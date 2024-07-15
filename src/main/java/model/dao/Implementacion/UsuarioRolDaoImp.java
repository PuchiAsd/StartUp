package model.dao.Implementacion;

import model.connection.MySqlConnection;
import model.dao.Interface.IUsuarioRolDao;
import model.models.UsuarioRol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioRolDaoImp implements IUsuarioRolDao {
    private static final String INSERT_USUARIOROL = "INSERT INTO usuarios_roles (id_usuarios, id_roles) VALUES (?,?)";

    @Override
    public UsuarioRol InsertUsuarioRol(UsuarioRol paramUsuarioRol){
        try(Connection connection = MySqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_USUARIOROL)) {

            ps.setInt(1, paramUsuarioRol.getId_usuario());
            ps.setInt(2, paramUsuarioRol.getId_role());

            // Ejecuta la inserción y nos devuelve si fue válido
            int affectedRows =  ps.executeUpdate();

            // Valida si se inserto el registro
            if(affectedRows == 0){
                throw new SQLException("Falló Insertar UsuarioRol");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return paramUsuarioRol;
    }
}
