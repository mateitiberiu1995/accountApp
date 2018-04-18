package Accounting;

import java.util.HashMap;
import java.util.Scanner;

public class AccountingSystem {
	private static HashMap<String, Account> accountsList = new HashMap<String, Account>();
	public static void main(String[] args) {
		
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
	
	

}
