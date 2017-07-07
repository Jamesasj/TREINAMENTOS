package compra.descontos;

import compra.Orcamento;

public class SemDesconto implements Desconto {

	@Override
	public double desconta(Orcamento orcamento) {
		return 0;
	}


	@Override
	public void setProx(Desconto proximo) {
		// TODO Auto-generated method stub
		
	}

}
