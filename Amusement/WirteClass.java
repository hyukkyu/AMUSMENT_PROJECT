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
		String data2 = "날짜 ,권종 ,연령구분 ,수량 ,가격 ,우대사항\n";
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
			temp += "주간권 ,";
		} else if (ticketType == 2) {
			temp += "야간권 ,";
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
			temp += "경로 ,";
		} else if (real_Age >= 19) {
			temp += "대인 ,";
		} else if (real_Age >= 12) {
			temp += "청소년 ,";
		} else if (real_Age >= 3) {
			temp += "소인 ,";
		} else if (real_Age >= 0) {
			temp += "유아 ,";
		} 
		
		temp += ticketCount + ",";
		temp += Price + ",";
		
		if (handicapNum == 1) {
			temp += " 우대사항 없음 ";
		} else if (handicapNum == 2) {
			temp += " 장애인 ";
		} else if (handicapNum == 3) {
			temp += " 국가유공자 ";
		} else if (handicapNum == 4) {
			temp += " 다자녀 ";
		} else if (handicapNum == 5) {
			temp += " 임산부 ";
		} 
		return temp;
	}
}
