import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Lista lista = new Lista(30);

        Scanner scanner = new Scanner(System.in);

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
                    System.out.println("Gostaria de armezanenar esse item por qual atributo? ");
                    System.out.println("N - Nome \nQ - Quantidade \nP - Preço ");
                    String index = scanner.next();

                    lista.insere(new Item(quantidade, nome, preco, index));

                    System.out.println("Item adicionado com sucesso!");
                    break;
                case 2:
                    System.out.println("Mostrando lista: ");
                    lista.mostrar();
                    break;
                // BUSCA
                case 3:
                    System.out.println("Com qual atributo o item foi cadastrado?");
                    System.out.println("N - Nome \nQ - Quantidade \nP - Preço ");
                    String atributo = scanner.next();

                    System.out.println("Qual o valor desse atributo no item que voce quer buscar?");

                    String busca = scanner.next();
                    Item itemEncontrado = lista.buscar(busca);

                    // perdoai-me pelo if-else 🙏
                    if (itemEncontrado != null) {
                        System.out.println("Esse item está na posicão:" + lista.getHash(busca));
                        System.out.println("Encontramos este item:" + itemEncontrado);
                    } else {
                        System.out.println("Item não encontrado :(");
                    }

                    break;
                case 4:
                    System.out.println("Nome do item que voce quer remover:");
                    String nomeParaRemover = scanner.next();
                    lista.remover(nomeParaRemover);
                    System.out.println("Item removido com sucesso!");
                    break;
                case 9:
                    System.out.println("Saindo!");
                    break menu;

                default:
                    System.out.println("Pv liberado");
                    break;
            }
        }
    }
}