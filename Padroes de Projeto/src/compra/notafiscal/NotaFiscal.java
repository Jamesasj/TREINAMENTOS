package compra.notafiscal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotaFiscal {
private String razaoSocial;
private String Cnpj;
private double valor;
private double imposto;
private Calendar data;
private List <ItemdaNota> itens = new ArrayList<ItemdaNota>();
private String observacao;



public String getObservacao() {
	return observacao;
}

public NotaFiscal(String razaoSocial, String cnpj, double valor,
		double imposto, Calendar data, List<ItemdaNota> itens, String observacao) {
	super();
	this.razaoSocial = razaoSocial;
	Cnpj = cnpj;
	this.valor = valor;
	this.imposto = imposto;
	this.data = data;
	this.itens = itens;
	this.observacao = observacao;
}

public NotaFiscal(String razaoSocial, String cnpj, double valor,
		double imposto, Calendar data, List<ItemdaNota> itens) {
	this.razaoSocial = razaoSocial;
	Cnpj = cnpj;
	this.valor = valor;
	this.imposto = imposto;
	this.data = data;
	this.itens = itens;
}

public String getRazaoSocial() {
	return razaoSocial;
}

public String getCnpj() {
	return Cnpj;
}

public double getValor() {
	return valor;
}

public double getImposto() {
	return imposto;
}

public Calendar getData() {
	return data;
}

public List<ItemdaNota> getItens() {
	return itens;
}


}
