package investimentos;

public class Moderado implements Investimento {

	private double valor;

	public Moderado(double valor) {
		this.valor = valor;
	}

	@Override
	public double calcularInvestimento() {
		if(Math.random()*11 > 5) 
			return valor*0.025;
		else 
			return valor*0.07;
	}

}
