package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class resetPoint {
	
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
	
	public resetPoint() {
		
		Connection con = null;
		PreparedStatement select1=null, select2=null, select3=null, select4=null;
		ResultSet rs = null;
		
		ImageIcon icon = new ImageIcon("image/reset_icon.jpg");
		
		int input = JOptionPane.showConfirmDialog(null, "포인트를 초기화 하시겠습니까?", 
		"포인트 초기화", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE, icon);
		
		if (input==0) {
			try {
				con = getConnection();
				String sql1 = "update team1 set studentpoint=0";
				select1 = con.prepareStatement(sql1);
				rs = select1.executeQuery();
				
				String sql2 = "update team2 set studentpoint=0";
				select2 = con.prepareStatement(sql2);
				rs = select2.executeQuery();
				
				String sql3 = "update team3 set studentpoint=0";
				select3 = con.prepareStatement(sql3);
				rs = select3.executeQuery();
				
				String sql4 = "update team4 set studentpoint=0";
				select4 = con.prepareStatement(sql4);
				rs = select4.executeQuery();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					select1.close();
					select2.close();
					select3.close();
					select4.close();
					con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
					System.out.println("con close에 문제 발생");
				}
			}
			
			JOptionPane.showMessageDialog(null, "포인트를 초기화했습니다\n다시 조회해주세요");
			
		} else if (input==1) {
			JOptionPane.showMessageDialog(null, "초기화를 취소했습니다");
		}
		
	}
	
}
