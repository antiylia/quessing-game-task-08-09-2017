package by.htp.padawanssecond;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Comparable {

	/**
	 * student id
	 */
	private int id;

	/**
	 * student name and surname separated by the whitespace for example:
	 * fullName = "David Luis";
	 */
	private String fullName;

	/**
	 * student date of birth in "yyyy-MM-dd" format
	 */
	private Date birthDate;

	/**
	 * student average mark
	 */
	private double avgMark;
	
	
	public Student() {
		
	}

	public Student(int id, String fullName, Date birthDate, double avgMark) {
		this.id = id;
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.avgMark = avgMark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthDate() {
		return birthDate;
	}
	
	
	
	    // I'm not sure how to implement that
		/**
		 * student date of birth in "yyyy-MM-dd" format
		 */	
	
	public static String transformDateIntoString (Date date) {
		if (date == null) {
			throw new IllegalArgumentException();
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sf.format(date);
		return dateStr;
	  }
		
	
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public double getAvgMark() {
		return avgMark;
	}

	public void setAvgMark(double avgMark) {
		this.avgMark = avgMark;
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avgMark);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Double.doubleToLongBits(avgMark) != Double.doubleToLongBits(other.avgMark))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * DO NOT change this method it will be used during the task check
	 */
	@Override
	public int compareTo(Object o) {
		Student other = (Student) o;
		return (this.fullName.compareTo(other.fullName));
	}

	@Override
	public String toString() {
		return "Student id=" + id + ", fullName=" + fullName + ", birthDate=" + transformDateIntoString(birthDate) + ", avgMark=" + avgMark;
	}
		
	
	
}