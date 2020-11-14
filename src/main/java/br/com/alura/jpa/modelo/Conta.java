package br.com.alura.jpa.modelo;

public class Conta {

	private Long id;
	private Integer agencia;
	private Integer numero;
	private String titular;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public final Integer getAgencia() {
		return agencia;
	}

	public final void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public final Integer getNumero() {
		return numero;
	}

	public final void setNumero(Integer numero) {
		this.numero = numero;
	}

	public final String getTitular() {
		return titular;
	}

	public final void setTitular(String titular) {
		this.titular = titular;
	}

}