package outros;

public class Conta {
	private String nomeTitular;
	private double saldo;
	
	
	public Conta(String nomeTitular, double saldo) {
		this.nomeTitular = nomeTitular;
		this.saldo = saldo;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
   
}
