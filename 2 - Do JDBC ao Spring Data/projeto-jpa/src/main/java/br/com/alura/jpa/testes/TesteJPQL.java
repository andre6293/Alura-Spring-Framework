package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

import javax.persistence.*;
import java.util.List;

public class TesteJPQL {

    public static void main(String[] args) {

        EntityManagerFactory emt = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emt.createEntityManager();

        Conta conta = new Conta();
        conta.setId(1L);

//        String query = "select * from Movimentacao where conta_id = 1;"; // SQL

//        String jpql = "select m from Movimentacao m where m.conta.id = 1"; // JPQL com query mais próxima de um banco relacional

        String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc"; // JPQL com query orientada a objetos, o p antes do nome da variável é opcional, mas é considerado boa prática

//        Query query = em.createQuery(jpql);
        TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
        query.setParameter("pConta", conta);

        List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao mov : movimentacoes) {
            System.out.printf("Descrição: %s\n", mov.getDescricao());
            System.out.printf("Tipo: %s\n", mov.getTipoMovimentacao());
        }
    }
}
