package amigofiel;

public class Produto {
	private String nome;
	private String categoria;
	private double preco;
	private int qtEstoque;
	
public Produto (String nome, String categoria, double preco, int qtEstoque) {
	this.nome = nome;
	this.categoria = categoria;
	this.preco = preco;
	this.qtEstoque = qtEstoque;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCategoria() {
	return categoria;
}

public void setCategoria(String categoria) {
	 this.categoria = categoria;
}

public double getPreco() {
	 return this.preco;
}

public void setPreco(double preco) {
	 this.preco = preco;
}

public int getQtEstoque() {
	return qtEstoque;
}

public void setQtEstoque(int qtEstoque) {
	this.qtEstoque = qtEstoque;
}

public boolean vender(int quantidade) {
	if (quantidade <= qtEstoque) {
		qtEstoque -= quantidade;
		return true;
	} else {
		return false;
	}
}

}
