package compra.impostos;

import compra.Orcamento;

public abstract class TempleteImpostoCondional extends Imposto{

	@Override
	public double calcula(Orcamento orcamento) {
		if (MaiorTaxacao(orcamento))
			return maiorTaxa(orcamento);
		else
			return menorTaxa(orcamento);
	}

	public abstract double menorTaxa(Orcamento orcamento);

	public abstract double maiorTaxa(Orcamento orcamento);

	public abstract boolean MaiorTaxacao(Orcamento orcamento);

}
