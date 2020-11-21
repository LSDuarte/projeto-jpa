package br.com.alura.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("contas");
		EntityManager entity = fabrica.createEntityManager();

		Conta novaConta = new Conta();
		novaConta.setTitular("Larissa");
		novaConta.setNumero(15796525);
		novaConta.setAgencia(385);

		//inicia transação - escopo
		entity.getTransaction().begin();
		
		//realiza inserção da conta no banco
		entity.persist(novaConta);
		
		//
		entity.getTransaction().commit();
	}

}