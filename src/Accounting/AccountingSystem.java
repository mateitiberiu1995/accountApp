package Accounting;

import java.util.HashMap;
import java.util.Scanner;

public class AccountingSystem {
	private static HashMap<String, Account> accountsList = new HashMap<String, Account>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String answer;
		Scanner reader = new Scanner(System.in);
		answer=reader.next();
		while(!answer.equals("stop"))
		{
			System.out.println(answer);
			if(answer.equals("add"))
			{
				String firstName,lastName,accountNumber;
				System.out.println("Write your first name: ");
				firstName=reader.next();
				System.out.println("Write your last name: ");
				lastName=reader.next();
				System.out.println("Write your account number: ");
				accountNumber=reader.next();
				if(add(firstName,lastName,accountNumber))
				{
					System.out.println("account added");
				}
				else {
					System.out.println("The account is already in System!");
				}
			}
			if(answer.equals("remove"))
			{
				String accountNumber;
				System.out.println("Write your account number: ");
				accountNumber=reader.next();
				if(accountsList.containsKey(accountNumber))
				{
					accountsList.remove(accountNumber);
				}
				else {
					System.out.println("The account is not in the System!");
				}
			}
			if(answer.equals("show"))
			{
				for (String accountNumber: accountsList.keySet()){

			        System.out.println(show(accountNumber));
				} 
			}
			answer=reader.next();
		}
		
		reader.close();*/

	}
	public static boolean add(String firstName,String lastName,String accountNumber)
	{
		if(!accountsList.containsKey(accountNumber))
		{
			Account Person = new Account(firstName,lastName,accountNumber);
			accountsList.put(accountNumber,Person);
			return true;
		}
		else {
			return false;
		}
		
		
	}
	public static String show(String accountNumber)
	{

	        return (accountsList.get(accountNumber).getFirst_name()+ " " + accountsList.get(accountNumber).getLast_name()+ " " + accountsList.get(accountNumber).getAccount_number());

	}
	public static boolean remove(String accountNumber)
	{
		if(accountsList.containsKey(accountNumber))
		{
			accountsList.remove(accountNumber);
			return true;
		}
		else
			return false;
	}
	
	

}
