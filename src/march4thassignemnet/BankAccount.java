package march4thassignemnet;

public abstract class BankAccount {
    private int accNum;
    private String accHoldName;
    protected float balance;

    BankAccount(int accNum, String accHoldName, float balance)
    {
        this.accNum=accNum;
        this.accHoldName=accHoldName;
        this.balance=balance;
    }

    public void deposit(double amount)
    {
        if (amount<=0)
        {
            System.out.println("please provide a valid amount in order to deposit");
        }
        else
        {
            double cur=amount+=balance;
            System.out.println("after depositing the amount your current balance is"+cur);
        }

    }

     abstract void withdraw(double amount);

    public void displayBalance()
    {

    }




}
class SavingAccount extends BankAccount implements CalculateInterest{


    SavingAccount(int accNum, String accHoldName, float balance) {
        super(accNum, accHoldName, balance);
    }

    @Override
    public void interestRatePerYear(int amount, float rate)
    {
        if(amount<=0)
        {
            System.out.println("you did not have enough money to get interest rate");
        }
        else  {
            System.out.println("you got 5% interest on your money");


                float interest= ((amount * rate) );
                System.out.println(interest+"rs");
            }
        }

    @Override
    void withdraw(double amount)
    {
        try {
            if (amount > balance) {
                throw new InsufficientFundsException("you are requesting to withdraw amount " + amount + " which is more than your amount in saving " + balance);
            } else {
                double new_amount = balance - amount;
                System.out.println("after withdrawing of " + amount + "you have " + new_amount + " in your account");
            }
        }
        catch (InsufficientFundsException i)
        {
            System.out.println("you getting an error"+i.getMessage());
        }
    }

}

class CurrentAccount extends BankAccount {

    CurrentAccount(int accNum, String accHoldName, float balance) {
        super(accNum, accHoldName, balance);
    }

    @Override
    void withdraw(double amount) {

        if(amount>25000)
        {
            System.out.println("sorry you have reached the limit of overdraw amount");
        }
        else
        {
           double after_withdraw=balance-amount;
            System.out.println("After withdrawing your amount from current account, your current balance is "+after_withdraw);
        }


    }

}



