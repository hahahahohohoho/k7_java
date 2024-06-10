import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class DriverLoading {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "tiger");
		Statement st = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("=".repeat(80));
			System.out.println(">> Select [0:Exit]");
			System.out.println("[1:수도 이름과 함께 국가 이름을 검색합니다]");
			System.out.println("[2:세계에서 인구가 가장 많은 상위 5개 나라의 이름과 인구를 검색합니다.]");
			System.out.println("[3:미국(United States)에 있는 모든 도시의 이름과 인구를 검색합니다.]");
			System.out.println("[4:중국(China)에서 사용되는 모든 언어의 이름을 검색합니다.]");
			System.out.println("[5:인구가 100만 명 이상인 유럽 국가의 이름을 검색합니다.]");
			System.out.println("[6:1900년 이후 독립한 국가의 이름을 검색합니다.]");
			System.out.println("[7:영어가 공용어가 아니고 국민총생산(GNP)이 1,000보다 큰 국가의 이름을 검색합니다.]");
			System.out.println("=".repeat(80));
			int sel = sc.nextInt();
			if (sel == 0) break;
			switch(sel) {
				case 1 : query1(st); break;
				case 2: query2(st); break;
				case 3: query3(st); break;
				case 4: query4(st);break;
				case 5: query5(st); break;
				case 6: query6(st); break;
				case 7: query7(st); break;
				default :		break;
			}
		}
		sc.close();
		st.close();
		con.close();
	}
	static void printResult(ResultSet rs) throws SQLException {
		ResultSetMetaData meta = rs.getMetaData();
		while(rs.next()) {
			for(int i=1; i<=meta.getColumnCount();i++) {
				System.out.print(rs.getString(i)+ (i==meta.getColumnCount()?"":", "));
			}
			System.out.println();
		}
		rs.close();
	}
	//city 실행문
	static void query1(Statement st) {
		try {
			String sql = "select c.name, cc.name"
					+ "from country c, city cc"
					+ "where c.code = cc.countrycode and c.capital = cc.id";
			printResult(st.executeQuery(sql));
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}
	//country 실행문
	static void query2(Statement st) {
		try {
			printResult(st.executeQuery("select name, population from country order by population desc limit 5"));
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}
	static void query3(Statement st) {
		try {
			printResult(st.executeQuery("select name, population from city where countrycode = 'USA'"));
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}
	//[4:중국(China)에서 사용되는 모든 언어의 이름을 검색합니다.]
	static void query4(Statement st) {
		try {
			printResult(st.executeQuery("select l.language, l.percentage from country c, countrylanguage l where l.countrycode = c.code and c.code ='chn'"));
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}
	//[5:인구가 100만 명 이상인 유럽 국가의 이름을 검색합니다.]
	static void query5(Statement st) {
		try {
			printResult(st.executeQuery("select name, continent, population from country where continent ='Europe' and population > 1000000"));
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}		
	}
	//[6:1900년 이후 독립한 국가의 이름을 검색합니다.]
	static void query6(Statement st) {
		try {
			printResult(st.executeQuery("select name, indepyear from country where indepyear >=1900 order by indepyear"));
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
		
	}
	//[7:영어가 공용어가 아니고 국민총생산(GNP)이 1,000보다 큰 국가의 이름을 검색합니다.]
	static void query7(Statement st) {
		try {
			String sql = "select name, gnp from country c, countrylanguage l where c.code = l.countrycode and l.language = 'english' and l.isofficial = 'F'";
			printResult(st.executeQuery(sql));
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
		
	}
}
