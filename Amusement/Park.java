package Amusement;

public class Park {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputClass input = new InputClass();
		RunPark run = new RunPark();
		OutputClass print = new OutputClass();
		
		int ticketType = 0; // 주간권인지 야간권인지
		int handicapNum = 0;
		int sum;
		String coustmerID;
		int ticketCount;
		int continueTicket;
		int finsh;

		while (true) {
			while(true) {
				ticketType = input.typeTicket();
				if (ticketType == ConstValueClass.Morning_Ticket) {
					sum = run.judgeAge(input.coustmerID(), input.ticketCount());
					handicapNum = input.handicap();
					run.handicap(handicapNum, sum);
					print.printPrice(run.handicap(handicapNum, sum));
				} else if (ticketType == ConstValueClass.Afternoon_Ticket) {
					sum = run.judgeAge2(input.coustmerID(), input.ticketCount());
					handicapNum = input.handicap();
					run.handicap(handicapNum, sum);
					print.printPrice(run.handicap(handicapNum, sum));
				}
				continueTicket = input.continueTicket();
				if(continueTicket == 2) {
					print.printFinish();
					print.printresult(ticketType);
					break;
				}
			}
			finsh = input.finsh();
			if (finsh == 2) {
				break;
			}
		}
	}
}
