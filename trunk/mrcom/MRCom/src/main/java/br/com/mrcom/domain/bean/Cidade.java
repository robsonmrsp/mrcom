package br.com.mrcom.domain.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CIDADE")
public class Cidade implements Serializable{

	private static final long serialVersionUID = 1L;

	private static long contadorCidades ;


	@Id
	@Column(name="CID_CODIGO")
	private Long codigo;

	@Column(name="CID_NOME")
	private String nome;

	@ManyToOne
	@JoinColumn(name="CID_ESTADO")
	private Estado estado;

	@Column(name="CID_CEP")
	private String cep;
	
	
	@OneToMany(mappedBy="cidade")
	private List<Bairro> bairros;
	
	public List<Bairro> getBairros() {
		return bairros;
	}
	
	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public Cidade() {

		contadorCidades++;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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
		Cidade other = (Cidade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	



}
