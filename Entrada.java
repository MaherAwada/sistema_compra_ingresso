public abstract class Entrada {
    private int numeroAssento;
    private Espetaculo espetaculo;

    public Entrada(int numeroAssento, Espetaculo espetaculo) {
        this.numeroAssento = numeroAssento;
        this.espetaculo = espetaculo;
    }

    public int getNumeroAssento() {
        return numeroAssento;
    }

    public Espetaculo getEspetaculo() {
        return espetaculo;
    }

    public abstract double calcularValor();
}