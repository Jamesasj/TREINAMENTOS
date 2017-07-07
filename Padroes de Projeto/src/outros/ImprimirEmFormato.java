package outros;

public abstract class ImprimirEmFormato implements AcaoTipodeSaida {
	
	

	private AcaoTipodeSaida prox;

	
	public ImprimirEmFormato(AcaoTipodeSaida prox) {
		this.setProx(prox);
	}
	@Override
	public void imprimirFormato(Conta conta, Requisicao req) {
		// TODO Auto-generated method stub

	}
	public AcaoTipodeSaida getProx() {
		return prox;
	}
	public void setProx(AcaoTipodeSaida prox) {
		this.prox = prox;
	}


}
