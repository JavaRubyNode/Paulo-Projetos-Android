package br.com.projetopatrimoniocrud.modelo;

import java.io.Serializable;
import java.util.Date;

public class Patrimonio implements Serializable {

	private Long id;
	private String descricao;
	private double valor;
	private Date dataAquisicao;

	public Patrimonio() {
		super();
	}

	public Patrimonio(Long id, String descricao, double valor,
			Date dataAquisicao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.dataAquisicao = dataAquisicao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patrimonio other = (Patrimonio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
