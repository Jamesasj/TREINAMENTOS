package testes;

import compra.Orcamento;
import compra.impostos.CalcularImposto;
import compra.impostos.ICMS;
import compra.impostos.ISS;
import compra.impostos.Imposto;

public class TesteDecorator {
	public static void main(String[] args) {
		Imposto imposto = new ISS(new ICMS());
		Orcamento orcamento = new Orcamento(100.0);
		CalcularImposto calcularImposto =  new CalcularImposto();
		calcularImposto.realizarCalculo(orcamento, imposto);
	}
}
