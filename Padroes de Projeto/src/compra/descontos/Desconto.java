package compra.descontos;

import compra.Orcamento;

public interface Desconto {
	double desconta(Orcamento orcamento);
	void setProx(Desconto proximo);
}
