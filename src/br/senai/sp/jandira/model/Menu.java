package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Cliente cliente = new Cliente();
    Conta conta = new Conta();
    public void executarMenu(){

        boolean exit = false;

        while(!exit){

            System.out.println("Escolha a opção que deseja seguir: \n" +
                "1- Cadastar Cliente\n" +
                "2- Cadastrar Conta\n" +
                "3- Consultar Saldo\n" +
                "4- Realizar Deposito: R$\n" +
                "5- Realizar Saque: R$\n" +
                "6- Sair\n" +
                "Opcão:"
        );
            int optionUser = scanner.nextInt();
            scanner.nextLine();

            switch (optionUser){
                case 1:
                    cliente.cadastrarCliente();
                    break;
                case 2:
                    System.out.println("Feature in Development");
                    break;
                case 3:
                    conta.consultarSaldo();
                    break;
                case 4:
                    System.out.println("Informe o valor que deseja depositar: ");
                    double valorDepositado = scanner.nextDouble();
                    scanner.nextLine();
                    conta.realizarDeposito(valorDepositado);
                    break;
                case 5:
                    System.out.println("Informe o valor que deseja sacar: ");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine();
                    conta.realizarSaque(valorSaque);
                    break;
                case 6:
                    exit = true;
                    break;
            }
        }
    }
}
