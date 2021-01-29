package br.com.alura.jdbc.teste;

import br.com.alura.jdbc.factory.ConnectionFactory;

import java.sql.SQLException;

public class TestePoolConexoes {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        for (int i = 0; i < 20; i++) {
            connectionFactory.recuperarConexao();
            System.out.println("conexão número: " + i);
        }
    }
}
