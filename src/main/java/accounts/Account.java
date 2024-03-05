package accounts;

import java.math.BigDecimal;
import java.util.HashMap;

abstract class Account {

    private String clientName;
    private int number;
    private Currency currency;
    private HashMap<Currency, Integer> wallet;

    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public HashMap<Currency, Integer> getWallet() {
        return wallet;
    }

    public Account(String clientName) {
        this.setClientName(clientName);
    }
}

//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("Account{");
//        sb.append("accountNum='").append(this.accountNum).append('\'');
//        sb.append(", balance=").append(balance);
//        sb.append(", commission=").append(commission);
//        sb.append(", currency=").append(currency);
//        sb.append('}');
//        return sb.toString();
//    }
}
