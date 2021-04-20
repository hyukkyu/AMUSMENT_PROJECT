package ReadAmusement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ReadClass {
	
	public void printFile() {
		List<List<String>> list = new ArrayList<List<String>>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader (ConstValueClass.address));
			List<String> oneline = new ArrayList<String>();
			String line = "";
			while((line = reader.readLine()) != null) {
				String[] array = line.split(",");
				oneline = Arrays.asList(array);
				list.add(oneline);
			}
			
			System.out.println("==================== report.csv =====================");
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.get(i).size(); j++) {
					System.out.print(list.get(i).get(j) + "   ");
				}
				System.out.println();
			}
			System.out.println("---------------------------------------------------\n");
			System.out.println("===================== 권종 별 판매현황 =========================");
			
			//주간권 갯수, 유아갯수, 어린이갯수, 청소년갯수, 어른갯수, 노인갯수, 주간권 매출
			//야간권 갯수, 유아갯수, 어린이갯수, 청소년갯수, 어른갯수, 노인갯수, 야간권 매출
			int morningcount = 0;
			int afternooncount = 0;
			int morningsum = 0;
			int afternoonsum = 0;
			int morningbabycount = 0;
			int morningyoungcount = 0;
			int morninghighteencount = 0;
			int morningadultcount = 0;
			int morningoldcount = 0;
			int afternoonbabycount = 0;
			int afternoonyoungcount = 0;
			int afternoonhighteencount = 0;
			int afternoonadultcount = 0;
			int afternoonoldcount = 0;
			String data2 = "";
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).get(1).equals("주간권")) {
					morningcount += Integer.parseInt(list.get(i).get(3));
					morningsum += Integer.parseInt(list.get(i).get(4));
					if (list.get(i).get(2).equals("유아")) {
						morningbabycount += Integer.parseInt(list.get(i).get(3));
					} else if (list.get(i).get(2).equals("어린이")) {
						morningyoungcount += Integer.parseInt(list.get(i).get(3));
					} else if (list.get(i).get(2).equals("청소년")) {
						morninghighteencount += Integer.parseInt(list.get(i).get(3));
					} else if (list.get(i).get(2).equals("어른")) {
						morningadultcount += Integer.parseInt(list.get(i).get(3));
					} else if (list.get(i).get(2).equals("노인")) {
						morningoldcount += Integer.parseInt(list.get(i).get(3));
					}
					
				} else if (list.get(i).get(1).equals("야간권")) {
					afternooncount += Integer.parseInt(list.get(i).get(3));
					afternoonsum += Integer.parseInt(list.get(i).get(4));
					if (list.get(i).get(2).equals("유아")) {
						afternoonbabycount += Integer.parseInt(list.get(i).get(3));
					} else if (list.get(i).get(2).equals("어린이")) {
						afternoonyoungcount += Integer.parseInt(list.get(i).get(3));
					} else if (list.get(i).get(2).equals("청소년")) {
						afternoonhighteencount += Integer.parseInt(list.get(i).get(3));
					} else if (list.get(i).get(2).equals("어른")) {
						afternoonadultcount += Integer.parseInt(list.get(i).get(3));
					} else if (list.get(i).get(2).equals("노인")) {
						afternoonoldcount += Integer.parseInt(list.get(i).get(3));
					}
				}
			}
			System.out.printf("주간권 총 %d매\n유아 %d매, 어린이 %d매, 청소년 %d매, 어른 %d매, 노인 %d\n주간권 매출 : %d원\n\n" 
						, morningcount, morningbabycount, morningyoungcount, morninghighteencount, morningadultcount, morningoldcount, morningsum);
			System.out.printf("야간권 총 %d매\n유아 %d매, 어린이 %d매, 청소년 %d매, 어른 %d매, 노인 %d매\n야간권 매출 : %d원\n\n" 
						, afternooncount, afternoonbabycount, afternoonyoungcount, afternoonhighteencount, afternoonadultcount, afternoonoldcount, afternoonsum);
			String data3 = "유아, " + morningbabycount + "," + afternoonbabycount + "\n" + "어린이," + morningyoungcount + "," + afternoonyoungcount +"\n" 
							+ "청소년, " + morninghighteencount + "," + afternoonhighteencount + "\n"
							+ "어른 ," + morningadultcount + "," + afternoonadultcount + "\n" + "노인 ," + morningoldcount + "," + afternoonoldcount 
							+ "\n합계 ," + morningcount + "," + afternooncount + "\n매출 ," + morningsum + "," + afternoonsum;
			System.out.println("========== 일자별 매출 현황 ==========");
			int sum = 0;
			int sum1 = 0;
			int totalcount = 0;
			int normalcount = 0;
			int handicapcount = 0;
			int nationalcount = 0;
			int manycount = 0;
			int pregnantcount = 0;
			for (int i = 0; i < list.size(); i++) {
				totalcount += Integer.parseInt(list.get(i).get(3));
				
				if (list.get(i).get(5).equals("없음")) {
					normalcount += Integer.parseInt(list.get(i).get(3));
				} else if (list.get(i).get(5).contains("장애인")) {
					handicapcount += Integer.parseInt(list.get(i).get(3));
				} else if (list.get(i).get(5).equals("국가유공자")) {
					nationalcount += Integer.parseInt(list.get(i).get(3));
				} else if (list.get(i).get(5).equals("다자녀")) {
					manycount += Integer.parseInt(list.get(i).get(3));
				} else if (list.get(i).get(5).equals("임산부")) {
					pregnantcount += Integer.parseInt(list.get(i).get(3));
				}
				
			}
			
			HashSet<String> hash = new HashSet<String>();
			for (int i = 0; i < list.size(); i++) {
				hash.add(list.get(i).get(0));
			}
			Iterator<String> iter = hash.iterator();
			
			ArrayList<String> array = new ArrayList<String>();
			while(iter.hasNext()) {
				int i = 0;
				array.add(iter.next());
				i++;
			}
			//ArrayList<String> array = new ArrayList<String>(hash); 도 가능
			
			Collections.sort(array);
			String data = "";
			for (int i = 0; i < array.size(); i++) {
				int daySum = 0;
				for (int j = 0; j < list.size(); j++) {
					if (array.get(i).equals(list.get(j).get(0))) {
						daySum += Integer.parseInt(list.get(j).get(4));
					}
				}
				data += array.get(i) + ",";	//파일에 쓰기위해서 날짜 저장
				data += daySum + "\n";		//파일에 쓰기위해서 총매출액 저장
				System.out.printf("%s : 총 매출 %d원\n", array.get(i), daySum);
			}
			
			
			System.out.printf("------------------------------------------\n\n");
			System.out.print("===== 우대권 판매 현황 ====\n");
			System.out.printf("총 판매 티켓수   : %d매\n우대 없음        : %d매\n장애인           : %d매\n국가유공자       : %d매\n다자녀           : %d매\n임산부           : %d매\n" 
						, totalcount, normalcount, handicapcount, nationalcount, manycount, pregnantcount);
			System.out.printf("————————————-----------------\n");
			
			FileWriter fw = new FileWriter(ConstValueClass.wirteaddress, true);
			fw.write(data);
			fw.close();
			
			FileWriter fw2 = new FileWriter(ConstValueClass.writetypetotalPrice, true);
			fw2.write(data3);
			fw2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
