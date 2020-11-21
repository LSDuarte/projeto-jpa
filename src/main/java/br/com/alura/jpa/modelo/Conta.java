package br.com.alura.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer agencia;
	private Integer numero;
	private String titular;
	private Double saldo;

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

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}