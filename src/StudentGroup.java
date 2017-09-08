package by.htp.padawanssecond;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentGroup {
/*
array length should always be equal to the number of stored elements
after the element was removed the size of the array should be equal to the number of stored elements
after the element was added the size of the array should be equal to the number of stored elements
null elements are not allowed to be stored in the array
 */
	
	private Student[] students;
	int size = 0;

	public StudentGroup() {
		students = new Student[2];
		this.size = students.length;
	}
	
	
	public StudentGroup(int length) {
		students = new Student[length];
		this.size = length;
	}

	

	// implementation
	public Student[] getStudents() {
		return students;
	}
		

	public void setStudents(Student[] students) {
		if (students == null) {
			throw new IllegalArgumentException();
		}
		this.students = students;
		this.size = students.length;
	}

	
	
	public Student getStudent(int index) {
		if (index >= students.length || index < 0) {
			throw new IllegalArgumentException();
		}
		return students[index];
	}

	
	
	public void setStudent(Student student, int index) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		if (index >= students.length || index < 0) {
			throw new IllegalArgumentException();
		}
		students[index] = student;
	  }
	
	
	
	
	public void add(Student student, int index) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		if (index >= students.length || index < 0) {
			throw new IllegalArgumentException();
		}
		if (students[index] == null) {
			students[index] = student;
			size++;
		} else {
			Student[] studentsNew = new Student[students.length + 1];
			int i, y;

			for (i = 0, y = 0; i < studentsNew.length & y < index; i++, y++) {
				studentsNew[i] = students[y];
			}
			studentsNew[index] = student;

			for (i = index + 1, y = index; i < studentsNew.length & y < students.length; i++, y++) {
				studentsNew[i] = students[y];
			}
			students = studentsNew;
			size = students.length;
		}		
	}
	
	
	
	
	
	public void addFirst(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		add (student, 0);
	}

	
		
	
	public void addLast(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		Student[] studentsNew = new Student[students.length + 1];
		int i, y;
		for (i = 0, y = 0; i < studentsNew.length & y < students.length; i++, y++) {
			studentsNew[i] = students[y];
		}
		studentsNew[studentsNew.length - 1] = student;
		students = studentsNew;
		size = students.length;
	}
	
	


	public void remove(int index) {
		if (index >= students.length || index < 0) {
			throw new IllegalArgumentException();
		}
		Student[] studentsNew = new Student[students.length - 1];
		int i, y;

		for (i = 0, y = 0; i < studentsNew.length & y < index; i++, y++) {
			studentsNew[i] = students[y];
		}
		for (i = index, y = index + 1; i < studentsNew.length & y < students.length; i++, y++) {
			studentsNew[i] = students[y];
		}
		students = studentsNew;
		size = students.length;
	}
	
	
	
	
 // Removes the first occurrence of the specified element from this array	
	public void remove(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		int index = findIndexStudent(student);
		if (index != -1) {
			remove(index);
		}
	}

	
	
	private int findIndexStudent(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		int index = -1;
			for (int i = 0; i < students.length; i++) { 
				if (student.equals(students[i])) {
					index = i;
					break;
				} else {
					throw new IllegalArgumentException("Student not exist");		
				}
		     }
		return index;
	  }

	
	
	// Removes all elements from the specified element 
	// (except the specified element)
	
	public void removeFromIndex(int index) {
	   if (index >= students.length || index < 0) {
			throw new IllegalArgumentException();
		}
	    int position = index + 1;
		Student[] studentsNew = new Student[position];

		int i, y;
		for (i = 0, y = 0; i < studentsNew.length & y < position; i++, y++) {
			studentsNew[i] = students[y];
		}
		students = studentsNew;
		size = students.length;
	}

	
	
	public void removeFromElement(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		int index = findIndexStudent(student);
		removeFromIndex(index);
	}

	
	
	// Removes all elements to the specified index
	// (except the element with the specified index)
	public void removeToIndex(int index) {
		if (index >= students.length || index < 0) {
			throw new IllegalArgumentException();
		}
		int position = index;
		Student[] studentsNew = new Student[students.length - position];
		int i, y;
		for (i = 0, y = position; i < studentsNew.length & y < students.length; i++, y++) {
			studentsNew[i] = students[y];
		}
		students = studentsNew;
		size = students.length;
	}
	

		
	
	public void removeToElement(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		int index = findIndexStudent(student);
		removeToIndex(index);
	}

		
	
	public void bubbleSort() {
		for (int i = 0; i < students.length - 1; i++) {
			for (int j = 0; j < i; j++) {
				if (students[j].compareTo(students[j + 1]) > 0) {
					Student buffer = students[j];
					students[j] = students[j + 1];
					students[j + 1] = buffer;
				}
			}
		}
	}

		
	
	public Student[] getByBirthDate(Date date) {
		if (date == null) {
			throw new IllegalArgumentException();
		}
		int nessesarySize = 0;
			
		for (int i = 0; i<students.length; i++) {
			if (students[i].getBirthDate().getTime() <= date.getTime()) {
				nessesarySize++;		
		   }
		}
		Student [] newStudents = new Student[nessesarySize]; 	
		
		int i, y;
		for (i = 0, y = 0; i < newStudents.length & y < students.length; y++) {
			if (students[y] != null) {
				if (students[i].getBirthDate().getTime() <= date.getTime()) {
					newStudents[i] = students[y];
					i++;
				}
			}
		}
		
	  return newStudents;
	}
	
		
	
	
	
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		if (firstDate == null || lastDate == null) {
			throw new IllegalArgumentException();
		}
		int nessesarySize = 0;
				
		for (int i = 0; i<students.length; i++) {
			if (firstDate.getTime() <= students[i].getBirthDate().getTime() & students[i].getBirthDate().getTime() <= lastDate.getTime()) {
				nessesarySize++;		
		   }
		}
		Student [] newStudents = new Student[nessesarySize];
		
		int i, y;
	   for (i = 0, y = 0; i < newStudents.length & y < students.length; y++) {
			if (students[y] != null) {
				if (firstDate.getTime() <= students[y].getBirthDate().getTime()	& students[y].getBirthDate().getTime() <= lastDate.getTime()) {
					newStudents[i] = students[y];
					i++;
				}
			}
		}
		return newStudents;
	}
	
		
	

	public Student[] getNearBirthDate(Date date, int days) {
		if (date == null) {
			throw new IllegalArgumentException();
		}
		long milliseconds = date.getTime();
		long addMilliseconds = days * 86_400_000L;

		Date dateLate = new Date(milliseconds + addMilliseconds);
		return getBetweenBirthDates(date, dateLate);
	}

		
	 // Is it nesserary only 
	//  one checking ????    ( if indexOfStudent == 0)
	
	public int getCurrentAgeByDate(int indexOfStudent) {
		if (indexOfStudent >= students.length || indexOfStudent <= 0) {
			throw new IllegalArgumentException();
		}
		int age = 0;
		Student student = getStudent(indexOfStudent);
		
		long year = 31_536_000_000L;
		age = (int) ((new Date().getTime() - student.getBirthDate().getTime()) / year);
		return age;
	}

	
	
	
	public Student[] getStudentsByAge(int age) {
		int nessesarySize = 0;
		for (int i=0; i<students.length; i++) {
			if (getCurrentAgeByDate(i) == age) {
				nessesarySize++;
			}
		}
		
		Student[] studentsNew = new Student[nessesarySize];
		
		int i, y;
		for (i = 0, y = 0; i < studentsNew.length & y < students.length; y++) {
			if (getCurrentAgeByDate(y) == age) {
				studentsNew[i] = students[y];
				i++;
			}
		}
		return studentsNew;
	}

		
	
	
	public Student[] getStudentsWithMaxAvgMark() {
		
		double maxAvgMark = 0;
		maxAvgMark = students[0].getAvgMark();
		
		int y, q;
		for (y = 0, q=1; y < students.length & q<students.length; y++, q++) {
			if (students[y].getAvgMark() < students[q].getAvgMark()) {
				maxAvgMark = students[q].getAvgMark();
			}
		}
		
		int nessesarySize = 0;
		for (int i=0; i<students.length; i++) {
			if (students[i].getAvgMark() == maxAvgMark) {
				nessesarySize++;
			}		
		}
				
     	Student[] studentsNew = new Student[nessesarySize];
     	    	
		for (y = 0, q=0; y < studentsNew.length & q<students.length; q++) {
			if (students[q].getAvgMark() == maxAvgMark) {
				studentsNew[y] = students[q];
				y++;
			}			
		}		
		return studentsNew;
	}

	
	
	public Student getNextStudent(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		
		int index = findIndexStudent(student);
		int targetIndex = index + 1;
		
		if (targetIndex >= size) {
		  System.out.println("Founded element hasn't next element");
		}
		return getStudent(targetIndex);
		
	}	
}
