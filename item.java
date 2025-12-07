public class item {
    private String tipo;      
    private String descricao;
    private boolean concluido;

  
    public item(String tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.concluido = false;
    }


    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluido() {
        return concluido;
    }

   
    public void marcarComoConcluido() {
        this.concluido = true;
    }

    @Override
    public String toString() {
        String status = concluido ? "✅ CONCLUÍDO" : "⏳ PENDENTE";
        return "Tipo: " + tipo + " | Descrição: " + descricao + " | Status: " + status;
    }
}
