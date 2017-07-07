package testes;

import compra.notafiscal.NotaFiscal;
import compra.notafiscal.NotaFiscalBuilder;

public class TesteBuilder {
	public static void main(String[] args) {
		NotaFiscal nf= new NotaFiscalBuilder()
		.paraRazaoSocial("Empresa X")
		.comCNPJ("1234567891212")
		.gerarData()
		.comItem("Item 1", 100.0)
		.comItem("Item 2", 200.0)
		.comItem("Item 3", 400.0)
		.comObservacao("Observacao").constroi();

		System.out.println(nf.getValor());

	}
}
