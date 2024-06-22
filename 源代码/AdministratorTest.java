//文件名：AdministratorTest.java
package ATM;
import java.io.*;
import java.util.*;
public class AdministratorTest {
	static ArrayList<AdministratorAccount> administratorArrayList;//集合类-ArrayList类
	static AdministratorAccount currentAdministratorAccount;//当前管理员账号
	static File administratorFile;//File类
	static File currentAdministratorFile;//当前管理员文件
	static FileReader fr;//FileReader类
	static FileWriter fw;//FileWriter类
	public static void main(String[] args) throws Exception {
		administratorArrayList=new ArrayList<AdministratorAccount>();//集合类-ArrayList类
		currentAdministratorAccount=new AdministratorAccount(null,null,0);//当前管理员账号
		administratorFile=new File("administratorFile.txt");//File类
		if(!administratorFile.exists()) {
			administratorFile.createNewFile();
			fw=new FileWriter("administratorFile.txt");
			fw.write("000000 000000 400000.00\r\n");
			/*
版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
本文链接：https://xxxxychen.blog.csdn.net/article/details/107825056*/
			fw.flush();
			fw.close();
		}
		administratorArrayListRead();
	}
	public static void administratorArrayListRead() throws Exception {
		fr=new FileReader("administratorFile.txt");//fr01
		BufferedReader br=new BufferedReader(fr);//字符流//br01
		String temp="";//03
		String[] tempString=new String[5];//04
		while((temp=br.readLine())!=null) {//05
			tempString=temp.split("\\s+");//split//06
			AdministratorAccount aa=new AdministratorAccount(tempString[0],tempString[1],Float.parseFloat(tempString[2]));
			administratorArrayList.add(aa);
		}
		br.close();//br02
		fr.close();//fr02
	}
}