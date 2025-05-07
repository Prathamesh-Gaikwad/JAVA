 Q1) Design a class for Bank. Bank Class should support following operations; a. Deposit a certain amount into an account b. Withdraw a certain amount from an account c. Return a Balance value specifying the amount with details [10 marks] 

import java.io.*;

class Bank

{

    int acno;

    String name;

    double balance; 

    

    public Bank(int ano,String n,double b)

    {

        acno=ano;

	name=n;

	balance=b;

    }

    

   public void viewBalance()

   {

	System.out.println("Account Number : " +acno ); 

       System.out.println("Name: " + name);     

       System.out.println("The balance is: " + balance); 

   }

  

   public void deposit(double amount)

   {

       balance += amount; 

	

   }

   

   public void withdraw(double amount)

   {

		balance-=amount;

   }   

}

class Slip7_1

{

	

	public static void main(String args[]) throws IOException

	{

		Bank s=new Bank(1,"abc",500);	

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int ch;

	do

	{

	System.out.println("Enter \n1.View Balance\n2.Withdraw\n3.Deposit\n4.Exit");

	ch=Integer.parseInt(br.readLine());

	

	   switch(ch)

	   {

		case 1:s.viewBalance();break;

		case 2:System.out.println("Enter Amount to Withdraw");

			double amt=Double.parseDouble(br.readLine());

			s.withdraw(amt);

			break;

		case 3:System.out.println("Enter Amount to Deposit");

			double amt1=Double.parseDouble(br.readLine());

			s.deposit(amt1);

			break;

	    }

	}while(ch!=4);

	}

}



