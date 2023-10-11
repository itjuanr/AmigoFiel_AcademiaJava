package amigofiel;

public class Agenda {
	private String nome;
	private String servico;
	private String data;
	private String horario;
	

public Agenda (String nome, String servico, String data, String horario) {
	this.nome = nome;
	this.servico = servico;
	this.data = data;
	this.horario = horario;
}

public String getNome() {
	return this.nome;
}

public String getServico() {
	return this.servico;
}

public String getData() {
	return this.data;
}

public String getHorario() {
	return this.horario;
}

public void setNome(String nome) {
	this.nome = nome;
}

public void setServico(String servico) {
	this.servico = servico;
}

public void setData(String data) {
	this.data = data;
}

public void setHorario(String horario) {
	this.horario = horario;
}


}
