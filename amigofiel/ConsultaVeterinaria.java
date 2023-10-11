package amigofiel;

public class ConsultaVeterinaria extends Servico {
	private String descricao;
	private double preco;

public ConsultaVeterinaria(String descricao, double preco) {
        super(descricao, preco);
        this.descricao = descricao;
        this.preco = preco;
}

@Override
public String descricao() {
    return descricao;
}

@Override
public double preco() {
    return preco;
  }
}
