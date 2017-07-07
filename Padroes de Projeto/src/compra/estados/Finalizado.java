package compra.estados;

import compra.Orcamento;

public class Finalizado implements Estados {

	@Override
	public double AplicaDescontoExtra(Orcamento orcamento) {
		throw new RuntimeException("Or�amento finalizado!");
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Or�amento Finalizado!");
		
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Or�amento Finalizado!");
		
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Or�amento Finalizado!");
		
	}

}
