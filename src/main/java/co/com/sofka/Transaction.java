package co.com.sofka;

import co.com.sofka.values.Ammount;
import co.com.sofka.values.Date;
import co.com.sofka.values.MovementType;

public class Transaction {
    private Movement movement;
    private Date date;

    public Transaction(Date date) {
        this.date = date;
    }

    public void generateMovement(Ammount balance, Ammount ammount, MovementType type) {
        this.movement = new Movement(balance, ammount, type);
    }

    public Movement movement() {
        return movement;
    }

    public Date date() {
        return date;
    }

    @Override
    public String toString() {
        if (movement.type().toString().equalsIgnoreCase("credit")) {
            return "| " + date.value() + " |  "
                    + movement.specificAmmount() +
                    "  |         |  " + movement.globalAmmount() + "   |";
        }

        return "| " + date.value() +
                " |          |  "
                + movement.specificAmmount() + "  |  "
                + movement.globalAmmount() + "   |";
    }
}
