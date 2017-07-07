package outros;

public class ExibirPorcento implements AcaoTipodeSaida {

	private AcaoTipodeSaida prox;

	@Override
	public void imprimirFormato(Conta conta,  Requisicao req) {
		if(req.getFormato() == Formato.PORCENTO){
			System.out.println("Imprimiu Porcento");
		}else{
			if(prox != null)
				this.prox.imprimirFormato(conta, req);
			else
				throw new NullPointerException("Nenhum formato foi selecionado");
		}

	}

	@Override
	public void setProximo(AcaoTipodeSaida prox) {
		this.prox = prox;
	}

}
