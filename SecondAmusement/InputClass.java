package SecondAmusement;

import java.util.Scanner;

public class InputClass {
	Scanner sc = null;
	
	public InputClass() {
		sc = new Scanner(System.in);
	}
	
	public int ticketType() {
		System.out.println("������ �����ϼ���.\n1. �ְ���\n2. �߰���");
		int type = sc.nextInt();
		
		return type;
	}
	
	public String checkid() {
		System.out.println("�ֹι�ȣ�� �Է��ϼ���");
		String id = sc.next();
		
		return id;
	}
	
	public int ticketCount() {
		System.out.println("��� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)");
		int count = sc.nextInt();
		
		return count;
	}
	
	public int handicapNum() {
		System.out.println("�������� �����ϼ���.\n1. ���� (���� ���� �ڵ�ó��)\n2. �����"
							+ "\n3. ����������\n4. ���ڳ�\n5. �ӻ��");
		int handiNum = sc.nextInt();
	
		return handiNum;
	}
	
	public int continueTicket() {
		System.out.println("��� �߱� �Ͻðڽ��ϱ�?\n1. Ƽ�� �߱�\n2. ����");
		int n = sc.nextInt();
		
		return n;
	}
	
	public int exit() {
		System.out.print("��� ����(1: ���ο� �ֹ�, 2: ���α׷� ����) :");
		int n = sc.nextInt();
		
		return n;
	}
}
