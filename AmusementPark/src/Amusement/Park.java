package Amusement;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class Park {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputClass input = new InputClass();
		RunPark run = null;
		OutputClass output = new OutputClass();
		WriteClass write = new WriteClass();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		ReadClass read = new ReadClass();
		
		int ticketType;
		String customerId;
		int ticketCount;
		int handicap;
		int totalPrice;
		int sum;
		int continueTicket;
		int exit;
		String year;
		while(true) {
			ArrayList<RunPark> arrayRun = new ArrayList<RunPark>();
			while(true) {
				run = new RunPark();
				ticketType = input.ticketType();
				customerId = input.id();
				ticketCount = input.ticketCount();
				handicap = input.handicap();
				totalPrice = run.calPrice(ticketType, customerId, ticketCount);
				sum = run.handicapPrice(handicap, totalPrice);
				output.printResult(sum);
				year = sf.format(date);
				
				run.setYear(year);
				run.setTicketType(ticketType);
				run.setCheckId(customerId);
				run.setTicketCount(ticketCount);
				run.setHandicap(handicap);
				run.setPrice(sum);
				
				arrayRun.add(run);
				continueTicket = input.continueTicket();
				if(continueTicket == 2) {
					output.printSum(arrayRun);
					break;
				}
			}
			exit = input.exit();
			if(exit == 2) {
				write.WriteClass(arrayRun);
				read.ReadFile();
				break;
			}
		}
	}
}
