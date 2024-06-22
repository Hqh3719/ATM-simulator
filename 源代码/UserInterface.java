//文件名：UserInterface.java
package ATM;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
public class UserInterface {
	static FileReader fr;//FileReader类
	static FileWriter fw;//FileWriter类
	static SimpleDateFormat time;
	static Date date;
	//用户界面组件
	static JFrame mainJFrame_3=new JFrame();
	static JLabel lbl=new JLabel("ATM柜员机模拟程序——用户界面",JLabel.CENTER);
	static JDialog diag_message=new JDialog();
	static JLabel lb_message=new JLabel();
	//查询余额界面组件
	static JDialog diag_checkTheBalance=new JDialog(mainJFrame_3);
	static JLabel lb_checkTheBalance=new JLabel();
	static JButton bt_return_checkTheBalance=new JButton("返回");
	//取款界面组件
	static JDialog diag_withdrawMoney=new JDialog(mainJFrame_3);
	static JLabel lb_withdrawMoney=new JLabel();
	static JTextField tf_withdrawMoney=new JTextField(20);
	static JButton bt_determine_withdrawMoney=new JButton("确定");
	static JButton bt_return_withdrawMoney=new JButton("返回");
	//存款界面组件
	static JDialog diag_deposit=new JDialog(mainJFrame_3);
	static JLabel lb_deposit=new JLabel();
	static JTextField tf_deposit=new JTextField(20);
	static JButton bt_determine_deposit=new JButton("确定");
	static JButton bt_return_deposit=new JButton("返回");
	//转账界面组件
	static JDialog diag_transferAccounts=new JDialog(mainJFrame_3);
	static JLabel lb_transferAccounts=new JLabel();
	static JTextField tf_transferAccounts_name=new JTextField(20);
	static JTextField tf_transferAccounts_amount=new JTextField(20);
	static JButton bt_determine_transferAccounts=new JButton("确定");
	static JButton bt_return_transferAccounts=new JButton("返回");
	//转账确认界面组件
	static JDialog diag_transferAccounts_confirm=new JDialog(mainJFrame_3);
	static JLabel lb_transferAccounts_confirm_name=new JLabel();
	static JLabel lb_transferAccounts_confirm_amount=new JLabel();
	static JButton bt_transferAccounts_confirm_yes=new JButton("是");
	static JButton bt_transferAccounts_confirm_no=new JButton("否");
	//历史交易记录查询界面组件
	static JDialog diag_historicalTransactionQuery=new JDialog(mainJFrame_3);
	static JTextArea ta=new JTextArea(22,1);
	static JButton bt_return_historicalTransactionQuery=new JButton("返回");
	//修改密码界面组件
	static JDialog diag_changePassword=new JDialog(mainJFrame_3);
	static JTextField tf_changePassword_old=new JTextField(20);
	static JTextField tf_changePassword_new=new JTextField(20);
	static JTextField tf_changePassword_new_confirm=new JTextField(20);
	static JButton bt_determine_changePassword=new JButton("确定");
	static JButton bt_return_changePassword=new JButton("返回");
	//退卡界面组件
	static JDialog diag_refundCard=new JDialog(mainJFrame_3);
	static JButton bt_close=new JButton("关闭");
	static JButton bt_cancel=new JButton("取消");
	//用户界面组件
	static JButton bt_checkTheBalance=new JButton("查询余额");
	static JButton bt_withdrawMoney=new JButton("取款");
	static JButton bt_deposit=new JButton("存款");
	static JButton bt_transferAccounts=new JButton("转账");
	static JButton bt_historicalTransactionQuery=new JButton("历史交易记录查询");
	static JButton bt_changePassword=new JButton("修改密码");
	static JButton bt_refundCard=new JButton("退卡");
	public static void main(String[] args) {
		//用户界面
		mainJFrame_3.setTitle("ATM柜员机模拟程序——用户界面");
		/*
版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
本文链接：https://xxxxychen.blog.csdn.net/article/details/107825056*/
		mainJFrame_3.setBounds(0, 0, 800, 600);
		mainJFrame_3.setLocationRelativeTo(null);
		mainJFrame_3.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		Container container=mainJFrame_3.getContentPane();
		container.setLayout(null);
		container.add(lbl);
		lbl.setBounds(0, 75, 800, 50);
		lbl.setFont(new Font("楷体",Font.BOLD,40));
		diag_message.setTitle("消息");
		diag_message.setSize(800, 600);
		diag_message.setLayout(new FlowLayout(FlowLayout.CENTER,100,100));
		diag_message.add(lb_message);
		diag_message.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//查询余额界面
		container.add(bt_checkTheBalance);
		bt_checkTheBalance.setBounds(0, 200, 200, 50);
		bt_checkTheBalance.setFont(new Font("黑体",Font.BOLD,20));
		bt_checkTheBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton bt=(JButton)e.getSource();
				if(bt==bt_checkTheBalance) {
					time=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
					date=new Date();
					diag_checkTheBalance.setTitle("查询余额");
					diag_checkTheBalance.setSize(400, 300);
					diag_checkTheBalance.setLayout(new FlowLayout(FlowLayout.CENTER,100,100));
					diag_checkTheBalance.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					diag_checkTheBalance.add(lb_checkTheBalance);
					lb_checkTheBalance.setText("您的余额为 "+UserTest.currentUserAccount.balance+" 元");
					lb_checkTheBalance.setFont(new Font("楷体",Font.BOLD,20));
					//记录操作
					try {
						fw=new FileWriter(UserTest.currentUserAccount.userAccount+".txt",true);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					try {//"时 间\t\t\t\t操作\t\t余额\t\t备注\r\n"
						fw.write(time.format(date)+"\t\t查询余额\t\t\t"+UserTest.currentUserAccount.balance+"元\t\t无\r\n");
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
					try {
						fw=new FileWriter("historyOfAll.txt",true);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					try {
						fw.write(UserTest.currentUserAccount.userAccount+"\t\t"+time.format(date)+"\t\t查询余额\t\t\t无\t\t其余额"+UserTest.currentUserAccount.balance+"元\r\n");
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
					diag_checkTheBalance.add(bt_return_checkTheBalance);
					bt_return_checkTheBalance.setFont(new Font("黑体",Font.BOLD,15));
					bt_return_checkTheBalance.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_return_checkTheBalance) {
								diag_checkTheBalance.dispose();
							}
						}
					});
					diag_checkTheBalance.setLocationRelativeTo(null);
					diag_checkTheBalance.setVisible(true);
				}
			}
		});
		//取款界面
		container.add(bt_withdrawMoney);
		bt_withdrawMoney.setBounds(0, 300, 200, 50);
		bt_withdrawMoney.setFont(new Font("黑体",Font.BOLD,20));
		bt_withdrawMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton bt=(JButton)e.getSource();
				if(bt==bt_withdrawMoney) {
					diag_withdrawMoney.setTitle("取款");
					diag_withdrawMoney.setSize(400, 300);
					diag_withdrawMoney.setLayout(new FlowLayout(FlowLayout.CENTER,100,50));
					diag_withdrawMoney.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					diag_withdrawMoney.add(lb_withdrawMoney);
					lb_withdrawMoney.setText("您的余额为 "+UserTest.currentUserAccount.balance+" 元");
					lb_withdrawMoney.setFont(new Font("楷体",Font.BOLD,20));
					diag_withdrawMoney.add(tf_withdrawMoney);
					tf_withdrawMoney.setText("请输入取款金额");
					tf_withdrawMoney.setFont(new Font("楷体",Font.BOLD,20));
					diag_withdrawMoney.add(bt_determine_withdrawMoney);
					bt_determine_withdrawMoney.setFont(new Font("黑体",Font.BOLD,15));
					bt_determine_withdrawMoney.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_determine_withdrawMoney) {
								//每次取款金额为100的倍数
								if(Float.parseFloat(tf_withdrawMoney.getText())%100!=0) {
									diag_withdrawMoney.dispose();
									diag_message.setLocationRelativeTo(null);
									diag_message.setVisible(true);
									lb_message.setText("请注意：每次取款金额应为100的倍数，请检查后再试！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								//每次取款总额不超过5000元
								else if(Float.parseFloat(tf_withdrawMoney.getText())>5000.00) {
									diag_withdrawMoney.dispose();
									diag_message.setLocationRelativeTo(null);
									diag_message.setVisible(true);
									lb_message.setText("请注意：每次取款总额不得超过 5000.00 元，请检查后再试！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								//支取金额不允许透支
								else if(Float.parseFloat(tf_withdrawMoney.getText())>UserTest.currentUserAccount.balance) {
									diag_withdrawMoney.dispose();
									diag_message.setLocationRelativeTo(null);
									diag_message.setVisible(true);
									lb_message.setText("请注意：支取金额不允许透支，请检查后再试！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								//非正数
								else if(Float.parseFloat(tf_withdrawMoney.getText())<=0) {
									diag_withdrawMoney.dispose();
									diag_message.setLocationRelativeTo(null);
									diag_message.setVisible(true);
									lb_message.setText("请注意：您的输入有误，请检查后再试！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								//成功取款
								else {
									time=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
									date=new Date();
									UserTest.currentUserAccount.balance-=Float.parseFloat(tf_withdrawMoney.getText());
									//记录操作
									try {
										fw=new FileWriter(UserTest.currentUserAccount.userAccount+".txt",true);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									try {//"时 间\t\t\t\t操作\t\t余额\t\t备注\r\n"
										fw.write(time.format(date)+"\t\t取款"+Float.parseFloat(tf_withdrawMoney.getText())+"元\t\t"+UserTest.currentUserAccount.balance+"元\t\t无\r\n");
									} catch (NumberFormatException | IOException e1) {
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
									try {
										fw=new FileWriter("historyOfAll.txt",true);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									try {
										fw.write(UserTest.currentUserAccount.userAccount+"\t\t"+time.format(date)+"\t\t取款"+Float.parseFloat(tf_withdrawMoney.getText())+"元\t\t无\t\t其余额"+UserTest.currentUserAccount.balance+"元\r\n");
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
									try {
										fr=new FileReader("administratorFile.txt");
									} catch (FileNotFoundException e1) {
										e1.printStackTrace();
									}
									BufferedReader br=new BufferedReader(fr);
									String temp="";
									String[] tempString=new String[5];
									String A=null;
									String B=null;
									String C=null;
									try {
										while((temp=br.readLine())!=null) {
											tempString=temp.split("\\s+");
											A=tempString[0];
											B=tempString[1];
											C=tempString[2];
										}
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									float balance=Float.parseFloat(C)-Float.parseFloat(tf_withdrawMoney.getText());
									try {
										fw=new FileWriter("administratorFile.txt");
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									StringBuilder sb=new StringBuilder();
									sb.append(A+" "+B+" "+balance+"\r\n");
									try {
										fw.write(sb.toString());
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
									try {
										fw=new FileWriter("recentFund.txt",true);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									try {
										fw.write(time.format(date)+"\t\t支出"+Float.parseFloat(tf_withdrawMoney.getText())+"元\t\t至"+UserTest.currentUserAccount.userAccount+"\t\t本机余额"+balance+"元\r\n");
									} catch (NumberFormatException | IOException e1) {
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
									//更新UserFile
									try {
										UserTest.userArrayListWrite();
									} catch (Exception e1) {
										e1.printStackTrace();
									}
									diag_withdrawMoney.dispose();
									diag_message.setLocationRelativeTo(null);
									diag_message.setVisible(true);
									lb_message.setText("请注意：取款成功！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
							}
						}
					});
					diag_withdrawMoney.add(bt_return_withdrawMoney);
					bt_return_withdrawMoney.setFont(new Font("黑体",Font.BOLD,15));
					bt_return_withdrawMoney.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_return_withdrawMoney) {
								diag_withdrawMoney.dispose();
							}
						}
					});
					diag_withdrawMoney.setLocationRelativeTo(null);
					diag_withdrawMoney.setVisible(true);
				}
			}
		});
		//存款界面
		container.add(bt_deposit);
		bt_deposit.setBounds(0, 400, 200, 50);
		bt_deposit.setFont(new Font("黑体",Font.BOLD,20));
		bt_deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton bt=(JButton)e.getSource();
				if(bt==bt_deposit) {
					diag_deposit.setTitle("存款");
					diag_deposit.setSize(400, 300);
					diag_deposit.setLayout(new FlowLayout(FlowLayout.CENTER,100,50));
					diag_deposit.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					diag_deposit.add(lb_deposit);
					lb_deposit.setText("您的余额为 "+UserTest.currentUserAccount.balance+" 元");
					lb_deposit.setFont(new Font("楷体",Font.BOLD,20));
					diag_deposit.add(tf_deposit);
					tf_deposit.setText("请输入存款金额");
					tf_deposit.setFont(new Font("楷体",Font.BOLD,20));
					diag_deposit.add(bt_determine_deposit);
					bt_determine_deposit.setFont(new Font("黑体",Font.BOLD,15));
					bt_determine_deposit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_determine_deposit) {
								//每次存款金额为100的倍数
								if(Float.parseFloat(tf_deposit.getText())%100!=0) {
									diag_deposit.dispose();
									diag_message.setLocationRelativeTo(null);
									diag_message.setVisible(true);
									lb_message.setText("请注意：每次存款金额应为100的倍数，请检查后再试！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								//非正数
								else if(Float.parseFloat(tf_deposit.getText())<=0) {
									diag_deposit.dispose();
									diag_message.setLocationRelativeTo(null);
									diag_message.setVisible(true);
									lb_message.setText("请注意：您的输入有误，请检查后再试！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								//成功存款
								else {
									time=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
									date=new Date();
									UserTest.currentUserAccount.balance+=Float.parseFloat(tf_deposit.getText());
									//记录操作
									try {
										fw=new FileWriter(UserTest.currentUserAccount.userAccount+".txt",true);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									try {//"时 间\t\t\t\t操作\t\t余额\t\t备注\r\n"
										fw.write(time.format(date)+"\t\t存款"+Float.parseFloat(tf_deposit.getText())+"元\t\t"+UserTest.currentUserAccount.balance+"元\t\t无\r\n");
									} catch (NumberFormatException | IOException e1) {
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
									try {
										fw=new FileWriter("historyOfAll.txt",true);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									try {
										fw.write(UserTest.currentUserAccount.userAccount+"\t\t"+time.format(date)+"\t\t存款"+Float.parseFloat(tf_deposit.getText())+"元\t\t无\t\t其余额"+UserTest.currentUserAccount.balance+"元\r\n");
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
									try {
										fr=new FileReader("administratorFile.txt");
									} catch (FileNotFoundException e1) {
										e1.printStackTrace();
									}
									BufferedReader br=new BufferedReader(fr);
									String temp="";
									String[] tempString=new String[5];
									String A=null;
									String B=null;
									String C=null;
									try {
										while((temp=br.readLine())!=null) {
											tempString=temp.split("\\s+");
											A=tempString[0];
											B=tempString[1];
											C=tempString[2];
										}
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									float balance=Float.parseFloat(C)+Float.parseFloat(tf_deposit.getText());
									try {
										fw=new FileWriter("administratorFile.txt");
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									StringBuilder sb=new StringBuilder();
									sb.append(A+" "+B+" "+balance+"\r\n");
									try {
										fw.write(sb.toString());
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
									try {
										fw=new FileWriter("recentFund.txt",true);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									try {
										fw.write(time.format(date)+"\t\t收入"+Float.parseFloat(tf_deposit.getText())+"元\t\t来自"+UserTest.currentUserAccount.userAccount+"\t\t本机余额"+balance+"元\r\n");
									} catch (NumberFormatException | IOException e1) {
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
									//更新UserFile
									try {
										UserTest.userArrayListWrite();
									} catch (Exception e1) {
										e1.printStackTrace();
									}
									diag_deposit.dispose();
									diag_message.setLocationRelativeTo(null);
									diag_message.setVisible(true);
									lb_message.setText("请注意：存款成功！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
							}
						}
					});
					diag_deposit.add(bt_return_deposit);
					bt_return_deposit.setFont(new Font("黑体",Font.BOLD,15));
					bt_return_deposit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_return_deposit) {
								diag_deposit.dispose();
							}
						}
					});
					diag_deposit.setLocationRelativeTo(null);
					diag_deposit.setVisible(true);
				}
			}
		});
		//转账界面
		container.add(bt_transferAccounts);
		bt_transferAccounts.setBounds(0, 500, 200, 50);
		bt_transferAccounts.setFont(new Font("黑体",Font.BOLD,20));
		bt_transferAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton bt=(JButton)e.getSource();
				if(bt==bt_transferAccounts) {
					diag_transferAccounts.setTitle("转账");
					diag_transferAccounts.setSize(400, 300);
					diag_transferAccounts.setLayout(new FlowLayout(FlowLayout.CENTER,100,25));
					diag_transferAccounts.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					diag_transferAccounts.add(lb_transferAccounts);
					lb_transferAccounts.setText("您的余额为 "+UserTest.currentUserAccount.balance+" 元");
					lb_transferAccounts.setFont(new Font("楷体",Font.BOLD,20));
					diag_transferAccounts.add(tf_transferAccounts_name);
					tf_transferAccounts_name.setText("请输入转账账号");
					tf_transferAccounts_name.setFont(new Font("楷体",Font.BOLD,20));
					diag_transferAccounts.add(tf_transferAccounts_amount);
					tf_transferAccounts_amount.setText("请输入转账金额");
					tf_transferAccounts_amount.setFont(new Font("楷体",Font.BOLD,20));
					diag_transferAccounts.add(bt_determine_transferAccounts);
					bt_determine_transferAccounts.setFont(new Font("黑体",Font.BOLD,15));
					bt_determine_transferAccounts.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_determine_transferAccounts) {
								int f=0;
								for(int i=0;i<UserTest.userArrayList.size();i++) {
									if((tf_transferAccounts_name.getText()).equals(UserTest.userArrayList.get(i).userAccount)){
										f=1;
										UserTest.currentUserAccount_1.userAccount=UserTest.userArrayList.get(i).userAccount;
										UserTest.currentUserAccount_1.balance=UserTest.userArrayList.get(i).balance;
									}
								}
								//银行卡不存在
								if(f==0) {
									diag_transferAccounts.dispose();
									diag_message.setLocationRelativeTo(null);
									diag_message.setVisible(true);
									lb_message.setText("请注意：对方账号不存在，请检查后再试！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								//每次转账总额不超过10000元
								else if(Float.parseFloat(tf_transferAccounts_amount.getText())>10000.00) {
									diag_transferAccounts.dispose();
									diag_message.setLocationRelativeTo(null);
									diag_message.setVisible(true);
									lb_message.setText("请注意：每次转账总额不得超过 10000.00 元，请检查后再试！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								//余额不足
								else if(f==1&&(Float.parseFloat(tf_transferAccounts_amount.getText())>UserTest.currentUserAccount.balance)) {
									diag_transferAccounts.dispose();
									diag_message.setLocationRelativeTo(null);
									diag_message.setVisible(true);
									lb_message.setText("请注意：您的余额不足，请检查后再试！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								//非正数
								else if(f==1&&(Float.parseFloat(tf_transferAccounts_amount.getText())<=0)) {
									diag_transferAccounts.dispose();
									diag_message.setLocationRelativeTo(null);
									diag_message.setVisible(true);
									lb_message.setText("请注意：您的输入有误，请检查后再试！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								//不得向自己转账
								else if(f==0&&(tf_transferAccounts_name.getText()==UserTest.currentUserAccount.userAccount)) {
									diag_transferAccounts.dispose();
									diag_message.setLocationRelativeTo(null);
									diag_message.setVisible(true);
									lb_message.setText("请注意：您的输入有误，请检查后再试！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								//待成功转账
								else {
									String amount=tf_transferAccounts_amount.getText();
									String name=tf_transferAccounts_name.getText();
									lb_transferAccounts_confirm_name.setText("是否确认转账 "+amount+" 元");
									lb_transferAccounts_confirm_amount.setText("至 "+name+" 账户");
									//转账确认界面
									diag_transferAccounts_confirm.setTitle("转账确认");
									diag_transferAccounts_confirm.setSize(400, 300);
									diag_transferAccounts_confirm.setLayout(new FlowLayout(FlowLayout.CENTER,100,50));
									diag_transferAccounts_confirm.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
									diag_transferAccounts_confirm.add(lb_transferAccounts_confirm_name);
									lb_transferAccounts_confirm_name.setFont(new Font("楷体",Font.BOLD,20));
									diag_transferAccounts_confirm.add(lb_transferAccounts_confirm_amount);
									lb_transferAccounts_confirm_amount.setFont(new Font("楷体",Font.BOLD,20));
									diag_transferAccounts_confirm.add(bt_transferAccounts_confirm_yes);
									bt_transferAccounts_confirm_yes.setFont(new Font("黑体",Font.BOLD,15));
									bt_transferAccounts_confirm_yes.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											JButton bt=(JButton)e.getSource();
											//成功转账
											if(bt==bt_transferAccounts_confirm_yes) {
												time=new SimpleDateFormat("yyyy年MM月dd日");
												date=new Date();
												try {
													fr=new FileReader(UserTest.currentUserAccount.userAccount+" "+time.format(date)+"transfer.txt");
												} catch (FileNotFoundException e1) {
													e1.printStackTrace();
												}
												BufferedReader br_1=new BufferedReader(fr);
												String temp_1="";
												String[] tempString_1=new String[2];
												String A_1=null;
												try {
													while((temp_1=br_1.readLine())!=null) {
														tempString_1=temp_1.split("\\s+");
														A_1=tempString_1[0];
													}
												} catch (IOException e1) {
													e1.printStackTrace();
												}
												float transfer_1=Float.parseFloat(A_1);
												try {
													br_1.close();
												} catch (IOException e1) {
													e1.printStackTrace();
												}
												try {
													fr.close();
												} catch (IOException e1) {
													e1.printStackTrace();
												}
												if(transfer_1+Float.parseFloat(tf_transferAccounts_amount.getText())>=10000) {
													diag_transferAccounts_confirm.dispose();
													diag_transferAccounts.dispose();
													diag_message.setLocationRelativeTo(null);
													diag_message.setVisible(true);
													lb_message.setText("请注意：当前账号当日转账超过 10000.00 元，暂时无法转账，请明日再试！");
													lb_message.setFont(new Font("楷体",Font.BOLD,20));
												}
												else {
													time=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
													date=new Date();
													UserTest.currentUserAccount.balance-=Float.parseFloat(tf_transferAccounts_amount.getText());
													UserTest.currentUserAccount_1.balance+=Float.parseFloat(tf_transferAccounts_amount.getText());
													//记录操作01
													try {
														fw=new FileWriter(UserTest.currentUserAccount.userAccount+".txt",true);
													} catch (IOException e1) {
														e1.printStackTrace();
													}
													try {//"时 间\t\t\t\t操作\t\t余额\t\t备注\r\n"
														fw.write(time.format(date)+"\t\t转账"+Float.parseFloat(tf_transferAccounts_amount.getText())+"元\t\t"+UserTest.currentUserAccount.balance+"元\t\t至"+UserTest.currentUserAccount_1.userAccount+"\r\n");
													} catch (NumberFormatException | IOException e1) {
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
													UserTest.currentUserFile=new File(UserTest.currentUserAccount_1.userAccount+".txt");
													if(!UserTest.currentUserFile.exists()) {
														try {
															UserTest.currentUserFile.createNewFile();
														} catch (IOException e1) {
															e1.printStackTrace();
														}
														try {
															fw=new FileWriter(UserTest.currentUserAccount_1.userAccount+".txt");
														} catch (IOException e1) {
															e1.printStackTrace();
														}
														try {
															fw.write("时 间\t\t\t\t操作\t\t\t余额\t\t备注\r\n");
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
													//记录操作02
													try {
														fw=new FileWriter(UserTest.currentUserAccount_1.userAccount+".txt",true);
													} catch (IOException e1) {
														e1.printStackTrace();
													}
													try {//"时间\t\t\t\t操作\t\t余额\t\t备注\r\n"
														fw.write(time.format(date)+"\t\t收到转账"+Float.parseFloat(tf_transferAccounts_amount.getText())+"元\t\t"+UserTest.currentUserAccount_1.balance+"元\t来自"+UserTest.currentUserAccount.userAccount+"\r\n");
													} catch (NumberFormatException | IOException e1) {
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
													try {
														fw=new FileWriter("historyOfAll.txt",true);
													} catch (IOException e1) {
														e1.printStackTrace();
													}
													try {
														fw.write(UserTest.currentUserAccount.userAccount+"\t\t"+time.format(date)+"\t\t转账"+Float.parseFloat(tf_transferAccounts_amount.getText())+"元\t\t至"+UserTest.currentUserAccount_1.userAccount+"\t\t其余额"+UserTest.currentUserAccount.balance+"元\r\n");
														fw.write(UserTest.currentUserAccount_1.userAccount+"\t\t"+time.format(date)+"\t\t收到转账"+Float.parseFloat(tf_transferAccounts_amount.getText())+"元\t\t来自"+UserTest.currentUserAccount.userAccount+"\t\t其余额"+UserTest.currentUserAccount_1.balance+"元\r\n");
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
													//更新UserFile
													for(int i=0;i<UserTest.userArrayList.size();i++) {
														if(UserTest.userArrayList.get(i).userAccount.equals(UserTest.currentUserAccount_1.userAccount)) {
															UserTest.userArrayList.get(i).balance=UserTest.currentUserAccount_1.balance;
														}
													}
													try {
														UserTest.userArrayListWrite();
													} catch (Exception e1) {
														e1.printStackTrace();
													}
													time=new SimpleDateFormat("yyyy年MM月dd日");
													date=new Date();
													try {
														fr=new FileReader(UserTest.currentUserAccount.userAccount+" "+time.format(date)+"transfer.txt");
													} catch (FileNotFoundException e1) {
														e1.printStackTrace();
													}
													BufferedReader br=new BufferedReader(fr);
													String temp="";
													String[] tempString=new String[2];
													String A=null;
													try {
														while((temp=br.readLine())!=null) {
															tempString=temp.split("\\s+");
															A=tempString[0];
														}
													} catch (IOException e1) {
														e1.printStackTrace();
													}
													float transfer=Float.parseFloat(A);
													try {
														br.close();
													} catch (IOException e1) {
														e1.printStackTrace();
													}
													try {
														fr.close();
													} catch (IOException e1) {
														e1.printStackTrace();
													}
													transfer+=Float.parseFloat(tf_transferAccounts_amount.getText());
													try {
														fw=new FileWriter(UserTest.currentUserAccount.userAccount+" "+time.format(date)+"transfer.txt");
													} catch (IOException e1) {
														e1.printStackTrace();
													}
													try {
														fw.write(transfer+"");
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
													diag_transferAccounts_confirm.dispose();
													diag_transferAccounts.dispose();
													diag_message.setLocationRelativeTo(null);
													diag_message.setVisible(true);
													lb_message.setText("请注意：转账成功！");
													lb_message.setFont(new Font("楷体",Font.BOLD,20));
												}
											}
										}
									});
									diag_transferAccounts_confirm.add(bt_transferAccounts_confirm_no);
									bt_transferAccounts_confirm_no.setFont(new Font("黑体",Font.BOLD,15));
									bt_transferAccounts_confirm_no.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											JButton bt=(JButton)e.getSource();
											if(bt==bt_transferAccounts_confirm_no) {
												diag_transferAccounts_confirm.dispose();
											}
										}
									});
									diag_transferAccounts_confirm.setLocationRelativeTo(null);
									diag_transferAccounts_confirm.setVisible(true);
								}
							}
						}
					});
					diag_transferAccounts.add(bt_return_transferAccounts);
					bt_return_transferAccounts.setFont(new Font("黑体",Font.BOLD,15));
					bt_return_transferAccounts.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_return_transferAccounts) {
								diag_transferAccounts.dispose();
							}
						}
					});
					diag_transferAccounts.setLocationRelativeTo(null);
					diag_transferAccounts.setVisible(true);
				}
			}
		});
		//历史交易记录查询界面
		container.add(bt_historicalTransactionQuery);
		bt_historicalTransactionQuery.setBounds(585, 250, 200, 50);
		bt_historicalTransactionQuery.setFont(new Font("黑体",Font.BOLD,19));
		bt_historicalTransactionQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton bt=(JButton)e.getSource();
				if(bt==bt_historicalTransactionQuery) {
					diag_historicalTransactionQuery.setTitle("历史交易记录查询");
					diag_historicalTransactionQuery.setSize(800, 600);
					diag_historicalTransactionQuery.setLayout(null);
					diag_historicalTransactionQuery.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					diag_historicalTransactionQuery.add(ta);
					ta.setBounds(0, 0, 800, 500);
					try {
						fr=new FileReader(UserTest.currentUserAccount.userAccount+".txt");
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
								ta.append("\r\n  "+A+B+"\t\t\t\t"+C+"\t\t"+D+"\t\t"+E+"\r\n\r\n");
							}
							else if(C.equals("查询余额")) {}
							else if(C.equals("历史交易记录查询")) {}
							else if(C.equals("修改密码")) {}
							else {
								ta.append("  "+A+" "+B+"\t"+C+"\t"+D+"\t"+E+"\r\n");
							}
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					try {
						br.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					try {
						fr.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					time=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
					date=new Date();
					//记录操作
					try {
						fw=new FileWriter(UserTest.currentUserAccount.userAccount+".txt",true);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					try {//"时 间\t\t\t\t操作\t\t余额\t\t备注\r\n"
						fw.write(time.format(date)+"\t\t历史交易记录查询\t\t"+UserTest.currentUserAccount.balance+"元\t\t无\r\n");
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
					try {
						fw=new FileWriter("historyOfAll.txt",true);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					try {
						fw.write(UserTest.currentUserAccount.userAccount+"\t\t"+time.format(date)+"\t\t历史记录查询\t\t无\t\t其余额"+UserTest.currentUserAccount.balance+"元\r\n");
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
					ta.setEditable(false);
					ta.setFont(new Font("黑体",Font.BOLD,15));
					diag_historicalTransactionQuery.add(bt_return_historicalTransactionQuery);
					bt_return_historicalTransactionQuery.setBounds(367, 520, 66, 28);
					bt_return_historicalTransactionQuery.setFont(new Font("黑体",Font.BOLD,15));
					bt_return_historicalTransactionQuery.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_return_historicalTransactionQuery) {
								diag_historicalTransactionQuery.dispose();
								ta.setText("");
							}
						}
					});
					diag_historicalTransactionQuery.setLocationRelativeTo(null);
					diag_historicalTransactionQuery.setVisible(true);
				}
			}
		});
		//修改密码界面
		container.add(bt_changePassword);
		bt_changePassword.setBounds(585, 350, 200, 50);
		bt_changePassword.setFont(new Font("黑体",Font.BOLD,20));
		bt_changePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton bt=(JButton)e.getSource();
				if(bt==bt_changePassword) {
					diag_changePassword.setTitle("修改密码");
					diag_changePassword.setSize(400, 300);
					diag_changePassword.setLayout(new FlowLayout(FlowLayout.CENTER,100,25));
					diag_changePassword.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					diag_changePassword.add(tf_changePassword_old);
					tf_changePassword_old.setText("请输入旧密码");
					tf_changePassword_old.setFont(new Font("楷体",Font.BOLD,20));
					diag_changePassword.add(tf_changePassword_new);
					tf_changePassword_new.setText("请输入新密码");
					tf_changePassword_new.setFont(new Font("楷体",Font.BOLD,20));
					diag_changePassword.add(tf_changePassword_new_confirm);
					tf_changePassword_new_confirm.setText("请确认新密码");
					tf_changePassword_new_confirm.setFont(new Font("楷体",Font.BOLD,20));
					diag_changePassword.add(bt_determine_changePassword);
					bt_determine_changePassword.setFont(new Font("黑体",Font.BOLD,15));
					bt_determine_changePassword.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_determine_changePassword) {
								String old=tf_changePassword_old.getText();
								String new_input=tf_changePassword_new.getText();
								String new_confirm=tf_changePassword_new_confirm.getText();
								try {
									fr=new FileReader("userFile.txt");
								} catch (FileNotFoundException e1) {
									e1.printStackTrace();
								}
								BufferedReader br=new BufferedReader(fr);
								String temp="";
								String[] tempString=new String[5];
								try {
									while((temp=br.readLine())!=null) {
										tempString=temp.split("\\s+");
										if(tempString[0].equals(UserTest.currentUserAccount.userAccount)) {
											UserTest.currentUserAccount.password=tempString[1];
										}
									}
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								try {
									br.close();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								try {
									fr.close();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								if(old.equals("请输入旧密码")) {//未输入旧密码
									lb_message.setText("请注意：请输入旧密码！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								else if(new_input.equals("请输入新密码")) {//未输入新密码
									lb_message.setText("请注意：请输入新密码！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								else if(new_confirm.equals("请确认新密码")) {//未确认新密码
									lb_message.setText("请注意：请确认新密码！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								else if(!old.equals(UserTest.currentUserAccount.password)) {//旧密码输入有误
									lb_message.setText("请注意：您输入的旧密码有误，请检查后再试！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								else if(new_input.equals(old)) {//新密码与旧密码一致
									lb_message.setText("请注意：您输入的新密码与旧密码一致，无法修改！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								else if(!new_confirm.equals(new_input)) {//两次输入新密码不一致
									lb_message.setText("请注意：您两次输入的新密码不一致，请检查后再试！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								else if(new_input.length()!=6) {//新密码不为6位
									lb_message.setText("请注意：您输入的新密码不为6位，请检查后再试！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								else if(new_input.equals("000000")||new_input.equals("111111")||new_input.equals("222222")||new_input.equals("333333")||new_input.equals("444444")||new_input.equals("555555")||new_input.equals("666666")||new_input.equals("777777")||new_input.equals("888888")||new_input.equals("999999")) {//新密码出现6位完全相同的数字
									lb_message.setText("请注意：您输入的新密码不得出现6位完全相同的数字，请检查后再试！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
								}
								else {//成功修改密码
									time=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
									date=new Date();
									UserTest.currentUserAccount.password=new_confirm;
									//记录操作
									try {
										fw=new FileWriter(UserTest.currentUserAccount.userAccount+".txt",true);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									try {//"时 间\t\t\t\t操作\t\t余额\t\t备注\r\n"
										fw.write(time.format(date)+"\t\t修改密码\t\t\t"+UserTest.currentUserAccount.balance+"元\t\t无\r\n");
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
									try {
										fw=new FileWriter("historyOfAll.txt",true);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									try {
										fw.write(UserTest.currentUserAccount.userAccount+"\t\t"+time.format(date)+"\t\t修改密码\t\t\t无\t\t其余额"+UserTest.currentUserAccount.balance+"元\r\n");
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
									//更新UserFile
									for(int i=0;i<UserTest.userArrayList.size();i++) {
										if(UserTest.userArrayList.get(i).userAccount.equals(UserTest.currentUserAccount.userAccount)) {
											UserTest.userArrayList.get(i).password=UserTest.currentUserAccount.password;
										}
									}
									try {
										UserTest.userArrayListWrite();
									} catch (Exception e1) {
										e1.printStackTrace();
									}
									lb_message.setText("请注意：修改成功，请重新登录！");
									lb_message.setFont(new Font("楷体",Font.BOLD,20));
									diag_message.addWindowListener(new WindowListener() {
										@Override
										public void windowOpened(WindowEvent e) {
										}
										@Override
										public void windowClosing(WindowEvent e) {
											System.exit(0);
										}
										@Override
										public void windowClosed(WindowEvent e) {
											System.exit(0);
										}
										@Override
										public void windowIconified(WindowEvent e) {	
										}
										@Override
										public void windowDeiconified(WindowEvent e) {
										}
										@Override
										public void windowActivated(WindowEvent e) {
										}
										@Override
										public void windowDeactivated(WindowEvent e) {
										}
									});
								}
								diag_changePassword.dispose();
								diag_message.setLocationRelativeTo(null);
								diag_message.setVisible(true);
							}
						}
					});
					diag_changePassword.add(bt_return_changePassword);
					bt_return_changePassword.setFont(new Font("黑体",Font.BOLD,15));
					bt_return_changePassword.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_return_changePassword) {
								diag_changePassword.dispose();
							}
						}
					});
					diag_changePassword.setLocationRelativeTo(null);
					diag_changePassword.setVisible(true);
				}
			}
		});
		//退卡界面
		container.add(bt_refundCard);
		bt_refundCard.setBounds(585, 450, 200, 50);
		bt_refundCard.setFont(new Font("黑体",Font.BOLD,20));
		bt_refundCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton bt=(JButton)e.getSource();
				if(bt==bt_refundCard) {
					diag_refundCard.setTitle("退卡");
					diag_refundCard.setSize(400, 300);
					diag_refundCard.setLayout(new FlowLayout(FlowLayout.CENTER,50,100));
					diag_refundCard.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					diag_refundCard.add(bt_close);
					bt_close.setFont(new Font("黑体",Font.BOLD,15));
					bt_close.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_close) {
								System.exit(0);
							}
						}
					});
					diag_refundCard.add(bt_cancel);
					bt_cancel.setFont(new Font("黑体",Font.BOLD,15));
					bt_cancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton bt=(JButton)e.getSource();
							if(bt==bt_cancel) {
								diag_refundCard.dispose();
							}
						}
					});
					diag_refundCard.setLocationRelativeTo(null);
					diag_refundCard.setVisible(true);
				}
			}
		});
		//用户界面
		mainJFrame_3.setVisible(true);
	}
}