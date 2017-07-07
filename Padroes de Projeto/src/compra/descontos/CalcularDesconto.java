package compra.descontos;

import compra.Orcamento;

public class CalcularDesconto {

	public double CalculaDesconto(Orcamento orcamento) {
		Desconto d1 = new Desconto5Itens();
		Desconto d2 = new DescontoMaior500();
		Desconto d3 = new DescontoVendaCasada();
		
		d1.setProx(d2);
		d2.setProx(d3);
		d3.setProx(new SemDesconto());
		
		return d1.desconta(orcamento);		
	}
}
