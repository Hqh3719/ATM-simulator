//文件名：UserLoginInterface.java
package ATM;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
public class UserLoginInterface {
	static FileReader fr;//FileReader类
	static FileWriter fw;//FileWriter类
	static SimpleDateFormat time;
	static Date date;
    	static Calendar calendar;
	static JFrame mainJFrame_1=new JFrame();
	static JLabel lbl=new JLabel("ATM柜员机模拟程序——用户登录界面",JLabel.CENTER);
	static JDialog diag_message=new JDialog();
	static JLabel lb_message=new JLabel();
	static JLabel lb_name=new JLabel("账号");
	static JLabel lb_pass=new JLabel("密码");
	static JTextField tf_name=new JTextField();
	static JPasswordField pf_pass=new JPasswordField();
	static JButton bt_login=new JButton("登录");
	static JButton bt_reset=new JButton("重置");
	static JButton bt_return=new JButton("返回");
	public static void main(String[] args) {
		mainJFrame_1.setTitle("ATM柜员机模拟程序——用户登录界面");
		mainJFrame_1.setBounds(0, 0, 800, 600);
		mainJFrame_1.setLocationRelativeTo(null);
		mainJFrame_1.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		Container container=mainJFrame_1.getContentPane();
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
						UserTest.main(args);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					time=new SimpleDateFormat("yyyy年MM月dd日");
					date=new Date();
                    				calendar=GregorianCalendar.getInstance();
					try {
						calendar.setTime(time.parse(time.format(date)));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					int today=calendar.get(Calendar.DATE);
					calendar.set(Calendar.DATE, today-1);
					String yesterday=time.format(calendar.getTime());
					calendar.set(Calendar.DATE, today-2);
					String theDayBeforeYesterday=time.format(calendar.getTime());
					File test_2=new File(tf_name.getText()+" "+theDayBeforeYesterday+".txt");
					File test_1=new File(tf_name.getText()+" "+yesterday+".txt");
					File test=new File(tf_name.getText()+" "+time.format(date)+".txt");
					String name=tf_name.getText();
					int r=0;
					if(test.exists()) {
						try {
							fr=new FileReader(tf_name.getText()+" "+time.format(date)+".txt");
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
						int times_1=Integer.parseInt(A_1);
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
						if(times_1>=3) {
							r=1;
							if(test_1.exists()) {
								try {
									fr=new FileReader(tf_name.getText()+" "+yesterday+".txt");
								} catch (FileNotFoundException e1) {
									e1.printStackTrace();
								}
								BufferedReader br_2=new BufferedReader(fr);
								String temp_2="";
								String[] tempString_2=new String[2];
								String A_2=null;
								try {
									while((temp_2=br_2.readLine())!=null) {
										tempString_2=temp_2.split("\\s+");
										A_2=tempString_2[0];
									}
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								int times_2=Integer.parseInt(A_2);
								try {
									br_2.close();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								try {
									fr.close();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								if(times_2>=3) {
									r=2;
									if(test_2.exists()) {
										try {
											fr=new FileReader(tf_name.getText()+" "+theDayBeforeYesterday+".txt");
										} catch (FileNotFoundException e1) {
											e1.printStackTrace();
										}
										BufferedReader br_3=new BufferedReader(fr);
										String temp_3="";
										String[] tempString_3=new String[2];
										String A_3=null;
										try {
											while((temp_3=br_3.readLine())!=null) {
												tempString_3=temp_3.split("\\s+");
												A_3=tempString_3[0];
											}
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										int times_3=Integer.parseInt(A_3);
										try {
											br_3.close();
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										try {
											fr.close();
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										if(times_3>=3) {
											r=3;
											if(r==3) {
												tf_name.setText("");
												pf_pass.setText("");
												diag_message.setLocationRelativeTo(null);
												diag_message.setVisible(true);
												lb_message.setText("请注意：当前账号连续三日出错超过3次，已被锁定，请联系管理员解锁！");
												lb_message.setFont(new Font("楷体",Font.BOLD,20));
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
												String[] tempString=new String[3];
												String A=null;
												String[] B=new String[5];
												for(int i=0;i<B.length;i++) {
													try {
														while((temp=br.readLine())!=null) {
															tempString=temp.split("\\s+");
															A=tempString[0];
															B[i]=A;
														}
													} catch (IOException e1) {
														e1.printStackTrace();
													}
												}
												if(!name.equals(B[0])&&!name.equals(B[1])&&!name.equals(B[2])&&!name.equals(B[3])&&!name.equals(B[4])) {
													try {
														fw=new FileWriter("unlock.txt",true);
													} catch (IOException e1) {
														e1.printStackTrace();
													}
													try {
														fw.write(name+"\t"+time.format(date)+"\t"+yesterday+"\t"+theDayBeforeYesterday+"\r\n");
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
											}
										}
										else {//
											int f=0;
											for(int i=0;i<UserTest.userArrayList.size();i++) {
												if((tf_name.getText()).equals(UserTest.userArrayList.get(i).userAccount)&&(String.valueOf(pf_pass.getPassword())).equals(UserTest.userArrayList.get(i).password)) {
													f=1;
													UserTest.currentUserAccount=UserTest.userArrayList.get(i);
													UserTest.currentUserFile=new File(UserTest.currentUserAccount.userAccount+".txt");//当前用户操作文件
													File limit_transfer=new File(UserTest.currentUserAccount.userAccount+" "+time.format(date)+"transfer.txt");
													File historyOfAll=new File("historyOfAll.txt");
													File recentFund=new File("recentFund.txt");
													File administratorFile=new File("administratorFile.txt");
													if(!UserTest.currentUserFile.exists()) {
														try {
															UserTest.currentUserFile.createNewFile();
														} catch (IOException e1) {
															e1.printStackTrace();
														}
														try {
															fw=new FileWriter(UserTest.currentUserAccount.userAccount+".txt");
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
													if(!limit_transfer.exists()) {
														try {
															limit_transfer.createNewFile();
														} catch (IOException e1) {
															e1.printStackTrace();
														}
														try {
															fw=new FileWriter(UserTest.currentUserAccount.userAccount+" "+time.format(date)+"transfer.txt");
														} catch (IOException e1) {
															e1.printStackTrace();
														}
														try {
															fw.write("0");
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
													if(!administratorFile.exists()) {
														try {
															administratorFile.createNewFile();
														} catch (IOException e1) {
															e1.printStackTrace();
														}
														try {
															fw=new FileWriter("administratorFile.txt");
														} catch (IOException e1) {
															e1.printStackTrace();
														}
														try {
															fw.write("000000 000000 400000.00\r\n");
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
													tf_name.setText("");
													pf_pass.setText("");
													new UserInterface();
													UserInterface.main(args);
												}
												if((tf_name.getText()).equals(UserTest.userArrayList.get(i).userAccount)&&!(String.valueOf(pf_pass.getPassword())).equals(UserTest.userArrayList.get(i).password)) {
													f=2;
													File limit_1=new File(UserTest.userArrayList.get(i).userAccount+" "+time.format(date)+".txt");
													if(!limit_1.exists()) {
														try {
															limit_1.createNewFile();
														} catch (IOException e1) {
															e1.printStackTrace();
														}
														try {
															fw=new FileWriter(UserTest.userArrayList.get(i).userAccount+" "+time.format(date)+".txt");
														} catch (IOException e1) {
															e1.printStackTrace();
														}
														try {
															fw.write("1");
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
													else {
														try {
															fr=new FileReader(UserTest.userArrayList.get(i).userAccount+" "+time.format(date)+".txt");
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
														int times=Integer.parseInt(A);
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
														times++;
														try {
															fw=new FileWriter(UserTest.userArrayList.get(i).userAccount+" "+time.format(date)+".txt");
														} catch (IOException e1) {
															e1.printStackTrace();
														}
														try {
															fw.write(times+"");
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
												}
											}
											if(f!=1) {
												tf_name.setText("");
												pf_pass.setText("");
												diag_message.setLocationRelativeTo(null);
												diag_message.setVisible(true);
												lb_message.setText("请注意：您输入的账号或密码有误，请检查后再试！");
												lb_message.setFont(new Font("楷体",Font.BOLD,20));
											}
										}
									}
									if(r==2) {
										tf_name.setText("");
										pf_pass.setText("");
										diag_message.setLocationRelativeTo(null);
										diag_message.setVisible(true);
										lb_message.setText("请注意：当前账号连续两日出错超过3次，暂被锁定，请明日再试！");
										lb_message.setFont(new Font("楷体",Font.BOLD,20));
									}
								}
								else {//
									int f=0;
									for(int i=0;i<UserTest.userArrayList.size();i++) {
										if((tf_name.getText()).equals(UserTest.userArrayList.get(i).userAccount)&&(String.valueOf(pf_pass.getPassword())).equals(UserTest.userArrayList.get(i).password)) {
											f=1;
											UserTest.currentUserAccount=UserTest.userArrayList.get(i);
											UserTest.currentUserFile=new File(UserTest.currentUserAccount.userAccount+".txt");//当前用户操作文件
											File limit_transfer=new File(UserTest.currentUserAccount.userAccount+" "+time.format(date)+"transfer.txt");
											File historyOfAll=new File("historyOfAll.txt");
											File recentFund=new File("recentFund.txt");
											File administratorFile=new File("administratorFile.txt");
											if(!UserTest.currentUserFile.exists()) {
												try {
													UserTest.currentUserFile.createNewFile();
												} catch (IOException e1) {
													e1.printStackTrace();
												}
												try {
													fw=new FileWriter(UserTest.currentUserAccount.userAccount+".txt");
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
											if(!limit_transfer.exists()) {
												try {
													limit_transfer.createNewFile();
												} catch (IOException e1) {
													e1.printStackTrace();
												}
												try {
													fw=new FileWriter(UserTest.currentUserAccount.userAccount+" "+time.format(date)+"transfer.txt");
												} catch (IOException e1) {
													e1.printStackTrace();
												}
												try {
													fw.write("0");
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
											if(!administratorFile.exists()) {
												try {
													administratorFile.createNewFile();
												} catch (IOException e1) {
													e1.printStackTrace();
												}
												try {
													fw=new FileWriter("administratorFile.txt");
												} catch (IOException e1) {
													e1.printStackTrace();
												}
												try {
													fw.write("000000 000000 400000.00\r\n");
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
											tf_name.setText("");
											pf_pass.setText("");
											new UserInterface();
											UserInterface.main(args);
										}
										if((tf_name.getText()).equals(UserTest.userArrayList.get(i).userAccount)&&!(String.valueOf(pf_pass.getPassword())).equals(UserTest.userArrayList.get(i).password)) {
											f=2;
											File limit_1=new File(UserTest.userArrayList.get(i).userAccount+" "+time.format(date)+".txt");
											if(!limit_1.exists()) {
												try {
													limit_1.createNewFile();
												} catch (IOException e1) {
													e1.printStackTrace();
												}
												try {
													fw=new FileWriter(UserTest.userArrayList.get(i).userAccount+" "+time.format(date)+".txt");
												} catch (IOException e1) {
													e1.printStackTrace();
												}
												try {
													fw.write("1");
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
											else {
												try {
													fr=new FileReader(UserTest.userArrayList.get(i).userAccount+" "+time.format(date)+".txt");
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
												int times=Integer.parseInt(A);
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
												times++;
												try {
													fw=new FileWriter(UserTest.userArrayList.get(i).userAccount+" "+time.format(date)+".txt");
												} catch (IOException e1) {
													e1.printStackTrace();
												}
												try {
													fw.write(times+"");
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
										}
									}
									if(f!=1) {
										tf_name.setText("");
										pf_pass.setText("");
										diag_message.setLocationRelativeTo(null);
										diag_message.setVisible(true);
										lb_message.setText("请注意：您输入的账号或密码有误，请检查后再试！");
										lb_message.setFont(new Font("楷体",Font.BOLD,20));
									}
								}
							}
							if(r==1) {
								tf_name.setText("");
								pf_pass.setText("");
								diag_message.setLocationRelativeTo(null);
								diag_message.setVisible(true);
								lb_message.setText("请注意：当前账号当日出错超过3次，暂被锁定，请明日再试！");
								lb_message.setFont(new Font("楷体",Font.BOLD,20));
							}
						}
						else {//
							int f=0;
							for(int i=0;i<UserTest.userArrayList.size();i++) {
								if((tf_name.getText()).equals(UserTest.userArrayList.get(i).userAccount)&&(String.valueOf(pf_pass.getPassword())).equals(UserTest.userArrayList.get(i).password)) {
									f=1;
									UserTest.currentUserAccount=UserTest.userArrayList.get(i);
									UserTest.currentUserFile=new File(UserTest.currentUserAccount.userAccount+".txt");//当前用户操作文件
									File limit_transfer=new File(UserTest.currentUserAccount.userAccount+" "+time.format(date)+"transfer.txt");
									File historyOfAll=new File("historyOfAll.txt");
									File recentFund=new File("recentFund.txt");
									File administratorFile=new File("administratorFile.txt");
									if(!UserTest.currentUserFile.exists()) {
										try {
											UserTest.currentUserFile.createNewFile();
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										try {
											fw=new FileWriter(UserTest.currentUserAccount.userAccount+".txt");
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
									if(!limit_transfer.exists()) {
										try {
											limit_transfer.createNewFile();
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										try {
											fw=new FileWriter(UserTest.currentUserAccount.userAccount+" "+time.format(date)+"transfer.txt");
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										try {
											fw.write("0");
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
									if(!administratorFile.exists()) {
										try {
											administratorFile.createNewFile();
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										try {
											fw=new FileWriter("administratorFile.txt");
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										try {
											fw.write("000000 000000 400000.00\r\n");
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
									tf_name.setText("");
									pf_pass.setText("");
									new UserInterface();
									UserInterface.main(args);
								}
								if((tf_name.getText()).equals(UserTest.userArrayList.get(i).userAccount)&&!(String.valueOf(pf_pass.getPassword())).equals(UserTest.userArrayList.get(i).password)) {
									f=2;
									File limit_1=new File(UserTest.userArrayList.get(i).userAccount+" "+time.format(date)+".txt");
									if(!limit_1.exists()) {
										try {
											limit_1.createNewFile();
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										try {
											fw=new FileWriter(UserTest.userArrayList.get(i).userAccount+" "+time.format(date)+".txt");
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										try {
											fw.write("1");
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
									else {
										try {
											fr=new FileReader(UserTest.userArrayList.get(i).userAccount+" "+time.format(date)+".txt");
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
										int times=Integer.parseInt(A);
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
										times++;
										try {
											fw=new FileWriter(UserTest.userArrayList.get(i).userAccount+" "+time.format(date)+".txt");
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										try {
											fw.write(times+"");
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
								}
							}
							if(f!=1) {
								tf_name.setText("");
								pf_pass.setText("");
								diag_message.setLocationRelativeTo(null);
								diag_message.setVisible(true);
								lb_message.setText("请注意：您输入的账号或密码有误，请检查后再试！");
								lb_message.setFont(new Font("楷体",Font.BOLD,20));
							}
						}
					}
					else {//
						int f=0;
						for(int i=0;i<UserTest.userArrayList.size();i++) {
							if((tf_name.getText()).equals(UserTest.userArrayList.get(i).userAccount)&&(String.valueOf(pf_pass.getPassword())).equals(UserTest.userArrayList.get(i).password)) {
								f=1;
								UserTest.currentUserAccount=UserTest.userArrayList.get(i);
								UserTest.currentUserFile=new File(UserTest.currentUserAccount.userAccount+".txt");//当前用户操作文件
								File limit_transfer=new File(UserTest.currentUserAccount.userAccount+" "+time.format(date)+"transfer.txt");
								File historyOfAll=new File("historyOfAll.txt");
								File recentFund=new File("recentFund.txt");
								File administratorFile=new File("administratorFile.txt");
								if(!UserTest.currentUserFile.exists()) {
									try {
										UserTest.currentUserFile.createNewFile();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									try {
										fw=new FileWriter(UserTest.currentUserAccount.userAccount+".txt");
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
								if(!limit_transfer.exists()) {
									try {
										limit_transfer.createNewFile();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									try {
										fw=new FileWriter(UserTest.currentUserAccount.userAccount+" "+time.format(date)+"transfer.txt");
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									try {
										fw.write("0");
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
								if(!administratorFile.exists()) {
									try {
										administratorFile.createNewFile();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									try {
										fw=new FileWriter("administratorFile.txt");
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									try {
										fw.write("000000 000000 400000.00\r\n");
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
								tf_name.setText("");
								pf_pass.setText("");
								new UserInterface();
								UserInterface.main(args);
							}
							if((tf_name.getText()).equals(UserTest.userArrayList.get(i).userAccount)&&!(String.valueOf(pf_pass.getPassword())).equals(UserTest.userArrayList.get(i).password)) {
								f=2;
								File limit_1=new File(UserTest.userArrayList.get(i).userAccount+" "+time.format(date)+".txt");
								if(!limit_1.exists()) {
									try {
										limit_1.createNewFile();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									try {
										fw=new FileWriter(UserTest.userArrayList.get(i).userAccount+" "+time.format(date)+".txt");
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									try {
										fw.write("1");
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
								else {
									try {
										fr=new FileReader(UserTest.userArrayList.get(i).userAccount+" "+time.format(date)+".txt");
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
									int times=Integer.parseInt(A);
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
									times++;
									try {
										fw=new FileWriter(UserTest.userArrayList.get(i).userAccount+" "+time.format(date)+".txt");
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									try {
										fw.write(times+"");
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
							}
						}
						if(f!=1) {
							tf_name.setText("");
							pf_pass.setText("");
							diag_message.setLocationRelativeTo(null);
							diag_message.setVisible(true);
							lb_message.setText("请注意：您输入的账号或密码有误，请检查后再试！");
							lb_message.setFont(new Font("楷体",Font.BOLD,20));
						}
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
					mainJFrame_1.dispose();
					MainInterface.main(args);
				}
			}
		});
		mainJFrame_1.setVisible(true);
	}
}