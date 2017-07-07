package testes;

import compra.Item;
import compra.Orcamento;
import compra.descontos.CalcularDesconto;

public class TesteDesconto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(499.0);
		orcamento.AddItem(new Item("Caneta", 10.00));
		orcamento.AddItem(new Item("Lapis", 10.00));
		CalcularDesconto calcularDesconto = new CalcularDesconto();
		
        System.out.println(calcularDesconto.CalculaDesconto(orcamento));
	}

}
