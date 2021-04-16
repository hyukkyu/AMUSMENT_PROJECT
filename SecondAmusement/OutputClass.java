package SecondAmusement;

import java.util.ArrayList;

public class OutputClass {
	
	public void printPrice(int price) {
		System.out.println("������ " + price + "�� �Դϴ�\n�����մϴ�.");
	}
	
	public void printResult(ArrayList<TicketInfoClass> arraylist_ticket) {
		TicketInfoClass info = null;
		int sum = 0;
		System.out.println("================ �������� ===============");
		for(int i = 0; i < arraylist_ticket.size(); i++) {
			info = arraylist_ticket.get(i);
			System.out.printf("%s %.4s X %2d %3d�� *%s\n", info.getTicketType(),info.getId(),
															info.getTicketCount(), info.getTotalprice(),
															info.getHandicap());
			sum += info.getTotalprice();
		}
		System.out.println("����� �Ѿ��� " + sum + "�� �Դϴ�.");
		System.out.println("================ �������� ===============");
	}
}
