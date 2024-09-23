import java.util.Arrays;

public class Espetaculo {
    private String nome;
    private String data;
    private String hora;
    private double precoEntrada;
    private boolean[][] assentos;

    public Espetaculo(String nome, String data, String hora, double precoEntrada) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.precoEntrada = precoEntrada;
        this.assentos = new boolean[5][10];
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public double getPrecoEntrada() {
        return precoEntrada;
    }

    public boolean[][] getAssentos() {
        return assentos;
    }

   public void apresentaAssentos() {
    System.out.println("Assentos disponíveis:");
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 10; j++) {
            int numeroAssento = i * 10 + j + 1;
            if (!assentos[i][j]) {
                System.out.print(String.format("%02d ", numeroAssento));
            } else {
                System.out.print("XX ");
            }
        }
        System.out.println();
    }
}


    public boolean marcarAssento(int numeroAssento) {
        if (numeroAssento < 1 || numeroAssento > 50) {
            return false;
        }

        int linha = (numeroAssento - 1) / 10;
        int coluna = (numeroAssento - 1) % 10;

        if (assentos[linha][coluna]) {
            return false;
        }

        assentos[linha][coluna] = true;
        return true;
    }

    public String getValorFormatado() {
        return "R$ " + String.format("%.2f", precoEntrada);
    }

    @Override
    public String toString() {
        return nome + " - Data: " + data + " - Hora: " + hora + " - Preço: " + getValorFormatado();
    }
}