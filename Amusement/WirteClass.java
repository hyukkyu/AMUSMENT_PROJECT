package Amusement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WirteClass {
	
	FileWriter fw = null;
	
	public WirteClass() throws IOException {
		fw = new FileWriter(ConstValueClass.address,true);
	}
	
	public void printWrite(String n) throws IOException {
		File file = new File(ConstValueClass.address);
		String data2 = "��¥ ,���� ,���ɱ��� ,���� ,���� ,������\n";
		if(file.exists() == true) {
			fw.write(n);
		} else {
			fw.write(data2);
			fw.write(n);
		}
		
		fw.close();
		
	}
	
	
	
	
	
	
	public String get_String (int ticketType, String coustmerID, int ticketCount, int handicapNum, int Price) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		
		String temp = "";
		
		temp += sf.format(date) + ",";
		
		if (ticketType == 1) {
			temp += "�ְ��� ,";
		} else if (ticketType == 2) {
			temp += "�߰��� ,";
		}
		
		String birth = coustmerID.substring(0, 2);
		int birth_Year = Integer.parseInt(birth);
		int real_Age;
		
		if (birth_Year <= 21) {
			real_Age = 21 - birth_Year;
		} else {
			real_Age = 121 - birth_Year;
		}
		
		if (real_Age >= 64) {
			temp += "��� ,";
		} else if (real_Age >= 19) {
			temp += "���� ,";
		} else if (real_Age >= 12) {
			temp += "û�ҳ� ,";
		} else if (real_Age >= 3) {
			temp += "���� ,";
		} else if (real_Age >= 0) {
			temp += "���� ,";
		} 
		
		temp += ticketCount + ",";
		temp += Price + ",";
		
		if (handicapNum == 1) {
			temp += " ������ ���� ";
		} else if (handicapNum == 2) {
			temp += " ����� ";
		} else if (handicapNum == 3) {
			temp += " ���������� ";
		} else if (handicapNum == 4) {
			temp += " ���ڳ� ";
		} else if (handicapNum == 5) {
			temp += " �ӻ�� ";
		} 
		return temp;
	}
}
