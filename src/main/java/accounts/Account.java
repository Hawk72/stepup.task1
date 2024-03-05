package accounts;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Account {

    private String clientName;
    private int number;
    private Currency currency;
    private HashMap<Currency, Integer> wallet;
    private Deque<Command> commands=new ArrayDeque<>();

    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        if(clientName==null||clientName.isEmpty()) throw new IllegalArgumentException("пустой clientName");
        String undoClientName=this.clientName;
        this.commands.push(()->{this.clientName=undoClientName;});  //команда для отката clientName
        this.clientName = clientName;
    }

    public HashMap<Currency, Integer> getWallet() {
        return new HashMap<Currency,Integer>(this.wallet);
    }

    public void setWallet(Currency currency, int number) {
        if(number<0) throw new IllegalArgumentException("количество не может быть отрицательным");
        //откат валета
        if(wallet.containsKey(currency)){
            //если есть такой ключ, то откатываем само значение
            int undoNumber=this.wallet.get(currency);   //текущее значение
            //System.out.println(undoNumber);
            this.commands.push(()->{this.wallet.put(currency,undoNumber);});
        } else{
            //иначе - завели новый ключ - убиваем всю пару
            this.commands.push(()->{this.wallet.remove(currency);});
        }
        this.wallet.put(currency,number);
    }

    public Account(String clientName) {
        this.setClientName(clientName);
        this.wallet=new HashMap<>();
    }

    private Account() {
    }

    public Account undo() throws NothingToUndo {
        if(commands.isEmpty()) throw new NothingToUndo("буффер отката пуст");
        commands.pop().perform();
        return this;
    }

    //--------------вывод на экран-------------------

    @Override
    public String toString() {
        return "clientName = " + clientName;
    }

    public void printWallet(){
        //хочу выводить пару валюта - число
        for(Currency cur : this.wallet.keySet()){
            System.out.println(cur.toString()+" : "+this.wallet.get(cur).toString());
        }
        //this.wallet.values().stream().forEach(System.out::println);   //прикольно, на память
    }

}
