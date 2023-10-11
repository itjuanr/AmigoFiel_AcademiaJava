package amigofiel;

import java.util.ArrayList;
import java.util.Date;

public class Agenda {
	private String nome;
	private String servico;
	private Date data;
	private String horario;
	

public Agenda (String nome, String servico, Date data, String horario) {
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

public Date getData() {
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

public void setData(Date data) {
	this.data = data;
}

public void setHorario(String horario) {
	this.horario = horario;
}

public void agendar(ArrayList<Agenda> agenda, Agenda novoAgendamento) {
	for (Agenda agendamento : agenda) {
		if(agendamento.getHorario().equals(novoAgendamento.getHorario()) &&
				agendamento.getData().equals(novoAgendamento.getData())) {
			System.out.println("A Data selecionada já está ocupada, escolha outro horário!");
			return;
		}
	}
	
	agenda.add(novoAgendamento);
	System.out.println("Agendamento realizado com sucesso!");
}

}
