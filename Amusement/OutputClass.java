package Amusement;

public class OutputClass {
	 
	public void printPrice(int price) {
		System.out.println("������ " + price + " �� �Դϴ�.\n�����մϴ�.");
		ConstValueClass.price.add(price);

	}
	
	public void printFinish() {
		System.out.println("Ƽ�� �߱��� �����մϴ�. �����մϴ�.");
		System.out.println("================== �������� ====================");
	
	}
	
	public void printresult(int n) {
		if (n == ConstValueClass.Morning_Ticket) {
			for (int i = 0; i < ConstValueClass.ticketType_Morning.size(); i++) {
				System.out.println("�ְ��� " + "X" + ConstValueClass.ticketType_Morning.get(i));
			} 
		} else if (n == ConstValueClass.Afternoon_Ticket){
			for (int i = 0; i < ConstValueClass.ticketType_Afternoon.size(); i++) {
				System.out.println("�߰���" + "X" + ConstValueClass.ticketType_Afternoon.get(i));
			}
		}
	}
}


