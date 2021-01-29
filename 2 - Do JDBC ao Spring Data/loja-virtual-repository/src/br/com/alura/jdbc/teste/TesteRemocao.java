package br.com.alura.jdbc.teste;

import br.com.alura.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;

public class TesteRemocao {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

//        Statement stm = connection.createStatement();
        PreparedStatement pStm = connection.prepareStatement("DELETE FROM produto WHERE ID > ?");
        pStm.setInt(1, 2);
        pStm.execute();

        int updateCount = pStm.getUpdateCount();

        System.out.println("Remoção bem sucedida");
        System.out.println("Linhas modificadas: " + updateCount);
    }
}
