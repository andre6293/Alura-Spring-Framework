package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaRelacionamentoClienteConta {

    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setId(1L);

        Cliente cliente = new Cliente();
        cliente.setNome("Maria");
        cliente.setEndereco("Whiterun, 50");
        cliente.setProfissao("Pintora");
//        cliente.setNome("Geralt");
//        cliente.setEndereco("Kaer Morhen, 50");
//        cliente.setProfissao("Caçador");
        cliente.setConta(conta);

        EntityManagerFactory emt = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emt.createEntityManager();

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }
}