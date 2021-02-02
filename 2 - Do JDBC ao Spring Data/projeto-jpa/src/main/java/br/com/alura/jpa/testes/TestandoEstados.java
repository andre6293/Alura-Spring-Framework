package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestandoEstados {

    public static void main(String[] args) {

        EntityManagerFactory emt = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emt.createEntityManager();

        // Transient
        Conta conta1 = new Conta(123L, 334455L, "Altair");

        em.getTransaction().begin();

        // Transient -> Managed
        em.persist(conta1);

        // Managed -> Removed
        em.remove(conta1);

        em.getTransaction().commit();

        em.close();
    }
}
