package FourthAmusement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OutputClass {

	public void printResult(int sum) {
		System.out.println("������ " + sum + "�� �Դϴ�.\n�����մϴ�.");
	}
	
	public void printSum(ArrayList<RunPark> arrayRun) {
		RunPark run = null;
		int totalSum = 0;
		System.out.println("===================== �������� ========================");
		
		for (int i = 0; i < arrayRun.size(); i++) {
			run = arrayRun.get(i);
			System.out.printf("%s %7s     X %3d %8d�� %7s\n", run.getTicketType(),run.getCheckId(),run.getTicketCount(),run.getPrice(),run.getHandicap());
			totalSum += run.getPrice();
		}
		System.out.println("����� �Ѿ��� " + totalSum + "�� �Դϴ�.");
		System.out.println("=======================================================");	
	}
}
