package compra.estados;

import compra.Orcamento;

public interface Estados {
  double AplicaDescontoExtra(Orcamento orcamento);
  void aprova(Orcamento orcamento);
  void reprova(Orcamento orcamento);
  void finaliza(Orcamento orcamento);
}
