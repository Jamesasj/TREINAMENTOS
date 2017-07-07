package compra.descontos;

import compra.Orcamento;

public class Desconto5Itens implements Desconto {

	private Desconto proximo;

	@Override
	public double desconta(Orcamento orcamento) {
		// TODO Auto-generated method stub
		return (orcamento.getItens().size()>=5) ? orcamento.getValor()*0.1 : proximo.desconta(orcamento) ;
	}

	@Override
	public void setProx(Desconto proximo) {
		this.proximo = proximo;
	}


}
