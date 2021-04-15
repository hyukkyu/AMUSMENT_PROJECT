package Amusement;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunPark {
	SimpleDateFormat sf = null;
	Date date = null;
	DecimalFormat df = null;
	
	public RunPark() {
		sf = new SimpleDateFormat("yy");
		date = new Date();
		df = new DecimalFormat("#,#00");
		
	}

	//�ְ��ǰ��
	public int judgeAge(String id, int ticketCount) {
		int judgeid = Integer.parseInt(id.substring(6, 7)); // �ֹι�ȣ���ڸ�Ȯ��
		int checkid; // ����
		int ticketsum = 0;

		if (judgeid == 1 || judgeid == 2) {
			checkid = (Integer.parseInt(sf.format(date)) + 100) - Integer.parseInt(id.substring(0, 2));
			if (checkid <= 64) {
				ticketsum = ticketCount * ConstValueClass.Morning_Adult;
				
			} else if (checkid >= 65) {
				ticketsum = ticketCount * ConstValueClass.Morning_Old;
				
			}
		} else if (judgeid == 3 || judgeid == 4) {
			checkid = Integer.parseInt(sf.format(date)) - Integer.parseInt(id.substring(0, 2));
			if (checkid >= 19 && checkid <= 21) {
				ticketsum = ticketCount * ConstValueClass.Morning_Adult;
				
			} else if (checkid >= 13 && checkid <= 18) {
				ticketsum = ticketCount * ConstValueClass.Morning_Highteen;
				
			} else if (checkid <= 2) {
				ticketsum = ConstValueClass.Morning_baby;
				
			}
		}
		return ticketsum;
	}
	
	//�߰��� ���
	public int judgeAge2(String id, int ticketCount) {
		int judgeid = Integer.parseInt(id.substring(6, 7)); // �ֹι�ȣ���ڸ�Ȯ��
		int checkid; // ����
		int ticketsum = 0;

		if (judgeid == 1 || judgeid == 2) {
			checkid = (Integer.parseInt(sf.format(date)) + 100) - Integer.parseInt(id.substring(0, 2));
			if (checkid <= 64) {
				ticketsum = ticketCount * ConstValueClass.Afternoon_Adult;
				
			} else if (checkid >= 65) {
				ticketsum = ticketCount * ConstValueClass.Afternoon_old;
				
			}
		} else if (judgeid == 3 || judgeid == 4) {
			checkid = Integer.parseInt(sf.format(date)) - Integer.parseInt(id.substring(0, 2));
			if (checkid >= 19 && checkid <= 21) {
				ticketsum = ticketCount * ConstValueClass.Afternoon_Adult;
				
			} else if (checkid >= 13 && checkid <= 18) {
				ticketsum = ticketCount * ConstValueClass.Afternoon_Highteen;
				
			} else if (checkid <= 2) {
				ticketsum = ConstValueClass.Afternoon_baby;
				
			}
		}
		return ticketsum;
	}
	
	//�����, ����������, ���ڳ�, �ӽ� ������ ���
	public int handicap(int n, int price) {
		int result = 0;
		if (n == ConstValueClass.Normal_person) {
			result = price;
		} else if (n == ConstValueClass.Handicap) {
			result = (int)(price * (1 - ConstValueClass.Discount_Handicap));
		} else if (n == ConstValueClass.National) {
			result = (int)(price * (1 - ConstValueClass.Discount_National));
		} else if (n == ConstValueClass.Many) {
			result = (int)(price * (1 - ConstValueClass.Discount_Many));
		} else if (n == ConstValueClass.Pregnant) {
			result = (int)(price * (1 - ConstValueClass.Discount_Pregnant));
		}
		return result;
	}
}
