package Exercicios.Classes.BancoDeContas;

public class ContaEspecial extends ContaBancaria {
    private double limite;

    public ContaEspecial() {
        super();
        this.limite = 0;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return super.toString() + ", limite=" + limite;
    }

    @Override
    public void setRendaUsuario(double rendaUsuario) {
        super.setRendaUsuario(rendaUsuario);
        if (rendaUsuario > 10000) {
            this.limite = 1000;
        }
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("\nValor inválido para saque.");
            return false;
        }

        if (valor > (getSaldo() + limite)) {
            System.out.println("\nSaldo e limite insuficientes.");
            return false;
        }

        double novoSaldo = getSaldo() - valor;
        setSaldo(novoSaldo);
        return true;
    }


}
