package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Accounting.AccountingSystem;

public class AccountingSystemTest {

	AccountingSystem oe = new AccountingSystem();
	ObjectMapper mapperObj = new ObjectMapper();
	
	@Test
	public void add() {
		assertEquals(true, oe.add("tiberiu","matei","023456"));
		assertEquals(false, oe.add("tiberiu","matei","023456"));
		assertEquals(true, oe.add("nidhesh","matei","123456"));
		assertEquals(true, oe.add("callum","matei","223456"));
	}
	
	@Test
	public void show() {
		assertEquals("tiberiu matei 023456", oe.show("023456"));
		assertEquals("callum matei 223456", oe.show("223456"));
		assertEquals("nidhesh matei 123456", oe.show("123456"));
	}

	@Test
	public void searchPerson() {
		oe.add("tiberiu","matei","013456");
		oe.add("tiberiu","matei","022456");
		oe.add("tiberiu","matei","023356");
		assertEquals(4, oe.searchFirstName("tiberiu"));
		oe.add("callum","matei","113456");
		oe.add("callum","matei","122456");
		oe.add("callum","matei","123356");
		assertEquals(4, oe.searchFirstName("callum"));
		
		
	}
	
	@Test
	public void removeTheAccounts() {
		assertEquals(true, oe.removeAccount("023456"));
		assertEquals(false, oe.removeAccount("023456"));
		assertEquals(true, oe.removeAccount("123456"));
		assertEquals(true, oe.removeAccount("223456"));
		assertEquals(true, oe.removeAccount("013456"));
		assertEquals(true, oe.removeAccount("022456"));
		assertEquals(true, oe.removeAccount("023356"));
		assertEquals(true, oe.removeAccount("113456"));
		assertEquals(true, oe.removeAccount("122456"));
		assertEquals(true, oe.removeAccount("123356"));
	}
	
	
	
	
	@Test
	public void accountConversionToJsonTest() throws JsonProcessingException
	{
		assertEquals(true, oe.add("tiberiu","matei","023455"));
		String emptyMap=mapperObj.writeValueAsString(oe.getAccountMap());
		assertEquals("{\"023455\":{\"first_name\":\"tiberiu\",\"last_name\":\"matei\",\"account_number\":\"023455\"}}",emptyMap);
		String accountAsJson = "{\"023455\":{\"first_name\":\"tiberiu\",\"last_name\":\"matei\",\"account_number\":\"023455\"},\"123455\":{\"first_name\":\"nidhesh\",\"last_name\":\"matei\",\"account_number\":\"123455\"},\"223455\":{\"first_name\":\"callum\",\"last_name\":\"matei\",\"account_number\":\"223455\"}}";
		assertEquals("{\"023455\":{\"first_name\":\"tiberiu\",\"last_name\":\"matei\",\"account_number\":\"023455\"}}",emptyMap);
		assertEquals(false, oe.add("tiberiu","matei","023455"));
		assertEquals(true, oe.add("nidhesh","matei","123455"));
		assertEquals(true, oe.add("callum","matei","223455"));
		String populatedAccountMap = mapperObj.writeValueAsString(oe.getAccountMap());
		assertEquals(accountAsJson, populatedAccountMap);
	}
	
	

}
