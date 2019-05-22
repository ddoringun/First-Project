package projectP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import projectP.MemberDTO;

public class WalletMemDAO {
	String url = "jdbc:mysql://localhost:3306/wallet";
	String user = "root";
	String password = "1234";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	static int num = 0;
	
	public ArrayList selectAll() {

		ArrayList list = new ArrayList();
		MemberDTO dto = null; 
		// 1. 드라이버 설정
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 ok!!");
			
			// 2. DB연결
			con = DriverManager.getConnection(url, user, password); // Stream생성 (네트워크 통신 가능)
			// ↑ 받아와야함  con이 null 상태이기 때문에
			System.out.println("2. DB연결 ok!!");
			
			// 3. SQL문 결정(객체화)
			String sql = "select * from member";  // 조건이 없으면 setString도 지워야함!!!
			ps = con.prepareStatement(sql);
			System.out.println("3. SQL문 객체화 ok!!");
			
			// 4. SQL문 전송
			rs = ps.executeQuery();
			System.out.println("4. SQL문 전송 ok!!");
			// 5. SQL문 결과가 있으면 받아서 처리
			while(rs.next()) { // while이 돌 때 마다 dto가 생성되고 ArrayList에 붙이게 됨
				dto = new MemberDTO();  //기본생성자 만들어줘야함
				String id = rs.getString(2);
				String pw = rs.getString(3);
				String name = rs.getString(4);
				String email = rs.getString(5);
				String home = rs.getString(6);
				String gender = rs.getString(7);
				int age = rs.getInt(8);
				dto.setId(id);
				dto.setPw(pw);
				dto.setName(name);
				dto.setEmail(email);
				dto.setHome(home);
				dto.setGender(gender);
				dto.setAge(age);
				
				list.add(dto); //dto의 주소
				
			}//while end	
			
		} catch (Exception e) { // 다 잡아버림 -> 모든 에러처리
			System.out.println("DB처리 중 에러 발생...");
			System.out.println(e.getMessage());
		} finally {
			// 에러 발생여부와 상관없이 무조건 실행해야 하는 코드 (강제성)
			// 작은 범위부터 close해야함
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
//				e.printStackTrace();
				System.out.println("자원 해제 중 에러발생!!!");
			} // catch
		} // try-catch-finally
		
		
		
		return list;
	}
	
	public void insert(WalletMemDTO dto) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 ok!!");
			
			con = DriverManager.getConnection(url, user, password); // Stream생성 (네트워크 통신 가능)
			System.out.println("2. DB연결 ok!!");
			
			String sql = "insert into member values(?,?,?,?,?,?,?,?)";  // 조건이 없으면 setString도 지워야함!!!
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, num);
			num++;
			ps.setString(2, dto.getId());
			System.out.println(dto.getId());
			ps.setString(3, dto.getPw());
			ps.setString(4, dto.getName());
			ps.setString(5, dto.getEmail());
			ps.setString(6, dto.getHome());
			ps.setString(7, dto.getGender());
			ps.setInt(8, dto.getAge());
			
			System.out.println("3. SQL문 객체화 ok!!");
			
			ps.executeUpdate();
			System.out.println("4. SQL문 전송 ok!!");
			
		} catch (Exception e) { // 다 잡아버림 -> 모든 에러처리
			System.out.println("DB처리 중 에러 발생...");
			System.out.println(e.getMessage());
		}
		
	} //end insert
	
	public boolean LoginCheck (String InputId, String InputPw) throws Exception {
		MemberDTO dto = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버 설정 ok!!");
		
		con = DriverManager.getConnection(url, user, password); 
		System.out.println("2. DB연결 ok!!");
		
		String sql = "select * from member where id = ? and pw = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, InputId);
		ps.setString(2, InputPw);
		
		rs = ps.executeQuery();
		
		boolean check = false;
		
		if(rs.next()) {
			check = true;
		} else {
			check = false;
		}
		
		return check;
	}
	
	
}






































