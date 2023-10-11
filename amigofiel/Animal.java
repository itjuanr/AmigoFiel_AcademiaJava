package amigofiel;

public class Animal {
	
	private String nome;
	private String especie;
	private String raca;
	private String dataNascimento;
	private String proprietario;


public Animal(String nome, String especie, String raca, String dataNascimento, String proprietario) {
	this.nome = nome;
	this.especie = especie;
	this.raca = raca;
	this.dataNascimento = dataNascimento;
	this.proprietario = proprietario;	
}

public String getNome() {
	return this.nome;
}

public String getEspecie() {
	return this.especie;
}

public String getRaca() {
	return this.raca;
}

public String dataNascimento() {
	return this.dataNascimento;
}

public String proprietario() {
	return this.proprietario;
}

public void setNome(String nome) {
	this.nome = nome;
}

public void setEspecie(String especie) {
	this.especie = especie;
}

public void setdataNascimento(String dataNascimento) {
	this.dataNascimento = dataNascimento;
}

public void setProprietario(String proprietario) {
	this.proprietario = proprietario;
}




}