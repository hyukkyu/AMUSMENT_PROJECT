package FourthAmusement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OutputClass {

	public void printResult(int sum) {
		System.out.println("가격은 " + sum + "원 입니다.\n감사합니다.");
	}
	
	public void printSum(ArrayList<RunPark> arrayRun) {
		RunPark run = null;
		int totalSum = 0;
		System.out.println("===================== 폴리랜드 ========================");
		
		for (int i = 0; i < arrayRun.size(); i++) {
			run = arrayRun.get(i);
			System.out.printf("%s %7s     X %3d %8d원 %7s\n", run.getTicketType(),run.getCheckId(),run.getTicketCount(),run.getPrice(),run.getHandicap());
			totalSum += run.getPrice();
		}
		System.out.println("입장료 총액은 " + totalSum + "원 입니다.");
		System.out.println("=======================================================");	
	}
}
