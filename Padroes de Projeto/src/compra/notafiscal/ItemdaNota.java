package compra.notafiscal;

public class ItemdaNota {
	private String descricao;
	private double valor;
	
	public ItemdaNota(String descricao, double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public double getValor() {
		return valor;
	}

}
