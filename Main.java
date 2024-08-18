public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Venilton");
        cliente1.setCpf("123.456.789-00");
        cliente1.setEndereco("Rua Exemplo, 123");
        cliente1.setTelefone("(11) 1234-5678");

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
