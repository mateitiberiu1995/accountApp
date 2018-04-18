package Accounting;

public class Account{
	private String first_name;
	private String last_name;
	private String account_number;
	Account(String first_name,String last_name,String account_number)
	{
		this.first_name=first_name;
		this.last_name=last_name;
		this.account_number=account_number;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	
}