package br.com.alura.jpa.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {

		Categoria c1 = new Categoria("Viagens");
		Categoria c2 = new Categoria("Negócios");
		
		Conta conta = new Conta();
		conta.setId(3L);
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(LocalDateTime.now());
		movimentacao1.setDescricao("Viagem à SP");
		movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal(200.0));
		movimentacao1.setCategorias(Arrays.asList(c1,c2)); // criando uma lista de categorias
		movimentacao1.setConta(conta);
		
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setDescricao("Viagem à MT");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal(300.0));
		movimentacao2.setCategorias(Arrays.asList(c1,c2));
		movimentacao2.setConta(conta);
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("contas");
		EntityManager em = fabrica.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		em.getTransaction().commit();
		em.clear();
		
	}
	
}