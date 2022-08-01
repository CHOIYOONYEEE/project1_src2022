package Test_code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javaswingdev.GradientDropdownMenu;
import javaswingdev.MenuEvent;
import project1.SelectTeam1;
import project1.SelectTeam2;
import project1.SelectTeam3;
import project1.SelectTeam4;
import project1.random;
import project1.sub;
//import project1.random.Main5_1;

public class test3 extends JFrame { // 귤 추가 화면

	static int count = 0;
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "12345");
			return con;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public test3() {
		Connection con = null;
		PreparedStatement select= null;
		ResultSet rs = null;
		final int teamnumber = 4;
		
		// 학생 이름 담는 배열
		ArrayList<String> arraylist = new ArrayList<>();
		// 버튼 붙일 패널 생성
//		JPanel jp = new JPanel();
//		jp.setBounds(20, 20, 850, 400);
//		jp.setBackground(Color.cyan);
		
		// 버튼 붙일 패널
		ImagePanel jp = new ImagePanel(new ImageIcon("image/sub.png").getImage());
//		JPanel jp = new JPanel(); // 조회데이터 라벨 붙일 패널 생성
		jp.setSize(850, 850);
		jp.setVisible(true);
		
		// 드랍다운 메뉴바
		GradientDropdownMenu menu = new GradientDropdownMenu();
		menu.setMenuHeight(70);
		menu.setGradientColor(new Color(230, 58, 58), new Color(200, 150, 30));
		menu.setBackground(new Color(0, 0, 0));
		menu.setHeaderGradient(true);
		menu.addItem("Home");
		menu.addItem("   ");
		menu.addItem("   ");
		menu.addItem("   ");
		menu.addItem("포인트 추가", "귤 추가");
		menu.addItem("팀별 현황", "화목한 조 현황", "코른이 대공원 현황", "조명은 LED 현황", "자료구조 현황");
		menu.addItem("포인트 게임", "랜덤 박스", "주사위", "경마");
		menu.addItem("테마", "Black", "Orange", "Green");
		menu.addItem("관리자 설정", "학생편집", "포인트 리셋");
		menu.applay(this);
		menu.addEvent((MenuEvent) new MenuEvent() {
			@Override
			public void selected(int index, int subIndex, boolean menuItem) {
				if (menuItem) {

					if (menu.getMenuNameAt(index, subIndex).trim().equals("Home")) {
						dispose();
						new sub();
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("귤 추가")) {
						new random();
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("화목한 조 현황")) {
						dispose();
						new SelectTeam1();
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("코른이 대공원 현황")) {
						dispose();
						new SelectTeam2();
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("조명은 LED 현황")) {
						dispose();
						new SelectTeam3();
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("자료구조 현황")) {
						dispose();
						new SelectTeam4();
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("Black")) {
						menu.setBackground(new Color(0, 0, 0));
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("Orange")) {
						menu.setBackground(new Color(230, 100, 10));
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("Green")) {
						menu.setBackground(new Color(25, 51, 0));
					}
				}
			}
		});
		
		try {
			con = getConnection();
			int x=25, y=250; // 버튼 좌표
			
			// 프레임 셋팅
			setBounds(0, 0, 850, 850); // (x, y): 화면에서 프레임 창 위치 (w, h): 프레임 창 크기
			setVisible(true);
			setLocationRelativeTo(null);
			setResizable(false);
			
			for (int j=0; j<teamnumber; j++) { // 팀 개수 만큼 반복
				String sql = "select studentname from team"+(j+1);
				select = con.prepareStatement(sql);
				rs = select.executeQuery();
				
				while (rs.next()) 
					arraylist.add(rs.getString("studentname"));
				
				JButton[] jbtn = new JButton[arraylist.size()]; // 각 팀원 수 마다 버튼배열 객체 생성해서 원소로 팀원버튼 각각 생성
				// 귤 줄 이름 버튼 나열 및 액션리스너
				for (int i=0; i<arraylist.size(); i++, x+=115) { // 팀원 수 만큼 반복
					Font font = new Font("함초롱바탕", Font.BOLD, 15); 
					jbtn[i] = new JButton(arraylist.get(i));
					jbtn[i].setBounds(x, y, 100, 30);
					jbtn[i].setFont(font);
					jp.add(jbtn[i]);
					jbtn[i].addActionListener(new ActionListener() { // 익명 클래스
						@Override
						public void actionPerformed(ActionEvent e) {
//							new Main5_1(count);
						}
					});
				} // 팀원 수 만큼 반복문
				y += 100; // y좌표는 한 팀씩 반복이 끝나면 밑으로 내려와서 다시 출력해야 하므로 증가
				x = 30; // x좌표는 처음시작 위치로 변경
				count++; // static변수 1씩증가로 모든 학생의 버튼이 Main5_1을 구현할 수 있도록
				arraylist.clear(); // 한 팀씩 반복이 끝나면 이름을 새로 받기위해 초기화
			} // 팀 개수만큼 반복문
			add(jp); // 패널 프레임에 부착
			
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				select.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("con close에 문제 발생");
			}
			
		} // finally
		
	} // test3()
	
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
	} // ImagePanel class
	
} // test3
