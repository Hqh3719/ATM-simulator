//文件名：UserTest.java
package ATM;
import java.io.*;
import java.util.*;
public class UserTest {
	static ArrayList<UserAccount> userArrayList;//集合类-ArrayList类
	static UserAccount currentUserAccount;//当前用户账号
	static UserAccount currentUserAccount_1;//当前被转帐用户账号
	static File userFile;//File类
	static File currentUserFile;//当前用户文件
	static FileReader fr;//FileReader类
	static FileWriter fw;//FileWriter类
	public static void main(String[] args) throws Exception {
		userArrayList=new ArrayList<UserAccount>();//集合类-ArrayList类
		currentUserAccount=new UserAccount(null,null,0);//当前用户账号
		currentUserAccount_1=new UserAccount(null,null,0);//当前被转帐用户账号
		userFile=new File("userFile.txt");//File类
		if(!userFile.exists()) {
			userFile.createNewFile();
			fw=new FileWriter("userFile.txt");
			fw.write("6214837525982959 123456 100000.00\r\n");
			fw.write("6222032008007668 123456 100000.00\r\n");
			fw.write("6217003170032409 123456 100000.00\r\n");
			fw.write("6212252008001091 123456 100000.00\r\n");
			/*
版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
本文链接：https://xxxxychen.blog.csdn.net/article/details/107825056*/
			fw.flush();
			fw.close();
		}
		userArrayListRead();
		userArrayListWrite();
	}
	public static void userArrayListRead() throws Exception {
		fr=new FileReader("userFile.txt");//fr01
		BufferedReader br=new BufferedReader(fr);//字符流//br01
		String temp="";//03
		String[] tempString=new String[5];//04
		while((temp=br.readLine())!=null) {//05
			tempString=temp.split("\\s+");//split//06
			UserAccount ua=new UserAccount(tempString[0],tempString[1],Float.parseFloat(tempString[2]));//UserAccount//07
			userArrayList.add(ua);//ArrayList//08
		}
		br.close();//br02
		fr.close();//fr02
	}
	public static void userArrayListWrite() throws Exception {
		fw=new FileWriter("userFile.txt");//fw01
		StringBuilder sb=new StringBuilder();//02
		for(int i=0;i<userArrayList.size();i++) {//03
			sb.append(userArrayList.get(i).userAccount+" "+userArrayList.get(i).password+" "+userArrayList.get(i).balance+"\r\n");//append//04
		}
		fw.write(sb.toString());//05
		fw.flush();//06
		fw.close();//fw02
	}
}