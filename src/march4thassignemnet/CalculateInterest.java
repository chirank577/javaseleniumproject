package march4thassignemnet;


public interface CalculateInterest {

    void interestRatePerYear(int amount, float rate);
    public static void main(String[] args) {
        SavingAccount s=new SavingAccount(222322,"chiru",10000);
        s.interestRatePerYear(100, 0.08F);
        CurrentAccount c=new CurrentAccount(12345,"chiranjivi",20000);
        c.deposit(999);
        s.withdraw(12000);
        c.withdraw(21000);


    }
}
