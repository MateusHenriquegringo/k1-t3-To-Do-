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
        var ordenado = tarefas
                .stream()
                .sorted(Comparator.comparing(Tarefa::getCategoria))
                .toList();

        ordenado.forEach(System.out::println);
    }

    public void listarTarefasPorPrioridade () {
        var ordenado = tarefas
                .stream()
                .sorted(Comparator.comparing(Tarefa::getPrioridade).reversed())
                .toList();

        ordenado.forEach(System.out::println);
    }

    public void listarTarefasPorStatus () {
        var ordenado = tarefas
                .stream()
                .sorted(Comparator.comparing(Tarefa::getStatus).reversed())
                .toList();

        ordenado.forEach(System.out::println);
    }

    public void exibirNumeroPeloStatus (){

        var toDo = tarefas.stream().filter(tarefa -> tarefa.getStatus().equals("ToDo")).count();
        System.out.println("ToDo: "+toDo);

        var doing = tarefas.stream().filter(tarefa -> tarefa.getStatus().equals("Doing")).count();
        System.out.println("Doing: "+doing);

        var done = tarefas.stream().filter(tarefa -> tarefa.getStatus().equals("Done")).count();
        System.out.println("Done: "+done);
    }


}
