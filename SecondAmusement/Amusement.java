package SecondAmusement;

import java.io.IOException;
import java.util.ArrayList;

public class Amusement {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputClass input = new InputClass();
		TicketInfoClass info = null;
		OutputClass output = new OutputClass();
		ArrayList<TicketInfoClass> arraylist_ticket = null;
		WriteClass wr = new WriteClass();
		
		int ticketType;
		String id;
		int count;
		int handicap;
		int sum;
		int totalsum;
		int continueticket = 0;
		int exit = 0;
		while(true) {
			arraylist_ticket = new ArrayList<TicketInfoClass>();
			while(true) {	
				info = new TicketInfoClass();
				ticketType = input.ticketType();
				id = input.checkid();
				count = input.ticketCount();
				sum = info.Price(ticketType, id, count);
				handicap = input.handicapNum();
				totalsum = info.totalPrice(handicap, sum);
				output.printPrice(totalsum);
				
				info.setTicketType(ticketType);
				info.setId(id);
				info.setTicketCount(count);
				info.setHandicap(handicap);
				info.setTotalprice(totalsum);
				
				arraylist_ticket.add(info);
				continueticket = input.continueTicket();
				if(continueticket == 2) {
					output.printResult(arraylist_ticket);
					break;
				}
			}
			wr.writefile(arraylist_ticket);
			exit = input.exit();
			if(exit == 2) {
				break;
			}
			
		}
	}

}
