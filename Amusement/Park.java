package Amusement;

import java.io.IOException;
import java.util.ArrayList;

public class Park {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputClass input = new InputClass();
		RunPark run = new RunPark();
		OutputClass print = new OutputClass();
		WirteClass wr = new WirteClass();
		
		int ticketType = 0; // 주간권인지 야간권인지
		int handicapNum = 0;
		int sum;
		String coustmerID;
		int ticketCount;
		int continueTicket;
		int finsh; 
		int count = 0;
		int Price = 0;
		int totalsum = 0;
		String write;
		String write2 = "";
		
		while (true) {
			ArrayList<String> printlist = new ArrayList<String>();

			while(true) {
				ticketType = input.typeTicket();
				coustmerID = input.coustmerID();
				ticketCount = input.ticketCount();
				handicapNum = input.handicap();
				
				if (ticketType == ConstValueClass.Morning_Ticket) {
					sum = run.judgeAge(coustmerID, ticketCount);
					Price = run.handicap(handicapNum, sum);
					print.printPrice(Price);
					
				} else if (ticketType == ConstValueClass.Afternoon_Ticket) {
					sum = run.judgeAge2(coustmerID, ticketCount);					
					Price = run.handicap(handicapNum, sum);
					print.printPrice(Price);
				}
				totalsum += Price;
				printlist.add(run.get_String(ticketType, coustmerID, ticketCount, handicapNum, Price));
				write = wr.get_String(ticketType, coustmerID, ticketCount, handicapNum, Price);
				write2 += write + "\n";
				
				if(input.continueTicket() == 2) {
					print.printFinish();
					for (int i = 0; i < printlist.size(); i++) {
						System.out.println(printlist.get(i));
					}
					print.printTotalResult(totalsum);
					break;
				}
				
			}
			
			if (input.finsh() == 2) {
				break;
			}
		}
		wr.printWrite(write2);
	}
}
