package compra.impostos;

import compra.Orcamento;

public class CalcularImposto {

	
public void realizarCalculo(Orcamento orcamento, Imposto imposto){
	double valor = imposto.calcula(orcamento);
	System.out.println(valor);
}
}
