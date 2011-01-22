package br.com.mrcom.domain.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ENDERECO")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;

	private static long contadorEnderecos;

	@Id
	@Column(name="END_CODIGO")
	private Long codigo;

	@Column(name="END_NOME")
	private String nome;

	@Column(name="END_CEP")
	private String cep;

	@ManyToOne
	@JoinColumn(name="END_ESTADO")
	private Estado estado;

	@ManyToOne
	@JoinColumn(name="END_CIDADE")
	private Cidade cidade;

	@ManyToOne
	@JoinColumn(name="END_BAIRRO")
	private Bairro bairro;

	public Endereco() {

		contadorEnderecos++;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
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
		Endereco other = (Endereco) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	public String toString(){
		
		return nome + ", " + getBairro().getNome() + " , " + getCidade().getNome() + " , " + getEstado().getNome(); 
	}

	public void init() {

		bairro = new Bairro();
		cidade = new Cidade();
		estado = new Estado();
		
		bairro.init();
		cidade.init();
		estado.init();		
	}
}
