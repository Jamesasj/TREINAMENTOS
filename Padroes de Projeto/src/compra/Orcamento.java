package compra;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import compra.estados.EmAprovacao;
import compra.estados.Estados;




public class Orcamento {
  
	private double valor;
    private List <Item> itens;
	private Estados estadoAtual;
    
	public Orcamento(double valor) {
		this.valor = valor;
		itens=new ArrayList<Item>();
		estadoAtual=new EmAprovacao();
}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List <Item> getItens() {
		return Collections.unmodifiableList(itens);
	}

	public void AddItem(Item item) {
		this.itens.add(item);
	}

	public Estados getEstadoAtual() {
		return estadoAtual;
	}

	public void aplicaDescontoExtra(){
		this.valor = estadoAtual.AplicaDescontoExtra(this);
	}
	
	public void setEstadoAtual(Estados estadoAtual) {
		this.estadoAtual = estadoAtual;
	}
	public void aprova(){
		estadoAtual.aprova(this);
	}
	 public void finaliza(){
		 estadoAtual.finaliza(this);
	 }
	 public void reprova(){
		 estadoAtual.reprova(this);
	 }
	
}
