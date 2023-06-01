public class Hash {
    public static int fromString(String busca, int tamanhoVetor) {
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
        //multiplica até o [3] da string (se tiver, se nao ate o 2, ou 1) por pesos.
        if (busca.length() > 3) {
            for (int i = 0; i < busca.length(); i++) {
                char letra = busca.charAt(i);
                soma += letra;
            }
        }

        // se for maior que o tamanho do vetor divide por 2
        int tamanhoMax = tamanhoVetor * 1000;
        if (soma >= tamanhoMax) soma /=  2;

        // para números
        return (int) Math.floor((double) soma / 100);
    }

    public static int fromInt(int numero, int tamanhoVetor) {
        int tamanhoTabela = tamanhoVetor;//tamanho do vetor
        double constante = 0.6180339887; // Exemplo de constante (número irracional)
        double produto = numero * constante;
        double parteFracionaria = produto - Math.floor(produto);

        return (int) (tamanhoTabela * parteFracionaria);
    }

    public static int fromFloat(float numero, int tamanhoVetor) {
        int tamanhoTabela = tamanhoVetor; //tamanho do vetor
        int bits = Float.floatToIntBits(numero);
        return bits % tamanhoTabela;
    }
}
