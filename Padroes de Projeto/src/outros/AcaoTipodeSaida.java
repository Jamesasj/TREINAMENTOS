package outros;

public interface AcaoTipodeSaida {
	void imprimirFormato(Conta conta, Requisicao req);
	void setProximo (AcaoTipodeSaida prox);
}
