package raiti.RaitisAPI.io;

import java.io.FileInputStream;
import java.io.IOException;

public class IoUtil {
	
	  private IoUtil() {}
	  
	  public static FileInputStream removeBOM(String file) throws IOException{
	    byte[] bom = new byte[3];
	    FileInputStream in = new FileInputStream(file);
	    FileInputStream sub = new FileInputStream(file);
	    in.read(bom, 0, 3);
	    if ((bom[0] != -17) || (bom[1] != -69) || (bom[2] != -65))
	    {
	      in.close();
	      return sub;
	    }
	    sub.close();
	    return in;
	  }
}
