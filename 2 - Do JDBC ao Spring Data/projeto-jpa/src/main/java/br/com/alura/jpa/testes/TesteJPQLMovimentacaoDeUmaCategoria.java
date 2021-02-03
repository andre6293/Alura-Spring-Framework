package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

import javax.persistence.*;
import java.util.List;

public class TesteJPQLMovimentacaoDeUmaCategoria {

    public static void main(String[] args) {

        EntityManagerFactory emt = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emt.createEntityManager();

        Categoria categoria = new Categoria();
        categoria.setId(1L);

        String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";

//        Query query = em.createQuery(jpql);
        TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
        query.setParameter("pCategoria", categoria);

        List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao mov : movimentacoes) {
            System.out.printf("Categorias: %s\n", mov.getCategorias());
            System.out.printf("Descrição: %s\n", mov.getDescricao());
            System.out.printf("Valor: %s\n", mov.getValor());
            System.out.printf("Tipo: %s\n", mov.getTipoMovimentacao());
        }
    }
}
