package br.com.mrcom.domain.dao.imp;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.mrcom.domain.bean.Estado;

public class HibernateEstadoDaoTest {

	private Estado estado = new Estado();
	private HibernateEstadoDao dao = new HibernateEstadoDao(Estado.class);
	
	@Test
	public void testDeleta1() {
		estado.setUf("AM");
		dao.deleta(estado);
		estado = null;
		assertNull(estado);
	}
	
	@Test
	public void testSalva() {
		estado.setNome("Amazonas");
		estado.setUf("AM");
		estado.setFaixaCep1Ini("61932-560");
		estado.setFaixaCep1Fim("98562-962");
		estado.setFaixaCep2Ini("45785-582");
		estado.setFaixaCep2Fim("60528-852");
		dao.salva(estado);
		estado = null;
		assertNull(estado);
	}
	
	@Test
	public void testBuscaSerializable() {
		estado = dao.busca("AM");
		assertEquals(estado.getFaixaCep1Ini(), "61932-560");
		assertEquals(estado.getFaixaCep1Fim(), "98562-962");
		assertEquals(estado.getFaixaCep2Ini(), "45785-582");
		assertEquals(estado.getFaixaCep2Fim(), "60528-852");
		assertEquals(estado.getNome(), "Amazonas");
		assertEquals(estado.getUf(), "AM");
	}

	@Test
	public void testAtualiza() {
		estado.setNome("Amazonas");
		estado.setUf("AM");
		estado.setFaixaCep1Ini("61934-560");
		estado.setFaixaCep1Fim("98564-962");
		estado.setFaixaCep2Ini("45784-582");
		estado.setFaixaCep2Fim("60524-852");
		dao.atualiza(estado);
		estado = null;
		assertNull(estado);
	}

	@Test
	public void testBuscaSerializableDepoisDeAtualizar() {
		estado = dao.busca("AM");
		assertEquals(estado.getFaixaCep1Ini(), "61934-560");
		assertEquals(estado.getFaixaCep1Fim(), "98564-962");
		assertEquals(estado.getFaixaCep2Ini(), "45784-582");
		assertEquals(estado.getFaixaCep2Fim(), "60524-852");
		assertEquals(estado.getNome(), "Amazonas");
		assertEquals(estado.getUf(), "AM");
	}
	
	@Test
	public void testDeleta() {
		estado.setUf("AM");
		dao.deleta(estado);
		estado = null;
		assertNull(estado);
	}

	@Test
	public void testBuscaSerializableDepoisDeDeletar() {
		estado = new Estado();
		estado = dao.busca("AM");
		assertNull(estado);
	}
}
