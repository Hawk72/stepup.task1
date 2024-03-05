package accounts;

import org.junit.jupiter.api.Assertions;

class AccountTest {

    @org.junit.jupiter.api.Test
     void getClientName() {
        String name="Vasya";
        Account acc=new Account(name);
        if(acc.getClientName().isEmpty()||!acc.getClientName().equals(name))
            throw new RuntimeException("test getClientName error");
    }

    @org.junit.jupiter.api.Test
    void setClientName() {
        try{
            Account acc=new Account("Vasya");
            acc.setClientName("");
        } catch (IllegalArgumentException e){
            return;
        }
        throw new RuntimeException("test setClientName error");
    }

    @org.junit.jupiter.api.Test
    void getWallet() {
    }

    @org.junit.jupiter.api.Test
    void setWallet() {
        Account acc=new Account("Vasya");
        Currency currencyR=Currency.RUB;
        int num=666;
        acc.setWallet(currencyR,num);
        if(acc.getWallet().get(currencyR) != num)
            throw new RuntimeException("test setWallet new currency error");
        Currency currencyD=Currency.USD;
        num=777;
        acc.setWallet(currencyD,num);
        if(acc.getWallet().get(currencyD) != num)
            throw new RuntimeException("test setWallet add currency error");
        num=888;
        acc.setWallet(currencyD,num);
        if(acc.getWallet().get(currencyD) != num)
            throw new RuntimeException("test setWallet replace currency error");
        try {
            acc.setWallet(Currency.RUB, -666);
        } catch (IllegalArgumentException e){
            return;
        }
        throw new RuntimeException("test setWalletNegative error");
    }
    @org.junit.jupiter.api.Test
    void undo() throws NothingToUndo {
        Account acc=new Account("Иван Петров");
        String oldName= acc.getClientName();
        acc.setClientName("Василий Иванов");
        acc.undo();
        Assertions.assertEquals(oldName,acc.getClientName());
    }
    @org.junit.jupiter.api.Test
    void save(){
        String name="Иван Петров";
        int num=333;
        Account acc=new Account(name);
        acc.setWallet(Currency.RUB,num);
        Loadable qs= acc.save();
        acc.setClientName("Василий Иванов");
        acc.setWallet(Currency.RUB,555);
        qs.load();
        Assertions.assertEquals(name,acc.getClientName());
        if(acc.getWallet().get(Currency.RUB) != num)
            throw new RuntimeException("test save() broken");
    }
}