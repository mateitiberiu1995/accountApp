package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Accounting.AccountingSystem;

public class AccountingSystemTest {

	AccountingSystem oe = new AccountingSystem();
	
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
	

}
