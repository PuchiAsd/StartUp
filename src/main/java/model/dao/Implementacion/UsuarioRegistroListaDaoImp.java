package model.dao.Implementacion;

import model.connection.MySqlConnection;
import model.dao.Interface.IUsuarioRegistroListaDao;
import model.models.AutoDTO;
import model.models.UsuarioRegistroDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRegistroListaDaoImp implements IUsuarioRegistroListaDao {

    private static final String SELECT_USUARIO_AUTO_ROL = "SELECT  usuario.id, usuario.nombre, usuario.correo, usuario.apodo, " +
            "direccion.nombre, rol.nombre, auto.nombre, auto.url, p.nombre FROM usuarios as usuario\n" +
            "LEFT   JOIN usuarios_roles as usuarioRol ON      usuario.id = usuarioRol.id_usuarios\n" +
            "LEFT   JOIN roles as rol ON      rol.id = usuarioRol.id_roles\n" +
            "LEFT   JOIN autos as auto ON      auto.id = usuario.id_autos\n" +
            "LEFT   JOIN proveedores as p ON  auto.id_proveedores = p.id\n" +
            "LEFT   JOIN direcciones as direccion ON      usuario.id = direccion.id_usuarios";
    public List<UsuarioRegistroDTO> GetUsuarioRegistrado(){
        List<UsuarioRegistroDTO> listaUsuarios = new ArrayList<>();

        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_USUARIO_AUTO_ROL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                UsuarioRegistroDTO usuarioRegistro = new UsuarioRegistroDTO();
                usuarioRegistro.setId(rs.getInt("usuario.id"));
                usuarioRegistro.setNombre(rs.getString("usuario.nombre"));
                usuarioRegistro.setCorreo(rs.getString("usuario.correo"));
                usuarioRegistro.setApodo(rs.getString("usuario.apodo"));
                usuarioRegistro.setDireccion(rs.getString("direccion.nombre"));
                usuarioRegistro.setRol(rs.getString("rol.nombre"));
                usuarioRegistro.setAuto(rs.getString("auto.nombre"));
                usuarioRegistro.setUrl(rs.getString("auto.url"));
                usuarioRegistro.setProveedor(rs.getString("p.nombre"));

                listaUsuarios.add(usuarioRegistro);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return listaUsuarios;
    }
}
