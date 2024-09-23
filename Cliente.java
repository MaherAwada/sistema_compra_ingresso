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