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