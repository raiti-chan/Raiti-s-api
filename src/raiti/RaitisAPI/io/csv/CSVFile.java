package raiti.RaitisAPI.io.csv;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import raiti.RaitisAPI.io.File;;

public class CSVFile extends CsvWriter{
	public CSVFile(Writer in)
	  {
	    super(in);
	  }
	  
	  public CSVFile(OutputStream output, String charsetName)
	    throws UnsupportedEncodingException
	  {
	    this(new OutputStreamWriter(output, charsetName));
	  }
	  
	  public CSVFile(OutputStream output)
	    throws UnsupportedEncodingException
	  {
	    this(new OutputStreamWriter(output, "UTF-8"));
	  }
	  
	  public CSVFile(File file, String charsetName)
	    throws FileNotFoundException, UnsupportedEncodingException
	  {
	    this(new FileOutputStream(file), charsetName);
	  }
	  
	  public CSVFile(File file)
	    throws FileNotFoundException, UnsupportedEncodingException
	  {
	    this(new FileOutputStream(file));
	  }
	  
	  public CSVFile(String URL, String charsetName)
	    throws FileNotFoundException, UnsupportedEncodingException
	  {
	    this(new FileOutputStream(URL), charsetName);
	  }
	  
	  public CSVFile(String URL)
	    throws FileNotFoundException, UnsupportedEncodingException
	  {
	    this(new FileOutputStream(URL));
	  }
}
