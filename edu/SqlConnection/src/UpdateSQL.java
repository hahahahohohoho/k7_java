import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class UpdateSQL {
		static String driver = "com.mysql.cj.jdbc.Driver";
		static String url = "jdbc:mysql://localhost:3306/musthave";
		static String username = "root";
		static String pw = "tiger";

		static void selectUser(Connection con) throws Exception {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from members");
			System.out.println("db를 출력합니다!");
			while(rs.next()) {
				System.out.print(rs.getInt("id") +", ");
				System.out.print(rs.getString("pass")+", ");
				System.out.print(rs.getString("name")+", ");
				System.out.print(rs.getDate("regidate")+"\n");
			}
			st.close();
		}
		static void updatetUser(){
			try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, username, pw);
				Scanner sc = new Scanner(System.in);
				String sql = "update members set pass=?, name=? where id=?";
				PreparedStatement ps = con.prepareStatement(sql);
				System.out.println("pass를 입력하세요");
				ps.setString(1, sc.nextLine());
				System.out.println("name을 입력하세요");
				ps.setString(2, sc.nextLine());
				System.out.println("바꾸고 싶은 id를 입력하세요");
				ps.setInt(3, sc.nextInt());
				ps.executeUpdate();
				System.out.println("update 성공!");
				selectUser(con);
				con.close();
				sc.close();
			}catch(Exception e) {
				e.getMessage();
			}
			
		}
		
		public static void main(String[] args) {			
			updatetUser();
		}

}
