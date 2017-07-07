package outros;

public class ExibirXML implements AcaoTipodeSaida {
    private AcaoTipodeSaida prox;
	@Override
	public void imprimirFormato(Conta conta, Requisicao req) {
		if(req.getFormato() == Formato.XML){
			System.out.println("Imprimiu XML");
		}else{
			this.prox.imprimirFormato(conta, req);
		}
		
	}

	@Override
	public void setProximo(AcaoTipodeSaida prox) {
		this.prox = prox;
	}


}
