package br.com.alura.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("contas");
		EntityManager em = fabrica.createEntityManager();

		Conta contaComSaldo = new Conta();
		contaComSaldo.setTitular("Luiz Claudio");
		contaComSaldo.setNumero(555555);
		contaComSaldo.setAgencia(222);
		contaComSaldo.setSaldo(1500.0);

		em.getTransaction().begin();

		em.persist(contaComSaldo);

		em.getTransaction().commit();
		em.close();
	
		// criando outro entity mananer, pois o anterior morreu.
		EntityManager em2 = fabrica.createEntityManager();
		
		System.out.println("Id do Luiz: " + contaComSaldo.getId());
		contaComSaldo.setSaldo(200.0); // não insere no banco pois a transação foi fechada ... em.close();
		
		em2.getTransaction().begin();
		em2.merge(contaComSaldo);
		em2.getTransaction().commit();
	}

}