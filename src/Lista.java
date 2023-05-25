public class Lista {
    private final int tamanho;
    public Item[] vetor;

    public Lista(int tamanho) {
        this.tamanho = tamanho;
        this.vetor = new Item[tamanho];
    }

    public void insere(Item item) {
        int index = getHash(item.getNome());
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
        int soma = 0;
        char a = busca.charAt(0);
        char b = busca.charAt(1);
        char c = busca.charAt(2);
        int aAsc = (int) a * 2;
        int bAsc = (int) b * 3;
        int cAsc = (int) c * 4;
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

        if(soma>=tamanhoMax) soma /= 2;

        //para numeros
        if(soma>1000){
            return (int) Math.floor(soma / 100);
        }
        return soma;
    }
}