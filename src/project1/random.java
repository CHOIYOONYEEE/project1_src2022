package project1;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.management.remote.JMXAddressable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;

public class random extends JFrame {

	JTextField name, age;// 클래스 변수로 선언.
	JLabel lbtitle;
	Font font = new Font("휴먼모음T", Font.PLAIN, 17);
	static int total2;
	
	public static Connection getConnection() {  
		try {
			String user = "system";
			String pw = "12345";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pw);
			System.out.println("연결성공");
			return con;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	static class Main5_1 extends JFrame {
		static int[] total = new int[25];
		static int total3;//1조 총점
		static int total4;//2조 총점
		static int total5;//3조 총점
		static int total6;//4조 총점

		// 버튼이 눌러지면 만들어지는 새 창을 정의한 클래스
		public Main5_1(int a) {
			// 주의, 여기서 setDefaultCloseOperation() 정의를 하지 말아야 한다
			// 정의하게 되면 새 창을 닫으면 모든 창과 프로그램이 동시에 꺼진다
			JFrame p1 = new JFrame();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 서브 프레임 종료버튼 생성
			p1.setTitle("귤");
			p1.setBounds(100, 100, 427, 250);
			p1.setLayout(new FlowLayout());
			p1.setLocationRelativeTo(null);
			JButton btn1 = new JButton(new ImageIcon("image/+.png"));
			JButton btn2 = new JButton(new ImageIcon("image/-.png"));
			btn1.setPreferredSize(new Dimension(200, 200));
			btn2.setPreferredSize(new Dimension(200, 200));
			p1.add(btn1);
			p1.add(btn2);
			p1.setVisible(true);

			btn1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int point = Integer.parseInt(JOptionPane.showInputDialog(null, "몇개 줄까요?"));

					Connection con = null;
					PreparedStatement update = null;
					PreparedStatement select= null;
					ResultSet rs = null;
					
					if (random.total2 == 0 || random.total2 == 1 || random.total2 == 2 || random.total2 == 3
							|| random.total2 == 4 || random.total2 == 5 || random.total2 == 6) {
							try {
								con = getConnection(); // con = null, build path에 jar 추가하지 않으면 con에 null들어옴! Statement url인가 거기서 가져오려면 jar이 있어야함
								String sql = "update team1 set StudentPoint=? where StudentNo=?";
								update = con.prepareStatement(sql);
								
								String sql1 = "select StudentPoint from team1 where StudentNo=?";
								select = con.prepareStatement(sql1);
								select.setString(1,String.valueOf(total2));
								rs = select.executeQuery();
								while(rs.next()) {
									String str1 = rs.getString(1);
									total[a]=Integer.parseInt(str1);
								}
								update.setString(1, String.valueOf(total[a]+=point));
								update.setInt(2,random.total2);
								update.executeUpdate();
								
								System.out.println("데이터 업데이트 완료");
								
							}catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
							}
							
							try {
								con = getConnection();
								String sql = "update total set team1= ?";
								update = con.prepareStatement(sql);
								
								String sql1 = "select team1 from total";
								select = con.prepareStatement(sql1);
								rs = select.executeQuery();
								while(rs.next()) {
									String str1 = rs.getString(1);
									total3 = Integer.parseInt(str1);
								}
								update.setString(1, String.valueOf(total3+point));
								update.executeUpdate();
								System.out.println("데이터 업데이트 완료");
							} catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
							}
						}

						else if (random.total2 == 7 || random.total2 == 8 || random.total2 == 9 || random.total2 == 10
								|| random.total2 == 11 || random.total2 == 12) {
						
							try {
								con = getConnection();
								String sql = "update team2 set StudentPoint=? where StudentNo=?";
								update = con.prepareStatement(sql);
								
								String sql1 = "select StudentPoint from team2 where StudentNo=?";
								select = con.prepareStatement(sql1);
								select.setString(1,String.valueOf(total2));
								rs = select.executeQuery();
								
								while(rs.next()) {
									String str1 = rs.getString(1);
									total[a]=Integer.parseInt(str1);
								}
								update.setString(1, String.valueOf(total[a]+=point));
								update.setInt(2,random.total2);
								update.executeUpdate();
								System.out.println("데이터 업데이트 완료");
								
							}catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
							}
							
							try {
								con = getConnection();
								String sql = "update total set team2= ?";
								update = con.prepareStatement(sql);
								String sql1 = "select team2 from total";
								select = con.prepareStatement(sql1);
								rs = select.executeQuery();
								while(rs.next()) {
									String str1 = rs.getString(1);
									total4 = Integer.parseInt(str1);
								}
								update.setString(1, String.valueOf(total4+point));
								update.executeUpdate();
								System.out.println("데이터 업데이트 완료");
							} catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
							}
						}

						else if (random.total2 == 13 || random.total2 == 14 || random.total2 == 15 || random.total2 == 16
								|| random.total2 == 17 || random.total2 == 18) {
						
							try {
								con = getConnection();
								String sql = "update team3 set StudentPoint=? where StudentNo=?";
								update = con.prepareStatement(sql);
								
								String sql1 = "select StudentPoint from team3 where StudentNo=?";
								select = con.prepareStatement(sql1);
								select.setString(1,String.valueOf(total2));
								rs = select.executeQuery();
								
								while(rs.next()) {
									String str1 = rs.getString(1);
									total[a]=Integer.parseInt(str1);
								}
								update.setString(1, String.valueOf(total[a]+=point));
								update.setInt(2,random.total2);
								update.executeUpdate();
								System.out.println("데이터 업데이트 완료");
								
							}catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
							}
							
							try {
								con = getConnection();
								String sql = "update total set team3= ?";
								update = con.prepareStatement(sql);
								String sql1 = "select team3 from total";
								select = con.prepareStatement(sql1);
								rs = select.executeQuery();
								while(rs.next()) {
									String str1 = rs.getString(1);
									total5 = Integer.parseInt(str1);
								}
								update.setString(1, String.valueOf(total5+point));
								update.executeUpdate();
								System.out.println("데이터 업데이트 완료");
							} catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
							}
						

						} else if (random.total2 == 19 || random.total2 == 20 || random.total2 == 21 || random.total2 == 22
								|| random.total2 == 23 || random.total2 == 24) {

							try {
								con = getConnection();
								String sql = "update team4 set StudentPoint=? where StudentNo=?";
								update = con.prepareStatement(sql);
								
								String sql1 = "select StudentPoint from team4 where StudentNo=?";
								select = con.prepareStatement(sql1);
								select.setString(1,String.valueOf(total2));
								rs = select.executeQuery();
								
								while(rs.next()) {
									String str1 = rs.getString(1);
									total[a]=Integer.parseInt(str1);
								}
								update.setString(1, String.valueOf(total[a]+=point));
								update.setInt(2,random.total2);
								update.executeUpdate();
								System.out.println("데이터 업데이트 완료");
								
							}catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
							}
							
							try {
								con = getConnection();
								String sql = "update total set team4= ?";
								update = con.prepareStatement(sql);
								String sql1 = "select team4 from total";
								select = con.prepareStatement(sql1);
								rs = select.executeQuery();
								while(rs.next()) {
									String str1 = rs.getString(1);
									total6 = Integer.parseInt(str1);
								}
								update.setString(1, String.valueOf(total6+point));
								update.executeUpdate();
								System.out.println("데이터 업데이트 완료");
							} catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
							}
						}
					}
			});

			btn2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int mpoint = Integer.parseInt(JOptionPane.showInputDialog(null, "몇개 뺏을까요?"));
					Connection con = null;
					PreparedStatement update = null;
					PreparedStatement select= null;
					ResultSet rs = null;
					
					if (random.total2 == 0 || random.total2 == 1 || random.total2 == 2 || random.total2 == 3
							|| random.total2 == 4) {

						try {
							con = getConnection();
							String sql = "update team1 set StudentPoint=? where StudentNo=?";
							update = con.prepareStatement(sql);
							
							String sql1 = "select StudentPoint from team1 where StudentNo=?";
							select = con.prepareStatement(sql1);
							select.setString(1,String.valueOf(total2));
							rs = select.executeQuery();
							
							while(rs.next()) {
								String str1 = rs.getString(1);
								total[a]=Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total[a]-=mpoint));
							update.setInt(2,random.total2);
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
							
						}catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
						
						try {
							con = getConnection();
							String sql = "update total set team1= ?";
							update = con.prepareStatement(sql);
							String sql1 = "select team1 from total";
							select = con.prepareStatement(sql1);
							rs = select.executeQuery();
							while(rs.next()) {
								String str1 = rs.getString(1);
								total3 = Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total3-mpoint));
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
					}

					else if (random.total2 == 5 || random.total2 == 6 || random.total2 == 7 || random.total2 == 8
							|| random.total2 == 9) {
						
						try {
							con = getConnection();
							String sql = "update team2 set StudentPoint=? where StudentNo=?";
							update = con.prepareStatement(sql);
							
							String sql1 = "select StudentPoint from team2 where StudentNo=?";
							select = con.prepareStatement(sql1);
							select.setString(1,String.valueOf(total2));
							rs = select.executeQuery();
							
							while(rs.next()) {
								String str1 = rs.getString(1);
								total[a]=Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total[a]-=mpoint));
							update.setInt(2,random.total2);
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
							
						}catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
						
						try {
							con = getConnection();
							String sql = "update total set team2= ?";
							update = con.prepareStatement(sql);
							String sql1 = "select team2 from total";
							select = con.prepareStatement(sql1);
							rs = select.executeQuery();
							while(rs.next()) {
								String str1 = rs.getString(1);
								total4 = Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total4-mpoint));
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
					}

					else if (random.total2 == 10 || random.total2 == 11 || random.total2 == 12 || random.total2 == 13
							|| random.total2 == 14) {

						try {
							con = getConnection();
							String sql = "update team3 set StudentPoint=? where StudentNo=?";
							update = con.prepareStatement(sql);
							
							String sql1 = "select StudentPoint from team3 where StudentNo=?";
							select = con.prepareStatement(sql1);
							select.setString(1,String.valueOf(total2));
							rs = select.executeQuery();
							
							while(rs.next()) {
								String str1 = rs.getString(1);
								total[a]=Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total[a]-=mpoint));
							update.setInt(2,random.total2);
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
							
						}catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
						try {
							con = getConnection();
							String sql = "update total set team3= ?";
							update = con.prepareStatement(sql);
							String sql1 = "select team3 from total";
							select = con.prepareStatement(sql1);
							rs = select.executeQuery();
							while(rs.next()) {
								String str1 = rs.getString(1);
								total5 = Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total5-mpoint));
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
					}
					else if (random.total2 == 15 || random.total2 == 16 || random.total2 == 17 || random.total2 == 18
							|| random.total2 == 19) {

						try {
							con = getConnection();
							String sql = "update team4 set StudentPoint=? where StudentNo=?";
							update = con.prepareStatement(sql);
							
							String sql1 = "select StudentPoint from team4 where StudentNo=?";
							select = con.prepareStatement(sql1);
							select.setString(1,String.valueOf(total2));
							rs = select.executeQuery();
							
							while(rs.next()) {
								String str1 = rs.getString(1);
								total[a]=Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total[a]-=mpoint));
							update.setInt(2,random.total2);
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
							
						}catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
						
						try {
							con = getConnection();
							String sql = "update total set team4= ?";
							update = con.prepareStatement(sql);
							String sql1 = "select team4 from total";
							select = con.prepareStatement(sql1);
							rs = select.executeQuery();
							while(rs.next()) {
								String str1 = rs.getString(1);
								total6 = Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total6-mpoint));
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
					}

				}
			});
		}
	}
