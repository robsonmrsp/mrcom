package br.com.mrcom.controller.managed;

import java.io.BufferedReader;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.mrcom.domain.bean.Cliente;
import br.com.mrcom.domain.bean.Endereco;
import br.com.mrcom.domain.dao.HibernateGenericDao;
import br.com.mrcom.domain.elements.Cpf;
import br.com.mrcom.util.Util;

public class FaceCliente {

	private HibernateGenericDao<Cliente> clienteDao 	= new HibernateGenericDao<Cliente>(Cliente.class);
	private HibernateGenericDao<Endereco> enderecoDao 	= new HibernateGenericDao<Endereco>(Endereco.class);
	
	private	Cliente cliente ;
	private	Cliente clientePesquisa ;
	private List<Cliente> clientes ;
		
	
	//controle de busca
	private Object valorParametroBusca = "";
	private String nomeParametroBusca = "";
	
	//controle de paginação. 
	private String campoOrdenacao 		  = "codigo" ;
	//deve definir se a ordenacao será crescente ou decrescentes
	private String tipoOrdenacao 		  = "asc" ;
	
	private int numeroPaginaAtual 		  = 1;
	private int quantidadeTotalPaginas = 1;
	private int quantidadeElementosPorPagina = 8;
	

	private HtmlSelectOneRadio checkSexo = new HtmlSelectOneRadio();  
	private UISelectItem item = new UISelectItem();
	
	
	private boolean mostraTabela = false;
	

	
	
	@SuppressWarnings("unused")
	private Locale locale;

	public boolean isMostraTabela() {
		return mostraTabela;
	}

	public void setMostraTabela(boolean mostraTabela) {
		this.mostraTabela = mostraTabela;
	}

	public FaceCliente() {

		cliente = new Cliente();
		cliente.init();

		setClientes(clienteDao.buscaOrdenadoPorParametro(campoOrdenacao, quantidadeElementosPorPagina, numeroPaginaAtual));				
	}

	public HtmlSelectOneRadio getCheckSexo() {
		return checkSexo;
	}

	public void setCheckSexo(HtmlSelectOneRadio checkSexo) {
		this.checkSexo = checkSexo;
	}
	public UISelectItem getItem() {
		return item;
	}

