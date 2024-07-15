package model.dao.Implementacion;

import model.connection.MySqlConnection;
import model.dao.Interface.ILoginDao;
import model.models.LoginDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImp implements ILoginDao {

    private static final String SELECT_LOGIN_USER = "SELECT correo, clave FROM usuarios WHERE correo=? AND clave=?";
    @Override
    public Boolean Login(LoginDTO paramLoginDTO){
        try(Connection connection = MySqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_LOGIN_USER)){

            ps.setString(1, paramLoginDTO.getCorreo());
            ps.setString(2, paramLoginDTO.getClave());

            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
