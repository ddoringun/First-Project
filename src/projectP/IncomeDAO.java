package projectP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class IncomeDAO {
	static int num = 0;
	String url = "jdbc:mysql://localhost:3306/wallet";
	String user = "root";
	String password = "1234";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String date;

	public void insert(String InputMemo, String InputDate, int InputIncome, String InputCategory) throws Exception {
		
		IncomeDTO dto = new IncomeDTO();
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		date = sdf.toString();
		
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("연결 확인");

		con = DriverManager.getConnection(url, user, password);
		System.out.println(dto.category);
		System.out.println("연결 승인");

		String sql = "insert into income values(?,?,?,?,?,?)";
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, num);
		num++;
		ps.setString(2, InputDate);
		ps.setInt(3, InputIncome);
		
		String myCate = InputCategory;
		if (myCate.equals("월       급")) {
			InputCategory = "salary";
		} else if(myCate.equals("용       돈")) {
			InputCategory = "allow";
		} else if(myCate.equals("기       타")){
			InputCategory = "etc";
		} else if(myCate.equals("초 기 자 본")) {
			InputCategory = "startMoney";
		}
		ps.setString(4, InputCategory);
		ps.setString(5, InputMemo);
		ps.setString(6, Login.myId);
		
		ps.executeUpdate();
		System.out.println("쿼리문 처리 완료");
		
		ps.close();
		con.close();
	}
}
