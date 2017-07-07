package compra.impostos;

import compra.Item;
import compra.Orcamento;



public class IKVC extends TempleteImpostoCondional{

	@Override
	public double menorTaxa(Orcamento orcamento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double maiorTaxa(Orcamento orcamento) {
		// TODO Auto-generated method stub
		return orcamento.getValor() * 0.10;
	}

	@Override
	public boolean MaiorTaxacao(Orcamento orcamento) {
		// TODO Auto-generated method stub
		return orcamento.getValor() > 500 && ExitemMaiorQue100(orcamento);
				
	}

	private boolean ExitemMaiorQue100(Orcamento orcamento) {
		// TODO Auto-generated method stub
		for (Item item : orcamento.getItens()) {
			if (item.getValor()>100) return true;
		};		
		return false;
	}

}
