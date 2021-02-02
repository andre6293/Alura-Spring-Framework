package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaContaComSaldo {

    public static void main(String[] args) {

        EntityManagerFactory emt = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emt.createEntityManager();

        Conta conta = new Conta(523L, 3215L, "Maria");
        conta.setSaldo(2000D);

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
        em.close();

        EntityManager em2 = emt.createEntityManager();
        conta.setSaldo(500D);

        em2.getTransaction().begin();
        em2.merge(conta);
        em2.getTransaction().commit();

    }
}
