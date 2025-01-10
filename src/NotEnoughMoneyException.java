
public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}


class Account {
    private String owner;
    private int balance;
    private String accountNumber;

    public Account(String owner, int balance, String accountNumber) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Metoda symulująca przelew
    public void transfer(int amount) throws NotEnoughMoneyException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Transfer successful. Transferred: " + amount + " PLN");
        } else {
            throw new NotEnoughMoneyException("Not enough funds in the account for transfer: " + amount + " PLN");
        }
    }
}


class Main {
    public static void main(String[] args) {
        Account account1 = new Account("Jan Kowalski", 100, "12345");
        System.out.println("Initial balance: " + account1.getBalance() + " PLN");

        try {
            // Próba wykonania przelewu z większą kwotą niż dostępne środki
            account1.transfer(150);
        } catch (NotEnoughMoneyException e) {
            System.out.println("Custom exception caught: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An unexpected exception occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Final balance: " + account1.getBalance() + " PLN");
        }
    }
}
