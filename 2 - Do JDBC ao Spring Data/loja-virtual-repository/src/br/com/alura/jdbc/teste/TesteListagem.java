package br.com.alura.jdbc.teste;

import br.com.alura.jdbc.factory.ConnectionFactory;

import java.sql.*;

public class TesteListagem {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();
        connection.setAutoCommit(false);

        PreparedStatement pStm = connection.prepareStatement(
                "SELECT ID, NOME, DESCRICAO FROM produto");
//        Statement stm = connection.createStatement();
        pStm.execute();

        ResultSet rst = pStm.getResultSet();

        while (rst.next()) {
            int id = rst.getInt("id");
            String nome = rst.getString("nome");
            String descricao = rst.getString("descricao");

            System.out.println("ID: " + id + ", Nome: " + nome + "\nDescrição: " + descricao + "\n");
        }
        connection.close();
    }
}
