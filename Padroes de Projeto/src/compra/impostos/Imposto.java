package compra.impostos;

import compra.Orcamento;

public abstract class Imposto {
 protected Imposto outroImposto;
 
public abstract double calcula(Orcamento orcamento);

public Imposto() {
	outroImposto = null;
}

public Imposto (Imposto outroImposto){
	this.outroImposto = outroImposto;	 
 }

protected double calculaOutroImposto(Orcamento orcamento) {
	if (outroImposto == null) return 0;
	return outroImposto.calcula(orcamento);
}
}