	public void setItem(UISelectItem item) {
		this.item = item;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String exibirCliente(){

		cliente = clienteDao.busca(cliente.getCodigo()); 
		FacesContext fc = FacesContext.getCurrentInstance();
		
//		FacesMessage men = new FacesMessage();
//		men.setSeverity(FacesMessage.SEVERITY_INFO);
//		men.setSummary("Exibindo o Cliente " + cliente);		
//		fc.addMessage("mensagemErro", men);
		
		return "atualizaTabela";
	}

	public String salvarCliente(){

		List<Endereco> e = enderecoDao.buscaPorParametros("cep", cliente.getCep());

		if(e != null && e.size() > 0){

			cliente.setEndereco(e.get(0));
		}

		if(cliente.getCodigo() == null || cliente.getCodigo().equals(0L)){

			clienteDao.salva(cliente);			
		}else{

			clienteDao.atualiza(cliente);
		}
		setClientes(clienteDao.buscaTodos());

		return "atualizaTabela";
	}

	public String limparCliente(){

		System.out.println("FaceCliente.limparCliente()");
		cliente = new Cliente();
		cliente.init();		
		//geraNomePessoa();
		return "atualizaTabela";		
	}

	public String deletarCliente(){
		clienteDao.deleta(cliente);

		cliente = new Cliente();
		cliente.init();

		setClientes(clienteDao.buscaTodos());

		return "atualizaTabela";		
	}

	public String buscaEndereco(){

		System.out.println("FaceCliente.buscaEndereco()");

		Endereco e = enderecoDao.buscaPorParametros("cep", cliente.getCep()).get(0);
		if(e == null){

			return "atualizaTabela";
		}
		System.out.println("FaceCliente.buscaEndereco()"  + e);
		cliente.setEndereco(e);	
		
		return "atualizaTabela";
	}
	public Locale getLocale(){

		return new Locale("pt", "BR");
	}

	public void setLocale(Locale l){

		locale = l;
	}


	public  void geraNomePessoa(){

		try {
			File file = new File("D:\\Estudo\\Desenvolvimento\\nomes_pessoas.txt");
			HibernateGenericDao<Cliente> daoCli = new HibernateGenericDao<Cliente>(Cliente.class);

			HibernateGenericDao<Endereco> daoEnd = new HibernateGenericDao<Endereco>(Endereco.class);

			long intEnd = (int) (777329 * Math.random());
			int numero = (int) (1000 * Math.random());
			String telefone ;
			String telefoneCom; 
			Cpf cpf = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

			String nome = reader.readLine().replaceAll("[ \\s]+", " ");
			if (nome != null){
				nome = nome.replaceAll("[ \\s]+", " ");
			}

			while(nome != null){

				intEnd = (long) (777329 * Math.random());
				numero = (int) (1000 * Math.random());
				cpf = new Cpf(Util.gerarCPF());
				telefone = "3" + String.valueOf((int) (10000000 * Math.random()));
				telefoneCom = "3" + String.valueOf((int) (10000000 * Math.random()));
				Date dtNas = new Date((long)((new Long("924564567890")) * Math.random()));

				System.out.println(intEnd);


				Endereco ender = daoEnd.busca(intEnd);

				while (ender == null){

					intEnd = (long) (777329 * Math.random());
					ender = daoEnd.busca(intEnd);
				}

				System.out.println("FaceCliente.geraNomePessoa() ender " + ender );
				Cliente cli = new Cliente();

				cli.setNome(nome);
				cli.setCpf(cpf);
				cli.setDataCadastro(new Date());
				cli.setDataAlteracao(new Date());
				cli.setDataNascimento(dtNas);
				cli.setTelefoneComercial(telefoneCom);
				cli.setTelefoneResidencial(telefone);

				cli.setEndereco(ender);
				cli.setBairro(ender.getBairro().getNome());
				cli.setCep(ender.getCep());
				cli.setCidade(ender.getCidade().getNome());
				cli.setEstado(ender.getEstado().getNome());
				cli.setNumero(numero);
				cli.setPais("Brasil");
				cli.setSexo("M");

				try{
					//daoCli.salva(cli);
					//HibernateUtil.getSessionFactory().getCurrentSession().flush();
				}catch (Exception e) {

					System.out.println("erro!");
				}

				System.out.println("FaceCliente.geraNomePessoa() " + nome );
				nome = reader.readLine();
				
				if(nome != null){
					
					nome = nome.replaceAll("[ \\s]+", " ");
				}
				
			}
			reader.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void validaCep(FacesContext context, UIComponent component, Object valor)	throws ValidatorException {

		String cep = Util.removeCaracterNaoNumerico(valor);
		System.out.println("FaceCliente.validaCep() " + cep);
		System.out.println("FaceCliente.validaCep() " + valor);

		List<Endereco> ends = enderecoDao.buscaPorParametros("cep", cep);

		FacesMessage message = new FacesMessage();


		if(ends == null || ends.size() ==0){
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("O Cep -> " + cep + " n�o � um cep v�lido.");
			throw(new ValidatorException(message));
		}else
		{
			System.out.println("FaceCliente.validaCep() dentro do else");
			Endereco e = ends.get(0);

			cliente.setBairro(e.getBairro().getNome());
			cliente.setCidade(e.getCidade().getNome());
			cliente.setEstado(e.getEstado().getNome());

			//			context.renderResponse();
			System.out.println(cliente.getBairro());
			System.out.println(cliente.getCidade());
			System.out.println(cliente.getEstado());
		}
	}
	
	
	
	public String populaTabelaProximos(){

		numeroPaginaAtual++;
		
		List<Cliente> clientes = clienteDao.buscaOrdenadoPorParametro(campoOrdenacao, quantidadeElementosPorPagina, numeroPaginaAtual);
		
		setClientes(clientes);
		
		setMostraTabela(true);
		return "atualizaTabela";
	}

	public String populaTabelaAnteriores(){

		numeroPaginaAtual--;
		
		List<Cliente> clientes = clienteDao.buscaOrdenadoPorParametro(campoOrdenacao, quantidadeElementosPorPagina, numeroPaginaAtual);
		
		setClientes(clientes);
		return "atualizaTabela";		
	}
	
	public String ordenarPorCodigo(){

		numeroPaginaAtual=1;
		campoOrdenacao = "codigo";
		List<Cliente> clientes = clienteDao.buscaOrdenadoPorParametro(campoOrdenacao, quantidadeElementosPorPagina, numeroPaginaAtual);
		
		setClientes(clientes);
		
		return "atualizaTabela";
	}
	public String ordenarPorNome(){
		
		numeroPaginaAtual=1;
		campoOrdenacao = "nome";
		List<Cliente> clientes = clienteDao.buscaOrdenadoPorParametro(campoOrdenacao, quantidadeElementosPorPagina, numeroPaginaAtual);
		
		setClientes(clientes);
		return "atualizaTabela";
	}
	public String ordenarPorCpf(){
		
		numeroPaginaAtual=1;
		campoOrdenacao = "cpf";
		List<Cliente> clientes = clienteDao.buscaOrdenadoPorParametro(campoOrdenacao, quantidadeElementosPorPagina, numeroPaginaAtual);
		
		setClientes(clientes);
		return "atualizaTabela";
	}
	public String ordenarPorCep(){

		return null;
	}
	
	public String  buscaPorNome(){

		valorParametroBusca = cliente.getNome();
		nomeParametroBusca = "nome";
		
		List<Cliente> lista = clienteDao.buscaPorParametrosLike("nome", cliente.getNome());

		
		if(lista != null && lista.size()>=1){
			
			cliente = lista.get(0);
			setClientes(lista);
		}else{
			
			FacesMessage message = new FacesMessage();
			
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("N�o foi encontrado nenhum Cliente com o nome " + cliente.getNome());
			
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "atualizaTabela";
	}
	
	public String  buscaPorCpf(){
		
		return null;
	}

	
	public int getNumeroPaginaAtual() {
		return numeroPaginaAtual;
	}

	public void setNumeroPaginaAtual(int numeroPaginaAtual) {
		this.numeroPaginaAtual = numeroPaginaAtual;
	}

	public int getQuantidadeElementosPorPagina() {
		return quantidadeElementosPorPagina;
	}

	public void setQuantidadeElementosPorPagina(int quantidadeElementosPorPagina) {
		this.quantidadeElementosPorPagina = quantidadeElementosPorPagina;
	}

	public int getQuantidadeTotalPaginas() {
		return quantidadeTotalPaginas;
	}

	public void setQuantidadeTotalPaginas(int quantidadeTotalPaginas) {
		
		this.quantidadeTotalPaginas = quantidadeTotalPaginas;
	}	 
}

