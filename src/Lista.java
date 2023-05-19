public class Lista {
    private int tamanho;
    public Item[] vetor;

    public Lista(int tamanho) {
        this.tamanho = tamanho;
        this.vetor = new Item[tamanho];
    }

    public void insere(Item item) {
        int index = getHash(item.getNome());
        this.vetor[index] = item;
    }

    public Item buscar(String nome) {
        return this.vetor[getHash(nome)];
    }

    public void remover(Item item) {
        // @TODO inserir
    }

    public void mostrar() {
        System.out.print("[");
        for (int i = 0; i < this.tamanho; i++) {
            System.out.print(this.vetor[i]);
            System.out.print(", ");
        }
        System.out.print("] ");
    }

    public int getHash(String nome) {
        int soma = 0;
        char a = nome.charAt(0);
        char b = nome.charAt(1);
        char c = nome.charAt(2);
        int aAsc = (int) a * 2;
        int bAsc = (int) b * 3;
        int cAsc = (int) c * 4;
        soma += aAsc + bAsc + cAsc;
        if (nome.length() > 3) {
            for (int i = 0; i < nome.length(); i++) {
                char letra = nome.charAt(i);
                int hashNum = (int) letra;
                soma += hashNum;
            }
        }
        int index = (int) Math.floor(soma / 100);
        return index;
    }
}