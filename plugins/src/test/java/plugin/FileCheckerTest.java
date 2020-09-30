package plugin;


import org.junit.Test;
import plugin.files.FileChecker;
import plugin.files.FileEvent;
import plugin.listeners.FileListener;

public class FileCheckerTest {

	protected FileChecker fc;
	protected MockFileListener listener;

	public class MockFileListener implements FileListener{
		public int tester = 0;
		
		public int getTester(){
			return this.tester;
		}

		@Override
		public void fileAdded(FileEvent fe, String path) {
			System.out.println("file added: " + path);
		}

		@Override
		public void fileRemoved(FileEvent fe, String path) {
			System.out.println("file delete: " + path);
			
		}
	}
	

	
	@Test
	public void checkFileActionListener() {
		/* 
		FileChecker fc = new FileChecker("../repository/plugins/");
		this.listener = new MockFileListener();
		fc.addFileListener(listener);
		
		fc.new checkFilesActionListener();
		System.out.println(listener.getTester());
		
		while(listener.getTester() != 1) {};
		*/
	}
	
	
	
	
}
