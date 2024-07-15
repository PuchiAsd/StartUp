package model.dao.Implementacion;

import model.connection.MySqlConnection;
import model.dao.Interface.IUsuarioDao;
import model.models.Usuario;

import java.sql.*;

public class UsuarioDaoImp implements IUsuarioDao {

    private static final String INSERT_USUARIO = "INSERT INTO usuarios(correo, clave, nombre, apodo, peso, fecha_creacion, fecha_modificacion, id_autos) values (?,?,?,?,?,?,?,?)";

    @Override
    public Usuario InsertUsuario(Usuario paramUsuario){
        try(Connection connection = MySqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_USUARIO, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, paramUsuario.getCorreo());
            ps.setString(2, paramUsuario.getClave());
            ps.setString(3, paramUsuario.getNombre());
            ps.setString(4, paramUsuario.getApodo());
            ps.setInt(5, paramUsuario.getPeso());
            ps.setDate(6, new Date(paramUsuario.getFecha_creacion().getTime()));
            ps.setDate(7,new Date(paramUsuario.getFecha_modificacion().getTime()));
            ps.setInt(8, paramUsuario.getId_auto());

            // Ejecuta la inserción y nos devuelve si fue válido
            int affectedRows =  ps.executeUpdate();

            // Valida si se inserto el registro
            if(affectedRows == 0){
                throw new SQLException("Falló Insertar Usuario");
            }

            // Obtiene el Id generado al momento de realizar el insert y asi podemos retornarlo en el modelo
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    paramUsuario.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falló al obtener el ID del usuario insertado.");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return paramUsuario;
    }
}