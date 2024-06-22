//文件名：AdministratorInterface.java
package ATM;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
public class AdministratorInterface {
	static FileReader fr;//FileReader类
	static FileWriter fw;//FileWriter类
	static SimpleDateFormat time;
	static Date date;
	static JFrame mainJFrame_4=new JFrame();
	static JLabel lbl=new JLabel("ATM柜员机模拟程序——管理员界面",JLabel.CENTER);
	static JDialog diag_message=new JDialog();
	static JLabel lb_message=new JLabel();
	static JDialog diag_recentFund=new JDialog(mainJFrame_4);
	static JTextArea ta_recentFund=new JTextArea();
	static JButton bt_return_recentFund=new JButton("返回");
	static JDialog diag_historyOfAll=new JDialog(mainJFrame_4);
	static JTextArea ta_historyOfAll=new JTextArea();
	static JButton bt_return_historyOfAll=new JButton("返回");
	static JDialog diag_userAccountUnlock=new JDialog(mainJFrame_4);
	static JTextArea ta_userAccountUnlock=new JTextArea();
	static JButton bt_unlock_userAccountUnlock=new JButton("全部解锁");
	static JButton bt_return_userAccountUnlock=new JButton("返回");
	static JDialog diag_signOut=new JDialog(mainJFrame_4);
	static JButton bt_close=new JButton("关闭");
	static JButton bt_cancel=new JButton("取消");
	static JButton bt_recentFund=new JButton("本机近期资金出入明细");
	static JButton bt_historyOfAll=new JButton("本机所有账户的历史记录");
	static JButton bt_userAccountUnlock=new JButton("用户账号解锁");
	static JButton bt_signOut=new JButton("退出");
	public static void main(String[] args) {
		//管理员界面
		mainJFrame_4.setTitle("ATM柜员机模拟程序——管理员界面");
		/*
版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
本文链接：https://xxxxychen.blog.csdn.net/article/details/107825056*/
		mainJFrame_4.setBounds(0, 0, 800, 600);
		mainJFrame_4.setLocationRelativeTo(null);
		mainJFrame_4.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		Container container=mainJFrame_4.getContentPane();
		container.setLayout(null);
		container.add(lbl);
		lbl.setBounds(0, 75, 800, 50);
		lbl.setFont(new Font("楷体",Font.BOLD,40));
		diag_message.setTitle("消息");
		diag_message.setSize(1200, 600);
		diag_message.setLayout(new FlowLayout(FlowLayout.CENTER,100,100));
		diag_message.add(lb_message);
		diag_message.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//本机近期资金出入明细界面
		container.add(bt_recentFund);
		bt_recentFund.setBounds(300, 200, 200, 50);
		bt_recentFund.setFont(new Font("黑体",Font.BOLD,15));
		bt_recentFund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton bt=(JButton)e.getSource();
				if(bt==bt_recentFund) {
					diag_recentFund.setTitle("本机近期资金出入明细");
					diag_recentFund.setSize(1200, 600);
					diag_recentFund.setLayout(null);
					diag_recentFund.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					diag_recentFund.add(ta_recentFund);
					ta_recentFund.setBounds(0, 0, 1200, 500);
					File recentFund=new File("recentFund.txt");
					if(!recentFund.exists()) {
						try {
							recentFund.createNewFile();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							fw=new FileWriter("recentFund.txt");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							fw.write("时 间\t\t\t\t操作\t\t\t备 注\r\n");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							fw.flush();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							fw.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					try {
						fr=new FileReader("recentFund.txt");
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					BufferedReader br=new BufferedReader(fr);
					String temp="";
					String[] tempString=new String[9];
					try {
						while((temp=br.readLine())!=null) {
							tempString=temp.split("\\s+");
							String A=tempString[0];
							String B=tempString[1];
							String C=tempString[2];
							String D=tempString[3];
							String E=tempString[4];
							if(A.equals("时")) {
								ta_recentFund.append("\r\n\t"+A+""+B+"\t\t\t\t"+C+"\t\t\t"+D+""+E+"\r\n\r\n");
							}
							else {
								ta_recentFund.append("\t"+A+" "+B+"\t"+C+"\t\t"+D+"    "+E+"\r\n");
							}
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					ta_recentFund.setEditable(false);
					ta_recentFund.setFont(new Font("黑体",Font.BOLD,15));
					diag_recentFund.add(bt_return_recentFund);
					bt_return_recentFund.setBounds(567, 520, 66, 28);
					bt_return_recentFund.setFont(new Font("黑体",Font.BOLD,15));
					bt_return_recentFund.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_return_recentFund) {
								diag_recentFund.dispose();
								ta_recentFund.setText("");
							}
						}
					});
					diag_recentFund.setLocationRelativeTo(null);
					diag_recentFund.setVisible(true);
				}
			}
		});
		//本机所有账户的历史记录界面
		container.add(bt_historyOfAll);
		bt_historyOfAll.setBounds(300, 300, 200, 50);
		bt_historyOfAll.setFont(new Font("黑体",Font.BOLD,14));
		bt_historyOfAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton bt=(JButton)e.getSource();
				if(bt==bt_historyOfAll) {
					diag_historyOfAll.setTitle("本机所有账户的历史记录");
					diag_historyOfAll.setSize(1200, 600);
					diag_historyOfAll.setLayout(null);
					diag_historyOfAll.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					diag_historyOfAll.add(ta_historyOfAll);
					ta_historyOfAll.setBounds(0, 0, 1200, 500);
					File historyOfAll=new File("historyOfAll.txt");
					if(!historyOfAll.exists()) {
						try {
							historyOfAll.createNewFile();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							fw=new FileWriter("historyOfAll.txt");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							fw.write("用户账号\t\t\t时 间\t\t\t\t操作\t\t\t备 注\r\n");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							fw.flush();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							fw.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					try {
						fr=new FileReader("historyOfAll.txt");
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					BufferedReader br=new BufferedReader(fr);
					String temp="";
					String[] tempString=new String[11];
					try {
						while((temp=br.readLine())!=null) {
							tempString=temp.split("\\s+");
							String A=tempString[0];
							String B=tempString[1];
							String C=tempString[2];
							String D=tempString[3];
							String E=tempString[4];
							String F=tempString[5];
							if(A.equals("用户账号")) {
								ta_historyOfAll.append("\r\n\t"+A+"\t\t\t"+B+""+C+"\t\t\t\t"+D+"\t\t\t"+E+""+F+"\r\n\r\n");
							}
							else if(D.equals("查询余额")) {
								ta_historyOfAll.append("\t"+A+"\t"+B+" "+C+"\t"+D+"\t\t\t"+E+"    "+F+"\r\n");
							}
							else if(D.equals("修改密码")) {
								ta_historyOfAll.append("\t"+A+"\t"+B+" "+C+"\t"+D+"\t\t\t"+E+"    "+F+"\r\n");
							}
							else {
								ta_historyOfAll.append("\t"+A+"\t"+B+" "+C+"\t"+D+"\t\t"+E+"    "+F+"\r\n");
							}
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					ta_historyOfAll.setEditable(false);
					ta_historyOfAll.setFont(new Font("黑体",Font.BOLD,15));
					diag_historyOfAll.add(bt_return_historyOfAll);
					bt_return_historyOfAll.setBounds(567, 520, 66, 28);
					bt_return_historyOfAll.setFont(new Font("黑体",Font.BOLD,15));
					bt_return_historyOfAll.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_return_historyOfAll) {
								diag_historyOfAll.dispose();
								ta_historyOfAll.setText("");
							}
						}
					});
					diag_historyOfAll.setLocationRelativeTo(null);
					diag_historyOfAll.setVisible(true);
				}
			}
		});
		//用户账号解锁界面
		container.add(bt_userAccountUnlock);
		bt_userAccountUnlock.setBounds(300, 400, 200, 50);
		bt_userAccountUnlock.setFont(new Font("黑体",Font.BOLD,20));
		bt_userAccountUnlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton bt=(JButton)e.getSource();
				if(bt==bt_userAccountUnlock) {
					diag_userAccountUnlock.setTitle("用户账号解锁");
					diag_userAccountUnlock.setSize(1200, 600);
					diag_userAccountUnlock.setLayout(null);
					diag_userAccountUnlock.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					diag_userAccountUnlock.add(ta_userAccountUnlock);
					ta_userAccountUnlock.setBounds(0, 0, 1200, 500);
					File unlock=new File("unlock.txt");
					if(!unlock.exists()) {
						try {
							unlock.createNewFile();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							fw=new FileWriter("unlock.txt");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							fw.write("被锁定 用户账号\t时 间\r\n");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							fw.flush();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							fw.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					try {
						fr=new FileReader("unlock.txt");
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					BufferedReader br=new BufferedReader(fr);
					String temp="";
					String[] tempString=new String[7];
					String A=null;
					String B=null;
					String C=null;
					String D=null;
					try {
						while((temp=br.readLine())!=null) {
							tempString=temp.split("\\s+");
							A=tempString[0];
							B=tempString[1];
							C=tempString[2];
							D=tempString[3];
							if(A.equals("被锁定")) {
								ta_userAccountUnlock.append("\r\n\t"+A+""+B+"\t\t"+C+""+D+"\r\n");
							}
							else {
								ta_userAccountUnlock.append("\r\n\t"+A+"\t"+D+"\t"+C+"\t"+B+"\r\n");
							}
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					ta_userAccountUnlock.setEditable(false);
					ta_userAccountUnlock.setFont(new Font("黑体",Font.BOLD,15));
					diag_userAccountUnlock.add(bt_unlock_userAccountUnlock);
					bt_unlock_userAccountUnlock.setBounds(450, 520, 100, 28);
					bt_unlock_userAccountUnlock.setFont(new Font("黑体",Font.BOLD,15));
					bt_unlock_userAccountUnlock.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_unlock_userAccountUnlock) {
								try {
									fr=new FileReader("unlock.txt");
								} catch (FileNotFoundException e1) {
									e1.printStackTrace();
								}
								BufferedReader br=new BufferedReader(fr);
								String temp="";
								String[] tempString=new String[3];
								String A=null;
								String B=null;
								String C=null;
								String D=null;
								try {
									while((temp=br.readLine())!=null) {
										tempString=temp.split("\\s+");
										A=tempString[0];
										B=tempString[1];
										C=tempString[2];
										D=tempString[3];
										if(!A.equals("被锁定")) {
											File delete_1=new File(A+" "+B+".txt");
											delete_1.delete();
											File delete_2=new File(A+" "+C+".txt");
											delete_2.delete();
											File delete_3=new File(A+" "+D+".txt");
											delete_3.delete();
											try {
												fw=new FileWriter("unlock.txt");
											} catch (IOException e1) {
												e1.printStackTrace();
											}
											try {
												fw.write("被锁定 用户账号\t时 间\r\n");
											} catch (IOException e1) {
												e1.printStackTrace();
											}
											try {
												fw.flush();
											} catch (IOException e1) {
												e1.printStackTrace();
											}
											try {
												fw.close();
											} catch (IOException e1) {
												e1.printStackTrace();
											}
											diag_userAccountUnlock.dispose();
											ta_userAccountUnlock.setText("");
											diag_message.setLocationRelativeTo(null);
											diag_message.setVisible(true);
											lb_message.setText("请注意：解锁成功！");
											lb_message.setFont(new Font("楷体",Font.BOLD,20));
										}
									}
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
						}
					});
					diag_userAccountUnlock.add(bt_return_userAccountUnlock);
					bt_return_userAccountUnlock.setBounds(650, 520, 100, 28);
					bt_return_userAccountUnlock.setFont(new Font("黑体",Font.BOLD,15));
					bt_return_userAccountUnlock.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_return_userAccountUnlock) {
								diag_userAccountUnlock.dispose();
								ta_userAccountUnlock.setText("");
							}
						}
					});
					diag_userAccountUnlock.setLocationRelativeTo(null);
					diag_userAccountUnlock.setVisible(true);
				}
			}
		});
		//退出界面
		container.add(bt_signOut);
		bt_signOut.setBounds(300, 500, 200, 50);
		bt_signOut.setFont(new Font("黑体",Font.BOLD,20));
		bt_signOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton bt=(JButton)e.getSource();
				if(bt==bt_signOut) {
					diag_signOut.setTitle("退出");
					diag_signOut.setSize(400, 300);
					diag_signOut.setLayout(new FlowLayout(FlowLayout.CENTER,50,100));
					diag_signOut.add(bt_close);
					bt_close.setFont(new Font("黑体",Font.BOLD,15));
					bt_close.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_close) {
								System.exit(0);
							}
						}
					});
					diag_signOut.add(bt_cancel);
					bt_cancel.setFont(new Font("黑体",Font.BOLD,15));
					bt_cancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_cancel) {
								diag_signOut.dispose();
							}
						}
					});
					diag_signOut.setLocationRelativeTo(null);
					diag_signOut.setVisible(true);
				}
			}
		});
		//管理员界面
		mainJFrame_4.setVisible(true);
	}
}