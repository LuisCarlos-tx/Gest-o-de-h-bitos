import java.util.ArrayList;
import java.util.List;

public class gerenciador {
    private List<Item> gestao;

    public gerenciador() {
        this.gestao = new ArrayList<>();
    }

    public void adicionaritem(String tipo, String descricao) {
        Item novoitem = new item(tipo, descricao);
        gestao.add(novoItem);
        System.out.println("\n✅ " + tipo + " '" + descricao + "' adicionado com sucesso!");
    }

    public boolean isListaVazia() {
        return gestao.isEmpty();
    }

    public List<item> listaritens() {
        return gestao;
    }

   
    public boolean marcarConcluido(int indice) {
        int i = indice - 1;

        if (i >= 0 && i < gestao.size()) {
            if (!gestao.get(i).isConcluido()) {
                gestao.get(i).marcarComoConcluido();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
