package investimentos;

public class TesteInvestidor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Investimento i1 = new Conservador(200.0);
    Investimento i2 = new Moderado(200.0);
    Investimento i3 = new Arrojado(200.0);
    
    RealizaInvestimento realizaInvestimento = new RealizaInvestimento();
    realizaInvestimento.investir(i1);
    realizaInvestimento.investir(i2);
    realizaInvestimento.investir(i3);
	}

}

