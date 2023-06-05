
public class Lista {
    public final int tamanho;
    public Item[] vetor;

    public Lista(int tamanho) {
        this.tamanho = tamanho;
        this.vetor = new Item[tamanho];
    }

    public void insere(Item item) {
        int index = -1;

        switch (item.getIndex()) {
            //caso o atributo escolhido seja nome
            case "N" -> index = Hash.fromString(item.getNome(), tamanho);

            //caso o atributo escolhido seja preco
            case "P" -> index = Hash.fromFloat(item.getPreco(), tamanho);

            //caso o atributo escolhido seja quantidade
            case "Q" -> index = Hash.fromInt(item.getQuantidade(), tamanho);
            default -> {
            }
        }

        this.vetor[index] = item;
    }

    //buscar
    public Item buscar(String busca, String atributo) {
        int index = 0;

        if (atributo.equals("Q")) {
            index = Hash.fromInt(Integer.parseInt(busca), tamanho);
        }
        if (atributo.equals("P")) {
            index = Hash.fromFloat(Float.parseFloat(busca), tamanho);
        }
        if (atributo.equals("N")) {
            index = Hash.fromString(busca, tamanho);
        }

        return this.vetor[index];
    }
    //remover
    public boolean remover(String remover, String atributo) {
        int index = 0;
        boolean existe = true;


        if (atributo.equals("Q")) {
            index = Hash.fromInt(Integer.parseInt(remover), tamanho);
        }
        if (atributo.equals("P")) {
            index = Hash.fromFloat(Float.parseFloat(remover), tamanho);
        }
        if (atributo.equals("N")) {
            index = Hash.fromString(remover, tamanho);
        }

        if (this.vetor[index] == null) {
            System.out.println("Este elemento não existe, nao pode ser removido.");
            existe = false;
            return existe;
        } else {
            this.vetor[index] = null;
            return existe;
        }
    }

    //mostrar
    public void mostrar() {
        System.out.print("[");
        for (int i = 0; i < this.tamanho; i++) {
            System.out.print(this.vetor[i]);
            System.out.print(", ");
        }
        System.out.print("] ");
    }
}