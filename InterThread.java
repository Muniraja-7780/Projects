
import java.util.Scanner;

class Muni1{
	int amount=15000;
public synchronized void withdraw(int amount) {
	System.out.println("withdrawing starts......");
	if(amount >this.amount)
	{
		System.out.println("low balance....!");
		 try {
			wait();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	this.amount-=amount;
	System.out.println("withdraw completed......"+this.amount);
	
}

public synchronized void deposit(int amount)
{
	System.out.println("deposit starts....");
	this.amount+=amount;
	System.out.println("deposit completed..."+this.amount);
	notify();
}
}
	

public class Interthread {
	public static void main(String[] args) {
		Muni1 m=new Muni1();
		Scanner sc=new Scanner(System.in);
		new Thread()
		{
			public void run()
			{
				m.withdraw(20000);
			}
		}.start();
		new Thread()
		{
			public void run()
			{
				m.deposit(10000);
			}
		}.start();		
	}

}
