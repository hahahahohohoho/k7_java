import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

public class QueryPreparedStatement {
	public static void main(String[] args) {
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url  = "jdbc:mysql://localhost:3306/world";
			String username = "root";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			PreparedStatement pt = con.prepareStatement("select id, name, countrycode, district, population from city where name like ?");
			PreparedStatement pt1 = con.prepareStatement("select id, name, countrycode, district, population from city where population >=?");
			PreparedStatement pt2 = con.prepareStatement("select id, name, countrycode, district, population from city where name like ? and population >=?");
			pt.setString(1, "Seoul"); // ?를 활용해서 조건을 설정 가능
			pt1.setInt(1, 9000000); // ?의 데이터 타입에 맞게 조건 설정 가능
			pt2.setString(1, "S%"); // ?의 순서에 맞게 데이터 타입 맞는 set을 여러번
			pt2.setInt(2, 1000000);
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt("id")+ ", ");
				System.out.print(rs.getString("name")+ ", ");
				System.out.print(rs.getString("countrycode")+ ", ");
				System.out.print(rs.getString("district")+ ", ");
				System.out.print(rs.getInt("population")+ "\n");
			}
			rs.close();
			pt.close();
			con.close();
		}catch (Exception e) {
			System.out.println("연결 실패" + e.getMessage());
		}
	}
}
