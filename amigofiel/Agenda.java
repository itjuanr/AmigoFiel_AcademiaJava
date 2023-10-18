package amigofiel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Agenda {
    private Animal animal;
    private Servico servico;
    private Date data;
    private String horario;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public Agenda(Animal animal, Servico servico, String data, String horario) {
        this.animal = animal;
        this.servico = servico;
        try {
            this.data = dateFormat.parse(data + " " + horario);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.horario = horario;
    }

    // Getters e setters
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void agendar(ArrayList<Agenda> agenda, Agenda novoAgendamento) {
        for (Agenda agendamento : agenda) {
            if (agendamento.getHorario().equals(novoAgendamento.getHorario()) &&
                    agendamento.getData().equals(novoAgendamento.getData())) {
                System.out.println("A Data selecionada já está ocupada, escolha outro horário!");
                return;
            }
        }
        agenda.add(novoAgendamento);
        System.out.println("Agendamento realizado com sucesso!");
    }
}
