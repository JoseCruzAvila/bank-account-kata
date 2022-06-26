package co.com.sofka;

import java.util.*;
import java.util.stream.Collectors;

import co.com.sofka.values.Ammount;
import co.com.sofka.values.Date;
import co.com.sofka.values.MovementType;


public class Statement {
    private Set<Transaction> transactions;
    
    public Statement() {
        this.transactions = new HashSet<>();
    }

    public void addTransaction(Ammount balance, Ammount ammount, MovementType type, Date date) {
        Transaction transaction = new Transaction(date);
        transaction.generateMovement(balance, ammount, type);

        this.transactions.add(transaction);
    }

    public List<String> listOfTransactions() {
        return transactions.stream()
                           .map(Transaction::toString)
                           .collect(Collectors.toList());
    }
}
