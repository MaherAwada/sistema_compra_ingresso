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
import java.util.Scanner;

public class Teatro {
    private List<Espetaculo> espetaculos;
    private List<Cliente> clientes;
    private Pedido carrinho;
    private Espetaculo espetaculoSelecionado;
    private Scanner scanner;

    public Teatro() {
        carrinho = new Pedido();
        espetaculos = new ArrayList<>();
        clientes = new ArrayList<>();
        scanner = new Scanner(System.in);

        Espetaculo espetaculo1 = new Espetaculo("Espetáculo 01", "15/05/2023", "19h30", 30.0);
        Espetaculo espetaculo2 = new Espetaculo("Espetáculo 02", "30/05/2023", "20h30", 50.0);
        Espetaculo espetaculo3 = new Espetaculo("Espetáculo 03", "02/06/2023", "21h30", 35.0);
        espetaculos.add(espetaculo1);
        espetaculos.add(espetaculo2);
        espetaculos.add(espetaculo3);
    }

    public void exibirMenu() {
        System.out.println("*** MACK THEATRE ***");
        System.out.println("1) Cadastrar Espetáculo");
        System.out.println("2) Cadastrar Cliente");
        System.out.println("3) Compra de Entradas");
        System.out.println("4) Sair");
        System.out.print("Selecione uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        while (opcao != 4) {
            switch (opcao) {
                case 1:
                    cadastrarEspetaculo();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    compraEntradas();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            System.out.println("\n");
            System.out.println("-----------------------------------------");
            System.out.println("*** MACK THEATRE ***");
            System.out.println("1) Cadastrar Espetáculo");
            System.out.println("2) Cadastrar Cliente");
            System.out.println("3) Compra de Entradas");
            System.out.println("4) Sair");
            System.out.print("Selecione uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Saindo do sistema...");
    }

    public void cadastrarEspetaculo() {
        System.out.println("*** CADASTRO DE ESPETÁCULO ***");
        System.out.print("Nome do Espetáculo: ");
        String nome = scanner.nextLine();
        System.out.print("Data: ");
        String data = scanner.nextLine();
        System.out.print("Hora: ");
        String hora = scanner.nextLine();
        System.out.print("Preço da Entrada Inteira: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        Espetaculo novoEspetaculo = new Espetaculo(nome, data, hora, preco);
        espetaculos.add(novoEspetaculo);

        System.out.println("\nEspetáculo cadastrado com sucesso!");
    }

    public void cadastrarCliente() {
        System.out.println("*** CADASTRO DE CLIENTE ***");
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Cliente novoCliente = new Cliente(nome, cpf);
        clientes.add(novoCliente);

        System.out.println("\nCliente cadastrado com sucesso!");
    }

    public void compraEntradas() {
        System.out.println("*** VENDA DE ENTRADAS - ESPETÁCULOS ***");
        exibirEspetaculos();

        System.out.print("Selecione um espetáculo: ");
        int numeroEspetaculo = scanner.nextInt();
        scanner.nextLine();

        if (numeroEspetaculo < 1 || numeroEspetaculo > espetaculos.size()) {
            System.out.println("Opção inválida. Retornando ao menu principal.");
            return;
        }

        espetaculoSelecionado = espetaculos.get(numeroEspetaculo - 1);
        System.out.println("\nEspetáculo selecionado: " + espetaculoSelecionado.toString());

        System.out.println("\n*** ASSENTOS DISPONÍVEIS ***");
        espetaculoSelecionado.apresentaAssentos();

        System.out.print("Selecione um assento: ");
        int numeroAssento = scanner.nextInt();
        scanner.nextLine();

        if (!espetaculoSelecionado.marcarAssento(numeroAssento)) {
            System.out.println("Assento inválido ou indisponível. Retornando ao menu principal.");
            return;
        }

        System.out.println("Assento selecionado: " + numeroAssento);

        System.out.println("\n*** TIPOS DE ENTRADA ***");
        System.out.println("1) Inteira");
        System.out.println("2) Meia        50% do valor da entrada");
        System.out.println("3) Professor   40% do valor da entrada");
        System.out.print("Selecione um tipo de entrada: ");
        int tipoEntrada = scanner.nextInt();
        scanner.nextLine();

        double precoEntrada = espetaculoSelecionado.getPrecoEntrada();
        double valorFinal = 0.0;

        if (tipoEntrada == 1) {
            carrinho.adicionaEntrada(new EntradaInteira(numeroAssento, espetaculoSelecionado));
            valorFinal = precoEntrada;
        } else if (tipoEntrada == 2) {
            carrinho.adicionaEntrada(new EntradaMeia(numeroAssento, espetaculoSelecionado));
            valorFinal = precoEntrada * 0.5;
        } else if (tipoEntrada == 3) {
            carrinho.adicionaEntrada(new EntradaProfessor(numeroAssento, espetaculoSelecionado));
            valorFinal = precoEntrada * 0.4;
        } else {
            System.out.println("Opção inválida. Retornando ao menu principal.");
            return;
        }

        System.out.println("Entrada adicionada ao carrinho.");

        System.out.print("\nDeseja comprar outra entrada (S/N)? ");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("S")) {
            compraEntradas();
        } else if (resposta.equalsIgnoreCase("N")) {
            System.out.println("");
            System.out.print("Digite o CPF do cliente: ");
            String cpfCliente = scanner.nextLine();

            Cliente cliente = null;
            for (Cliente c : clientes) {
                if (c.getCpf().equals(cpfCliente)) {
                    cliente = c;
                    break;
                }
            }

            if (cliente != null) {
                cliente.setCarrinho(carrinho);
                double valorTotalCarrinho = carrinho.calculaValorTotal();
                System.out.println("\nValor final do carrinho: R$" + valorTotalCarrinho);

                System.out.println("");
                System.out.println("Compra finalizada. Obrigado!");
                System.out.println("");
                System.out.println("-----------------------------------------");

            } else {
                System.out.println("Cliente não encontrado. Compra cancelada.");
            }
        } else {
            System.out.println("Opção inválida. Retornando ao menu principal.");
        }
    }

    public void exibirEspetaculos() {
        for (int i = 0; i < espetaculos.size(); i++) {
            Espetaculo espetaculo = espetaculos.get(i);
            System.out.println((i + 1) + ") " + espetaculo.toString());
        }
    }
}
