package Amusement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class ReadClass {

	public void ReadFile() {
		List<List<String>> list = new ArrayList<List<String>>();
		RunPark run = new RunPark();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(ConstValueClass.address));
			String line;
			String temp = "";
			while((line = reader.readLine()) != null) {
				
				List<String> oneline = new ArrayList<String>();
				String[] array = line.split(",");
				oneline = Arrays.asList(array);
				list.add(oneline);
			}
			 
			for(int i = 0; i < list.size(); i++) {
				for(int j = 0; j < list.get(i).size(); j++) {
					System.out.printf(list.get(i).get(j) + " ");
				}
				System.out.println();
			}
			
			int morningSum = 0;
			int afternoonSum = 0;
			for(int i = 1; i < list.size(); i++) {
				if (list.get(i).get(1).equals("주간권")) {
					morningSum += Integer.parseInt(list.get(i).get(4));
				} else if (list.get(i).get(1).equals("야간권")) {
					afternoonSum += Integer.parseInt(list.get(i).get(4));
				}
			}
			System.out.println("주간권 매출 : " + morningSum);
			System.out.println("야간권 매출 : " + afternoonSum);
		} catch (Exception e) {
			
		}
	}
}
