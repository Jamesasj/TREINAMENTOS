package compra.impostos;

import compra.Orcamento;

public class ISS extends Imposto {
	public ISS() {
	}
	public ISS(Imposto imposto) {
		super(imposto);
	}
   
	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor()*0.06 + calculaOutroImposto(orcamento);
	}

}
