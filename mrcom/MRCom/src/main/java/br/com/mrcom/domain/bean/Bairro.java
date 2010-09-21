package br.com.mrcom.domain.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BAIRRO")
public class Bairro implements Serializable{

	private static final long serialVersionUID = 1L;

	private static long contadorBairros;

	@Id
	@Column(name="BAI_CODIGO")
	private Long codigo;

	@Column(name="BAI_NOME")
	private String nome;


	@ManyToOne
	@JoinColumn(name="BAI_ESTADO")
	private Estado estado;

	@ManyToOne
	@JoinColumn(name="BAI_CIDADE")
	private Cidade cidade;

	public Bairro() {
		contadorBairros++;
	}

	
	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public Cidade getCidade() {
		return cidade;
	}


	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Bairro other = (Bairro) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}


	public void init() {

		cidade = new Cidade();
		estado = new Estado();
		
		cidade.init();
		estado.init();
	}
}
