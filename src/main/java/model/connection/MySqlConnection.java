package model.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private static MySqlConnection instance;
    private Connection connection;
    private String jdbcURL ="jdbc:mysql://localhost:3306/bd_startup";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234";

    private MySqlConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL, jdbcUsername,jdbcPassword);
        }catch ( SQLException | ClassNotFoundException e){
            throw new SQLException(e);
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public static MySqlConnection getInstance() throws SQLException {
        if(instance==null){
            instance = new MySqlConnection();
        }else if(instance.getConnection().isClosed()){
            instance = new MySqlConnection();
        }
        return instance;
    }
}