package amigofiel;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Animal> animais = new ArrayList<>();
        ArrayList<Servico> servicos = new ArrayList<>();
        ArrayList<Agenda> agendamentos = new ArrayList<>();
        ArrayList<Produto> produtos = new ArrayList<>();

        while (true) {
            // Mostrar menu para o usuário
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Animal");
            System.out.println("2 - Cadastrar Serviço");
            System.out.println("3 - Agendar Serviço");
            System.out.println("4 - Cadastrar Produto");
            System.out.println("5 - Vender Produto");
            System.out.println("6 - Sair");

            // Verificar se a entrada é um número
            if (scanner.hasNextInt()) {
                int escolha = scanner.nextInt();
                scanner.nextLine();  // Consumir a quebra de linha após o número

                switch (escolha) {
                    case 1:
                        // Cadastrar animal
                        Animal novoAnimal = cadastrarAnimal(scanner);
                        animais.add(novoAnimal);
                        System.out.println("Animal cadastrado com sucesso!");
                        break;
                    case 2:
                        // Cadastrar serviço
                        Servico novoServico = cadastrarServico(scanner);
                        if (novoServico != null) {
                            servicos.add(novoServico);
                            System.out.println("Serviço cadastrado com sucesso!");
                        }
                        break;
                    case 3:
                        // Agendar serviço
                        if (animais.isEmpty() || servicos.isEmpty()) {
                            System.out.println("Erro: Não há animais ou serviços cadastrados para agendar.");
                        } else {
                            Agenda novoAgendamento = agendarServico(scanner, animais, servicos);
                            if (novoAgendamento != null) {
                                agendamentos.add(novoAgendamento);
                                System.out.println("Agendamento realizado com sucesso!");
                            }
                        }
                        break;
                    case 4:
                        // Cadastrar produto
                        Produto novoProduto = cadastrarProduto(scanner);
                        produtos.add(novoProduto);
                        System.out.println("Produto cadastrado com sucesso!");
                        break;
                    case 5:
                        // Vender produto
                        if (produtos.isEmpty()) {
                            System.out.println("Erro: Não há produtos cadastrados para vender.");
                        } else {
                            venderProduto(scanner, produtos);
                        }
                        break;
                    case 6:
                        System.out.println("Saindo do programa. Até mais!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                System.out.println("Opção inválida. Tente novamente.");
                scanner.nextLine();  // Consumir a entrada inválida para evitar um loop infinito
            }
        }
    }

    private static Animal cadastrarAnimal(Scanner scanner) {
        System.out.println("Digite o nome do animal:");
        String nomeAnimal = scanner.nextLine();
        System.out.println("Digite a espécie do animal:");
        String especieAnimal = scanner.nextLine();
        System.out.println("Digite a raça do animal:");
        String racaAnimal = scanner.nextLine();
        System.out.println("Digite a data de nascimento do animal:");
        String dataNascimentoAnimal = scanner.nextLine();
        System.out.println("Digite o nome do proprietário:");
        String proprietarioAnimal = scanner.nextLine();

        return new Animal(nomeAnimal, especieAnimal, racaAnimal, dataNascimentoAnimal, proprietarioAnimal);
    }

    private static Servico cadastrarServico(Scanner scanner) {
        System.out.println("Digite o tipo de serviço (Banho, Tosa, Vacina):");
        String tipoServico = scanner.nextLine();

        switch (tipoServico.toLowerCase()) {
            case "banho":
                return new Banho("Banho para Animal", 30.0);
            case "tosa":
                return new Tosa("Tosa para Animal", 40.0);
            case "vacina":
                return new Vacina("Vacina para Animal", 50.0);
            default:
                System.out.println("Tipo de serviço inválido.");
                return null;
        }
    }

    private static Produto cadastrarProduto(Scanner scanner) {
        System.out.println("Digite o nome do produto:");
        String nomeProduto = scanner.nextLine();
        System.out.println("Digite a categoria do produto:");
        String categoriaProduto = scanner.nextLine();
        System.out.println("Digite o preço do produto:");
        double precoProduto = scanner.nextDouble();
        scanner.nextLine();  // Consumir a quebra de linha após o número
        System.out.println("Digite a quantidade em estoque do produto:");
        int qtEstoqueProduto = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha após o número

        return new Produto(nomeProduto, categoriaProduto, precoProduto, qtEstoqueProduto);
    }

    private static Agenda agendarServico(Scanner scanner, ArrayList<Animal> animais, ArrayList<Servico> servicos) {
        System.out.println("Lista de animais:");
        for (int i = 0; i < animais.size(); i++) {
            System.out.println((i + 1) + ". " + animais.get(i).getNome());
        }
        System.out.println("Selecione um animal digitando o número correspondente:");
        int numeroAnimal = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha após o número

        if (numeroAnimal <= 0 || numeroAnimal > animais.size()) {
            System.out.println("Número de animal inválido.");
            return null;
        }

        Animal animalSelecionado = animais.get(numeroAnimal - 1);

        System.out.println("Lista de serviços:");
        for (int i = 0; i < servicos.size(); i++) {
            System.out.println((i + 1) + ". " + servicos.get(i).getDescricao());
        }
        System.out.println("Selecione um serviço digitando o número correspondente:");
        int numeroServico = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha após o número

        if (numeroServico <= 0 || numeroServico > servicos.size()) {
            System.out.println("Número de serviço inválido.");
            return null;
        }

        Servico servicoSelecionado = servicos.get(numeroServico - 1);

        System.out.println("Digite a data do agendamento:");
        String dataAgendamento = scanner.nextLine();
        System.out.println("Digite o horário do agendamento:");
        String horarioAgendamento = scanner.nextLine();

        return new Agenda(animalSelecionado, servicoSelecionado, dataAgendamento, horarioAgendamento);
    }

    private static void venderProduto(Scanner scanner, ArrayList<Produto> produtos) {
        System.out.println("Lista de produtos disponíveis:");
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            System.out.println((i + 1) + ". " + produto.getNome() + " - R$ " + produto.getPreco() +
                    " - Estoque: " + produto.getQtEstoque());
        }
        System.out.println("Selecione um produto para vender digitando o número correspondente:");
        int numeroProduto = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha após o número

        if (numeroProduto <= 0 || numeroProduto > produtos.size()) {
            System.out.println("Número de produto inválido.");
            return;
        }

        Produto produtoSelecionado = produtos.get(numeroProduto - 1);

        System.out.println("Digite a quantidade que deseja comprar:");
        int quantidadeVendida = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha após o número

        if (quantidadeVendida <= 0 || quantidadeVendida > produtoSelecionado.getQtEstoque()) {
            System.out.println("Quantidade inválida ou insuficiente em estoque.");
            return;
        }

        double valorTotal = quantidadeVendida * produtoSelecionado.getPreco();
        System.out.println("Total a pagar: R$ " + valorTotal);

        // Atualizar o estoque do produto após a venda
        produtoSelecionado.setQtEstoque(produtoSelecionado.getQtEstoque() - quantidadeVendida);
        System.out.println("Venda realizada com sucesso!");
    }
}
