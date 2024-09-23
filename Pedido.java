/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author gabri
 *  Gabriel Rezende Rangel Santana- 32220596
    Maher Ahmad Awada - 32253958
    Sofia Maria Marques Gonçalves 32248921
 */




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