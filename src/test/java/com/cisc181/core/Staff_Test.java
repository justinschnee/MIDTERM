package com.cisc181.core;

import static org.junit.Assert.*;



import com.cisc181.eNums.eTitle;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Date;



public class Staff_Test {
	
	//Arraylist of staff	
	static ArrayList<Staff> staff = new ArrayList<Staff>();
	
	public static Date newDate(int yr, int mn, int day){
		Calendar Cal = Calendar.getInstance();
		Cal.set(yr,  mn, day);
		return Cal.getTime();
	
	}
	
	
	//five people added to the ArrayList
	@BeforeClass
	public static void setup() throws PersonException{
		
		staff.add(new Staff("Justin", "Blake", "Schnee", newDate(1998, 5, 22),"Catskill Court",
				"(201)-919-0998","jschnee@udel.edu","M 6:00-8:00pm",4, 120000, newDate(2012, 1,14), eTitle.MR));
		
		staff.add(new Staff("Joey", "Matt", "Lavake", newDate(1990, 2, 14),"HM Road",
				"(217)-212-2984","joeyl@aol.com","M 11:00-12:00pm",3, 200000, newDate(2010, 6, 12), eTitle.MR));
		
		staff.add(new Staff("Patrick", "Smith", "Kane", newDate(1989, 6, 12),"Bardown Lane",
				"(908)-876-2972","blackhawks@aol.com","W 2:30-4:00pm",1, 100000, newDate(2011, 8,12), eTitle.MRS));
		
		staff.add(new Staff("Andrew", "Money", "Luck", newDate(1999, 10, 1),"Colt Court",
				"(672)-678-9191","coltsqb@aol.com","TH 12:00-2:00pm",2, 130000, newDate(2012, 5,30), eTitle.MR));
		
		staff.add(new Staff("Adam", "John", "Henrique", newDate(1975, 9, 2),"Devils Way",
				"(123)-234-0999","AdamHenrique@gmail.com","T 1:00-3:00pm",5, 150000, newDate(2015, 12,10), eTitle.MS));
		
		
	}
	
	@Test 
	public void testAvgSalary()  throws PersonException{
		double sum = 0;
		for (Staff avgStaff : staff){
			sum = sum + avgStaff.getSalary();
		}
		
		double AvrgSalary = (sum / staff.size());
		
		assertEquals(140000,AvrgSalary, 0.1);

	}	
	
	@Test (expected = PersonException.class)
	public void testPhonefail() throws PersonException{
		
		new Staff("Patrick", "Smith", "Kane", newDate(1989, 6, 12),"Bardown Lane",
				"1-(908)-876-2972","blackhawks@aol.com","W 2:30-4:00pm",1, 100000, newDate(2011, 8,12), eTitle.MRS);
}
	
	@Test (expected = PersonException.class)
	public void testDOBfail() throws PersonException{
		
		new Staff("Adam", "John", "Henrique", newDate(4018, 13, 2),"Devils Way",
				"(123)-234-0999","AdamHenrique@gmail.com","T 1:00-3:00pm",5, 150000, newDate(2015, 12,10), eTitle.MS);
	}
	

}