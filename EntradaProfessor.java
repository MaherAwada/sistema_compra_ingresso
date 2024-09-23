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

public class EntradaProfessor extends Entrada {
    public EntradaProfessor(int numeroAssento, Espetaculo espetaculo) {
        super(numeroAssento, espetaculo);
    }

    @Override
    public double calcularValor() {
        return getEspetaculo().getPrecoEntrada() * 0.4;
    }
}