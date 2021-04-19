package FourthAmusement;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RunPark {
	
	private String ticketType;
	private String checkId;
	private int ticketCount;
	private String handicap;
	private int price;
	private String year;
	SimpleDateFormat sf = null;
	Date date = null;
	
	public RunPark() {
		sf = new SimpleDateFormat("yyyyMMdd");
		date = new Date();
	}
	
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = sf.format(date);
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(int n) {
		if (n == ConstValueClass.Morning_Ticket) {
			this.ticketType = "주간권";
		} else if (n == ConstValueClass.Afternoon_Ticket) {
			this.ticketType = "야간권";
		}
	}
	public String getCheckId() {
		return checkId;
	}
	public void setCheckId(String checkId) {
		RunPark run = new RunPark();
		int age = run.checkAge(checkId);
		if (age >= ConstValueClass.Old_Age) {
			this.checkId = "노인";
		} else if (age < ConstValueClass.Old_Age && age >= ConstValueClass.Adult_Age) {
			this.checkId = "어른";
		} else if (age < ConstValueClass.Adult_Age && age >= ConstValueClass.Highteen_Age) {
			this.checkId = "청소년";
		} else if (age < ConstValueClass.Highteen_Age && age >= ConstValueClass.Young_Age) {
			this.checkId = "어린이";
		} else if (age < ConstValueClass.Young_Age && age >= 0) {
			this.checkId = "유아";
		}
	}
	public int getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}
	public String getHandicap() {
		return handicap;
	}
	public void setHandicap(int handicap) {
		if (handicap == 1) {
			this.handicap = "없음";
		} else if (handicap == 2) {
			this.handicap = "장애인";
		} else if (handicap == 3) {
			this.handicap = "국가유공자";
		} else if (handicap == 4) {
			this.handicap = "다자녀";
		} else if (handicap == 5) {
			this.handicap = "임산부";
		}
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
		
	}
	
	public int checkAge(String id) {
		SimpleDateFormat sf = new SimpleDateFormat("yy");
		Date date = new Date();
		int checkId = Integer.parseInt(id.substring(0, 2));
		int judgeId = Integer.parseInt(id.substring(6, 7));
		int year = Integer.parseInt(sf.format(date));
		int realage = 0;
		
		if (judgeId == 1 || judgeId == 2) {
			realage = (year + 100) - checkId;
		} else if (judgeId == 3 || judgeId == 4) {
			realage = year - checkId;
		}
		
		return realage;
	}
	
	public int calPrice(int ticketType, String id, int ticketCount) {
		RunPark run = new RunPark();
		int age = run.checkAge(id);
		int totalPrice = 0;
		if (ticketType == ConstValueClass.Morning_Ticket) {
			if (age > ConstValueClass.Old_Age) {
				totalPrice = ConstValueClass.Morning_Old * ticketCount;
			} else if (age < ConstValueClass.Old_Age && age >= ConstValueClass.Adult_Age) {
				totalPrice = ConstValueClass.Morning_Adult * ticketCount;
			} else if (age < ConstValueClass.Adult_Age && age >= ConstValueClass.Highteen_Age) {
				totalPrice = ConstValueClass.Morning_highteen * ticketCount;
			} else if (age < ConstValueClass.Highteen_Age && age >= ConstValueClass.Young_Age) {
				totalPrice = ConstValueClass.Morning_Young * ticketCount;
			} else if (age < ConstValueClass.Young_Age && age >=0) {
				totalPrice = ConstValueClass.Morning_baby * ticketCount;
			}
		} else if (ticketType == ConstValueClass.Afternoon_Ticket) {
			if (age > ConstValueClass.Old_Age) {
				totalPrice = ConstValueClass.Afternoon_Old * ticketCount;
			} else if (age >= ConstValueClass.Adult_Age && age < ConstValueClass.Old_Age) {
				totalPrice = ConstValueClass.Afternoon_Adult * ticketCount;
			} else if (age < ConstValueClass.Adult_Age && age >= ConstValueClass.Highteen_Age) {
				totalPrice = ConstValueClass.Afternoon_Highteen	* ticketCount;
			} else if (age < ConstValueClass.Highteen_Age && age >= ConstValueClass.Young_Age) {
				totalPrice = ConstValueClass.Afternoon_Young * ticketCount;
			} else if (age < ConstValueClass.Young_Age && age >= 0) {
				totalPrice = ConstValueClass.Afternoon_baby * ticketCount;
			}
		}
		
		return totalPrice;
	}
	
	public int handicapPrice(int handicapType, int totalPrice) {
		int result = 0;
		if (handicapType == 1) {
			result = (int)(totalPrice * ConstValueClass.NormalPerson);
		} else if (handicapType == 2) {
			result = (int)(totalPrice * ConstValueClass.Handicap);
		} else if (handicapType == 3) {
			result = (int)(totalPrice * ConstValueClass.National);
		} else if (handicapType == 4) {
			result = (int)(totalPrice * ConstValueClass.Many);
		} else if (handicapType == 5) {
			result = (int)(totalPrice * ConstValueClass.Pregnant);
		}
		
		return result;
	}
	
	
}
