package br.com.alura.jdbc.teste;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.model.Categoria;
import br.com.alura.jdbc.model.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TesteListagemCategoria {

    public static void main(String[] args) throws SQLException {


        try (Connection connection = new ConnectionFactory().recuperarConexao()){
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaDeCategorias = categoriaDAO.listarComProdutos();

            listaDeCategorias.forEach(categoria -> {
                System.out.println(categoria.getNome());
                for (Produto produto : categoria.getProdutos()) {
                    System.out.println(categoria.getNome() + " - " + produto.getNome());
                }
            });
        }
    }
}
