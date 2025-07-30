
import Exercicios.Classes.BancoDeContas.ContaEspecial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ContaEspecial conta = new ContaEspecial();

        // Criando a conta
        System.out.print("Nome completo: ");
        conta.setNomeUsuario(input.nextLine());

        System.out.print("Renda mensal: ");
        double renda = input.nextDouble();
        conta.setRendaUsuario(renda);

        input.nextLine();
        System.out.print("Crie uma senha: ");
        conta.setSenha(input.nextLine());

        System.out.println("\nConta criada com sucesso! Número: " + conta.getNumConta());

        // Menu de ações
        int opcao = -1;
        while (opcao != 5) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Alterar senha");
            System.out.println("4. Consultar saldo");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            input.nextLine(); // limpa buffer

            switch (opcao) {
                case 1:
                    System.out.print("Valor para depósito: R$ ");
                    double valorDep = input.nextDouble();
                    if (conta.depositar(valorDep)) {
                        System.out.println("Depósito realizado com sucesso.");
                    }
                    break;

                case 2:
                    System.out.print("Valor para saque: R$ ");
                    double valorSaque = input.nextDouble();
                    if (conta.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso.");
                    }
                    break;

                case 3:
                    System.out.print("Digite a senha atual: ");
                    String senhaAtual = input.nextLine();

                    if (senhaAtual.equals(conta.getSenha())) {
                        System.out.print("Nova senha: ");
                        String novaSenha = input.nextLine();
                        conta.setSenha(novaSenha);
                        System.out.println("Senha atualizada com sucesso.");
                    } else {
                        System.out.println("Senha incorreta.");
                    }
                    break;

                case 4:
                    System.out.println("Saldo disponível: R$ " + conta.getSaldo());
                    System.out.println("Limite disponível: R$ " + conta.getLimite());
                    break;

                case 5:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        input.close();
    }
}
