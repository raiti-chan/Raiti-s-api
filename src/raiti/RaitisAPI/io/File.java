package raiti.RaitisAPI.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;

import raiti.RaitisAPI.io.File;
import raiti.RaitisAPI.io.FileErrorProgran;

public class File extends java.io.File{
	
	  private FileErrorProgran Program = null;
	  
	  private static final long serialVersionUID = 1L;
	  
	  public File(URI uri)
	  {
	    super(uri);
	  }
	  
	  public File(String parent, String child)
	  {
	    super(parent, child);
	  }
	  
	  public File(String pathname)
	  {
	    super(pathname);
	  }
	  
	  public File(java.io.File parent, String child)
	  {
	    super(parent, child);
	  }
	  
	  public File Copy(String URL)
	    throws FileNotFoundException, IOException
	  {
	    File out = new File(URL);
	    out.MakeDir();
	    Files.copy(toPath(), new FileOutputStream(URL));
	    return out;
	  }
	  
	  public boolean MakeFile()
	  {
	    String Path = getPath();
	    if (exists()) {
	      return false;
	    }
	    String[] dirs = Path.split("\\\\");
	    String directry = "";
	    for (int i = 0; i < dirs.length - 1; i++) {
	      directry = directry + dirs[i] + "\\";
	    }
	    File directryFile = new File(directry);
	    if (!directryFile.exists()) {
	      directryFile.mkdirs();
	    }
	    try
	    {
	      createNewFile();
	    }
	    catch (IOException e)
	    {
	      if (this.Program != null) {
	        this.Program.MakeFileError(e);
	      }
	      return false;
	    }
	    return true;
	  }
	  
	  public boolean MakeDir()
	  {
	    String Path = getPath();
	    String[] dirs = Path.split("\\\\");
	    String directry = "";
	    for (int i = 0; i < dirs.length - 1; i++) {
	      directry = directry + dirs[i] + "\\";
	    }
	    File directryFile = new File(directry);
	    if (directryFile.exists()) {
	      return false;
	    }
	    directryFile.mkdirs();
	    return true;
	  }
	  
	  public FileErrorProgran getProgram()
	  {
	    return this.Program;
	  }
	  
	  public void setProgram(FileErrorProgran program)
	  {
	    this.Program = program;
	  }
	  
	  public void removeProgran()
	  {
	    this.Program = null;
	  }
}
