package Object.HomeWork.HomeWork08;

public class Test {
    public static void main(String[] args) {
        BankAccount bankAccount = new SavingAccount(1000);
        bankAccount.deposit(2000);
        bankAccount.deposit(2000);
        bankAccount.deposit(2000);
        bankAccount.deposit(2000);
        bankAccount.withdraw(2000);
        bankAccount.earnMonthlyInterest();
        bankAccount.deposit(2000);
        bankAccount.deposit(2000);
        bankAccount.deposit(2000);
        bankAccount.deposit(2000);
        bankAccount.withdraw(2000);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        if (getFreeTimes() <= 0) {
            serviceCharge();
            System.out.println("存款+" + amount + "当前余额为：" + balance + "免手续存取次数为0");
            return;
        }
        setFreeTimes(getFreeTimes() - 1);
        System.out.println("存款+" + amount + "当前余额为：" + balance + "免手续存取次数为" + getFreeTimes());
    }

    public void withdraw(double amount) {
        balance -= amount;
        if (getFreeTimes() <= 0) {
            serviceCharge();
            System.out.println("取款-" + amount + "当前余额为：" + balance + "免手续存取次数为0");
            return;
        }
        setFreeTimes(getFreeTimes() - 1);
        System.out.println("取款-" + amount + "当前余额为：" + balance + "免手续存取次数为" + getFreeTimes());
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void serviceCharge() {
        System.out.println("父类：收取手续费！");
    }

    public void earnMonthlyInterest() {
        System.out.println("父类的重置次数和利息方法");
    }

    public void setFreeTimes(int freeTimes) {
        System.out.println("父类的设至次数方法");
    }

    public int getFreeTimes() {
        return -1;
    }
}

class CheckingAccount extends BankAccount {

    private double serviceCharge = 1;

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    public void serviceCharge() {
        //System.out.println("子类：收取" + serviceCharge + "手续费！");
        setBalance(getBalance() - serviceCharge);
    }
}

class SavingAccount extends CheckingAccount {
    private double rate = 0.03;
    private int freeTimes = 3;

    public SavingAccount(double initialBalance) {
        super(initialBalance);
    }

    public void earnMonthlyInterest() {
        freeTimes = 3;
        setBalance(getBalance() + getBalance() * rate);
        System.out.println("您已经存款1个月，利息已经放至在您的余额,并且免手续费的存款和取款次数被重置为3次啦~" +
                "加上利息后，当前余额为：" + getBalance());
    }

    public void setFreeTimes(int freeTimes) {
        this.freeTimes = freeTimes;
    }

    public int getFreeTimes() {
        return freeTimes;
    }
}