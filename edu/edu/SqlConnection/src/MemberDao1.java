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
		String sql = "insert into members(id, pass, name) values(?, ?, ?) ";
		PreparedStatement ps = con.prepareCall(sql);
		for (int i = 1; i<=10; i ++) {
			ps.setInt(1, i);
			ps.setString(2, "userpass"+i);
			ps.setString(3, "username"+i);
			ps.executeUpdate();
		}
		System.out.println("Insert Done!");
	}
	private static void updateMember(Connection con)throws SQLException {
		System.out.println("Update Member");
		String sql = "update members set pass=?, name=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);System.out.print("바꾸고 싶은 id를 입력하세요: ");
        int id = sc.nextInt(); // Read the id
        sc.nextLine(); // Consume the leftover newline character

        System.out.print("pass를 입력하세요: ");
        ps.setString(1, sc.nextLine()); // Read the pass

        System.out.print("name을 입력하세요: ");
        ps.setString(2, sc.nextLine()); // Read the name
        
        ps.setInt(3, id); // Set the id in the PreparedStatement
        ps.executeUpdate();
        System.out.println("update 성공!");
	}
	private static void deleteMember(Connection con)throws SQLException {
		System.out.println("Delete Member");
		String sql = "delete from members where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.print("지우고 싶은 id를 입력하세요: ");
		ps.setInt(1, sc.nextInt());
		ps.executeUpdate();
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
