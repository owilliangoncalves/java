package Desafios.Classes.Desafio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {
    private List<Produto> produtos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void executarSistema() {
        int opcao;
        do {
            System.out.println("\n=== Sistema de Estoque ===");
            System.out.println("1. Cadastrar novo produto");
            System.out.println("2. Adicionar ao estoque");
            System.out.println("3. Vender produto");
            System.out.println("4. Listar produtos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarProduto();
                case 2 -> adicionarEstoque();
                case 3 -> venderProduto();
                case 4 -> listarProdutos();
                case 5 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 5);
    }

    private void cadastrarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade inicial: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        Produto novo = new Produto(nome, preco, quantidade);
        produtos.add(novo);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private void adicionarEstoque() {
        Produto produto = buscarProdutoPorNome();
        if (produto == null) return;

        System.out.print("Quantidade a adicionar: ");
        int qtd = scanner.nextInt();
        scanner.nextLine();

        try {
            produto.adicionarEstoque(qtd);
            System.out.println("Estoque atualizado.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void venderProduto() {
        Produto produto = buscarProdutoPorNome();
        if (produto == null) return;

        System.out.print("Quantidade a vender: ");
        int qtd = scanner.nextInt();
        scanner.nextLine();

        if (produto.vender(qtd)) {
            System.out.println("Venda realizada!");
        } else {
            System.out.println("Estoque insuficiente.");
        }
    }

    private void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto p : produtos) {
                p.exibirInfo();
            }
        }
    }

    private Produto buscarProdutoPorNome() {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }

        System.out.println("Produto não encontrado.");
        return null;
    }
}
