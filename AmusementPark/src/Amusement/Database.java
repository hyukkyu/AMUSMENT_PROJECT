package Amusement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Database {
	
	public void db(ArrayList<RunPark> arrayRun) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String time = sdf.format(date);
		
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1:3306/testdb",
						"root" ,
						"kms0411");
			Statement stmt = conn.createStatement();
			String data = "";
			for (int i = 0; i < arrayRun.size(); i++) {
				RunPark run = arrayRun.get(i);
				data = String.format("insert into `report` (`date`, `type`, `age`, `count`, `price`, `treat`) "
						+ "values ('%s', '%s', '%s', '%d', '%d', '%s')", time, run.getTicketType(), run.getCheckId()
																		,run.getTicketCount(), run.getPrice(), run.getHandicap());
				stmt.execute(data);
			}

			stmt.close();
			conn.close();
		} catch (Exception e) {
			
		}
	}
}
