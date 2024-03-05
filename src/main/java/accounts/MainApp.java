package accounts;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Welcome in my task1! :)");
        System.out.println("-------------------");
        Account acc=new Account("Pete");
        acc.setWallet(Currency.RUB,100);
        acc.setWallet(Currency.EUR,50);
        System.out.println(acc);
        acc.printWallet();
    }
}
