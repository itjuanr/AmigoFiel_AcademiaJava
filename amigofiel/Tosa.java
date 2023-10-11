package amigofiel;

public class Tosa extends Servico {
	
	private String descricao;
	private double preco;

public Tosa(String descricao, double preco) {
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
