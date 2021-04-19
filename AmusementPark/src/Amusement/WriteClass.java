package Amusement;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WriteClass {
	SimpleDateFormat sf = null;
	Date date = null;
	FileWriter fw = null;
	
	public void WriteClass(ArrayList<RunPark> arrayRun) {
		try {
			RunPark run = null;
			sf = new SimpleDateFormat("yyyyMMdd");
			date = new Date();
			fw = new FileWriter(ConstValueClass.address, true);
			String data = "";
			for (int i = 0; i < arrayRun.size(); i++) {
				run = arrayRun.get(i);
				data += sf.format(date) + ",";
				data += run.getTicketType() + ",";
				data += run.getCheckId() + ",";
				data += run.getTicketCount() + ",";
				data += run.getPrice() + ",";
				data += run.getHandicap() + "\n";
				
				fw.write(data);
			}
			fw.close();
		} catch(Exception e) {
			
		}
	}
}