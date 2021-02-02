package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlteraSaldoConta {

    public static void main(String[] args) {

        EntityManagerFactory emt = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emt.createEntityManager();

        Conta contaLeonardo = em.find(Conta.class, 1L);

        em.getTransaction().begin();
        contaLeonardo.setSaldo(200D);
        em.getTransaction().commit();
    }
}
