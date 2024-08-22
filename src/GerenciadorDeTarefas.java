import java.util.*;

public class GerenciadorDeTarefas {

    private List<Tarefa> tarefas = new ArrayList<>(List.of());


    public void adicionarTarefa (Tarefa tarefa) {
        tarefas.add(tarefa);
        tarefas.sort(Comparator.comparing(Tarefa::getPrioridade).reversed());
    }

    public void removerTarefaPeloId(Integer id) {
        tarefas.removeIf(tarefa -> tarefa.getId().equals(id));
    }


    public void listarTarefasPorCategoria () {
        List<Tarefa> ordenado = tarefas
                .stream()
                .sorted(Comparator.comparing(Tarefa::getCategoria))
                .toList();

        ordenado.forEach(System.out::println);
    }

    public void listarTarefasPorPrioridade () {
        List<Tarefa> ordenado = tarefas
                .stream()
                .sorted(Comparator.comparing(Tarefa::getPrioridade).reversed())
                .toList();

        ordenado.forEach(System.out::println);
    }

    public void listarTarefasPorStatus () {
        List<Tarefa> ordenado = tarefas
                .stream()
                .sorted(Comparator.comparing(Tarefa::getStatus).reversed())
                .toList();

        ordenado.forEach(System.out::println);
    }

    public void exibirNumeroPeloStatus (){

        long toDo = tarefas.stream().filter(tarefa -> tarefa.getStatus().equals("todo")).count();
        System.out.println("ToDo: "+toDo);

        long doing = tarefas.stream().filter(tarefa -> tarefa.getStatus().equals("doing")).count();
        System.out.println("Doing: "+doing);

        long done = tarefas.stream().filter(tarefa -> tarefa.getStatus().equals("done")).count();
        System.out.println("Done: "+done);
    }


}
