package projectP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class SpendDAO {

	static int num = 0;
	String url = "jdbc:mysql://localhost:3306/wallet";
	String user = "root";
	String password = "1234";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String date;

	public void insert(String InputMemo, String InputDate, int InputSpend, String InputCategory) throws Exception {
		
		SpendDTO dto = new SpendDTO();
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		date = sdf.toString();
		
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("연결 확인");

		con = DriverManager.getConnection(url, user, password);
		System.out.println(dto.getCategory());
		System.out.println("연결 승인");

		String sql = "insert into spend values(?,?,?,?,?,?)";
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, num);
		num++;
		ps.setString(2, InputDate);
		ps.setInt(3, InputSpend);
		
		String myCate = InputCategory;
		if(InputCategory.equals("식       비")) {
			myCate = "E";
		}else if(InputCategory.equals("교 통 비")) {
			myCate = "B";
		}else if(InputCategory.equals("주거/통신비")) {
			myCate = "HP";
		}else if(InputCategory.equals("생활용품")) {
			myCate = "HG";
		}else if(InputCategory.equals("의복/미용")) {
			myCate = "CB";
		}else if(InputCategory.equals("건강/문화")) {
			myCate = "HC";
		}else if(InputCategory.equals("교육/육아")) {
			myCate = "ED";
		}else if(InputCategory.equals("경조사/회비")) {
			myCate = "H";
		}else if(InputCategory.equals("세금/이자")) {
			myCate = "T";
		}else if(InputCategory.equals("용돈/기타")) {
			myCate = "A";
		}else if(InputCategory.equals("미 분 류")) {
			myCate = "etc";
		}
		
		ps.setString(4, myCate);
		ps.setString(5, InputMemo);
		ps.setString(6, Login.myId);
		
		ps.executeUpdate();
		System.out.println("쿼리문 처리 완료");
		
		ps.close();
		con.close();
		
	}

}
