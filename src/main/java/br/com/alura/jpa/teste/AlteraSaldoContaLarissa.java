package br.com.alura.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoContaLarissa {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("contas");
		EntityManager em = fabrica.createEntityManager();
		
		Conta contaDaLarissa = em.find(Conta.class, 1L);
		System.out.println("Conta da " + contaDaLarissa.getTitular());
		
		em.getTransaction().begin();
		contaDaLarissa.setSaldo(150.0);
		em.getTransaction().commit();
		
	}

}