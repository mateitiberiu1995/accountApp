package Accounting;

import java.util.HashMap;

public class AccountingSystem {
	private static HashMap<String, Account> accountsList = new HashMap<String, Account>();
	//private static HashMap<String, Account> accountsList2 = new HashMap<String, Account>();

	public static void main(String[] args) {
        /*ObjectMapper mapperObj = new ObjectMapper();
        boolean adding = add("tiberiu","matei","023456");
        adding = add("nidhesh","matei","123456");
        adding = add("callum","matei","223456");
         
        try {
            // get Employee object as a json string
        	mapperObj.writeValue(new File("C:\\Users\\Admin\\eclipse-workspace\\file.json"), accountsList);
            //String jsonStr = mapperObj.writeValueAsString(accountsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*ObjectMapper mapper = new ObjectMapper();

        try {
			accountsList2 = mapper.readValue(new File("C:\\Users\\Admin\\eclipse-workspace\\file.json"),HashMap.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
            // get Employee object as a json string
        	mapperObj.writeValue(new File("C:\\Users\\Admin\\eclipse-workspace\\file2.json"), accountsList2);
            //String jsonStr = mapperObj.writeValueAsString(accountsList);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        
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
	public static int searchFirstName(String firstName)
	{
		/*int counter=0;
		for(HashMap.Entry<String, Account> entry : accountsList.entrySet())
		{
			if(firstName==accountsList.get(entry.getKey()).getFirst_name())
			{
				counter++;
			}
		}
		return counter;*/
		
		return (int) accountsList.values().stream().filter(something -> something.getFirst_name().equals(firstName)).count();
		
	}
	public static boolean removeAccount(String accountNumber)
	{
		boolean countExists =accountsList.containsKey(accountNumber);
		if(countExists)
		{
			accountsList.remove(accountNumber);
			return true;
		}
		return false;
	}
	public static HashMap<String, Account> getAccountMap()
	{
		return accountsList;
	}
	
	

}
