package br.com.alura.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaCriaTabelaConta {

	public static void main(String[] args) {
		//criando fabrica entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager createEntityManager =  emf.createEntityManager();
		emf.close();
	}

}