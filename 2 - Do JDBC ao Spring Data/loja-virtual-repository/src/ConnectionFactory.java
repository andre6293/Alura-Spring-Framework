import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private String user = "ander";
    private String password = "password";

    public Connection recuperarConexao() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", user, password);
    }
}
