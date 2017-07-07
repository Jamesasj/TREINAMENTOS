package compra.acoes;

import compra.notafiscal.NotaFiscal;

public class NotaFiscalDAO implements Acoes{

	@Override
	public void executar(NotaFiscal nf) {
		System.out.println("Gravou no Banco");
	}

}
