package Amusement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class DatabaseOutputClass {
	private Connection conn;
	private Statement stmt;
	//private ResultSet rset;
	
	public DatabaseOutputClass() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/testdb",
					"root" ,
					"kms0411");
			stmt = conn.createStatement();
			//rset = stmt.executeQuery("SELECT * FROM `report`");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//데이터베이스에 입력하기
	public void addToDatabase(RunPark run) {
		try {
			String str = "INSERT INTO `report` (`date`, `type`, `age`, `count`, `price`, `treat`)"
					+"VALUES (now(),"
					+ "'" + run.getTicketType() + "',"
					+ "'" + run.getCheckId() + "',"
					+ "'" + run.getTicketCount() + "',"
					+ "'" + run.getPrice() + "',"
					+ "'" + run.getHandicap()
					+ "');";
			stmt.execute(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	//데이터베이스에서 정보 가져오기
	public void printDatabase() {
		try {
			ResultSet rset = stmt.executeQuery("SELECT * FROM `report`");
			System.out.println("===================== report.csv =========================");
			System.out.println("날짜 권종 나이 개수 가격 우대사항");
			String str = "SELECT * FROM `report` WHERE `type` LIKE '주간권'";
			while(rset.next()) {
				//System.out.println(rset.getString(1) + " " + rset.getString(2) + " "
							//+ rset.getString(3) + " " + rset.getInt(4) + " " + rset.getInt(5) + " " + rset.getString(6));
				String data = rset.getString(1) + " " + rset.getString(2) + " "
						+ rset.getString(3) + " " + rset.getInt(4) + " " + rset.getInt(5) + " " + rset.getString(6);
				System.out.println(data);
				
			}
			System.out.println("-----------------------------------------------------------");
		} catch(SQLException e) {
		e.printStackTrace();
		} catch(Exception e) {
		e.printStackTrace();
		}
	}
	
	public void printticketType() {
		try {
			System.out.println("==================== 권종 별 판매현황 ======================");
			//주간권 판매현황
			ResultSet rset = stmt.executeQuery("SELECT SUM(count) FROM `report` WHERE `type` LIKE '주간권'");
			while(rset.next()) {
				System.out.println("주간권 총 " + rset.getInt(1) + "매");
			}
			
			rset = stmt.executeQuery("SELECT SUM(count) FROM `report` WHERE `type` LIKE '주간권' AND `age` LIKE '유아'");
			while(rset.next()) {
				System.out.print("유아" + rset.getInt(1) + "매,");
			}
			rset = stmt.executeQuery("SELECT SUM(count) FROM `report` WHERE `type` LIKE '주간권' AND `age` LIKE '어린이'");
			while(rset.next()) {
				System.out.print("어린이" + rset.getInt(1) + "매,");
			}
			rset = stmt.executeQuery("SELECT SUM(count) FROM `report` WHERE `type` LIKE '주간권' AND `age` LIKE '청소년'");
			while(rset.next()) {
				System.out.print("청소년" + rset.getInt(1) + "매,");
			}
			rset = stmt.executeQuery("SELECT SUM(count) FROM `report` WHERE `type` LIKE '주간권' AND `age` LIKE '어른'");
			while(rset.next()) {
				System.out.print("어른" + rset.getInt(1) + "매,");
			}
			rset = stmt.executeQuery("SELECT SUM(count) FROM `report` WHERE `type` LIKE '주간권' AND `age` LIKE '노인'");
			while(rset.next()) {
				System.out.print("노인" + rset.getInt(1) + "매\n");
			}
			rset = stmt.executeQuery("SELECT SUM(price) FROM `report` WHERE `type` LIKE '주간권'");
			while(rset.next()) {
				System.out.print("주간권 매출 : " + rset.getInt(1) + "원\n\n");
			}
			//야간권 판매현황
			rset = stmt.executeQuery("SELECT SUM(count) FROM `report` WHERE `type` LIKE '야간권'");
			while(rset.next()) {
				System.out.println("야간권 총 " + rset.getInt(1) + "매");
			}
			rset = stmt.executeQuery("SELECT SUM(count) FROM `report` WHERE `type` LIKE '야간권' AND `age` LIKE '유아'");
			while(rset.next()) {
				System.out.print("유아" + rset.getInt(1) + "매,");
			}
			rset = stmt.executeQuery("SELECT SUM(count) FROM `report` WHERE `type` LIKE '야간권' AND `age` LIKE '어린이'");
			while(rset.next()) {
				System.out.print("어린이" + rset.getInt(1) + "매,");
			}
			rset = stmt.executeQuery("SELECT SUM(count) FROM `report` WHERE `type` LIKE '야간권' AND `age` LIKE '청소년'");
			while(rset.next()) {
				System.out.print("청소년" + rset.getInt(1) + "매,");
			}
			rset = stmt.executeQuery("SELECT SUM(count) FROM `report` WHERE `type` LIKE '야간권' AND `age` LIKE '어른'");
			while(rset.next()) {
				System.out.print("어른" + rset.getInt(1) + "매,");
			}
			rset = stmt.executeQuery("SELECT SUM(count) FROM `report` WHERE `type` LIKE '야간권' AND `age` LIKE '노인'");
			while(rset.next()) {
				System.out.print("노인" + rset.getInt(1) + "매\n");
			}
			rset = stmt.executeQuery("SELECT SUM(price) FROM `report` WHERE `type` LIKE '야간권'");
			while(rset.next()) {
				System.out.print("야간권 매출 : " + rset.getInt(1) + "원\n\n");
			}
		} catch (Exception e) {
			
		}
		System.out.println("-------------------------------------------------------------\n");
	}
	
	//일자별 매출현황
	public void printdayResult() {
		System.out.println("=========== 일자별 매출 현황 ===============");
		try {
			ResultSet rset = stmt.executeQuery("SELECT `date`, SUM(price) FROM `report` GROUP BY `date`");
			while(rset.next()) {
				System.out.println(rset.getString(1) + " : " + " 총 매출 " + rset.getString(2) + "원");
			}
			
		} catch(Exception e) {
			
		}
		System.out.println("------------------------------------------\n");
	}
	
	public void printhandicapResult() {
		System.out.println("==== 우대권 판매 현황 ====");
		try {
			ResultSet rset = stmt.executeQuery("SELECT SUM(count) FROM `report`");
			while(rset.next()) {
				System.out.printf("총 판매 티켓수 : %d매\n" , rset.getInt(1));
			}
			rset = stmt.executeQuery("SELECT SUM(count) FROM `report` WHERE `treat` LIKE '없음'");
			while(rset.next()) {
				System.out.printf("우대 없음      : %d매\n" , rset.getInt(1));
			}
			rset = stmt.executeQuery("SELECT SUM(count) FROM `report` WHERE `treat` LIKE '장애인'");
			while(rset.next()) {
				System.out.printf("장애인         : %d매\n" , rset.getInt(1));
			}
			rset = stmt.executeQuery("SELECT SUM(count) FROM `report` WHERE `treat` LIKE '국가유공자'");
			while(rset.next()) {
				System.out.printf("국가유공자     : %d매\n" , rset.getInt(1));
			}
			rset = stmt.executeQuery("SELECT SUM(count) FROM `report` WHERE `treat` LIKE '다자녀'");
			while(rset.next()) {
				System.out.printf("다자녀         : %d매\n" , rset.getInt(1));
			}
			rset = stmt.executeQuery("SELECT SUM(count) FROM `report` WHERE `treat` LIKE '임산부'");
			while(rset.next()) {
				System.out.printf("임산부         : %d매\n" , rset.getInt(1));
			}
		} catch(Exception e) {
			
		}
		System.out.println("--------------------------");
	}
}
