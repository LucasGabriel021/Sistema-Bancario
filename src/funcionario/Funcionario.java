package funcionario;

import conta.Conta;

public class Funcionario extends Thread {
    private String nome;
    private Conta contaSalario;
    private Conta contaInvestimentos;

    public Funcionario(String nome, int numConta, double salario, double investimento) {
        this.nome = nome;
        this.contaSalario = new Conta(numConta, salario);
        this.contaInvestimentos = new Conta(numConta, investimento);
    }

    public String getNome() {
        return nome;
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getContaInvestimentos() {
        return contaInvestimentos;
    }

    public void receberPagamento(double valor) {
        contaSalario.depositarValor(valor);
        realizarInvestimento();
    }

    public void realizarInvestimento() {
        double investimento = contaSalario.getSaldo() * 0.2; // Deve investir 20%.
        contaInvestimentos.depositarValor(investimento);
        System.out.println(String.format("Após o pagamento %s(%d) investiu um quantia de R$: %.2f na bolsa de valores.\n", this.nome, getId(), investimento));
    }

    @Override
    public void run() {
        realizarInvestimento();
    }
}
