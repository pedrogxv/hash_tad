
public class Lista<T> {
    private final int tamanho;
    public Item[] vetor;

    public Lista(int tamanho) {
        this.tamanho = tamanho;
        this.vetor = new Item[tamanho];
    }

    public void insere(Item item) {
        int index = -1;

        switch (item.getIndex()) {
            //caso o atributo escolhido seja nome
            case "N" -> index = getHashString(item.getNome());

            //caso o atributo escolhido seja preco
            case "P" -> index = getHashFloat(item.getPreco());

            //caso o atributo escolhido seja quantidade
            case "Q" -> index = getHashInt(item.getQuantidade());
            default -> {
            }
        }

        this.vetor[index] = item;
    }

    //buscar
    public Item buscar(String busca, String atributo) {
        int index = 0;

        if (atributo.equals("Q")) {
            index = getHashInt(Integer.parseInt(busca));
        }
        if (atributo.equals("P")) {
            index = getHashFloat(Float.parseFloat(busca));
        }
        if (atributo.equals("N")) {
            index = getHashString(busca);
        }

        return this.vetor[index];
    }

    public boolean remover(String remover, String atributo) {
        int index = 0;
        boolean existe = true;


        if (atributo.equals("Q")) {
            index = getHashInt(Integer.parseInt(remover));
        }
        if (atributo.equals("P")) {
            index = getHashFloat(Float.parseFloat(remover));
        }
        if (atributo.equals("N")) {
            index = getHashString(remover);
        }

        if (this.vetor[index] == null) {
            existe = false;
            return existe;

        } else {
            existe = true;
            this.vetor[index] = null;
            return existe;
        }
    }

    //remover


    //mostrar
    public void mostrar() {
        System.out.print("[");
        for (int i = 0; i < this.tamanho; i++) {
            System.out.print(this.vetor[i]);
            System.out.print(", ");
        }
        System.out.print("] ");
    }

    //hash string
    public int getHashString(String busca) {
        int soma = 0, cAsc = 0, bAsc = 0;
        int lenght = busca.length();
        char a = busca.charAt(0);
        //transformando as strings em int (ascii)

        //caso busca seja <2
        if (lenght > 1) {
            char b = busca.charAt(1);
            bAsc = (int) b * 3;
        }
        //caso busca seja <3
        if (lenght > 2) {
            char c = busca.charAt(2);
            cAsc = (int) c * 4;
        }
        int aAsc = (int) a * 2;
        soma += aAsc + bAsc + cAsc;
        //multiplica ate o [3] da string (se tiver, se nao ate o 2, ou 1) por pesos.
        if (busca.length() > 3) {
            for (int i = 0; i < busca.length(); i++) {
                char letra = busca.charAt(i);
                soma += letra;
            }
        }

        //se for maior q o tamanho do vetor divide por 2
        int tamanhoMax = this.tamanho * 1000;

        if (soma >= tamanhoMax) soma /= 2;

        //para numeros
        return (int) Math.floor((double) soma / 100);
    }

    public int getHashInt(int numero) {
        int tamanhoTabela = this.tamanho;//tamanho do vetor
        double constante = 0.6180339887; // Exemplo de constante (número irracional)
        double produto = numero * constante;
        double parteFracionaria = produto - Math.floor(produto);

        return (int) (tamanhoTabela * parteFracionaria);
    }

    public int getHashFloat(float numero) {
        int tamanhoTabela = this.tamanho;//tamanho do vetor
        int bits = Float.floatToIntBits(numero);
        return bits % tamanhoTabela;
    }
}