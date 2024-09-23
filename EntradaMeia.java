public class EntradaMeia extends Entrada {
    public EntradaMeia(int numeroAssento, Espetaculo espetaculo) {
        super(numeroAssento, espetaculo);
    }

    @Override
    public double calcularValor() {
        return getEspetaculo().getPrecoEntrada() * 0.5;
    }
}