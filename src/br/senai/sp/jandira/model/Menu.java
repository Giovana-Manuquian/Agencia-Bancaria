package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Cliente referenciaCliente = new Cliente();
    Conta referenciaConta = new Conta();
    public void executarMenu(){

        boolean exit = false;

        while(!exit){

            System.out.println("Escolha a opção que deseja seguir: \n" +
                "1- Cadastar Cliente\n" +
                "2- Gerar Conta\n" +
                "3- Consultar Saldo\n" +
                "4- Realizar Deposito: R$\n" +
                "5- Realizar Saque: R$\n" +
                "6- Realizar Transferência: R$\n" +
                "7- Sair\n" +
                "Opcão:"
        );
            int optionUser = scanner.nextInt();
            scanner.nextLine();

            switch (optionUser){
                case 1:
                    Cliente cliente = new Cliente();
                    cliente.cadastrarCliente();
                    referenciaCliente.adicionarCliente(cliente);
                    break;
                case 2:
                    System.out.println("Informe o CPF do titular: ");
                    long cpfTitular = scanner.nextLong();
                    scanner.nextLine();

                    Cliente clienteConta = referenciaCliente.pesquisarCliente(cpfTitular);

                    if (clienteConta != null){
                        Conta conta = new Conta();
                        conta.gerarConta(clienteConta);
                        referenciaConta.adicionarConta(conta);
                        System.out.println("Conta criada com sucesso!");
                    } else {
                        System.out.println("O cliente não tem cadastro!");
                    }
                    break;
                case 3:
                    System.out.println("Informe o CPF do titular: ");
                    long cpfSaldo = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaSaldo = referenciaConta.pesquisarConta(cpfSaldo);

                    if (contaSaldo != null){
                        contaSaldo.consultarSaldo();
                    }else{
                        System.out.println("O cliente não tem conta cadastrada!");
                    }
                    break;
                case 4:
                    System.out.println("Informe o CPF do titular: ");
                    long cpfDeposito = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaDeposito = referenciaConta.pesquisarConta(cpfDeposito);

                    if (contaDeposito != null){
                        System.out.println("Informe o valor do deposito: ");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();

                        contaDeposito.realizarDeposito(valorDeposito);
                    }else{
                        System.out.println("O cliente não tem conta cadastrada!");
                    }
                    break;
                case 5:
                    System.out.println("Informe o CPF do titular: ");
                    long cpfSaque = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaSaque = referenciaConta.pesquisarConta(cpfSaque);

                    if (contaSaque != null){
                        System.out.println("Informe o valor para o saque: ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine();

                        contaSaque.realizarSaque(valorSaque);
                    }else{
                        System.out.println("O cliente não tem conta cadastrada!");
                    }
                    break;
                case 6:
                    System.out.println("Informe o CPF do titular: ");
                    long cpfUser = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Informe o CPF do destinatario: ");
                    long cpfDestinatario = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaUser = referenciaConta.pesquisarConta(cpfUser);
                    Conta contaDestinatario = referenciaConta.pesquisarConta(cpfDestinatario);

                    if (contaUser  != null && contaDestinatario != null ){
                        referenciaConta.realizarTransferencia(contaUser, contaDestinatario);

                    }else {
                        System.out.println("Por favor verifique as informações digitadas");
                    }
                    break;
                case 7:
                    exit = true;
                    break;
            }
        }
    }
}
