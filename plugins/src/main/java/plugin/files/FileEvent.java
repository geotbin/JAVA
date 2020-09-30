package plugin.files;

import java.util.EventObject;

public class FileEvent extends EventObject{

	private static final long serialVersionUID = 1L;
	private String fileName;
	
	public FileEvent(Object paramObject, String paramStringr) {
		super(paramObject);
		this.fileName = paramStringr;
	}
	
	  public String getFileName()
	  {
	    return this.fileName;
	  }
	
	
	
}