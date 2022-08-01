package Test_code;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class test2 extends JFrame { // 팀별 새로배치, 귤주기 에서 학생들 이름버튼 나열 (액션리스너 추가해야 함(Main5_1(귤주는 메소드)과 연결해야 함))
	
	// con 연결
	// 이름 가져와 ArrayList 만들기
	// 4번 반복하기
	// 배치하기
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "12345");
			return con;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결 실패");
			return null;
		}
	}
	
	public test2() {
		Connection con = null;
		PreparedStatement select= null;
		ResultSet rs = null;
		final int teamnumber = 4;
		
		// 학생 이름 담는 배열
		ArrayList<String> arraylist = new ArrayList<>();
		
		 // Main5_1 메소드를 actionlistener 내부에서 호출하기 위한 final배열
		final ArrayList<Integer> student_number = new ArrayList<>();
		
		// 버튼 붙일 패널 생성
		JPanel jp = new JPanel();
		jp.setBounds(50, 50, 700, 500);
		jp.setBackground(Color.cyan);
		
		try {
			con = getConnection();
			int x=100, y=50;
			for (int j=0; j<teamnumber; j++) {
				String sql = "select studentname from team"+(j+1);
				select = con.prepareStatement(sql);
				rs = select.executeQuery();
				
				while (rs.next()) {
					arraylist.add(rs.getString("studentname"));
				}
				// JLabel일 때 마지막 꺼가 이상하게 값이 들어가는데 해결하고 싶다
//				arraylist.add(""); // JLabel 이름 출력 용도
				
				System.out.println(arraylist);
				
//				setBounds(100, 100, 600, 600); // JLabel 이름 출력 용도
				setBounds(0, 0, 800, 700);
				setVisible(true);
				setResizable(false);
				
				JButton[] jbtn = new JButton[arraylist.size()];
				
//				JLabel[] jlabel = new JLabel[arraylist.size()]; // JLabel 이름 출력 용도
				
				// 귤 줄 이름 버튼 나열 및 액션리스너
				for (int i=0; i<arraylist.size(); i++, y+=70) {
					Font font = new Font("맑은고딕", Font.BOLD, 15);
//					jlabel[i] = new JButton(arraylist.get(i)); // JLabel 이름 출력 용도
					jbtn[i] = new JButton(arraylist.get(i));
//					jlabel[i].setBounds(x, y, 70, 100); // JLabel 이름 출력 용도
					jbtn[i].setBounds(x, y, 100, 30);
					jbtn[i].setFont(font);
//					add(jlabel[i]); // JLabel 이름 출력 용도
					jp.add(jbtn[i]);
					
					student_number.add(i);
					
					jbtn[i].addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(null, "안녕하세요?");
							// 지역변수가 final변수가 들어와야 함. 근데 total_student_num은 하나씩 증가하는 값인데 
//							new Main5_1(arraylist.get(i));
//							new Main5_1((int)student_number.get(i));
							
						}
					});
					
				}
				x += 150;
				y = 50;
				arraylist.clear();
			}
			
			add(jp);
			
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
		}
	}
	
	public static void main(String[] args) {
		new test2();
	}
}
