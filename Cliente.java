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


public class Cliente {
    private String nome;
    private String cpf;
    private Pedido carrinho;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Pedido getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Pedido carrinho) {
        this.carrinho = carrinho;
    }
}