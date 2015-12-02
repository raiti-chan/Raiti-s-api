package raiti.RaitisAPI.io.csv;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;

import raiti.RaitisAPI.io.File;

public class CsvWriter extends BufferedWriter{
	  private ArrayList<String[]> csvDataList = new ArrayList();
	  
	  public CsvWriter(Writer in)
	  {
	    super(in);
	  }
	  
	  public CsvWriter(OutputStream output, String charsetName)
	    throws UnsupportedEncodingException
	  {
	    this(new OutputStreamWriter(output, charsetName));
	  }
	  
	  public CsvWriter(OutputStream output)
	    throws UnsupportedEncodingException
	  {
	    this(new OutputStreamWriter(output, "UTF-8"));
	  }
	  
	  public CsvWriter(File file, String charsetName)
	    throws FileNotFoundException, UnsupportedEncodingException
	  {
	    this(new FileOutputStream(file), charsetName);
	  }
	  
	  public CsvWriter(File file)
	    throws FileNotFoundException, UnsupportedEncodingException
	  {
	    this(new FileOutputStream(file));
	  }
	  
	  public CsvWriter(String URL, String charsetName)
	    throws FileNotFoundException, UnsupportedEncodingException
	  {
	    this(new FileOutputStream(URL), charsetName);
	  }
	  
	  public CsvWriter(String URL)
	    throws FileNotFoundException, UnsupportedEncodingException
	  {
	    this(new FileOutputStream(URL));
	  }
	  
	  public void add(String... data)
	  {
	    this.csvDataList.add(data);
	  }
	  
	  public void add(int index, String... data)
	  {
	    this.csvDataList.add(index, data);
	  }
	  
	  public void add(ArrayList<String[]> csvDataList)
	  {
	    for (String[] dataline : csvDataList) {
	      add(dataline);
	    }
	  }
	  
	  public void setCsvDataList(ArrayList<String[]> csvDataList)
	  {
	    this.csvDataList = csvDataList;
	  }
	  
	  public void writePlus(String delim)
	    throws IOException
	  {
	    for (String[] line : this.csvDataList)
	    {
	      for (int i = 0; i < line.length; i++)
	      {
	        super.write(line[i]);
	        if (i < line.length - 1) {
	          super.write(",");
	        }
	      }
	      super.newLine();
	    }
	    this.csvDataList = new ArrayList();
	  }
	  
	  public void write()
	    throws IOException
	  {
	    writePlus(",");
	  }
	  
	  @Override
	@Deprecated
	  public void newLine()
	    throws IOException
	  {
	    super.newLine();
	  }
	  
	  @Override
	@Deprecated
	  public void write(char[] cbuf, int off, int len)
	    throws IOException
	  {
	    super.write(cbuf, off, len);
	  }
	  
	  @Override
	@Deprecated
	  public void write(int c)
	    throws IOException
	  {
	    super.write(c);
	  }
	  
	  @Override
	@Deprecated
	  public void write(String s, int off, int len)
	    throws IOException
	  {
	    super.write(s, off, len);
	  }
	  
	  @Override
	@Deprecated
	  public void write(char[] cbuf)
	    throws IOException
	  {
	    super.write(cbuf);
	  }
	  
	  @Override
	@Deprecated
	  public void write(String str)
	    throws IOException
	  {
	    super.write(str);
	  }
}
