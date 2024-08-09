import java.time.LocalDate;
import java.util.Scanner;
// Autor: Mateus Derossi
// Este programa é uma aplicação simples para gerenciamento de tarefas, permitindo a criação, deleção, listagem e contagem de tarefas por status.

public class Main {
    private static final GerenciadorDeTarefas gerenciador=new GerenciadorDeTarefas();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


        while (true) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    adicionarTarefa();
                    break;
                case "2":
                    System.out.print("Id da tarefa a deletar: ");
                    String id = scanner.nextLine();
                    gerenciador.removerTarefaPeloId(Integer.parseInt(id));
                    break;
                case "3":
                    gerenciador.listarTarefasPorCategoria();
                    break;
                case "4":
                    gerenciador.listarTarefasPorPrioridade();
                    break;
                case "5":
                    gerenciador.listarTarefasPorStatus();
                    break;
                case "6":
                    gerenciador.exibirNumeroPeloStatus();
                    break;
                default:
                    System.out.println("escolha invalida");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. adicionar tarefa");
        System.out.println("2. remover tarefa");
        System.out.println("3. listar tarefa por categoria");
        System.out.println("4. listar tarefa por prioridade");
        System.out.println("5. listar tarefa por status");
        System.out.println("6. exibir numero de tarefas por status");


    }
    private static void adicionarTarefa () {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descricao: ");
        String descricao = scanner.nextLine();
        System.out.print("Data Limite (YYYY-MM-DD): ");
        LocalDate data = LocalDate.parse(scanner.nextLine());
        System.out.print("Prioridade (1-5): ");
        int prioridade = Integer.parseInt(scanner.nextLine());
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();
        System.out.print("Status (ToDo, Doing, Done): ");
        String status = scanner.nextLine();

        gerenciador.adicionarTarefa(new Tarefa.Builder()
                .status(status)
                .categoria(categoria)
                .dataFinal(data)
                .nome(nome)
                .prioridade(prioridade)
                .build());
    }

}