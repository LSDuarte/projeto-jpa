package br.com.alura.jpa.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia(258);
		conta.setNumero(23658);
		conta.setTitular("Fernanda");
		conta.setSaldo(350.0);

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Amigo cachaça");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal(150.0));
//		movimentacao.setConta(conta);
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("contas");
		EntityManager em = fabrica.createEntityManager();
		
		em.getTransaction().begin();
//		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		em.close();
		
	}
	
}