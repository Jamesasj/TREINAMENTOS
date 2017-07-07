package testes;

import compra.Item;
import compra.Orcamento;
import compra.impostos.CalcularImposto;
import compra.impostos.ICPP;
import compra.impostos.IKVC;
import compra.impostos.Imposto;

public class TestesImposto {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Imposto IKVC = new IKVC();
		Imposto ICPP = new ICPP();

		Orcamento orcamento = new Orcamento(600.0);
		orcamento.AddItem(new Item("Lapis",200));
		orcamento.AddItem(new Item("Caneta",300));

		CalcularImposto calcularImposto = new CalcularImposto();

		orcamento.setValor(3001.0);
		calcularImposto.realizarCalculo(orcamento,IKVC);

		orcamento.setValor(3001.0);
		calcularImposto.realizarCalculo(orcamento, ICPP);    
	}

}
