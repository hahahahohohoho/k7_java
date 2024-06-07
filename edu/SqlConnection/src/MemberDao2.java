import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//statement 구현
public class MemberDao2 {
	private static Scanner sc = new Scanner(System.in);
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/musthave";
	private static String user = "root";
	private static String pw = "tiger";
	
	public static void main(String[] args) throws Exception {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pw);
		boolean flag = true;
		while(flag) {
			System.out.print("[I]nsert/[U]date/[D]elete/[S]elect/e[X]it :");
			String s = sc.next().toUpperCase();
			switch (s) {
			case "I": insertMember(con); break;
			case "U": updateMember(con); break;
			case "D": deleteMember(con); break;
			case "S": selectMember(con); break;
			case "X": flag = false; break;
			}
		}
		con.close();
		sc.close();
		System.out.println("Done");
	}
	private static void insertMember(Connection con) throws SQLException{
		String sql = "insert into members(pass, name) values";
		Statement stmt = con.createStatement();
		for (int i = 1; i<=10; i ++) {
			sql = sql + String.format("('%s', '%s')", "pass"+i, "name"+i);
			stmt.executeUpdate(sql);
			sql = "insert into members(pass, name) values";
		}
		stmt.close();
		System.out.println("Insert Done!");
	}
	private static void updateMember(Connection con)throws SQLException {
		System.out.println("Update Member");
		Statement stmt = con.createStatement();
		String sql = "update members set pass=";
		System.out.print("바꾸고 싶은 id를 입력하세요: ");		int id = sc.nextInt(); 
		System.out.print("pass 값을 입력하세요: ");		String ps = sc.next(); 
		System.out.print("name 값을 입력하세요: ");		String nm = sc.next(); 
		sql = sql + String.format("%s, name=%s where id=%d", ps, nm, id);
		stmt.executeUpdate(sql);
        stmt.close();
        System.out.println("update 성공!");
	}
	private static void deleteMember(Connection con)throws SQLException {
		System.out.println("Delete Member");
		String sql = "delete from members where id=";
		System.out.print("지우고 싶은 id를 입력하세요: ");
		sql = sql + String.format("%s", sc.next());
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		System.out.println("delete 성공!");
	}
	private static void selectMember(Connection con) throws SQLException{
		System.out.println("db를 출력합니다!");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from members");
		while(rs.next()) {
			System.out.print(rs.getInt("id") +", ");
			System.out.print(rs.getString("pass")+", ");
			System.out.print(rs.getString("name")+", ");
			System.out.print(rs.getDate("regidate")+"\n");
		}
		st.close();		
	}

}
