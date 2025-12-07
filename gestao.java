import java.util.List;
import java.util.Scanner;

public class GestaoSimples {

    private static Gerenciador gerenciador = new Gerenciador();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    private static void exibirLista() {
        if (gerenciador.isListaVazia()) {
            System.out.println("\nLista vazia. Adicione uma meta ou um hábito primeiro.");
            return;
        }

        List<Item> lista = gerenciador.listarItens();
        System.out.println("\n--- 📋 SUAS METAS E HÁBITOS ---");
        for (int i = 0; i < lista.size(); i++) {
            // Imprime o índice + 1 para o usuário
            System.out.println("[" + (i + 1) + "] " + lista.get(i));
        }
        System.out.println("-----------------------------------");
    }

    private static void marcar() {
        exibirLista();

        if (gerenciador.isListaVazia()) {
            return;
        }

        System.out.print("Digite o NÚMERO do item a ser concluído: ");
        try {
            int indice = Integer.parseInt(scanner.nextLine());
            
            if (gerenciador.marcarConcluido(indice)) {
                // Se a marcação foi bem-sucedida, pega a descrição para feedback
                // Nota: Em um sistema mais robusto, o Gerenciador retornaria o item.
                // Aqui, vamos apenas dar o feedback de sucesso.
                System.out.println("\n🎉 Item " + indice + " marcado como CONCLUÍDO!");
            } else {
                // O método retorna false se o índice for inválido ou se já estiver concluído
                System.out.println("\n❌ Não foi possível marcar o item. Verifique o número digitado ou se ele já está concluído.");
            }
        } catch (NumberFormatException e) {
            System.out.println("\n❌ Entrada inválida. Por favor, digite um número.");
        }
    }

    private static void menu() {
        String escolha;
        do {
            System.out.println("\n==================================");
            System.out.println("    SISTEMA DE GESTÃO MODULAR");
            System.out.println("==================================");
            System.out.println("[1] Adicionar Meta");
            System.out.println("[2] Adicionar Hábito");
            System.out.println("[3] Listar Todos os Itens");
            System.out.println("[4] Marcar Item como Concluído");
            System.out.println("[5] Sair");
            System.out.println("----------------------------------");
            System.out.print("Digite sua opção (1-5): ");
            escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    System.out.print("Descreva a nova meta: ");
                    gerenciador.adicionarItem("Meta", scanner.nextLine());
                    break;
                case "2":
                    System.out.print("Descreva o novo hábito: ");
                    gerenciador.adicionarItem("Hábito", scanner.nextLine());
                    break;
                case "3":
                    exibirLista();
                    break;
                case "4":
                    marcar();
                    break;
                case "5":
                    System.out.println("\n👋 Saindo do programa. Obrigado por usar o sistema.");
                    break;
                default:
                    System.out.println("\n❌ Opção inválida. Por favor, escolha um número de 1 a 5.");
            }
        } while (!escolha.equals("5"));
    }
}
