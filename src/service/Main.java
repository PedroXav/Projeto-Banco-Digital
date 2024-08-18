package src.service;

import src.mode1.Cliente;
import src.mode1.conta.Conta;
import src.mode1.conta.ContaCorrente;
import src.mode1.conta.ContaPoupanca;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Jair");
        cliente1.setCpf("223-123-709-52");
        cliente1.setEndereco("Rua Gericó, 156");
        cliente1.setTelefone("(11) 99550-3543");

        Conta cc = new ContaCorrente(cliente1);
        Conta poupanca = new ContaPoupanca(cliente1);

        cc.depositar(1000);
        cc.transferir(250, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        
        System.out.println("Histórico de Transações Conta Corrente:");
        for (String transacao : cc.getTransacoes()) {
            System.out.println(transacao);
        }

        System.out.println("Histórico de Transações Conta Poupança:");
        for (String transacao : poupanca.getTransacoes()) {
            System.out.println(transacao);
        }
    }
}
