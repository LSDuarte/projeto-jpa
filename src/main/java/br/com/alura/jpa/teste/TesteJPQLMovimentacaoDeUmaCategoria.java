package br.com.alura.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoDeUmaCategoria {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria"; // parametro

		Categoria categoria = new Categoria();
		categoria.setId(3L);


		// mais especifico
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		query.setParameter("pCategoria", categoria);
		List<Movimentacao> movimentacoes = query.getResultList();

		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Categorias: " + movimentacao.getCategorias());
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
			System.out.println("Valor: " + movimentacao.getValor());
		}

	}

}