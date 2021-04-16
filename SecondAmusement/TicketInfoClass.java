package SecondAmusement;

public class TicketInfoClass {
	private String ticketType;
	private String id;
	private int ticketCount;
	private String handicap;
	private int totalprice;
	
	

	//주간권, 야간권 결정
	public String getTicketType() {
		return ticketType;
	}
	
	public void setTicketType(int n) {
		if (n == 1) {
			this.ticketType = ConstValueClass.Ticket_Type[0];
		} else if (n == 2) {
			this.ticketType = ConstValueClass.Ticket_Type[1];
		}
	}
	
	//나이판단
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		int realage = checkId(id);
		if (realage >= ConstValueClass.Old) {
			this.id = ConstValueClass.Type[0];
		} else if (realage < ConstValueClass.Old && realage >= ConstValueClass.Adult) {
			this.id = ConstValueClass.Type[1];
		} else if (realage >= ConstValueClass.Highteen && realage < ConstValueClass.Adult) {
			this.id = ConstValueClass.Type[2];
		} else if (realage >= ConstValueClass.young && realage < ConstValueClass.Highteen) {
			this.id = ConstValueClass.Type[3];
		} else if (realage >= ConstValueClass.baby && realage < ConstValueClass.young) {
			this.id = ConstValueClass.Type[4];
		}
	}
	
	//티켓 갯수
	public int getTicketCount() {
		return ticketCount;
	}
	
	public void setTicketCount(int ticketCount) {
		if (ticketCount > 10) {
			System.out.println("10장으로 처리하겠습니다.");
			this.ticketCount = 10;
		} else {
			this.ticketCount = ticketCount;
		}
	}
	
	//우대사항
	public String getHandicap() {
		return handicap;
	}
	
	public void setHandicap(int handicap) {
		if(handicap == 1) {
			this.handicap = ConstValueClass.normalPerson;
		} else if(handicap == 2) {
			this.handicap = ConstValueClass.handicap;
		} else if(handicap == 3) {
			this.handicap = ConstValueClass.national;
		} else if(handicap == 4) {
			this.handicap = ConstValueClass.many;
		} else if(handicap == 5) {
			this.handicap = ConstValueClass.pregnant;
		}
	}
	
	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
	
	//요금계산
	public int Price(int ticketType, String id, int ticketCount) {
		int customerage = checkId(id);
		int totalPrice = 0;
		if (ticketType == ConstValueClass.MorningType) {
			if (customerage > ConstValueClass.Old) {
				totalPrice = ticketCount * ConstValueClass.Morning_Price[3];
			} else if (customerage < ConstValueClass.Old && customerage >= ConstValueClass.Adult) {
				totalPrice = ticketCount * ConstValueClass.Morning_Price[0];
			} else if (customerage < ConstValueClass.Adult && customerage >= ConstValueClass.Highteen) {
				totalPrice = ticketCount * ConstValueClass.Morning_Price[1];
			} else if (customerage < ConstValueClass.Highteen && customerage >= ConstValueClass.young) {
				totalPrice = ticketCount * ConstValueClass.Morning_Price[2];
			} else if (customerage < ConstValueClass.young && customerage >= ConstValueClass.baby) {
				totalPrice = ticketCount * ConstValueClass.Morning_Price[4];
			}
			
		} else if (ticketType == ConstValueClass.AftenoonType) {
			if (customerage > ConstValueClass.Old) {
				totalPrice = ticketCount * ConstValueClass.Afternoon_Price[3];
			} else if (customerage < ConstValueClass.Old && customerage >= ConstValueClass.Adult) {
				totalPrice = ticketCount * ConstValueClass.Afternoon_Price[0];
			} else if (customerage < ConstValueClass.Adult && customerage >= ConstValueClass.Highteen) {
				totalPrice = ticketCount * ConstValueClass.Afternoon_Price[1];
			} else if (customerage < ConstValueClass.Highteen && customerage >= ConstValueClass.young) {
				totalPrice = ticketCount * ConstValueClass.Afternoon_Price[2];
			} else if (customerage < ConstValueClass.young && customerage >= ConstValueClass.baby) {
				totalPrice = ticketCount * ConstValueClass.Afternoon_Price[4];
			}
		}
		
		return totalPrice;
	}
	
	//총계산
	public int totalPrice(int handicapNum, int price) {
		int totalPrice = 0;
		if (handicapNum == ConstValueClass.normalNum) {
			totalPrice = (int)(price * ConstValueClass.Discount[0]);
		} else if (handicapNum == ConstValueClass.handiNum) {
			totalPrice = (int)(price * ConstValueClass.Discount[1]);
		} else if (handicapNum == ConstValueClass.nationalNum) {
			totalPrice = (int)(price * ConstValueClass.Discount[2]);
		} else if (handicapNum == ConstValueClass.manyNum) {
			totalPrice = (int)(price * ConstValueClass.Discount[3]);
		} else if (handicapNum == ConstValueClass.pregnatNum) {
			totalPrice = (int)(price * ConstValueClass.Discount[4]);
		}
		
		
		return totalPrice;
	}
	
	
	
	
	//00년생전후 계산
	public static int checkId(String customerId) {
		int age = Integer.parseInt(customerId.substring(0, 2));
		int realage;
		
		if (age < 22) {
			realage = 21 - age;
		} else { 
			realage = 121 - age;
		}
		
		return realage;
	}
	
}
