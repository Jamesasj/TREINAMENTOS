package investimentos;

public class Arrojado implements Investimento {

	private double valor;

	public Arrojado(double valor) {
		this.valor = valor;
	}

	@Override
	public double calcularInvestimento() {
		double escolhido = Math.random();
		// TODO Auto-generated method stub
		if (escolhido>0.5)
			return valor*0.05;
		else if(escolhido>0.3)
			return valor*0.03;
		else
			return valor*0.06;
	}

}
