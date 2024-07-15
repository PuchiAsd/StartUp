package model.dao.Implementacion;

import model.connection.MySqlConnection;
import model.dao.Interface.IRolesDao;
import model.models.Roles;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RolesDaoImp implements IRolesDao {

    private static final String SELECT_ROLES = "SELECT id, nombre FROM roles";

    @Override
    public List<Roles> GetRoles() {
        List<Roles> listaRoles = new ArrayList<>();

        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ROLES);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Roles rol = new Roles();
                rol.setId(rs.getInt("id"));
                rol.setNombre(rs.getString("nombre"));

                listaRoles.add(rol);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return listaRoles;
    }
}
