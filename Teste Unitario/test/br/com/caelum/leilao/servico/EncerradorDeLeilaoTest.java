package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.any;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.infra.dao.RepositorioDeLeiloes;

public class EncerradorDeLeilaoTest {
	private RepositorioDeLeiloes dao;
	private EnviadorDeEmail carteiro;
	private EncerradorDeLeilao eLeilao;

	@Before
	public void utilits() {
		dao = mock(RepositorioDeLeiloes.class);
		carteiro = mock(EnviadorDeEmail.class);
		eLeilao = new EncerradorDeLeilao(dao,carteiro);
	}

	@Test
	public void encerraSegundoLeilaoQuandoPrimeiroFalha() {
		Calendar old = Calendar.getInstance();
		old.set(2011, 11, 01);

		Leilao leilao1 = new CriadorDeLeilao().para("Selos").naData(old)
				.constroi();

		Leilao leilao2 = new CriadorDeLeilao().para("Aneis").naData(old)
				.constroi();

		when(dao.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));
		doThrow(new RuntimeException()).when(dao).atualiza(leilao1); 
		doThrow(new RuntimeException()).when(carteiro).envia(leilao1); 
		

		eLeilao.encerra();
		verify(dao,times(1)).atualiza(leilao2);
		verify(carteiro,times(1)).envia(leilao2);
	}
	
	@Test
	public void encerraSegundoLeilaoQuandoEmailDoPrimeiroFalha() {
		Calendar old = Calendar.getInstance();
		old.set(2011, 11, 01);
		
		Leilao leilao1 = new CriadorDeLeilao().para("Selos").naData(old)
				.constroi();
		
		Leilao leilao2 = new CriadorDeLeilao().para("Aneis").naData(old)
				.constroi();
		
		when(dao.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));
		doThrow(new RuntimeException()).when(carteiro).envia(leilao1); 
		
		
		eLeilao.encerra();
		verify(dao,times(1)).atualiza(leilao1);
		verify(dao,times(1)).atualiza(leilao2);
		verify(carteiro,times(1)).envia(leilao2);
	}
	
	@Test
	public void carteiroNumcaInvocado() {
		Calendar old = Calendar.getInstance();
		old.set(2011, 11, 01);
		
		Leilao leilao1 = new CriadorDeLeilao().para("Selos").naData(old)
				.constroi();
		
		Leilao leilao2 = new CriadorDeLeilao().para("Aneis").naData(old)
				.constroi();
		
		when(dao.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));
		doThrow(new RuntimeException()).when(dao).atualiza(any(Leilao.class)); 
		
		eLeilao.encerra();
		verify(carteiro,never()).envia(leilao1);
		verify(carteiro,never()).envia(leilao2);
	}
	
	@Test
	public void encerrarLeiloesMaiorQueUmaSemana() {
		Calendar old = Calendar.getInstance();
		old.set(2011, 11, 01);
		
		Leilao leilao1 = new CriadorDeLeilao().para("Selos").naData(old)
				.constroi();
		
		Leilao leilao2 = new CriadorDeLeilao().para("Aneis").naData(old)
				.constroi();
		List<Leilao> lista = Arrays.asList(leilao1, leilao2);
		
		when(dao.correntes()).thenReturn(lista);
		
		eLeilao.encerra();
		
		assertEquals(2, eLeilao.getTotalEncerrados());
		assertTrue(leilao1.isEncerrado());
		assertTrue(leilao2.isEncerrado());
	}
	
	
	@Test
	public void encerrarLeiloesMaiorQueUmaSemanaEEnviaEmail() {
		Calendar old = Calendar.getInstance();
		old.set(2011, 11, 01);
		
		Leilao leilao1 = new CriadorDeLeilao().para("Selos").naData(old)
				.constroi();
		
		Leilao leilao2 = new CriadorDeLeilao().para("Aneis").naData(old)
				.constroi();
		List<Leilao> lista = Arrays.asList(leilao1, leilao2);
		
		when(dao.correntes()).thenReturn(lista);
		
		eLeilao.encerra();
		
		InOrder inOrder = inOrder(dao,carteiro);
		inOrder.verify(dao,times(1)).atualiza(leilao1);
		inOrder.verify(carteiro,times(1)).envia(leilao1);
	}

	@Test
	public void NaoEncerraLeiloesMenoresQueUmaSemana() {
		Calendar old = Calendar.getInstance();
		old.set(2012, 12, 27);

		Leilao leilao1 = new CriadorDeLeilao().para("Selos").naData(old)
				.constroi();

		Leilao leilao2 = new CriadorDeLeilao().para("Aneis").naData(old)
				.constroi();
		List<Leilao> lista = Arrays.asList(leilao1, leilao2);

		when(dao.correntes()).thenReturn(lista);

		eLeilao.encerra();

		assertEquals(0, eLeilao.getTotalEncerrados());
	}

	@Test
	public void ListaDeLeilaVazia() {
		when(dao.correntes()).thenReturn(new ArrayList<Leilao>());

		eLeilao.encerra();

		assertEquals(0, eLeilao.getTotalEncerrados());
	}

	@Test
	public void VericaSeMetodoAtualizaeExecutado() {
		Calendar old = Calendar.getInstance();
		old.set(2011, 11, 01);

		Leilao leilao1 = new CriadorDeLeilao().para("Selos").naData(old)
				.constroi();

		when(dao.correntes()).thenReturn(Arrays.asList(leilao1));

		eLeilao.encerra();

		assertEquals(1, eLeilao.getTotalEncerrados());
		assertTrue(leilao1.isEncerrado());
		verify(dao, times(1)).atualiza(leilao1);
	}

//	@Test
//	public void naoDeveEncerrarLeiloesQueComecaramMenosDeUmaSemanaAtras() {
//
//		Calendar ontem = Calendar.getInstance();
//		ontem.set(Calendar.DAY_OF_MONTH, -1);
//		Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma")
//				.naData(ontem).constroi();
//		Leilao leilao2 = new CriadorDeLeilao().para("Geladeira").naData(ontem)
//				.constroi();
//
//		when(dao.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));
//		eLeilao.encerra();
//
//		assertEquals(0, eLeilao.getTotalEncerrados());
//		assertFalse(leilao1.isEncerrado());
//		assertFalse(leilao2.isEncerrado());
//
//		verify(dao, never()).atualiza(leilao1);
//		verify(dao, atLeastOnce()).atualiza(leilao1);
//		verify(dao, atLeast(2)).atualiza(leilao1);
//		verify(dao, atMost(1)).atualiza(leilao1);
//	}
}
