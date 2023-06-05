import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("# Escreva o tamanho do vetor: ");
        Lista lista = new Lista(scanner.nextInt());

        // menu
        menu:
        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("Lista de Compras");
            System.out.println("--------------------------------------------------");
            System.out.println("1 - Adicionar um item");
            System.out.println("2 - Mostrar todos os itens");
            System.out.println("3 - Buscar item");
            System.out.println("4 - Remover item");
            System.out.println("9 - Sair");
            System.out.println("--------------------------------------------------");

            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Nome do item:");
                    String nome = scanner.next();
                    System.out.println("Valor do item:");
                    float preco = scanner.nextFloat();
                    System.out.println("Quantidade do item:");
                    int quantidade = scanner.nextInt();
                    System.out.println("# Gostaria de armezanenar esse item por qual atributo? ");
                    System.out.println("N - Nome \nQ - Quantidade \nP - Preço ");
                    String index = scanner.next();

                    lista.insere(new Item(quantidade, nome, preco, index));

                    System.out.println("[✅] Item adicionado com sucesso!");
                    break;
                case 2:
                    System.out.println("... Mostrando lista: ");
                    lista.mostrar();
                    break;
                // BUSCA
                case 3:
                    System.out.println("Com qual atributo o item foi cadastrado?");
                    System.out.println("N - Nome \nQ - Quantidade \nP - Preço ");
                    String atributo = scanner.next();

                    System.out.println("Qual o valor desse atributo no item que voce quer buscar?");

                    String busca = scanner.next();
                    Item itemEncontrado = lista.buscar(busca, atributo);

                    // perdoai-me pelo if-else 🙏
                    if (itemEncontrado != null) {
                        System.out.println("=> Esse item está na posicão:" + Hash.fromString(busca, lista.tamanho));
                        System.out.println("[✅] Encontramos este item:" + itemEncontrado);
                    } else {
                        System.out.println("[!] Item não encontrado!");
                    }

                    break;
                // REMOVER
                case 4:
                    System.out.println("# Com qual atributo o item que deseja remover foi cadastrado?");
                    System.out.println("N - Nome \nQ - Quantidade \nP - Preço ");
                    String atributoo = scanner.next();

                    System.out.println("# Atributo do item que voce quer remover:");
                    String nomeParaRemover = scanner.next();

                    if (lista.remover(nomeParaRemover, atributoo)) {
                        System.out.println("[✅] Item removido com sucesso!");
                    } else {
                        System.out.println("[!] Item não encontrado para remoção!");
                    }
                    break;
                case 9:
                    System.out.println("[✅] Sessão Encerrada!");
                    break menu;

                default:
                    System.out.println("[!] Opção Inválida!");
                    break;
            }

        }
    }
}