package co.com.sofka.values;

public class Ammount {
    private final double value;

    public Ammount() {
        this.value = 0;
    }
    
    public Ammount(Ammount ammount) {
        this.value = ammount.value();
    }

    private Ammount(double value) {
        this.value = value;
    }
    
    public static Ammount amountOf(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Your account can not be created with less than 0 of ammount");
        }

        return new Ammount(value);
    }

    public Ammount addAmmount(double newValue) {
        if (newValue < 0) {
            throw new IllegalArgumentException("The desposit must be greater than 0");
        }

        double total = value + newValue;

        return new Ammount(total);
    }

    public Ammount substractAmmount(double newValue) {
        double total = value - newValue;

        if (total < 0) {
            throw new IllegalArgumentException("You don’t have enough funds for this transaction");
        }

        return new Ammount(total);
    }

    public double value() {
        return value;
    }
}
