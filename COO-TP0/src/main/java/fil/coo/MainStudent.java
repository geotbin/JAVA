package fil.coo;

import java.util.ArrayList;

public class MainStudent {

	public static void main(String args[]) {
		
		ArrayList<Student> someStudents = new ArrayList<Student>();
		Student st1 = new Student("1", "Jean");
		Student st2 = new Student("2", "Marc");
		someStudents.add(st1);
		someStudents.add(st2);
		
		for(Student s : someStudents) {
			System.out.println("L'étudiant n°" + s.getNumStudent() + " s'appelle " + s.getNameStudent());
		}

	}
	
}
