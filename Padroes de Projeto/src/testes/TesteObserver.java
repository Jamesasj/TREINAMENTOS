package testes;

import compra.acoes.Email;
import compra.acoes.NotaFiscalDAO;
import compra.notafiscal.NotaFiscal;
import compra.notafiscal.NotaFiscalBuilder;

public class TesteObserver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       NotaFiscalBuilder builder = new NotaFiscalBuilder();
       builder.addAcao(new NotaFiscalDAO());
       builder.addAcao(new Email());
       
       NotaFiscal nf = builder.paraRazaoSocial("Empresa X")
		       .comCNPJ("1234567891212")
		       .gerarData()
		       .comItem("Item 1", 100.0)
		       .comItem("Item 2", 200.0)
		       .comItem("Item 3", 400.0)
		       .comObservacao("Observacao").constroi();
       
System.out.println(nf.getValor());
	}

}
