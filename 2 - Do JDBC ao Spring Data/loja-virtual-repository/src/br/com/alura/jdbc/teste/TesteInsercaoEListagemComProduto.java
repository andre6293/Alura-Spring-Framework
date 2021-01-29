package br.com.alura.jdbc.teste;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.model.Produto;

import java.sql.*;
import java.util.List;

public class TesteInsercaoEListagemComProduto {

    public static void main(String[] args) throws SQLException {

        Produto comoda = new Produto("Cômoda", "Cômoda vertical");

        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(comoda);
            List<Produto> lista = produtoDAO.listar();

            System.out.println("#### PRODUTOS ####");
            lista.forEach(System.out::println);
            System.out.println("##################");
        }
    }
}
