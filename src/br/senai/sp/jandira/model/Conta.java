package br.senai.sp.jandira.model;

public class Conta {
    private String agencia = "1258-X";
    private int numeroConta = 549687;
    private double saldo = 6943.80;

    public void realizarDeposito(double valor){
        this.saldo += valor;
        System.out.println("O saldo disponivel na conta é: " + this.saldo);
    }
    public void realizarSaque(double valor){

        boolean validaSaque = avaliarSaque(valor);

        if (validaSaque){
            this.saldo -= valor;
        }else {
            System.out.println("Impossível realizar saque");
        }

        this.saldo -= valor;
        System.out.println("O saldo disponivel na conta é: " + this.saldo);
    }
    public void consultarSaldo(){
        System.out.println("O saldo disponivel na conta é: " + this.saldo);
    }
    public boolean avaliarSaque(double valor){
        if (this.saldo >= valor){
            return true;
        } else {
            return false;
        }
    }

}
