package br.com.alura.jdbc.teste;

import br.com.alura.jdbc.factory.ConnectionFactory;

import java.sql.*;

public class TesteInsercao {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory conn = new ConnectionFactory();
        try (Connection connection = conn.recuperarConexao()) {
            connection.setAutoCommit(false);

            try (PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO produto (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);) {

                adicionarVariavel("Smart TV", "45 polegadas", stm);
                adicionarVariavel("Rádio", "25W", stm);

                connection.commit();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Rollback executado");
                connection.rollback();
            }
        }
    }
    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

//        if (nome.equals("Rádio")) {
//            throw new RuntimeException("Não foi possível executar");
//        }

        try(ResultSet rst = stm.getGeneratedKeys()) {
            while (rst.next()) {
                int id = rst.getInt(1);
                System.out.println(id);
            }
        }
    }
}