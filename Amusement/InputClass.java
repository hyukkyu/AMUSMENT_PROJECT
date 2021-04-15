package Amusement;

import java.util.Scanner;

public class InputClass {
	Scanner sc = null;
	
	public InputClass() {
		sc = new Scanner(System.in);
	}
	
	public int typeTicket() {
		System.out.println("권종을 선택하세요.\n"
						+ "1. 주간권\n"
						+ "2. 야간권");
		int n = sc.nextInt();
		if(n == 1) {
			ConstValueClass.ticketType_Morning.add(n);
		} else if(n == 2) {
			ConstValueClass.ticketType_Afternoon.add(n);
		}
		
		return n;
	}
	
	
	public String coustmerID() {
		System.out.println("주민번호를 입력하세요.");
		String id = sc.next();
		
		return id;
	}
	
	public int ticketCount() {
		System.out.println("몇개를 주문하시겠습니까? (최대 10개)");
		int n = sc.nextInt();
		ConstValueClass.ticketCount.add(n);
		
		return n;
	}
	
	public int handicap() {
		System.out.println("우대사항을 선택하세요.\n1. 없음 (나이 우대는 자동처리)\n2. 장애인\n3. 국가유공자\n"
							+ "4. 다자녀\n5. 임산부");
		int n = sc.nextInt();
		ConstValueClass.handicap.add(n);
		
		return n;
	}
	
	public int continueTicket() {
		System.out.println("계속 발권 하시겠습니까?\n1. 티켓 발권\n2. 종료");
		int n = sc.nextInt();
		
		return n;
	}
	
	public int finsh() {
		System.out.print("계속 진행(1 : 새로운 주문, 2: 프로그램 종료) : ");
		int n = sc.nextInt();
		
		return n;
	}
}
