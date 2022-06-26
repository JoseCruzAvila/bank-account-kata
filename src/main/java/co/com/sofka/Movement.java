package co.com.sofka;

import co.com.sofka.values.Ammount;
import co.com.sofka.values.MovementType;

public class Movement {
    private MovementDetails details;
    private MovementType type;

    public Movement(Ammount balance, Ammount ammount, MovementType type) {
        this.details = new MovementDetails(ammount, balance);
        this.type = type;
    }

    public Double specificAmmount() {
        return details.movementAmmount();
    }

    public Double globalAmmount() {
        return details.movementBalance();
    }

    public MovementDetails details() {
        return details;
    }

    public MovementType type() {
        return type;
    }
}
