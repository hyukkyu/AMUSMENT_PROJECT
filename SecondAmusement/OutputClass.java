package SecondAmusement;

import java.util.ArrayList;

public class OutputClass {
	
	public void printPrice(int price) {
		System.out.println("가격은 " + price + "원 입니다\n감사합니다.");
	}
	
	public void printResult(ArrayList<TicketInfoClass> arraylist_ticket) {
		TicketInfoClass info = null;
		int sum = 0;
		System.out.println("================ 폴리랜드 ===============");
		for(int i = 0; i < arraylist_ticket.size(); i++) {
			info = arraylist_ticket.get(i);
			System.out.printf("%s %.4s X %2d %3d원 *%s\n", info.getTicketType(),info.getId(),
															info.getTicketCount(), info.getTotalprice(),
															info.getHandicap());
			sum += info.getTotalprice();
		}
		System.out.println("입장료 총액은 " + sum + "원 입니다.");
		System.out.println("================ 폴리랜드 ===============");
	}
}
