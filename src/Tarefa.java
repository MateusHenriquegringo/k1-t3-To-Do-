import java.time.LocalDate;

public class Tarefa {

    private static Integer proximoId = 1;

    private Integer id;

    private String nome;
    private String descricao;
    private LocalDate dataLimite;
    private Integer prioridade;
    private String categoria;
    private String status;

    private Tarefa (Builder builder){
        this.id = proximoId++;
        this.nome = builder.nome;
        this.descricao = builder.descricao;
        this.prioridade = builder.prioridade;
        this.status = builder.status;
        this.categoria = builder.categoria;
        this.dataLimite = builder.dataLimite;

    }

    public static class Builder {

        private  String nome;
        private  LocalDate dataLimite;
        private  int prioridade;
        private  String status;
        private  String categoria;
        private  String descricao;



        public Builder nome(String nome){
            this.nome = nome;
            return this;
        }
        public Builder descricao(String descricao){
            this.descricao = descricao;
            return this;
        }

        public Builder categoria(String categoria){
            this.categoria = categoria;
            return this;
        }

        public Builder dataFinal(LocalDate data){
            this.dataLimite = data;
            return this;
        }

        public Builder prioridade(int prioridade){
            if (prioridade>5||prioridade<1) {
                throw new RuntimeException("prioridade deve ser entre 1 e 5");
            }
            this.prioridade = prioridade;
            return this;
        }

        public Builder status (String status){
            this.status = status;
            return this;
        }

        public Tarefa build(){
            return new Tarefa(this);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getId (){
        return id;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataLimite=" + dataLimite +
                ", prioridade=" + prioridade +
                ", categoria='" + categoria + '\'' +
                ", status=" + status +
                '}';
    }
}
