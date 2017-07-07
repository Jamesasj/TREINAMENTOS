package investimentos;

public class Conservador implements Investimento {

	private double valor;

	public Conservador(double valor) {
		this.valor = valor;
	}

	@Override
	public double calcularInvestimento() {
		// TODO Auto-generated method stub
		return valor*0.008;
	}

}
