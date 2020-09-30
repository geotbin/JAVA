package fil.coo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



/**
 * Unit test for Student Class
 *
 */
public class StudentTest {
	
	
	
	/**
	 * initializing Student object before each test
	 */
	Student st;
	
	@Before public void initialize() {
		st = new Student("12", "A");
	}
	
	@Test
	public void testSettingNameOfStudent() {
		st.setNameStudent("B");
		assertEquals("B", st.getNameStudent());
	}
	
	@Test
	public void testSettingNumberOfStudent() {
		st.setNumStudent("178");
		assertEquals("178", st.getNumStudent());
	}
	
	@Test
	public void testEqualsStudentWithDifferentName() {
		Student st2 = new Student("12", "WWW");
		assertEquals(false, st.equals(st2));
	}

	@Test public void testEqualsStudentWithDifferentNumber() {
		Student st2 = new Student("14", "A");
		assertEquals(false, st.equals(st2));
	}
	
	@Test public void testEqualsStudentSameNameSameNumber() {
		Student st2 = new Student("12", "A");
		assertEquals(true, st.equals(st2));
	}
}
