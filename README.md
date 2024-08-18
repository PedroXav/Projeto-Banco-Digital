# Projeto Bancário em Java

## Descrição

Este projeto é uma implementação de um sistema bancário simples em Java, desenvolvido com base nos conceitos de Programação Orientada a Objetos (POO). Ele inclui funcionalidades básicas como criação de contas correntes e poupança, depósitos, saques e transferências entre contas.

## Funcionalidades

- **Criação de Contas:** Suporta a criação de contas correntes e poupança.
- **Depósitos:** Permite depositar valores em qualquer conta.
- **Saques:** Permite sacar valores de qualquer conta.
- **Transferências:** Permite a transferência de valores entre contas.
- **Impressão de Extrato:** Exibe um extrato com as informações da conta.

## Estrutura do Projeto

O projeto está dividido em várias classes e interfaces que representam os diferentes elementos do sistema bancário:

- **Banco:** Representa o banco e gerencia as contas.
- **Cliente:** Representa um cliente do banco.
- **IConta:** Interface que define as operações que uma conta bancária deve implementar.
- **Conta:** Classe abstrata que implementa a interface `IConta` e define as operações comuns a todas as contas.
  - **ContaCorrente:** Classe que herda de `Conta` e representa uma conta corrente.
  - **ContaPoupanca:** Classe que herda de `Conta` e representa uma conta poupança.
- **Main:** Classe principal que contém o método `main` e executa o programa.
 
