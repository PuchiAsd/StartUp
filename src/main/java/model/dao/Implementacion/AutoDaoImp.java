package model.dao.Implementacion;

import model.connection.MySqlConnection;
import model.dao.Interface.IAutoDao;
import model.models.AutoDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutoDaoImp implements IAutoDao {

    private static final String SELECT_AUTOS = "SELECT id, nombre FROM autos";

    @Override
    public List<AutoDTO> GetAutos(){
        List<AutoDTO> listaAutos = new ArrayList<>();

        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_AUTOS);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                AutoDTO auto = new AutoDTO();
                auto.setId(rs.getInt("id"));
                auto.setNombre(rs.getString("nombre"));
                listaAutos.add(auto);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return listaAutos;
    }
}