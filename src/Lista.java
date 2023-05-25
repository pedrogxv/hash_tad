
public class Lista {
    private final int tamanho;
    public Item[] vetor;

    public Lista(int tamanho) {
        this.tamanho = tamanho;
        this.vetor = new Item[tamanho];
    }

    public void insere(Item item) {
        String finder = null;
        switch (item.getIndex()) {
            //caso o atributo escolhido seja nome
            case "N":
                finder = item.getNome();
                break;
            //caso o atributo escolhido seja preco
            case "P":
                finder = Float.toString(item.getPreco());
                break;
            //caso o atributo escolhido seja quantidade
            case "Q":
                finder = Integer.toString(item.getQuantidade());
                break;

            default:
                break;
        }

        int index = getHash(finder);

        this.vetor[index] = item;
    }

    public Item buscar(String busca) {
        return this.vetor[getHash(busca)];
    }

    public void remover(String nome) {
        this.vetor[getHash(nome)] = null;
    }

    public void mostrar() {
        System.out.print("[");
        for (int i = 0; i < this.tamanho; i++) {
            System.out.print(this.vetor[i]);
            System.out.print(", ");
        }
        System.out.print("] ");
    }

    public int getHash(String busca) {
        int soma = 0, cAsc = 0, bAsc = 0;
        int lenght = busca.length();
        char a = busca.charAt(0);
        if (lenght > 1) {
            char b = busca.charAt(1);
            bAsc = (int) b * 3;
        }
        if (lenght > 2) {
            char c = busca.charAt(2);
            cAsc = (int) c * 4;
        }
        int aAsc = (int) a * 2;
        soma += aAsc + bAsc + cAsc;
        if (busca.length() > 3) {
            for (int i = 0; i < busca.length(); i++) {
                char letra = busca.charAt(i);
                int hashNum = (int) letra;
                soma += hashNum;
            }
        }
        //se for maior q o tamanho do vetor divide por 2
        int tamanhoMax = 30000;

        if (soma >= tamanhoMax) soma /= 2;

        //para numeros
        return (int) Math.floor(soma / 100);

    }
}