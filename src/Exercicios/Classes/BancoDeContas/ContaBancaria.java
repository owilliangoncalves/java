package Exercicios.Classes.BancoDeContas;

import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {
    private static List<Long> contasCriadas = new ArrayList<>();
    private String nomeUsuario;
    private double rendaUsuario;
    private double saldo;
    private long numConta;
    private String senha;

    public ContaBancaria() {
        this.nomeUsuario = "";
        this.rendaUsuario = 0;
        this.saldo = 0;
        this.numConta = gerarNumeroContaUnico();
    }

    private long gerarNumeroContaUnico() {
        long numero;
        do {
            numero = (long) (Math.random() * 1_000_000L);
        } while (contasCriadas.contains(numero));

        contasCriadas.add(numero);
        return numero;
    }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito.");
            return false;
        }
        this.saldo += valor;
        return true;
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
            return false;
        }

        if (valor > this.saldo) {
            System.out.println("Saldo insuficiente.");
            return false;
        }
        this.saldo -= valor;
        return true;
    }

    // Setters
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setRendaUsuario(double rendaUsuario) {
        this.rendaUsuario = rendaUsuario;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Getters
    public String getNomeUsuario() {
        return nomeUsuario;
    }


    public double getSaldo() {
        return saldo;
    }

    public long getNumConta() {
        return numConta;
    }

    public String getSenha() {
        return senha;
    }



    @Override
    public String toString() {
        return "ContaBancaria{" +
                "nomeUsuario='" + nomeUsuario + '\'' +
                ", rendaUsuario='" + rendaUsuario + '\'' +
                ", saldo=" + saldo +
                ", numConta=" + numConta +
                '}';
    }
}
