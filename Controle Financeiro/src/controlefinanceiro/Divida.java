package controlefinanceiro;

import java.util.ArrayList;

public class Divida {
 private double total;
 private double valorpago;
 private String credor;
 private String cnpjPagado;
 private ArrayList<Pagamento> pagamento = new ArrayList<Pagamento>();
 
 public ArrayList<Pagamento> getPagamento() {
	return pagamento;
}

public void setPagamento(ArrayList<Pagamento> pagamento) {
	this.pagamento = pagamento;
}

public void setValorpago(double valorpago) {
	this.valorpago = valorpago;
}

public double getTotal() {
	return total;
}

 public void setTotal(double total) {
	this.total = total;
}

public double getValorpago() {
	return valorpago;
}

public String getCredor() {
	return credor;
}

public void setCredor(String credor) {
	this.credor = credor;
}

public String getCnpjPagado() {
	return cnpjPagado;
}

public void setCnpjPagado(String cnpjPagado) {
	this.cnpjPagado = cnpjPagado;
}

public void paga(double valor) {
	if (valor > 0)
	this.valorpago = valor;
}
 
 
}
