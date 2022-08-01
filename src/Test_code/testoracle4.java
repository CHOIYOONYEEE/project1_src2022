package Test_code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class testoracle4 {

	public static void main(String[] args) {

		Connection con = null; // 지역변수 (반드시 초기화)

		// SQL문장을 사용하기 위한 Statement객체
		Statement st = null;

		try {
			// 1. 드라이버 로딩
			// 지정된 스트링명을 가지는 클래스 또는 인터페이스에 경로를 돌려준다.
			Class.forName("oracle.jdbc.OracleDriver");

			// 2. DB연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "12345");

			// 3. Statement 얻기
			String sql = "update team1 set studentname ='귤' where studentname = '이지예'";
			st = con.createStatement();

			// 4. 구문 실행
			st.executeUpdate(sql);
			System.out.println("입력성공");

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}

		}
	}

}
