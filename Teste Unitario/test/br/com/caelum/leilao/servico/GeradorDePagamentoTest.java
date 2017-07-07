package br.com.caelum.leilao.servico;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Pagamento;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.infra.dao.RepositorioDeLeiloes;
import br.com.caelum.leilao.infra.dao.RepositorioDePagamento;
import br.com.caelum.leilao.infra.relogio.Relogio;
import br.com.caelum.leilao.infra.relogio.RelogioDoSistema;

public class GeradorDePagamentoTest {
	@Test
	public void valorPagoIgualMaiorLance() {
		RepositorioDeLeiloes deLeiloes = mock(RepositorioDeLeiloes.class);
		RepositorioDePagamento dePagamento = mock(RepositorioDePagamento.class);
		Avaliador avaliador =new Avaliador();

		Leilao leilao = new CriadorDeLeilao().para("Playstation")
				.lance(new Usuario("José da Silva"), 2000.0)
				.lance(new Usuario("Maria Pereira"), 2500.0).constroi();
		
		when(deLeiloes.encerrados()).thenReturn(Arrays.asList(leilao));
		
		GeradorDePagamento pagamento  = new GeradorDePagamento(dePagamento, deLeiloes, avaliador);
		pagamento.gerar();
		
		ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(Pagamento.class);
		verify(dePagamento).savar(argumento.capture());
	    Pagamento pagamento2 = argumento.getValue();
	    assertEquals(2500.0, pagamento2.getValor(),0.000001);
	}
	
	@Test
	public void soPAgaEmDiaUtil() {
		RepositorioDeLeiloes deLeiloes = mock(RepositorioDeLeiloes.class);
		RepositorioDePagamento dePagamento = mock(RepositorioDePagamento.class);
		Relogio relogio = mock(Relogio.class);
		
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        
		Leilao leilao = new CriadorDeLeilao().para("Playstation")
				.lance(new Usuario("José da Silva"), 2000.0)
				.lance(new Usuario("Maria Pereira"), 2500.0).constroi();
		
		when(deLeiloes.encerrados()).thenReturn(Arrays.asList(leilao));
		when(relogio.hoje()).thenReturn(calendar);
		
		
		GeradorDePagamento pagamento  = new GeradorDePagamento(dePagamento, deLeiloes, new Avaliador(),relogio);
		pagamento.gerar();
		
		ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(Pagamento.class);
		verify(dePagamento).savar(argumento.capture());
	    Pagamento pagamento2 = argumento.getValue();
	    assertEquals(Calendar.MONDAY, pagamento2.getData().get(Calendar.DAY_OF_WEEK));
	}
}
