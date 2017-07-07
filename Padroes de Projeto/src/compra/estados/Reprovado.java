package compra.estados;

import compra.Orcamento;

public class Reprovado implements Estados {

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Orçamento Reprovado!");
	}

	@Override
	public void reprova(Orcamento orcamento) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Orçamento Reprovado!");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Orçamento Reprovado!");
	}

	@Override
	public double AplicaDescontoExtra(Orcamento orcamento) {
		throw new RuntimeException("Orçamento Reprovado Impossivel aplicar Desconto!");
	}

}
