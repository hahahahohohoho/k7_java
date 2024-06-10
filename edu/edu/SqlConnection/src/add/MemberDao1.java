package add;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//preparedStatement 구현
public class MemberDao1 {
	private static Scanner sc = new Scanner(System.in);
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/musthave";
	private static String user = "root";
	private static String pw = "tiger";
	
	public static void main(String[] args) throws Exception {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pw);
		MemberDaoStatement ms = new MemberDaoStatement();
		boolean flag = true;
		while(flag) {
			System.out.println("[I]nsert/[U]date/[D]elete/[S]elect/e[X]it :");
			String s = sc.next().toUpperCase();
			switch (s) {
			case "I": ms.insertMember(con); break;
			case "U": ms.updateMember(con); break;
			case "D": ms.deleteMember(con); break;
			case "S": ms.selectMember(con); break;
			case "X": flag = false; break;
			}
		}
		con.close();
		sc.close();
		System.out.println("Done");
	}
}
