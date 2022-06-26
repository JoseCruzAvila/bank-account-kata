package co.com.sofka;

import java.io.PrintStream;
import java.util.List;

import co.com.sofka.values.Ammount;
import co.com.sofka.values.Date;
import co.com.sofka.values.MovementType;

public class Account {
    private Statement statement;
    private Ammount balance;

    public Account(Statement statement) {
        this.statement = statement;
        this.balance = new Ammount();
    }

    void deposit(Ammount ammount, Date date) {
        this.balance = this.balance.addAmmount(ammount.value());
        this.statement.addTransaction(new Ammount(this.balance), ammount, MovementType.CREDIT, date);
    }
    
    void withdrawal(Ammount ammount, Date date){
        this.balance = this.balance.substractAmmount(ammount.value());
        this.statement.addTransaction(new Ammount(this.balance), ammount, MovementType.DEBIT, date);
    }

    void transfer(Ammount ammount, Account account, Date date) {
        withdrawal(ammount, date);
        account.deposit(ammount, date);
    }

    void printStatements(PrintStream out) {
        List<String> transactions = statement.listOfTransactions();
        final String SEPARATOR = "-----------------------------------------------";

        out.println(SEPARATOR);
        out.println("|    date    |  credit  |  debit  |  balance  |");
        out.println(SEPARATOR);
        transactions.stream()
                    .forEach(out::println);
        out.println(SEPARATOR);
    }
}
