import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercao {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory conn = new ConnectionFactory();
        Connection connection = conn.recuperarConexao();

        String nome = "Teclado 66 teclas";
        String descricao = "tal tal tal";

        Statement stm = connection.createStatement();
        stm.execute("INSERT INTO produto (nome, descricao) VALUES ('" + nome + "', '" + descricao +"')"
        , Statement.RETURN_GENERATED_KEYS);

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()) {
            int id = rst.getInt(1);
            System.out.println(id);
        }
    }
}
