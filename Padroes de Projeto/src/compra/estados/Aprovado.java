package compra.estados;

import compra.Orcamento;

public class Aprovado implements Estados{


	@Override
	public double AplicaDescontoExtra(Orcamento orcamento) {
		return orcamento.getValor() - orcamento.getValor()*0.02;
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Ja foi aprovado");
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Ja foi aprovado");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.setEstadoAtual(new Finalizado());			
	}

}
