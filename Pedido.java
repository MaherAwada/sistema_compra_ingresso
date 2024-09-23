import java.util.ArrayList;
import java.util.List;

class Pedido {
    private List<Entrada> entradas;

    public Pedido() {
        entradas = new ArrayList<>();
    }

    public void adicionaEntrada(Entrada entrada) {
        entradas.add(entrada);
    }

    public double calculaValorTotal() {
        double valorTotal = 0.0;

        for (Entrada entrada : entradas) {
            valorTotal += entrada.calcularValor();
        }

        return valorTotal;
    }

    public void exibirValorTotal() {
        double valorTotal = calculaValorTotal();
        System.out.println("Valor total do carrinho: R$" + valorTotal);
    }
}