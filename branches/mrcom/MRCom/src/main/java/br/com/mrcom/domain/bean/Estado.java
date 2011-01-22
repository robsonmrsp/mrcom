package br.com.mrcom.domain.bean;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="ESTADO")
public class Estado implements Serializable{

	private static final long serialVersionUID = 1L;
	private static long contadorEstados ;

	@Id
	@Column(name="EST_CODIGO")
	private String uf;

	@Column(name="EST_NOME")
	private String nome;
	
	@Column(name="EST_FAIXA_CEP1_INI")
	private String faixaCep1Ini;
	
	@Column(name="EST_FAIXA_CEP1_FIM")
	private String faixaCep1Fim;
	
	@Column(name="EST_FAIXA_CEP2_INI")
	private String faixaCep2Ini;
	
	@Column(name="EST_FAIXA_CEP2_FIM")
	private String faixaCep2Fim;
	
	public Estado() {
	
		contadorEstados++;
	}
	
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFaixaCep1Ini() {
		return faixaCep1Ini;
	}

	public void setFaixaCep1Ini(String faixaCep1Ini) {
		this.faixaCep1Ini = faixaCep1Ini;
	}

	public String getFaixaCep1Fim() {
		return faixaCep1Fim;
	}

	public void setFaixaCep1Fim(String faixaCep1fim) {
		this.faixaCep1Fim = faixaCep1fim;
	}

	public String getFaixaCep2Ini() {
		return faixaCep2Ini;
	}

	public void setFaixaCep2Ini(String faixaCep2Ini) {
		this.faixaCep2Ini = faixaCep2Ini;
	}

	public String getFaixaCep2Fim() {
		return faixaCep2Fim;
	}

	public void setFaixaCep2Fim(String faixaCep2fim) {
		this.faixaCep2Fim = faixaCep2fim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		Estado other = (Estado) obj;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}


	public void init() {

	}
}
