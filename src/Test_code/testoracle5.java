package Test_code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class testoracle5 {
	public static void main(String[] args) {
		//DB와 연결하기 위한 객체
				Connection con = null; //지역변수 (반드시 초기화)
				
				//SQL문장을 사용하기 위한 Statement객체
				Statement st = null;
				
				try{
				// 1. 드라이버 로딩
				//지정된 스트링명을 가지는 클래스 또는 인터페이스에 경로를 돌려준다.
				Class.forName("oracle.jdbc.OracleDriver"); 

				// 2. DB연결
				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe", "system", "12345");

				// 3. Statement 얻기
				Scanner scan = new Scanner(System.in);
				int stno = scan.nextInt();
				String stname = scan.next();
				int stp = scan.nextInt();
				int stt = scan.nextInt();
				String sql = "insert into team1 values(stno, stname, stp, stt)";
				st = con.createStatement();
				    
				// 4. 구문 실행
				st.executeUpdate(sql);
				System.out.println("입력성공");

				}catch(Exception e){
					
				  e.printStackTrace();
				  
				}finally{
					
				  try{
				     if(st != null)
				       st.close();
				     if(con != null)
				       con.close();
				  }catch(Exception e){}
				  
				}
}

}
