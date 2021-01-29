package br.com.alura.jdbc.dao;

import br.com.alura.jdbc.model.Categoria;
import br.com.alura.jdbc.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Produto produto) throws SQLException {
            String sql = "INSERT INTO produto (NOME, DESCRICAO) values(?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setString(1, produto.getNome());
                pstm.setString(2, produto.getDescricao());

                pstm.execute();

                try (ResultSet resultSet = pstm.getGeneratedKeys()) {
                    while (resultSet.next()) {
                        produto.setId(resultSet.getInt(1));
                    }
                }
            }
        System.out.println("#### INSERÇÃO BEM SUCEDIDA ####\n" + produto + "\n###############################");
    }

    public List<Produto> listar() throws SQLException {

        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT ID, NOME, DESCRICAO FROM produto";

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();
            try(ResultSet resultSet = pstm.getResultSet()) {
                while(resultSet.next()) {
                    produtos.add(new Produto(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3)
                    ));
                }
            }
        }
        return produtos;
    }

    public List<Produto> buscar(Categoria categoria) throws SQLException {

        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT ID, NOME, DESCRICAO FROM produto WHERE categoria_id = ?";

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, categoria.getId());
            pstm.execute();
            try(ResultSet resultSet = pstm.getResultSet()) {
                while(resultSet.next()) {
                    produtos.add(new Produto(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3)
                    ));
                }
            }
        }
        return produtos;
    }
}
