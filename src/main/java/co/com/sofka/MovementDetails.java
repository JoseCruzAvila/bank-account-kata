package co.com.sofka;

import co.com.sofka.values.Ammount;

public class MovementDetails {
    private Ammount ammount;
    private Ammount balance;

    public MovementDetails(Ammount ammount, Ammount balance) {
        this.ammount = ammount;
        this.balance = balance;
    }

    public Double movementAmmount() {
        return ammount.value();
    }

    public Double movementBalance() {
        return balance.value();
    }
}
