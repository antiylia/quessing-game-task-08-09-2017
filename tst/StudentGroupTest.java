
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class StudentGroupTest {

	private static StudentArrayOperation studentOperation;
	
	int index = 1;
	
	Date date1 = Main.transformIntoDate ("1999-10-23");
	Date date2 = Main.transformIntoDate ("1997-08-20");
	Date date3 = Main.transformIntoDate ("1999-11-13");
	Date date4 = Main.transformIntoDate ("2000-12-03");
	
	
	Student [] students = {
			     new Student(1, "Bob Smith1", date1, 8.1),
                 new Student(2, "Bob Smith2", date2, 9.2),
                 new Student(4, "Bob Smith4", date3, 9.2),
                 new Student(5, "Bob Smith5", date4, 9.1) };
	
	Student newStudent =  new Student(6, "Bob Smith10", date1, 5);
		
		  
	@Before
	public void initStudentArrayOperation() {
		studentOperation = new StudentGroup();
		}
	
	// Student[] getStudents();
	@Test 
    public void returnedArrStudentsIsNotNull () {
		Student[] student = studentOperation.getStudents();
		assertNotNull("Array students is null", student);
	}
	
	//void setStudents(Student[] students);
	@Test
	public void settedArrayIsCorrect () {
		studentOperation.setStudents(students);
		assertArrayEquals(students, studentOperation.getStudents());
	}	
	
	//Student getStudent(int index);
	@Test
	public void returnedStudentIsCorrect () {
		
		Student[] students = studentOperation.getStudents();
		Student student1 = students[index];
		
		Student student2 = studentOperation.getStudent(index);
		
		assertEquals(student1, student2);
	}
	
	//void setStudent(Student student, int index);
	@Test
	public void arrayContainsSettedStudent () {
		studentOperation.setStudent(newStudent, index);
		
		Student studentInArrayAfterChanges = studentOperation.getStudent(index);
		assertEquals(newStudent, studentInArrayAfterChanges);
	}
	
	//void add(Student student, int index);
	@Test
	public void arrayAfterAdding () {
		studentOperation.setStudents(students);
		int sizeBeforeAdding = studentOperation.getStudents().length; 
		
		studentOperation.add(newStudent, index);
		int sizeAfterAdding = studentOperation.getStudents().length; 
		
		assertFalse( sizeBeforeAdding >= sizeAfterAdding );
		assertEquals(newStudent, studentOperation.getStudent(index));
	}
	
	//void addFirst(Student student);
	@Test
	public void arrayAfterAddingFirst () {
		studentOperation.setStudents(students);
		int sizeBeforeAdding = studentOperation.getStudents().length; 
		
		studentOperation.addFirst(newStudent);
		int sizeAfterAdding = studentOperation.getStudents().length; 
		
		assertFalse( sizeBeforeAdding >= sizeAfterAdding );
		assertEquals(newStudent, studentOperation.getStudent(0));
	}
	
	//void addLast(Student student);
	@Test
	public void arrayAfterAddingLast () {
		studentOperation.setStudents(students);
		int sizeBeforeAdding = studentOperation.getStudents().length; 
		
		studentOperation.addLast(newStudent);
		int sizeAfterAdding = studentOperation.getStudents().length; 
		
		assertFalse( sizeBeforeAdding >= sizeAfterAdding );
		int length = sizeBeforeAdding;
		assertEquals(newStudent, studentOperation.getStudent(length));
	}
	
	//void remove(int index);
	@Test
	public void arrayAfterRemovingIndex () {
		studentOperation.setStudents(students);
		
		int sizeBeforeRemoving = studentOperation.getStudents().length; 
		int index = 2;
		Student studentRemov = studentOperation.getStudent(index);
		
		studentOperation.remove(index);
		int sizeAfterRemoving = studentOperation.getStudents().length; 
		assertFalse( sizeBeforeRemoving <= sizeAfterRemoving);
			
		assertNotEquals(studentRemov, studentOperation.getStudent(index));
	}
	
	// void remove(Student student);
	@Test
	public void arrayAfterRemovingInstance () {
		
		Student [] students = {
			    new Student(1, "Bob Smith1", date1, 8.1),
                new Student(2, "Bob Smith2", date2, 9.2),
                new Student(4, "Bob Smith4", date3, 9.2),
                new Student(5, "Bob Smith5", date4, 9.1) };
		
		studentOperation.setStudents(students);
				
		int sizeBeforeRemoving = studentOperation.getStudents().length; 
		
		Student studentForRemov = new Student(4, "Bob Smith4", date3, 9.2);
		studentOperation.remove(studentForRemov);
		
		int sizeAfterRemoving = studentOperation.getStudents().length; 
			
		assertFalse(sizeBeforeRemoving <= sizeAfterRemoving);
	
		for (Student a: studentOperation.getStudents()) {
		   if (a.equals(studentForRemov)) {
			   fail();
		   }
		}		
	}
	
	//void removeFromIndex(int index);
	
	@Test
	public void arrayAfterRemovingFromIndex () {
		
		Student [] students = {
			    new Student(1, "Bob Smith1", date1, 8.1),
                new Student(2, "Bob Smith2", date2, 9.2),
                new Student(4, "Bob Smith4", date3, 9.2),
                new Student(5, "Bob Smith5", date4, 9.1) };
		
		studentOperation.setStudents(students);
				
		int index = 2;
		studentOperation.removeFromIndex(index);
		int sizeAfterRemoving = studentOperation.getStudents().length; 
			
		assertTrue((index+1) == sizeAfterRemoving);
	      }
	
	
	// void removeFromElement(Student student);
	@Test
	public void arrayAfterRemovingFromInstance () {
		
		Student [] students = {
			    new Student(1, "Bob Smith1", date1, 8.1),
                new Student(2, "Bob Smith2", date2, 9.2),
                new Student(4, "Bob Smith4", date3, 9.2),
                new Student(5, "Bob Smith5", date4, 9.1) };
		
		studentOperation.setStudents(students);
				
		int sizeBeforeRemoving = studentOperation.getStudents().length; 
		
		Student studentFromRemov = new Student(4, "Bob Smith4", date3, 9.2);
		studentOperation.removeFromElement(studentFromRemov);
		
		int sizeAfterRemoving = studentOperation.getStudents().length; 
		assertFalse(sizeBeforeRemoving <= sizeAfterRemoving);
	
		boolean flag = false;
		for (Student a: studentOperation.getStudents()) {
			if (a.equals(studentFromRemov)) {
				flag = true;
		   }
		}
			assertTrue(flag);   
	}
	
	
	//void removeToIndex(int index);
	
		@Test
		public void arrayAfterRemovingToIndex () {
			
			Student [] students = {
				    new Student(1, "Bob Smith1", date1, 8.1),
	                new Student(2, "Bob Smith2", date2, 9.2),
	                new Student(4, "Bob Smith4", date3, 9.2),
	                new Student(5, "Bob Smith5", date4, 9.1) };
			
			studentOperation.setStudents(students);
			int sizeBeforeRemoving = studentOperation.getStudents().length; 
					
			int index = 2;
			studentOperation.removeToIndex(index);
			int sizeAfterRemoving = studentOperation.getStudents().length; 
				
			assertTrue((sizeBeforeRemoving-index) == sizeAfterRemoving);
			
			boolean flag = false;
			for (Student a: studentOperation.getStudents()) {
				if (a.equals(students[index])) {
					flag = true;
			   }
			}
				assertTrue(flag);
				
		  }
	
		// void removeToElement(Student student);
		@Test
		public void arrayAfterRemovingToInstance () {
			
			Student [] students = {
				    new Student(1, "Bob Smith1", date1, 8.1),
	                new Student(2, "Bob Smith2", date2, 9.2),
	                new Student(4, "Bob Smith4", date3, 9.2),
	                new Student(5, "Bob Smith5", date4, 9.1) };
			
			studentOperation.setStudents(students);
			int sizeBeforeRemoving = studentOperation.getStudents().length; 
			
			Student studentToRemov = new Student(4, "Bob Smith4", date3, 9.2);
			studentOperation.removeToElement(studentToRemov);
					
			int sizeAfterRemoving = studentOperation.getStudents().length; 
			assertFalse(sizeBeforeRemoving <= sizeAfterRemoving);
			
			boolean flag = false;
			for (Student a: studentOperation.getStudents()) {
				if (a.equals(studentToRemov)) {
					flag = true;
			   }
			}
				assertTrue(flag);
					
		  }
		
	// void bubbleSort();	
	@Test
	 public void isCorrectOrderAfterBubleSort () {		
		Student [] students = {
			    new Student(1, "Bob Smith4", date1, 8.1),
                new Student(2, "Bob Smith3", date2, 9.2),
                new Student(4, "Bob Smith1", date3, 9.2),
                new Student(5, "Bob Smith2", date4, 9.1) };
		
		studentOperation.setStudents(students);
		studentOperation.bubbleSort();
		Student [] resultStudent = studentOperation.getStudents();
			
		boolean flag = true;
		int i, y;
			
		for (i=0, y=1; i<resultStudent.length & y< resultStudent.length; i++, y++) {
			if (resultStudent[i].getFullName().compareTo(resultStudent[y].getFullName())>0) {
				flag = false;
		   }		
		}
		assertTrue(flag);				
	}
	
	// Student[] getByBirthDate(Date date);
	 @Test
	public void studentsWithSpecifiedDateBirth () {			
		Student [] students = {
			    new Student(1, "Bob Smith1", date1, 8.1),
                new Student(2, "Bob Smith2", date2, 9.2),
                new Student(4, "Bob Smith4", date3, 9.2),
                new Student(5, "Bob Smith5", date4, 9.1) };
		
		studentOperation.setStudents(students);
		Date checkDate = date3;
		Student [] resultStudents = studentOperation.getByBirthDate(checkDate);
	
		boolean flag = true;
		for (Student a: resultStudents) {
			if (a.getBirthDate().getTime()>checkDate.getTime()) {
				flag = false;
		   }		
		}
		assertTrue(flag);	
	 }
	 
 // getBetweenBirthDates(Date firstDate, Date lastDate) 
	 @Test
    public void studentsBetweenDates () {	
	 Student [] students = {
			 new Student(1, "Bob Smith1", date1, 8.1),
             new Student(2, "Bob Smith2", date2, 9.2),
             new Student(4, "Bob Smith4", date3, 9.2),
             new Student(5, "Bob Smith5", date4, 9.1) };
		
		studentOperation.setStudents(students);
		Date firstDate = date2;
		Date lastDate = date4;
	 
  Student [] resultStudents = studentOperation.getBetweenBirthDates(firstDate, lastDate);
		
  boolean flag = true;
  	 for (Student a: resultStudents) {
		  boolean a1 = a.getBirthDate().getTime() < firstDate.getTime();
		  boolean a2 = a.getBirthDate().getTime() > lastDate.getTime();
			 
		if ( a1 || a2 ) {
			flag = false;
	      }		
	  }
	assertTrue(flag);	
   }
	 
	// Student[] getNearBirthDate(Date date, int days);
	  @Test
	 public void studentsNearBirthDates () {	 
		Student [] students = {
					 new Student(1, "Bob Smith1", date1, 8.1),
		             new Student(2, "Bob Smith2", date2, 9.2),
		             new Student(4, "Bob Smith4", date3, 9.2),
		             new Student(5, "Bob Smith5", date4, 9.1) };
				
	  studentOperation.setStudents(students);
	  
	  Date checkDate = Main.transformIntoDate ("1999-10-20");
	  int amountDays = 30;
	  Student [] resultStudents = studentOperation.getNearBirthDate(checkDate, amountDays);
		
	  boolean flag = true;
	  	 for (Student a: resultStudents) {
			  boolean a1 = a.getBirthDate().getTime() < checkDate.getTime();
			  boolean a2 = a.getBirthDate().getTime() > (checkDate.getTime() + amountDays*86_400_000L);
				 
			if ( a1 || a2 ) {
				flag = false;
		      }		
		  }
		assertTrue(flag);	
	   
	 }
	 
	// int getCurrentAgeByDate(int indexOfStudent);
	  @Test
    public void studentsCurrentAge () {  
		  Student [] students = {
					 new Student(1, "Bob Smith1", date1, 8.1),
		             new Student(2, "Bob Smith2", date2, 9.2),
		             new Student(4, "Bob Smith4", date3, 9.2),
		             new Student(5, "Bob Smith5", date4, 9.1) };
				
	    studentOperation.setStudents(students);
	    int indexStudent = 3;
	    int age = studentOperation.getCurrentAgeByDate(indexStudent);
	    Date dateBirth = studentOperation.getStudent(indexStudent).getBirthDate();
	    
	    long year = 31_536_000_000L;
	    int ageCheck =(int) (( new Date().getTime() - dateBirth.getTime() ) / year);
	       
	    assertTrue("Uncorrect students' age ", age == ageCheck);
	   }  
	  
	  
	//  Student[] getStudentsByAge(int age);
	  @Test  
     public void studentsByAge () {	 
		Student [] students = {
						 new Student(1, "Bob Smith1", date1, 8.1),
			             new Student(2, "Bob Smith2", date2, 9.2),
			             new Student(4, "Bob Smith4", date3, 9.2),
			             new Student(5, "Bob Smith5", date4, 9.1) };
					
		  studentOperation.setStudents(students);
	   int age = 17;  
       Student [] resultStudents = studentOperation.getStudentsByAge(age); 
            
       boolean flag = true;
       long year = 31_536_000_000L;
		for (Student a: resultStudents) {
			int studentAge = (int) ((new Date().getTime() - a.getBirthDate().getTime())/year);
			if (studentAge != age) {
				flag = false;
		   }		
		}
		assertTrue(flag);
	 }
	
	  
	//Student[] getStudentsWithMaxAvgMark();
	  @Test  
	  public void studentsWithMaxAvgMark() {	 
		  Student [] students = {
					 new Student(1, "Bob Smith1", date1, 8.1),
		             new Student(2, "Bob Smith2", date2, 9.2),
		             new Student(4, "Bob Smith4", date3, 9.2),
		             new Student(5, "Bob Smith5", date4, 9.1) };
				
	    studentOperation.setStudents(students);
	    Student [] resultStudents = studentOperation.getStudentsWithMaxAvgMark();
	    boolean flag = true;
	    int i, y;
	    for (i=0; i<resultStudents.length; i++) {
	    	for (y=0;  y< students.length; y++) {
	    		if (resultStudents[i].getAvgMark()<students[y].getAvgMark()) {
	    			flag=false;
	    		}
	    	}	
	    }
	    assertTrue(flag);
	 }
		  
	// Student getNextStudent(Student student);  
	  @Test  
	  public void getNextStudent() {	
		  Student [] students = {
					 new Student(1, "Bob Smith1", date1, 8.1),
		             new Student(2, "Bob Smith2", date2, 9.2),
		             new Student(4, "Bob Smith4", date3, 9.2),
		             new Student(5, "Bob Smith5", date4, 9.1) };
				
	    studentOperation.setStudents(students);
	    Student student = new Student(4, "Bob Smith4", date3, 9.2);
	    Student foundStudent = studentOperation.getNextStudent(student);
	  
	    
	    int index=-1;
	    for (int i=0; i<studentOperation.getStudents().length; i++) {
	    	if (studentOperation.getStudents()[i].equals(foundStudent)) {
	    		index = i;
	    	}	    
	    } 
	  boolean cond = studentOperation.getStudent(index-1).equals(student);
	  assertTrue(cond);
	  }
 }
