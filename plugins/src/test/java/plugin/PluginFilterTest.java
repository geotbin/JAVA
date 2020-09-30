package plugin;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.FilenameFilter;
import org.junit.Before;
import org.junit.Test;

import plugin.PluginFilter;


public class PluginFilterTest {

	private File dir;
	private FilenameFilter filter;

	@Before
	public void setUp(){
		this.filter = new PluginFilter();
		this.dir  = new File("../repository/plugins/");
	}
	
	@Test
	public void AcceptFilterWithCorrectPluginFile() {
		assertTrue(this.filter.accept(this.dir, "ToUpperCase.class"));
	}
	
	
	@Test(expected = AssertionError.class)
	public void testNotExistingFile() {
		assertTrue(this.filter.accept(this.dir, "notexistingfile"));
	}
	
	
	@Test(expected = AssertionError.class)
	public void testNotValidClassFile() {
		assertTrue(this.filter.accept(this.dir, "Fake.class"));
	}
	
	
}
