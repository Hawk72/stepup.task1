package accounts;

public enum Currency {
    USD("доллар США"),
    EUR("евро"),
    JOY("Йена"),
    TRY("Лира"),
    AED("Дирхам"),
    RUB("Рубль");

    private String name;

    Currency(String name) {
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return "Currency{" +
//                "name='" + name + '\'' + this
//                '}';
//    }
}
