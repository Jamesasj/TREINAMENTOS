package testes;

import compra.Orcamento;

public class TesteDeEstados {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orcamento orcamento = new Orcamento(500.00);
		orcamento.aplicaDescontoExtra();
		System.out.println(orcamento.getValor());
		orcamento.aprova();
		orcamento.aplicaDescontoExtra();
		System.out.println(orcamento.getValor());
		orcamento.finaliza();
		orcamento.aplicaDescontoExtra();
		System.out.println(orcamento.getValor());
	}

}
