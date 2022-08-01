package Test_code;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class test extends JFrame { // 팀 페이지에서 학생들 이름과 포인트 나열 (총점, 환전기능 아직 구현X)
	
	// 오라클 연동 함수
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
	
	public test() {
		Connection con = null;
		PreparedStatement select= null; // Statement는 Query 작업을 실행하기 위한 객체.
		PreparedStatement select2= null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		// db에서 가져온 학생이름 담을 리스트 생성 
		ArrayList<String> arraylist = new ArrayList<>();
		// db에서 가져온 포인트점수 담을 리스트 생성
		ArrayList<String> arraylist2 = new ArrayList<>();
		
		try {
			// 연결
			con = getConnection();
			// sql문 - team1에서 학생들 이름을 조회해
			String sql = "select studentname, studentpoint from team1";
			// sql을 db에 보내기 위해 객체 생성
			select = con.prepareStatement(sql);
			// sql문 실행
			rs = select.executeQuery();
			// 실행되어 반환된 결과 테이블(모양)에서 "studentname"이라는 이름의 컬럼 값을 하나씩 가져온다 
			while (rs.next()) {
				arraylist.add(rs.getString("studentname"));
				arraylist2.add(rs.getString("studentpoint"));
			}
			rs2 = select.executeQuery();
			// 실행되어 반환된 결과 테이블(모양임)에서 "studentpoint"이라는 이름의 컬럼 값을 하나씩 가져온다

			// arraylist에 값이 잘 들어갔는지 조회 - [김예중, 김현재, 박성민, 김하영, 김민경, 한송의, 이병훈]
			System.out.println(arraylist);
			// arraylist2에 값이 잘 들어갔는지 조회 - [13, 7, 0, 0, 0, 0, 0]
			System.out.println(arraylist2);
			 
			// 각 ArrayList에 마지막 원소를 넣으면 깨지는 것이 해결되는 것 처럼 보임! 근데 근본적인 해결방법을 찾고 싶다
//			arraylist.add("");
//			arraylist2.add("");
			
			setBounds(10, 10, 800, 800);
			setVisible(true);
			Font font = new Font("맑은고딕", Font.BOLD, 20);
			
			// 버튼 붙일 패널 생성
			JPanel jp = new JPanel();
//			jp.setBounds(50, 50, 700, 500);
			jp.setBounds(0, 0, 800, 800);
//			jp.setBackground(Color.cyan);
			jp.setVisible(true);
			
			// 이름을 담아서 뿌릴 JLabel 객체 arraylist의 크기만큼 생성
			JLabel[] jlabel = new JLabel[arraylist.size()];
			JLabel[] jlabel2 = new JLabel[arraylist2.size()];
			
			for (int i=0, y=50; i<arraylist.size(); i++, y+=70) {
				jlabel[i] = new JLabel(arraylist.get(i));
				jlabel[i].setBounds(100, y, 70, 50);
//				jlabel[i].setOpaque(true);
//				jlabel[i].setBackground(new Color(0XFFD900));
				
				jlabel2[i] = new JLabel(arraylist2.get(i) + " 개");
				jlabel2[i].setBounds(350, y, 70, 50);
//				jlabel2[i].setOpaque(true);
//				jlabel2[i].setBackground(new Color(0XFFD700));
				
				jlabel[i].setFont(font);
				jlabel2[i].setFont(font);
				
				jp.add(jlabel[i]);
				jp.add(jlabel2[i]);
				
				add(jlabel[i]);
				add(jlabel2[i]);
				
				add(jp);
			}
//			for (int i=0, y=50; i<arraylist2.size(); i++, y+=100) {
//				jlabel2[i] = new JLabel(arraylist2.get(i) + " 개");
//				jlabel2[i].setBounds(200, y, 70, 50);
//				jlabel2[i].setOpaque(true);
//				jlabel2[i].setBackground(new Color(0XAAD900));
//				jlabel2[i].setFont(font);
////				add(jlabel2[i]);
//				jp.add(jlabel2[i]);
//				add(jp);
//			}
			
			
			System.out.println("끝!");
			
			addWindowListener(new WindowAdapter() { // x로 화면닫기 구현
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
		new test();
	}
}
