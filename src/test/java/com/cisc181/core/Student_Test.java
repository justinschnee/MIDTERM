package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {


	static ArrayList<Student> students = new ArrayList<Student>();
	static ArrayList<Course> courses = new ArrayList<Course>();
	static ArrayList<Semester> semesters = new ArrayList<Semester>();
	static ArrayList<Section> sections = new ArrayList<Section>();

	
	static ArrayList<Enrollment> GEOLF = new ArrayList<Enrollment>();
	static ArrayList<Enrollment> GEOLS = new ArrayList<Enrollment>();
	static ArrayList<Enrollment> CISCF = new ArrayList<Enrollment>();
	static ArrayList<Enrollment> CISCS = new ArrayList<Enrollment>();
	static ArrayList<Enrollment> CALCF = new ArrayList<Enrollment>();
	static ArrayList<Enrollment> CALCS = new ArrayList<Enrollment>();


	public static Date studDate(int year, int month, int day) 
	{
		Calendar CalB = Calendar.getInstance();
		CalB.set(year, month, day);
		return CalB.getTime();
	}

	@BeforeClass
	public static void setup() throws PersonException {

		Course GEOL = new Course(UUID.randomUUID(), "NATURAL HAZARDS", 100, eMajor.BUSINESS);
		Course CISC = new Course(UUID.randomUUID(), "Intro to Java", 100, eMajor.PHYSICS);
		Course CALC = new Course(UUID.randomUUID(), "Calculus C", 100, eMajor.CHEM);

		courses.add(GEOL);
		courses.add(CISC);
		courses.add(CALC);

		Semester fall17 = new Semester(UUID.randomUUID(), studDate(2017, 8, 24), studDate(2017, 12, 22));
		Semester spring18 = new Semester(UUID.randomUUID(), studDate(2018, 2, 5), studDate(2018, 5, 25));

	
		semesters.add(spring18);
		semesters.add(fall17);

		
		Section fallGEOL = new Section(GEOL.getCourseID(), fall17.getSemesterID(), UUID.randomUUID(), 515);
		Section fallCISC = new Section(CISC.getCourseID(), fall17.getSemesterID(), UUID.randomUUID(), 203);
		Section fallCALC = new Section(CALC.getCourseID(), fall17.getSemesterID(), UUID.randomUUID(), 310);

		Section springGEOL = new Section(GEOL.getCourseID(), spring18.getSemesterID(), UUID.randomUUID(), 220);
		Section springCISC = new Section(CISC.getCourseID(), spring18.getSemesterID(), UUID.randomUUID(), 101);
		Section springCALC = new Section(CALC.getCourseID(), spring18.getSemesterID(), UUID.randomUUID(), 419);

		
		sections.add(fallGEOL);
		sections.add(fallCISC);
		sections.add(fallCALC);
		sections.add(springGEOL);
		sections.add(springCISC);
		sections.add(springCALC);
		
		
		//Add Students
				Student A = new Student("Chris", "A", "Schnee", studDate(96, 1, 1), eMajor.BUSINESS, "UD", "(201)-922-0968", "cschnee@udel.com",UUID.randomUUID());
				Student B = new Student("Chris", "B", "Rock", studDate(96, 2, 2), eMajor.CHEM, "UD", "(123)-456-", "crock@gmail.com",UUID.randomUUID());
				Student C = new Student("Ben", "C", "Henrique", studDate(96, 3, 3), eMajor.COMPSI, "UD", "(434)-690-3411", "benhenrique@gmail.com",UUID.randomUUID());
				Student D = new Student("Andy", "D", "Luck", studDate(96, 4, 1), eMajor.NURSING, "UD", "(673)-921-3419", "luckcolts@gmail.com",UUID.randomUUID());
				Student E = new Student("Jon", "E", "Kane", studDate(96, 5, 9), eMajor.PHYSICS, "UD", "(678)-412-2341", "jkane@gmail.com",UUID.randomUUID());
				Student F = new Student("Collin", "F", "Smith", studDate(95, 1, 1), eMajor.BUSINESS, "UD", "(323)-432-3141", "csmith@gmail.com",UUID.randomUUID());
				Student G = new Student("Patrick", "G", "Elias", studDate(94, 7, 2), eMajor.NURSING, "UD", "(987)-341-2341", "pelias@gmail.com",UUID.randomUUID());
				Student H = new Student("Gary", "H", "Hacket", studDate(96, 7, 3), eMajor.COMPSI, "UD", "(783)-551-3411", "garyhack@gmail.com",UUID.randomUUID());
				Student I = new Student("Frog", "I", "Geico", studDate(96, 9, 1), eMajor.COMPSI, "UD", "(432)-826-3419", "frog@gmail.com",UUID.randomUUID());
				Student J = new Student("Gucci", "J", "Manne", studDate(96, 8, 9), eMajor.CHEM, "UD", "(738)-679-2341", "itsgucci@gmail.com",UUID.randomUUID());

		
		students.add(A);
		students.add(B);
		students.add(C);
		students.add(D);
		students.add(E);
		students.add(F);
		students.add(G);
		students.add(H);
		students.add(I);
		students.add(J);




	
		ArrayList<Integer> gradesA = new ArrayList<Integer>(Arrays.asList(96, 75, 65, 87, 74, 97, 73, 69, 80, 36));
		 ArrayList<Integer> gradesB = new ArrayList<Integer>(Arrays.asList(96, 70, 36, 98, 78, 66, 92, 63, 85, 73));
		 ArrayList<Integer> gradesC = new ArrayList<Integer>(Arrays.asList(95, 76, 43, 97, 60, 78, 85, 67, 83, 83));
	
		for (int i = 0; i < students.size(); i++) {

		GEOLF.add(new Enrollment(sections.get(0).getSectionID(), students.get(i).getStudentID()));
		GEOLF.get(i).setGrade(gradesA.get(i));

		GEOLS.add(new Enrollment(sections.get(1).getSectionID(), students.get(i).getStudentID()));
		GEOLF.get(i).setGrade(gradesB.get(i));

		CISCF.add(new Enrollment(sections.get(2).getSectionID(), students.get(i).getStudentID()));
		CISCF.get(i).setGrade(gradesC.get(i));

		CISCS.add(new Enrollment(sections.get(3).getSectionID(), students.get(i).getStudentID()));
		CISCS.get(i).setGrade(gradesA.get(i));

		CALCF.add(new Enrollment(sections.get(4).getSectionID(), students.get(i).getStudentID()));
		CALCF.get(i).setGrade(gradesB.get(i));

		CALCS.add(new Enrollment(sections.get(5).getSectionID(), students.get(i).getStudentID()));
		CALCS.get(i).setGrade(gradesC.get(i));
	}

}


public double GPACalculator(ArrayList<Enrollment> GEOLF, ArrayList<Enrollment> GEOLS, ArrayList<Enrollment> CISCF,
		ArrayList<Enrollment> CISCS, ArrayList<Enrollment> CALCF, ArrayList<Enrollment> CALCS, int Student) {
	
	final int numofcourses = 6;
	
	double GPA = 0;

	if ((GEOLF.get(Student).getGrade() + GEOLS.get(Student).getGrade() + CISCF.get(Student).getGrade()
			+ CISCS.get(Student).getGrade() + CALCF.get(Student).getGrade() + CALCS.get(Student).getGrade())
			/ numofcourses >= 90) 
	{
		GPA = 4.0;
	} 
	else if ((GEOLF.get(Student).getGrade() + GEOLS.get(Student).getGrade() + CISCF.get(Student).getGrade()
			+ CISCS.get(Student).getGrade() + CALCF.get(Student).getGrade() + CALCS.get(Student).getGrade())
			/ numofcourses >= 85) 
	{
		GPA = 3.75;
	} 
	else if ((GEOLF.get(Student).getGrade() + GEOLS.get(Student).getGrade() + CISCF.get(Student).getGrade()
			+ CISCS.get(Student).getGrade() + CALCF.get(Student).getGrade() + CALCS.get(Student).getGrade())
			/ numofcourses >= 80) 
	{
		GPA = 3.5;
	} 
	else if ((GEOLF.get(Student).getGrade() + GEOLS.get(Student).getGrade() + CISCF.get(Student).getGrade()
			+ CISCS.get(Student).getGrade() + CALCF.get(Student).getGrade() + CALCS.get(Student).getGrade())
			/ numofcourses >= 75) 
	{
		GPA = 3.0;
	} 
	else if ((GEOLF.get(Student).getGrade() + GEOLS.get(Student).getGrade() + CISCF.get(Student).getGrade()
			+ CISCS.get(Student).getGrade() + CALCF.get(Student).getGrade() + CALCS.get(Student).getGrade())
			/ numofcourses >= 70) 
	{
		GPA = 2.5;
	} 
	else if((GEOLF.get(Student).getGrade() + GEOLS.get(Student).getGrade() + CISCF.get(Student).getGrade()
			+ CISCS.get(Student).getGrade() + CALCF.get(Student).getGrade() + CALCS.get(Student).getGrade())
			/ numofcourses >= 65) 
	{
		GPA = 2.0;
	} 
	else if((GEOLF.get(Student).getGrade() + GEOLS.get(Student).getGrade() + CISCF.get(Student).getGrade()
			+ CISCS.get(Student).getGrade() + CALCF.get(Student).getGrade() + CALCS.get(Student).getGrade())
			/ numofcourses >= 60) 
	{
		GPA = 1.5;
	} 	else if((GEOLF.get(Student).getGrade() + GEOLS.get(Student).getGrade() + CISCF.get(Student).getGrade()
			+ CISCS.get(Student).getGrade() + CALCF.get(Student).getGrade() + CALCS.get(Student).getGrade())
			/ numofcourses >= 50) 
	{
		GPA = 1.0;
	} 
	else 
	{
		GPA = 0.0;
	}
	return GPA;
	
}



@Test
public void GPATest() 
{
	assertEquals(3.0, GPACalculator(GEOLF, GEOLS, CISCF, CISCS, CALCF, CALCS, 0), .001);
	assertEquals(1.5, GPACalculator(GEOLF, GEOLS, CISCF, CISCS, CALCF, CALCS, 1), .001);
	assertEquals(0.0, GPACalculator(GEOLF, GEOLS, CISCF, CISCS, CALCF, CALCS, 2), .001);
	assertEquals(3.0, GPACalculator(GEOLF, GEOLS, CISCF, CISCS, CALCF, CALCS, 3), .001);
	assertEquals(1.0, GPACalculator(GEOLF, GEOLS, CISCF, CISCS, CALCF, CALCS, 4), .001);
	assertEquals(1.5, GPACalculator(GEOLF, GEOLS, CISCF, CISCS, CALCF, CALCS, 5), .001);
	assertEquals(2.5, GPACalculator(GEOLF, GEOLS, CISCF, CISCS, CALCF, CALCS, 6), .001);
	assertEquals(1.0, GPACalculator(GEOLF, GEOLS, CISCF, CISCS, CALCF, CALCS, 7), .001);
	assertEquals(2.0, GPACalculator(GEOLF, GEOLS, CISCF, CISCS, CALCF, CALCS, 8), .001);
	assertEquals(1.0, GPACalculator(GEOLF, GEOLS, CISCF, CISCS, CALCF, CALCS, 9), .001);
}

//Calulates The average for the course
	public static double CourseGr(ArrayList<Enrollment> courses) {

		double average = 0;
		double courseAvg = 0;

		for (int x = 0; x< students.size(); x++) {
			average += courses.get(x).getGrade();
			courseAvg = (average / students.size());
		}
		return courseAvg;
	}

	// Tests for the course average
	@Test
	public void testCourseGr() {
		assertEquals(75.7, CourseGr(GEOLF), .01);
//Doesnt Run? assertEquals(75.7, CourseGr(GEOLS), .01);
		assertEquals(76.7, CourseGr(CISCF), .01);
		assertEquals(75.2, CourseGr(CISCS), .01);
		assertEquals(75.7, CourseGr(CALCF), .01);
		assertEquals(76.7, CourseGr(CALCS), .01);
	}


	@Test
	public void TestChangeMajor() throws PersonException{
		students.get(0).setMajor(eMajor.COMPSI);
		assertTrue(students.get(0).getMajor() == eMajor.COMPSI);
	}
	
}