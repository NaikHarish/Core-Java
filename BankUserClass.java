package SimpleBankingApplication;

public class BankUserClass {
	
	long acc_No;
	String user_Id;
	String password;
	
	public BankUserClass(long acc_No, String user_Id, String password) {
		super();
		this.acc_No = acc_No;
		this.user_Id = user_Id;
		this.password = password;
	}

	public long getAcc_No() {
		return acc_No;
	}

	public void setAcc_No(long acc_No) {
		this.acc_No = acc_No;
	}

	public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
