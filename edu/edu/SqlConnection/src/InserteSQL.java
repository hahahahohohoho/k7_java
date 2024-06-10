import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class InserteSQL {


		// TODO Auto-generated method stub
		static String driver = "com.mysql.cj.jdbc.Driver";
		static String url = "jdbc:mysql://localhost:3306/musthave";
		static String username = "root";
		static String pw = "tiger";
		
		static void insertUser(){
			try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, username, pw);
				Statement stmt = con.createStatement();
				String sql = "insert into members(pass, name) values(?, ?)";
				PreparedStatement ps = con.prepareCall(sql);
				for (int i = 1; i<=10; i ++) {
					ps.setString(1, "userpass"+i);
					ps.setString(2, "username"+i);
					ps.executeUpdate();
				}
				con.close();
				System.out.println("Insert Done!");
			}catch(Exception e) {
				e.getMessage();
			}
			
		}
		
		public static void main(String[] args) {
			
			insertUser();
		}

}
