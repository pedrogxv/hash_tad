import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Lista lista = new Lista(20);

        Scanner scanner = new Scanner(System.in);

        //menu
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
            int resposta = scanner.nextInt();

            switch (resposta){
                case 1:
                    System.out.println("Nome do item:");
                    String nome = scanner.next();
                    System.out.println("Valor do item:");
                    int preco = scanner.nextInt();

                    lista.insere(new Item(nome,preco));

                    System.out.println("Item adicionado com sucesso!");
                    break;
                case 2:
                    System.out.println("Mostrando lista: ");
                    lista.mostrar();
                    break;
                case 3:
                    //buscar
                case 4:
                    //remover
                case 9:
                    System.out.println("Saindo! ");
                    break menu;

                default:
                    System.out.println("Pv liberado");
                    break;
            }
        }
    }
}