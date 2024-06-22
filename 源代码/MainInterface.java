//文件名：MainInterface.java
package ATM;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public abstract class MainInterface implements ActionListener {
	static JFrame mainJFrame=new JFrame();
	static JLabel lbl=new JLabel("ATM柜员机模拟程序——主界面",JLabel.CENTER);
	static JButton bt_userMode=new JButton("用户模式");
	static JButton bt_systemManagementMode=new JButton("系统管理模式");
	static JButton bt_signOut=new JButton("退出");
	public static void main(String[] args) {
		mainJFrame.setTitle("ATM柜员机模拟程序——主界面");
		mainJFrame.setBounds(0, 0, 800, 600);
		mainJFrame.setLocationRelativeTo(null);
		mainJFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		Container container=mainJFrame.getContentPane();
		container.setLayout(null);
		container.add(lbl);
		lbl.setBounds(0, 75, 800, 50);
		lbl.setFont(new Font("楷体",Font.BOLD,40));
		container.add(bt_userMode);
		bt_userMode.setBounds(300, 200, 200, 50);
		bt_userMode.setFont(new Font("黑体",Font.BOLD,20));
		bt_userMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton bt=(JButton)e.getSource();
				if(bt==bt_userMode) {
					new UserLoginInterface();
					UserLoginInterface.main(args);
				}
			}
		}
		container.add(bt_systemManagementMode);
		bt_systemManagementMode.setBounds(300, 300, 200, 50);
		bt_systemManagementMode.setFont(new Font("黑体",Font.BOLD,20));
		bt_systemManagementMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton bt=(JButton)e.getSource();
				if(bt==bt_systemManagementMode) {
					new SystemSettingInterface();
					SystemSettingInterface.main(args);
				}
			}
		}
		container.add(bt_signOut);
		bt_signOut.setBounds(300, 400, 200, 50);
		bt_signOut.setFont(new Font("黑体",Font.BOLD,20));
		bt_signOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton bt=(JButton)e.getSource();
				if(bt==bt_signOut) {
					mainJFrame.dispose();
					System.exit(0);
				}
			}
		}
		mainJFrame.setVisible(true);
	}
}