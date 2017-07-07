package compra.descontos;

import compra.Orcamento;

public class DescontoMaior500 implements Desconto {

	private Desconto proximo;

	@Override
	public double desconta(Orcamento orcamento) {
		return (orcamento.getValor() >= 500.0) ? orcamento.getValor()*0.07 : proximo.desconta(orcamento);
	}

	@Override
	public void setProx(Desconto proximo) {
		this.proximo = proximo;
	}

}
