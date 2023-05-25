public class Item {
    public int getQuantidade() {
        return quantidade;
    }

    private final int quantidade;
    private final String nome;
    private final float preco;

    public String getIndex() {
        return index;
    }

    private final String index;

    public Item(int quantidade, String nome, float preco, String index) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.preco = preco;
        this.index = index;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }


    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
