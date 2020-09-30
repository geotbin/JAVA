package fil.coo;



public class Student 
{	
	/**
	 * Number of the student
	 */
	private String numStudent;
	
	/**
	 * Name of the student
	 */
	private String nameStudent;
	
	/**
	 * Constructor of "Student"
	 * 
	 * @param numStudent
	 * 		Number of the student
	 * @param nameStudent
	 * 		Name of the student
	 * 
	 */
	public Student(String numStudent, String nameStudent) {
		this.setNumStudent(numStudent);
		this.setNameStudent(nameStudent);
	}
    
	/**
	 * @return nameStudent
	 * 		return the name of the Student as a string
	 */
	public String getNameStudent() {
		return nameStudent;
	}
	
	/**
	 * @param nameStudent
	 * 		setting the new name of the student
	 */
	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}
	
	/**
	 * @return numStudent
	 * 		return the number of the Student as a string
	 */
	public String getNumStudent() {
		return numStudent;
	}
	
	/**
	 * @param numStudent
	 * 		setting the new name of the student
	 */
	public void setNumStudent(String numStudent) {
		this.numStudent = numStudent;
	}
	
	/**
	 * @param obj 
	 * 		Object
	 * @return boolean 
	 * 		check if the object is whether or not same as "Student" which called for "equals"
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (nameStudent == null) {
			if (other.nameStudent != null)
				return false;
		} else if (!nameStudent.equals(other.nameStudent))
			return false;
		if (numStudent == null) {
			if (other.numStudent != null)
				return false;
		} else if (!numStudent.equals(other.numStudent))
			return false;
		return true;
	}
}
