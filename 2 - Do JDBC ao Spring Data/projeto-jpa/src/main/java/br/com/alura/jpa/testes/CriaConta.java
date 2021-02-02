package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaConta {

    public static void main(String[] args) {

        EntityManagerFactory emt = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emt.createEntityManager();

        Conta conta = new Conta(1234L, 123324L, "Cleber");

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();

    }
}
