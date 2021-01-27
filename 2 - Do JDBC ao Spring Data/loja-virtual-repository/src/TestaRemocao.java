import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

//        Statement stm = connection.createStatement();
        PreparedStatement pStm = connection.prepareStatement("DELETE FROM produto WHERE ID > ?");
        pStm.setInt(1, 2);
        pStm.execute();

        int updateCount = pStm.getUpdateCount();

        System.out.println("Linhas modificadas: " + updateCount);
    }
}
