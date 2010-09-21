package br.com.mrcom.domain.bean;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.mrcom.domain.elements.Cpf;


@Entity
@Table(name="CLIENTE")
@SequenceGenerator(name="SEQ_CLIENTE", sequenceName="SEQ_CLIENTE", allocationSize=1, initialValue=1)
public class Cliente {

	public static long contadorClientes;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="SEQ_CLIENTE")
	@Column(name="CLI_CODIGO")	
	private Long codigo;

	@Embedded	
	@AttributeOverrides({  
		@AttributeOverride(name="valor",column=@Column(name="CLI_CPF")),  
	})  
	private Cpf cpf;

	@Column(name="CLI_NOME")
	private String nome;

	@Column(name="CLI_NUMERO")
	private Integer numero;

	@ManyToOne()
	@JoinColumn(name="CLI_ENDERECO")
	private Endereco endereco = new Endereco(); 

	@Column(name="CLI_BAIRRO")
	private String bairro;

	@Column(name="CLI_CIDADE")
	private String cidade;

	@Column(name="CLI_ESTADO")
	private String estado;
	


	@Column(name="CLI_PAIS")
	private String pais;

	@Column(name="CLI_CEP")
	private String cep;

	@Column(name="CLI_FONE")
	private String telefoneResidencial;

	@Column(name="CLI_FONE_COMERCIAL")
	private String telefoneComercial;

	@Column(name="CLI_SEXO")
	private String sexo;

	@Column(name="CLI_DTCADASTRO")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dataCadastro ;

	@Column(name="CLI_DTNASCIMENTO")
	@Temporal(value=TemporalType.DATE)
	private Date dataNascimento ;

	@Column(name="CLI_DTALTERACAO")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dataAlteracao ;

	public Cliente(Long codigo, String nome, Cpf cpf){

		this.codigo = codigo;
		this.nome = nome;
		this.cpf =  cpf;
	}
	public Cliente() {
		contadorClientes++;				
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Cpf getCpf() {
		return cpf;
	}

	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}


	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
	
		return nome;
	}
	
	public void init(){
		
		cpf = new Cpf();
		endereco = new Endereco();		
		cpf.init();		
		endereco.init();
	}
}
