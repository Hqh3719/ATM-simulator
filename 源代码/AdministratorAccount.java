//文件名：AdministratorAccount.java
package ATM;
public class AdministratorAccount {
	String administratorAccount;
	String password;
	float balance;
	public AdministratorAccount(String administratorAccount,String password,float balance) {
		this.administratorAccount=administratorAccount;
		this.password=password;
 		this.balance=balance;
	}
}