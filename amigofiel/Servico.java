package amigofiel;

public abstract class Servico {
	private String descricao;
	private double preco;
	

public Servico (String descricao, double preco) {
	this.descricao = descricao;
	this.preco = preco;
}

// Método abstrato para obter a descrição do serviço
public abstract String descricao();

// Método abstrato para obter o preço do serviço
public abstract double preco();

public String getDescricao() {
    return descricao;
}

public void setDescricao(String descricao) {
    this.descricao = descricao;
}

public double getPreco() {
    return preco;
}

public void setPreco(double preco) {
    this.preco = preco;
}

}
