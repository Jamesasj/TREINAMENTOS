package compra.impostos;

import compra.Orcamento;

public class ICPP extends TempleteImpostoCondional {

	@Override
	public double menorTaxa(Orcamento orcamento) {
		// TODO Auto-generated method stub
		return orcamento.getValor() * 0.05;
	}

	@Override
	public double maiorTaxa(Orcamento orcamento) {
		// TODO Auto-generated method stub
		return orcamento.getValor() * 0.07 ;
	}

	@Override
	public boolean MaiorTaxacao(Orcamento orcamento) {
		// TODO Auto-generated method stub
		return orcamento.getValor() > 500;
	}

}
