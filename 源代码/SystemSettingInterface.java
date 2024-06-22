//文件名：SystemSettingInterface.java
package ATM;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class SystemSettingInterface {
	static FileReader fr;//FileReader类
	static FileWriter fw;//FileWriter类
	static JFrame mainJFrame_2=new JFrame();
	static JLabel lbl=new JLabel("ATM柜员机模拟程序——系统设置界面",JLabel.CENTER);
	static JDialog diag_message=new JDialog();
	static JLabel lb_message=new JLabel();
	static JLabel lb_name=new JLabel("帐号");
	static JLabel lb_pass=new JLabel("密码");
	static JTextField tf_name=new JTextField();
	static JPasswordField pf_pass=new JPasswordField();
	static JButton bt_login=new JButton("登录");
	static JButton bt_reset=new JButton("重置");
	static JButton bt_return=new JButton("返回");
	public static void main(String[] args) {
		mainJFrame_2.setTitle("ATM柜员机模拟程序——系统设置界面");
		/*
版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
本文链接：https://xxxxychen.blog.csdn.net/article/details/107825056*/
		mainJFrame_2.setBounds(0, 0, 800, 600);
		mainJFrame_2.setLocationRelativeTo(null);
		mainJFrame_2.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		Container container=mainJFrame_2.getContentPane();
		container.setLayout(null);
		container.add(lbl);
		lbl.setBounds(0, 75, 800, 50);
		lbl.setFont(new Font("楷体",Font.BOLD,40));
		diag_message.setTitle("消息");
		diag_message.setSize(800, 600);
		diag_message.setLayout(new FlowLayout(FlowLayout.CENTER,100,100));
		diag_message.add(lb_message);
		diag_message.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		container.add(lb_name);
		lb_name.setBounds(250, 200, 50, 50);
		lb_name.setFont(new Font("黑体",Font.BOLD,20));
		container.add(lb_pass);
		lb_pass.setBounds(250, 300, 50, 50);
		lb_pass.setFont(new Font("黑体",Font.BOLD,20));
		container.add(tf_name);
		tf_name.setBounds(350, 200, 200, 50);
		tf_name.setFont(new Font("黑体",Font.BOLD,20));
		container.add(pf_pass);
		pf_pass.setBounds(350, 300, 200, 50);
		pf_pass.setFont(new Font("黑体",Font.BOLD,20));
		pf_pass.setEchoChar('*');
		container.add(bt_login);
		bt_login.setBounds(250, 400, 100, 50);
		bt_login.setFont(new Font("黑体",Font.BOLD,20));
		bt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton bt=(JButton)e.getSource();
				if(bt==bt_login) {
					try {
						AdministratorTest.main(args);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					int f=0;
					for(int i=0;i<AdministratorTest.administratorArrayList.size();i++) {
						if((tf_name.getText()).equals(AdministratorTest.administratorArrayList.get(i).administratorAccount)&&(String.valueOf(pf_pass.getPassword())).equals(AdministratorTest.administratorArrayList.get(i).password)) {
							f=1;
							AdministratorTest.currentAdministratorAccount=AdministratorTest.administratorArrayList.get(i);
							tf_name.setText("");
							pf_pass.setText("");
							new AdministratorInterface();
							AdministratorInterface.main(args);
						}
					}
					if(f==0) {
						tf_name.setText("");
						pf_pass.setText("");
						diag_message.setLocationRelativeTo(null);
						diag_message.setVisible(true);
						lb_message.setText("请注意：您输入的管理员账号或密码有误，请检查后再试！");
						lb_message.setFont(new Font("楷体",Font.BOLD,20));
					}
				}
			}
		});
		container.add(bt_reset);
		bt_reset.setBounds(450, 400, 100, 50);
		bt_reset.setFont(new Font("黑体",Font.BOLD,20));
		bt_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton bt=(JButton)e.getSource();
				if(bt==bt_reset) {
					tf_name.setText("");
					pf_pass.setText("");
				}
			}
		});
		container.add(bt_return);
		bt_return.setBounds(350, 500, 100, 50);
		bt_return.setFont(new Font("黑体",Font.BOLD,20));
		bt_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton bt=(JButton)e.getSource();
				if(bt==bt_return) {
					mainJFrame_2.dispose();
					MainInterface.main(args);
				}
			}
		});
		mainJFrame_2.setVisible(true);
	}
}