public class EntradaInteira extends Entrada {
    public EntradaInteira(int numeroAssento, Espetaculo espetaculo) {
        super(numeroAssento, espetaculo);
    }

    @Override
    public double calcularValor() {
        return getEspetaculo().getPrecoEntrada();
    }
}