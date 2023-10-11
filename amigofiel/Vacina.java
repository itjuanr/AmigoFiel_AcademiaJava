package amigofiel;

public class Vacina extends Servico{
	private String descricao;
	private double preco;

public Vacina(String descricao, double preco) {
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
