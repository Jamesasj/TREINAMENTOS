package compra.acoes;

import compra.notafiscal.NotaFiscal;

public class Email implements Acoes {

	@Override
	public void executar(NotaFiscal nf) {
		System.out.println("Enviou por email");
	}

}
