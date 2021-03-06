package compra.impostos;

import compra.Orcamento;

public class ICCC extends Imposto {

	@Override
	public double calcula(Orcamento orcamento) {
		if (orcamento.getValor() < 1000.0)
		 return orcamento.getValor()*0.05;	
		else 
			if (orcamento.getValor() <= 3000.0)
				return orcamento.getValor()*0.07;			
			else  
				return orcamento.getValor()*0.08+30.0;
	}

}
