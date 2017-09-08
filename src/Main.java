package by.htp.padawanssecond;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main (String [] args) {
		
		Date date1 = transformIntoDate ("1999-10-23");
		Date date2 = transformIntoDate ("1997-08-20");
		Date date3 = transformIntoDate ("1999-11-13");
		Date date4 = transformIntoDate ("2000-12-03");
		Date date5 = transformIntoDate ("2001-10-15");
		
		
		Student students [] = { new Student(1, "Bob Smith1", date1, 8.1), 
				                new Student(2, "Bob Smith2", date2, 9.2), 
				                new Student(3, "Bob Smith3", date3, 6.7),
				                new Student(4, "Bob Smith4", date4, 9.2),
				                new Student(5, "Bob Smith5", date5, 9.1)};
		
				
		StudentGroup studentGroup  = new StudentGroup (students.length);
		studentGroup.setStudents(students);
			
		
		for (Student a: studentGroup.getStudents()) {
			System.out.println(a.toString());
		}
		System.out.println();
		
		Date dateF = transformIntoDate ("2000-10-01");
		Date dateL = transformIntoDate ("2002-10-01");
		
		
		for (Student a: studentGroup.getBetweenBirthDates(dateF, dateL)) {
			System.out.println(a.toString());
		}
		System.out.println();
		
		
		
		for (Student a: studentGroup.getStudentsWithMaxAvgMark()) {
			System.out.println(a.toString());
		}
		System.out.println();
				
		
  }
		
		public static Date transformIntoDate (String date) {
		SimpleDateFormat simFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date dateUtil = null;
		try {
			dateUtil = simFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dateUtil;
	  }
	
}
