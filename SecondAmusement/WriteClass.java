package SecondAmusement;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WriteClass {
	
	FileWriter fw = null;
	SimpleDateFormat sf = null;
	Date date = null;
	
	public WriteClass() throws IOException {
		fw = new FileWriter(ConstValueClass.address,true);
		sf = new SimpleDateFormat("yyyyMMdd");
		date = new Date();
	}
	
	public void writefile(ArrayList<TicketInfoClass> arraylist_ticket) throws IOException {
		TicketInfoClass info = null;
		
		String data = "";
		for(int i = 0; i < arraylist_ticket.size(); i++) {
			info = arraylist_ticket.get(i);
			data += sf.format(date) + ",";
			data += info.getTicketType() + ",";
			data += info.getId() + ",";
			data += info.getTicketCount() + ",";
			data += info.getTotalprice() + ",";
			data += info.getHandicap() + "\n";
		}
		fw.write(data);
		fw.close();
	}
}
