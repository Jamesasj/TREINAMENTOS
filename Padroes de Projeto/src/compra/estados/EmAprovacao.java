package compra.estados;

import compra.Orcamento;

public class EmAprovacao implements Estados{


	@Override
	public double AplicaDescontoExtra(Orcamento orcamento) {
		return orcamento.getValor() - orcamento.getValor()*0.05;
	}

	@Override
	public void aprova(Orcamento orcamento) {
		orcamento.setEstadoAtual(new Aprovado());
		
	}

	@Override
	public void reprova(Orcamento orcamento) {
		orcamento.setEstadoAtual(new  Reprovado());
		
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Não pode ser finalizado!");
	}

}
