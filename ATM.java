package rejex;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;  
public class ATM 
{
	static int i=0;
	public static void main(String args[])
	{
		
		boolean pinsucess=false;
		int pinsucess1=1;
		int balance=0, withdraw, deposit;  
		
		Scanner sc = new Scanner(System.in);  
        BankConnection bc=new BankConnection();		
		
		try
		{
			//System.out.println("Enter the AccountNumber");
			 //i=sc.nextInt();

				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","root");
				Statement stmnt = con.createStatement();
								
				
				ResultSet rs = stmnt.executeQuery(" select * from bank_details where Account_Number=12345;");
				Vector vector = new Vector<>();
				
				
				if(!rs.isBeforeFirst()) {
					
					System.out.println("Account number does not exist");
				}
				else
				{
					System.out.println("The Account_Number is exit");
					while(rs.next()) 
				    {
						System.out.println(rs.getString("Account_Number"));
						vector.add(rs.getString("Account_Number"));
					pinsucess1=rs.getInt("Account_pin");
				    }
				
					
					
			 
			 
			 System.out.println("Enter the pin number");
		     int i1=sc.nextInt();
			
			if(pinsucess1==i1)
			{
			
			pinsucess=true;
			Pattern p=Pattern.compile("[0-9]");
			}
			else
			{
				System.out.println("Wrong pin Entered");
			}
		}
		}
		
		catch(Exception e)
		{
			System.out.println("pin is incorrect");
			System.exit(0);
		}
		
		while(pinsucess)  
		{  
			  System.out.println("login sucessfull");
			System.out.println("Choose 1 for Withdraw");  
			System.out.println("Choose 2 for Deposit");  
			System.out.println("Choose 3 for Check Balance");  
			System.out.println("Choose 4 for EXIT");  
			System.out.print("Choose the operation you want to perform:");  

			  
			int choice = sc.nextInt();  
			switch(choice)  
			{  
				case 1:  
					System.out.print("Enter money to be withdrawn:");  

				 
				withdraw = sc.nextInt();  

				
				if(balance >= withdraw)  
				{  
					
					balance = balance - withdraw;  
					System.out.println("Please collect your money");  
				}  
				else  
				{  
					  
					System.out.println("Insufficient Balance");  
				}  
				System.out.println("");  
				break;  

			case 2:  

				System.out.print("Enter money to be deposited:");  

			
				deposit = sc.nextInt();  

				
				balance = balance + deposit;  
				System.out.println("Your Money has been successfully depsited");  
				System.out.println("Please take the card");  
				break;  

			case 3:  
				 
				System.out.println("Balance : "+balance);  
				System.out.println("Take the receipt");  
				break;  
			
			
			case 4:  
				 
				System.out.println("Take your card");
				System.out.println("Thank you");
				System.exit(0); 
			}
		}
    }
}

