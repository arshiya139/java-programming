class bank
{
	int bal=10;
	synchronized void checkBal() 
	{ 
		System.out.println(Thread.currentThread().getName()+"Current balance: "+this.bal);
		try
		{
			Thread.sleep(500);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		
	}
	
	synchronized void withdraw(int amt)
	{ 
		int temp=bal;
		if(temp<bal) System.out.println(Thread.currentThread().getName()+"Insufficient funds.");
		
		else{temp-=amt;System.out.println(Thread.currentThread().getName()+"Current balance after withdrawl:"+temp);}
			
		this.bal=temp;
		
		try
		{
			Thread.sleep(500);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		
	}
	
	synchronized void deposit(int amt) 
	{
		this.bal+=amt;
		System.out.println(Thread.currentThread().getName()+"Current balance after deposit:"+this.bal);
		try
		{
			Thread.sleep(500);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
	}
	
}


public class Q3
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		bank acc= new bank();
		
		Thread t1=new Thread(new Runnable()
				{
					public void run()
					{
						for(int i=0;i<5;i++)
							acc.deposit(1);
					}
				});
	
		Thread t11=new Thread(new Runnable()
		{
			public void run()
			{
				for(int i=0;i<5;i++)
				{
					
					acc.deposit(1);
				}
			}
		});
		
		Thread t2=new Thread(new Runnable() 
		{
			public void run()
			{
				for(int i=0;i<5;i++)
				acc.withdraw(1);
			}
			
		});
		
		Thread t21=new Thread(new Runnable() 
		{
			public void run()
			{
				for(int i=0;i<5;i++)
				{
					acc.withdraw(1);
					
				}
				
			}
			
		});
		
		Thread t3=new Thread(new Runnable() 
		{
			public void run()
			{
				for(int i=0;i<5;i++)
				acc.checkBal();
			}
			
		});
		
		
		t1.setName("1st User");  
		t11.setName("2nd User");  
		t2.setName("1st User");  
		t21.setName("2nd User");  
		t3.setName("Balance Check");  
		
		t3.start();
		t1.start();
		t11.start();
		t2.start();
		t21.start();
		
		try
		{
			t3.join();
			t1.join();
			t11.join();
			t2.join();
			t21.join();
			
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}

	}

}