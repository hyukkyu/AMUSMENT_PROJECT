package Amusement;

import java.util.Scanner;

public class InputClass {
	Scanner sc = null;
	
	public InputClass() {
		sc = new Scanner(System.in);
	}
	
	public int typeTicket() {
		System.out.println("������ �����ϼ���.\n"
						+ "1. �ְ���\n"
						+ "2. �߰���");
		int n = sc.nextInt();
		if(n == 1) {
			ConstValueClass.ticketType_Morning.add(n);
		} else if(n == 2) {
			ConstValueClass.ticketType_Afternoon.add(n);
		}
		
		return n;
	}
	
	
	public String coustmerID() {
		System.out.println("�ֹι�ȣ�� �Է��ϼ���.");
		String id = sc.next();
		
		return id;
	}
	
	public int ticketCount() {
		System.out.println("��� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)");
		int n = sc.nextInt();
		ConstValueClass.ticketCount.add(n);
		
		return n;
	}
	
	public int handicap() {
		System.out.println("�������� �����ϼ���.\n1. ���� (���� ���� �ڵ�ó��)\n2. �����\n3. ����������\n"
							+ "4. ���ڳ�\n5. �ӻ��");
		int n = sc.nextInt();
		ConstValueClass.handicap.add(n);
		
		return n;
	}
	
	public int continueTicket() {
		System.out.println("��� �߱� �Ͻðڽ��ϱ�?\n1. Ƽ�� �߱�\n2. ����");
		int n = sc.nextInt();
		
		return n;
	}
	
	public int finsh() {
		System.out.print("��� ����(1 : ���ο� �ֹ�, 2: ���α׷� ����) : ");
		int n = sc.nextInt();
		
		return n;
	}
}
