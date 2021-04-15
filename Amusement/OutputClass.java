package Amusement;

public class OutputClass {
	 
	public void printPrice(int price) {
		System.out.println("가격은 " + price + " 원 입니다.\n감사합니다.");
		ConstValueClass.price.add(price);

	}
	
	public void printFinish() {
		System.out.println("티켓 발권을 종료합니다. 감사합니다.");
		System.out.println("================== 에버랜드 ====================");
	
	}
	
	public void printresult(int n) {
		if (n == ConstValueClass.Morning_Ticket) {
			for (int i = 0; i < ConstValueClass.ticketType_Morning.size(); i++) {
				System.out.println("주간권 " + "X" + ConstValueClass.ticketType_Morning.get(i));
			} 
		} else if (n == ConstValueClass.Afternoon_Ticket){
			for (int i = 0; i < ConstValueClass.ticketType_Afternoon.size(); i++) {
				System.out.println("야간권" + "X" + ConstValueClass.ticketType_Afternoon.get(i));
			}
		}
	}
}


