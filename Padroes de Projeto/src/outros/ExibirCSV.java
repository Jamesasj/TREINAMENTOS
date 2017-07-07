package outros;

public class ExibirCSV implements AcaoTipodeSaida {
    private AcaoTipodeSaida prox;
	@Override
	public void imprimirFormato(Conta conta, Requisicao req) {
		if(req.getFormato() == Formato.CSV){
			System.out.println("Imprimiu CSV");
		}else{
			this.prox.imprimirFormato(conta, req);
		}
	}

	@Override
	public void setProximo(AcaoTipodeSaida prox) {
		this.prox = prox;
		
	}



}
