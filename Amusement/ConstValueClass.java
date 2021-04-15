package Amusement;

import java.util.ArrayList;

public class ConstValueClass {
	public static final int Morning_Ticket = 1;
	public static final int Afternoon_Ticket = 2;
	
	public static final int Normal_person = 1;
	public static final int Handicap = 2;
	public static final int National = 3;
	public static final int Many = 4;
	public static final int Pregnant = 5;
	
	public static final int Morning_Adult = 56000;
	public static final int Morning_Highteen = 47000;
	public static final int Morning_Young = 44000;
	public static final int Morning_Old = 44000;
	public static final int Morning_baby = 0;
	
	public static final int Afternoon_Adult = 46000;
	public static final int Afternoon_Highteen = 40000;
	public static final int Afternoon_Young = 37000;
	public static final int Afternoon_old = 40000;
	public static final int Afternoon_baby = 0;
	
	public static final double Discount_Handicap = 0.4;
	public static final double Discount_National = 0.5;
	public static final double Discount_Many = 0.2;
	public static final double Discount_Pregnant = 0.15;
	
	public static ArrayList<Integer> ticketType_Morning	= new ArrayList<Integer>();
	public static ArrayList<Integer> ticketType_Afternoon	= new ArrayList<Integer>();
	public static ArrayList<Integer> ticketCount = new ArrayList<Integer>();
	public static ArrayList<Integer> handicap = new ArrayList<Integer>();
	public static ArrayList<Integer> price = new ArrayList<Integer>();
	
}
