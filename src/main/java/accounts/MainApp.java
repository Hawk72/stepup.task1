package accounts;

public class MainApp {
    public static void main(String[] args) throws NothingToUndo {
        System.out.println("Welcome in my task1! :)");
        System.out.println("-------------------");
        Account acc=new Account("Иван Петров");
        acc.setWallet(Currency.RUB,100);
        //acc.setWallet(Currency.EUR,50);
        System.out.println(acc);
        acc.printWallet();
        System.out.println("---------bfr undo--------");
        acc.setClientName("Василий Иванов");
        acc.setWallet(Currency.RUB,300);
        acc.setWallet(Currency.USD,55);
        System.out.println(acc);
        acc.printWallet();
        System.out.println("---------aft undo--------");
        acc.undo();
        acc.undo();
        acc.undo();
        acc.undo();
        System.out.println(acc);
        acc.printWallet();
        System.out.println("---------bfr snapshot--------");
        acc.setWallet(Currency.RUB,150);
        acc.setWallet(Currency.USD,66);
        System.out.println(acc);
        acc.printWallet();
        Loadable qs= acc.save();
        System.out.println("---------replace data--------");
        acc.setClientName("Инокентий Пупкин");
        acc.setWallet(Currency.RUB,222);
        acc.setWallet(Currency.USD,77);
        System.out.println(acc);
        acc.printWallet();
        System.out.println("---------load snapshot--------");
        qs.load();
        System.out.println(acc);
        acc.printWallet();
    }
}
