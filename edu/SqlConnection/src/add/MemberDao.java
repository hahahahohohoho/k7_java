package add;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public abstract class MemberDao {
	public static Scanner sc = new Scanner(System.in);
	public static String driver = "com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/musthave";
	public static String user = "root";
	public static String pw = "tiger";
	
	public void doubleLine() {
		System.out.println("=".repeat(80));
	}
	
	public abstract void insertMember(Connection con) throws SQLException;
	public abstract void updateMember(Connection con) throws SQLException;
	public abstract void deleteMember(Connection con) throws SQLException;
	public abstract void selectMember(Connection con) throws SQLException;
}

class MemberDaoStatement extends MemberDao{
	@Override public void insertMember(Connection con) throws SQLException {
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

	@Override public void updateMember(Connection con) throws SQLException {
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

	@Override public void deleteMember(Connection con) throws SQLException {
		System.out.println("Delete Member");
		String sql = "delete from members where id=";
		System.out.print("지우고 싶은 id를 입력하세요: ");
		sql = sql + String.format("%s", sc.next());
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		System.out.println("delete 성공!");
	}

	@Override public void selectMember(Connection con) throws SQLException {
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

class MemberDaoPreparedStatement extends  MemberDao{

	@Override public void insertMember(Connection con) throws SQLException {
		String sql = "insert into members(pass, name) values(?, ?) ";
		PreparedStatement ps = con.prepareCall(sql);
		for (int i = 1; i<=10; i ++) {
			ps.setString(1, "userpass"+i);
			ps.setString(2, "username"+i);
			ps.executeUpdate();
		}
		System.out.println("Insert Done!");
	}

	@Override public void updateMember(Connection con) throws SQLException {
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

	@Override public void deleteMember(Connection con) throws SQLException {
		System.out.println("Delete Member");
		String sql = "delete from members where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("지우고 싶은 id를 입력하세요");
		ps.setInt(1, sc.nextInt());
		ps.executeUpdate();
		System.out.println("delete 성공!");
	}

	@Override public void selectMember(Connection con) throws SQLException {

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

