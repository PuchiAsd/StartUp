package model.dao.Implementacion;

import model.connection.MySqlConnection;
import model.dao.Interface.IUsuarioAutenticadoDao;
import model.models.UsuarioAutenticadoDTO;

import java.sql.*;
public class UsuarioAutenticadoDaoImp implements IUsuarioAutenticadoDao {

    private static final String SELECT_USUARIO_ROL = "SELECT usuario.nombre, usuario.correo, usuario.apodo, rol.nombre " +
                    "FROM usuarios AS usuario " +
                    "LEFT JOIN usuarios_roles AS usuarioRol ON usuario.id = usuarioRol.id_usuarios " +
                    "LEFT JOIN roles AS rol ON rol.id = usuarioRol.id_roles " +
                    "WHERE usuario.correo = ? AND usuario.clave = ?";

    @Override
    public UsuarioAutenticadoDTO ObtieneUsuarioAutenticado(String correo, String clave){
        UsuarioAutenticadoDTO usuarioAutenticadoDTO = new UsuarioAutenticadoDTO();

        try(Connection connection = MySqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_USUARIO_ROL)){

            ps.setString(1, correo);
            ps.setString(2, clave);
            ResultSet res = ps.executeQuery();

            while(res.next()){
                usuarioAutenticadoDTO.setNombre(res.getString("usuario.nombre"));
                usuarioAutenticadoDTO.setCorreo(res.getString("usuario.correo"));
                usuarioAutenticadoDTO.setApodo(res.getString("usuario.apodo"));
                usuarioAutenticadoDTO.setRol(res.getString("rol.nombre"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return usuarioAutenticadoDTO;
    }
}