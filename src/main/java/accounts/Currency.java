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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Currency{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
