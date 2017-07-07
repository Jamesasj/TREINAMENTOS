package compra.notafiscal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import compra.acoes.Acoes;

public class NotaFiscalBuilder {

	private String razaoSocial;
	private String cnpj;
	private Calendar data;
	private List<ItemdaNota> itens = new ArrayList<ItemdaNota>();
	private double valor;
	private double imposto;
	private String observacao;
	private List<Acoes> acoesAutomaticas = new ArrayList<Acoes>();

	public void addAcao(Acoes acao){
		this.acoesAutomaticas.add(acao);
	}
	private void exetutaAcoes(NotaFiscal nf) {
		for (Acoes acao : this.acoesAutomaticas) {
			acao.executar(nf);
		}
	}

	public NotaFiscalBuilder paraRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}

	public NotaFiscalBuilder comCNPJ(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	public NotaFiscalBuilder gerarData() {
		this.data = Calendar.getInstance();
		return this;
	}

	public NotaFiscalBuilder comObservacao(String observacao) {
		this.observacao = observacao;
		return this;
	}

	public NotaFiscalBuilder comItem(String descricao, double valor) {
		this.itens.add(new ItemdaNota(descricao, valor));
		this.valor += valor;
		this.imposto += valor * 0.5;
		return this;
	}

	public NotaFiscal constroi() {
		NotaFiscal nf = new NotaFiscal(razaoSocial, cnpj, valor, imposto, data, itens, observacao);
		this.exetutaAcoes(nf);
		return nf;
	}

}
