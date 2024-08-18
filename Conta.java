import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    private List<String> transacoes;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo");
        }
        if (saldo < valor) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        saldo -= valor;
        registrarTransacao(String.format("Saque de R$%.2f", valor));
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo");
        }
        saldo += valor;
        registrarTransacao(String.format("Depósito de R$%.2f", valor));
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (contaDestino == null) {
            throw new IllegalArgumentException("Conta de destino inválida");
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
        registrarTransacao(String.format("Transferência de R$%.2f para conta %d", valor, ((Conta) contaDestino).getNumero()));
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<String> getTransacoes() {
        return transacoes;
    }

    protected void registrarTransacao(String descricao) {
        transacoes.add(descricao);
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
