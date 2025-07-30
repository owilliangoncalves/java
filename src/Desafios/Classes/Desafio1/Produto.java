package Desafios.Classes.Desafio1;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public boolean vender(int qtd) {
        if (this.quantidade >= qtd) {
            this.quantidade -= qtd;
            return true;
        }
        return false;
    }

    public void adicionarEstoque(int qtd) {
        if (qtd > 0) {
            this.quantidade += qtd;
        } else {
            throw new IllegalArgumentException("Quantidade precisa ser maior que zero.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void exibirInfo() {
        System.out.printf("Produto: %s | Preço: R$ %.2f | Estoque: %d\n",
                nome, preco, quantidade);
    }
}
