public class EntradaProfessor extends Entrada {
    public EntradaProfessor(int numeroAssento, Espetaculo espetaculo) {
        super(numeroAssento, espetaculo);
    }

    @Override
    public double calcularValor() {
        return getEspetaculo().getPrecoEntrada() * 0.4;
    }
}