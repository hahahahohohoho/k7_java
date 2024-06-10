package add;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//preparedStatement 구현
public class MemberDao3 {
	private static Scanner sc = new Scanner(System.in);
	private static String url = "jdbc:mysql://localhost:3306/musthave";
	private static String user = "root";
	private static String pw = "tiger";
	
	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection(url, user, pw);
		MemberDaoStatement ms = new MemberDaoStatement();
		MemberDaoPreparedStatement mp = new MemberDaoPreparedStatement();
		
		System.out.print("[S]tatement [P]repareStatement : ");
		String t = sc.next().toUpperCase();
		
		MemberDao dao = ms;
		if (t.equals("P")) {
			dao = mp;
		}
		boolean flag = true;
		while(flag) {
			System.out.print("[I]nsert/[U]date/[D]elete/[S]elect/e[X]it :");
			String s = sc.next().toUpperCase();
			switch (s) {
			case "I": dao.insertMember(con); break;
			case "U": dao.updateMember(con); break;
			case "D": dao.deleteMember(con); break;
			case "S": dao.selectMember(con); break;
			case "X": flag = false; break;
			}
		}
		con.close();
		sc.close();
		System.out.println("Done");
	}
}
