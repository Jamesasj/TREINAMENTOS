package compra.descontos;

import compra.Item;
import compra.Orcamento;

public class DescontoVendaCasada implements Desconto {

	private Desconto proximo;

	@Override
	public double desconta(Orcamento orcamento) {
		return (existeItem("Lapis",orcamento) && existeItem("Caneta",orcamento)) ? orcamento.getValor()*0.05 : proximo.desconta(orcamento);
	}

	private boolean existeItem(String string, Orcamento orcamento) {
		for (Item item : orcamento.getItens()) {
	        if(item.getNome().equals(string)) return true;
	    }
	    return false;
	}

	@Override
	public void setProx(Desconto proximo) {
		this.proximo = proximo;
	}

}
