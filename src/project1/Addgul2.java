package project1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import javaswingdev.GradientDropdownMenu;
import javaswingdev.MenuEvent;
import project1.EditButton.Main5_2;

public class Addgul2 extends JFrame implements ActionListener {

	JButton[] jbtn;
	
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
	
	public Addgul2() {
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
		ImagePanel jp = new ImagePanel(new ImageIcon("image/team100.png").getImage());
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
						new EditButton();
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
					
					}if (menu.getMenuNameAt(index, subIndex).trim().equals("학생편집")) {
							dispose();
							new StudentEdit();
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
					if(menu.getMenuNameAt(index, subIndex).trim().equals("학생 편집")) {
		        		
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("포인트 리셋")) {
		        		new resetPoint();
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
				
				jbtn = new JButton[arraylist.size()]; // 각 팀원 수 마다 버튼배열 객체 생성해서 원소로 팀원버튼 각각 생성
				jbtn1 = new JButton[4]; // 각 팀원 수 마다 버튼배열 객체 생성해서 원소로 팀원버튼 각각 생성
				
				
				// 귤 줄 이름 버튼 나열 및 액션리스너
				for (int i=0; i<arraylist.size(); i++, x+=115) { // 팀원 수 만큼 반복
					Font font = new Font("함초롱바탕", Font.BOLD, 15); 
					jbtn[i] = new JButton(arraylist.get(i));
					jbtn[i].setBounds(x, y, 90, 30);
					jbtn[i].setFont(font); // 폰트 설정
					jbtn[i].setForeground(Color.black); // 폰트 컬러
					jbtn[i].setBackground(new Color(255,190,60)); // 버튼 색
					jbtn[i].setUI(new StyledButtonUI()); // 버튼디자인UI 설정
					jp.add(jbtn[i]);
					// System.out.println(jbtn[i].getText()); // 눌린 버튼의 text값 가져오기
					jbtn[i].addActionListener(this); // 이벤트 메소드 호출
				} // 팀원 수 만큼 반복문
				y += 100; // y좌표는 한 팀씩 반복이 끝나면 밑으로 내려와서 다시 출력해야 하므로 증가
				x = 30; // x좌표는 처음시작 위치로 변경
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
		
	} // Addgul()
	

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(e.getActionCommand());
		if (e.getActionCommand().equals("김예중")) {
			EditButton.total2 = 0;
			new Main5_2(0);
		} else if (e.getActionCommand().equals("김현재")) {
			EditButton.total2 = 1;
			new Main5_2(1);
		} else if (e.getActionCommand().equals("박성민")) {
			EditButton.total2 = 2;
			new Main5_2(2);
		} else if (e.getActionCommand().equals("김하영")) {
			EditButton.total2 = 3;
			new Main5_2(3);
		} else if (e.getActionCommand().equals("김민경")) {
			EditButton.total2 = 4;
			new Main5_2(4);
		} else if (e.getActionCommand().equals("한송의")) {
			EditButton.total2 = 5;
			new Main5_2(5);
		} else if (e.getActionCommand().equals("이병훈")) {
			EditButton.total2 = 6;
			new Main5_2(6);
		// -------------------------------------------
		} else if (e.getActionCommand().equals("장인우")) {
			EditButton.total2 = 7;
			new Main5_2(7);
		} else if (e.getActionCommand().equals("이우철")) {
			EditButton.total2 = 8;
			new Main5_2(8);
		} else if (e.getActionCommand().equals("최진혁")) {
			EditButton.total2 = 9;
			new Main5_2(9);
		} else if (e.getActionCommand().equals("한희원")) {
			EditButton.total2 = 10;
			new Main5_2(10);
		} else if (e.getActionCommand().equals("임혁재")) {
			EditButton.total2 = 11;
			new Main5_2(11);
		} else if (e.getActionCommand().equals("이지예")) {
			EditButton.total2 = 12;
			new Main5_2(12);
		// -----------------------------------------
		} else if (e.getActionCommand().equals("이상주")) {
			EditButton.total2 = 13;
			new Main5_2(13);
		} else if (e.getActionCommand().equals("장다빈")) {
			EditButton.total2 = 14;
			new Main5_2(14);
		} else if (e.getActionCommand().equals("조현지")) {
			EditButton.total2 = 15;
			new Main5_2(15);
		} else if (e.getActionCommand().equals("정단비")) {
			EditButton.total2 = 16;
			new Main5_2(16);
		} else if (e.getActionCommand().equals("전선민")) {
			EditButton.total2 = 17;
			new Main5_2(17);
		} else if (e.getActionCommand().equals("이도일")) {
			EditButton.total2 = 18;
			new Main5_2(18);
		// ---------------------------------------
		} else if (e.getActionCommand().equals("이세창")) {
			EditButton.total2 = 19;
			new Main5_2(19);
		} else if (e.getActionCommand().equals("서경신")) {
			EditButton.total2 = 20;
			new Main5_2(20);
		} else if (e.getActionCommand().equals("최윤이")) {
			EditButton.total2 = 21;
			new Main5_2(21);
		} else if (e.getActionCommand().equals("이은석")) {
			EditButton.total2 = 22;
			new Main5_2(22);
		} else if (e.getActionCommand().equals("이승준")) {
			EditButton.total2 = 23;
			new Main5_2(23);
		} else if (e.getActionCommand().equals("제민규")) {
			EditButton.total2 = 24;
			new Main5_2(24);
		}
	}
	
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
	
	// 버튼 디자인
	class StyledButtonUI extends BasicButtonUI {

	    @Override
	    public void installUI (JComponent c) {
	        super.installUI(c);
	        AbstractButton button = (AbstractButton) c;
	        button.setOpaque(false);
	        button.setBorder(new EmptyBorder(5, 15, 5, 15));
	    }
	    
	    @Override
	    public void paint (Graphics g, JComponent c) {
	        AbstractButton b = (AbstractButton) c;
	        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
	        super.paint(g, c);
	    }

	    private void paintBackground (Graphics g, JComponent c, int yOffset) {
	        Dimension size = c.getSize();
	        Graphics2D g2 = (Graphics2D) g;
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g.setColor(c.getBackground().darker());
	        g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
	        g.setColor(c.getBackground());
	        g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
	    }
	}
	
} // test3
