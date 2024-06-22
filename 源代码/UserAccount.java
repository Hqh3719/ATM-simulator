//文件名：UserAccount.java
package ATM;
public class UserAccount {
	String userAccount;
	String password;
	float balance;
	/*
版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
本文链接：https://xxxxychen.blog.csdn.net/article/details/107825056*/
	public UserAccount(String userAccount,String password,float balance) {
		this.userAccount=userAccount;
		this.password=password;
		this.balance=balance;
	}
}