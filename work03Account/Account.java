package int101s2023h02.src.work03Account;

import int101s2023h02.src.work01Utilitor.Utilitor;
import int101s2023h02.src.work02Person.Person;

import java.util.Objects;

public class Account {
    private static long nextNo = 100_000_000;
    private final long no;
    private Person owner;
    private double balance;

    public Account(Person owner) {
        if (owner == null) throw new NullPointerException("Owner can't be null");
        Utilitor utilitor = new Utilitor();
        while (true) {
            long result = utilitor.computeIsbn10(nextNo);
            while (result == 10) {
                nextNo++;
                result = utilitor.computeIsbn10(nextNo);
            }
            this.no = 10 * nextNo + result;
            nextNo++;
            break;
        }
        this.owner = owner;

        this.balance = 0.0;
    }

    public long getNo() {
        return no;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        Utilitor.testPositive(amount);
        return this.balance += amount;
    }

    public double withdraw(double amount) {
        Utilitor.testPositive(amount);
        this.balance -= amount;
        Utilitor.testPositive(balance);
        return balance;
    }
    public void transfer(double amount, Account account) {
        if (account == null) throw new IllegalArgumentException("Account can't null");
        withdraw(amount);
        account.deposit(amount);
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("no=").append(no);
        sb.append(", owner=").append(owner);
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return no == account.no && Double.compare(balance, account.balance) == 0 && Objects.equals(owner, account.owner);
    }

}
