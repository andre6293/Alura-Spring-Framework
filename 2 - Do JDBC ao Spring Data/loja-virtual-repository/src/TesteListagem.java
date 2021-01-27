import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteListagem {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        Statement stm = connection.createStatement();
        stm.execute("SELECT ID, NOME, DESCRICAO FROM produto");

        ResultSet rst = stm.getResultSet();

        while (rst.next()) {
            int id = rst.getInt("id");
            String nome = rst.getString("nome");
            String descricao = rst.getString("descricao");

            System.out.println("ID: " + id + ", Nome: " + nome + "\nDescrição: " + descricao + "\n");
        }


        connection.close();
    }
}