//	class Listener implements ActionListener {
//		JFrame frame;
//
//		public Listener(JFrame f) {
//			frame = f;
//		}
//
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			int random;
//			random = (int) (Math.random() * 20);
//			if (random == 0) {
//				JOptionPane.showMessageDialog(frame, "이태주 당첨!");
//			} else if (random == 1) {
//				JOptionPane.showMessageDialog(frame, "김희선 당첨!");
//			} else if (random == 2) {
//				JOptionPane.showMessageDialog(frame, "강아름 당첨!");
//			} else if (random == 3) {
//				JOptionPane.showMessageDialog(frame, "최만민 당첨!");
//			} else if (random == 4) {
//				JOptionPane.showMessageDialog(frame, "육근우 당첨!");
//			} else if (random == 5) {
//				JOptionPane.showMessageDialog(frame, "이해민 당첨!");
//			} else if (random == 6) {
//				JOptionPane.showMessageDialog(frame, "윤근혁 당첨!");
//			} else if (random == 7) {
//				JOptionPane.showMessageDialog(frame, "강승재 당첨!");
//			} else if (random == 8) {
//				JOptionPane.showMessageDialog(frame, "최창현 당첨!");
//			} else if (random == 9) {
//				JOptionPane.showMessageDialog(frame, "박소현 당첨!");
//			} else if (random == 10) {
//				JOptionPane.showMessageDialog(frame, "이태주 당첨!");
//			} else if (random == 11) {
//				JOptionPane.showMessageDialog(frame, "한승수 당첨!");
//			} else if (random == 12) {
//				JOptionPane.showMessageDialog(frame, "정광용 당첨!");
//			} else if (random == 13) {
//				JOptionPane.showMessageDialog(frame, "이수진 당첨!");
//			} else if (random == 14) {
//				JOptionPane.showMessageDialog(frame, "도상원 당첨!");
//			} else if (random == 15) {
//				JOptionPane.showMessageDialog(frame, "장동훤 당첨!");
//			} else if (random == 16) {
//				JOptionPane.showMessageDialog(frame, "심왕원 당첨!");
//			} else if (random == 17) {
//				JOptionPane.showMessageDialog(frame, "정현우 당첨!");
//			} else if (random == 18) {
//				JOptionPane.showMessageDialog(frame, "남석현 당첨!");
//			} else if (random == 19) {
//				JOptionPane.showMessageDialog(frame, "정민아 당첨!");
//			}
//		}
//	}

	class ImagePanel extends JPanel {
		private Image img;

		public ImagePanel(Image img) {
			this.img = img;
			setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setLayout(null);
		}

		public int getWidth() {

			return img.getWidth(null); // 이미지 가로 넓이
		}

		public int getHeight() {

			return img.getHeight(null);
		}

		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}

}