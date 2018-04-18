package Accounting;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountingSystem {
	private static HashMap<String, Account> accountsList = new HashMap<String, Account>();
	private static HashMap<String, Account> accountsList2 = new HashMap<String, Account>();
	public static void main(String[] args) {
        ObjectMapper mapperObj = new ObjectMapper();
        boolean adding = add("tiberiu","matei","023456");
        adding = add("nidhesh","matei","123456");
        adding = add("callum","matei","223456");
         
        try {
            // get Employee object as a json string
        	mapperObj.writeValue(new File("C:\\Users\\Admin\\eclipse-workspace\\file.json"), accountsList);
            //String jsonStr = mapperObj.writeValueAsString(accountsList);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();

        //JSON from file to Object
        //accountsList2 = mapper.readValue("C:\\Users\\Admin\\eclipse-workspace\\file.json", Account.class);
        try {
			accountsList2 = mapper.readValue(new File("C:\\Users\\Admin\\eclipse-workspace\\file.json"),HashMap.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
            // get Employee object as a json string
        	mapperObj.writeValue(new File("C:\\Users\\Admin\\eclipse-workspace\\file2.json"), accountsList2);
            //String jsonStr = mapperObj.writeValueAsString(accountsList);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
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
