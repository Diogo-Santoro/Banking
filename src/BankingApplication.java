import java.util.Scanner;

public class BankingApplication {
    public static void main (String[] args){

        BankAccount obj1 = new BankAccount("ABC", "AA0000");
        obj1.showMenu();
    }
}


class BankAccount
{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String custname, String custid)
    {
        customerName = custname;
        customerId = custid;
    }

    void deposit (int amount)
    {
        if(amount > 0)
        {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }
    void withdraw( int amount)
    {
        if(amount > 0)
        {
            balance = balance - amount;
            previousTransaction = -amount;
        }

    }
    void getPreviousTransaction()
    {
        if(previousTransaction > 0)
        {
            System.out.println("Depositado: "+previousTransaction);
        }
        else if (previousTransaction < 0)
        {
            System.out.println("Retirado: "+Math.abs(previousTransaction));
        }
        else
        {
            System.out.println("Nenhuma transação ocorreu");
        }
    }
    void showMenu()
    {
        char option = '\0';
        Scanner scanner = new Scanner (System.in);

        System.out.println("Bem Vindo "+customerName);
        System.out.println("Seu ID é "+ customerId);
        System.out.println("\n");
        System.out.println("A. Checar saldo");
        System.out.println("B. Depósito");
        System.out.println("C. Retirar");
        System.out.println("D. Transação anterior");
        System.out.println("E. Sair");

        do {
            System.out.println("==========================================================================================================================================================================");
            System.out.println("Insira uma opção");
            System.out.println("==========================================================================================================================================================================");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("------------------------------------------");
                    System.out.println("Saldo = " + balance);
                    System.out.println("------------------------------------------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("------------------------------------------");
                    System.out.println("Insira uma quantia para depositar:");
                    System.out.println("------------------------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("------------------------------------------");
                    System.out.println("Insira uma quantia para retirar");
                    System.out.println("------------------------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("------------------------------------------");
                    break;
                case 'E':
                    System.out.println("******************************************");
                    break;

                default:
                    System.out.println("Opção invalida, por favor tente novamente");
                    break;
            }
        }while(option != 'E');
        System.out.println("Obrigado por usar nosso serviço");
        }
    }




