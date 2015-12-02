package raiti.RaitisAPI.io.csv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import raiti.RaitisAPI.io.File;
import raiti.RaitisAPI.util.RSystem;

public class CsvReader extends BufferedReader{
	private ArrayList<String[]> csvDataList = new ArrayList<String[]>();
	  private int Maxindex;
	  
	  public CsvReader(Reader in)
	  {
	    super(in);
	  }
	  
	  public CsvReader(FileInputStream input, String charsetName)
	    throws UnsupportedEncodingException
	  {
	    this(new InputStreamReader(input, charsetName));
	  }
	  
	  public CsvReader(FileInputStream input)
	    throws UnsupportedEncodingException
	  {
	    this(new InputStreamReader(input, "UTF-8"));
	  }
	  
	  public CsvReader(File file, String charsetName)
	    throws FileNotFoundException, UnsupportedEncodingException
	  {
	    this(new FileInputStream(file), charsetName);
	  }
	  
	  public CsvReader(File file)
	    throws IOException, UnsupportedEncodingException
	  {
	    this(new FileInputStream(file), RSystem.getFileChar(file.getPath()));
	  }
	  
	  public CsvReader(String URL, String charsetName)
	    throws FileNotFoundException, UnsupportedEncodingException
	  {
	    this(new FileInputStream(URL), charsetName);
	  }
	  
	  public CsvReader(String URL)
	    throws IOException, UnsupportedEncodingException
	  {
	    this(new FileInputStream(URL), RSystem.getFileChar(URL));
	  }
	  
	  public void load(String delim)
	    throws IOException
	  {
	    int index = 0;
	    String line;
	    while ((line = readLine()) != null)
	    {
	      StringTokenizer token = new StringTokenizer(line, delim);
	      String[] data = new String[token.countTokens()];
	      while (token.hasMoreTokens())
	      {
	        data[index] = token.nextToken();
	        index++;
	      }
	      this.csvDataList.add(data);
	      if (index + 1 >= this.Maxindex) {
	        this.Maxindex = (index + 1);
	      }
	      index = 0;
	    }
	  }
	  
	  public void load()
	    throws IOException
	  {
	    load(",");
	  }
	  
	  public String[][] getDataLineList()
	  {
	    String[][] dataLine = new String[this.csvDataList.size()][this.Maxindex];
	    for (int i = 0; i < this.csvDataList.size(); i++) {
	      dataLine[i] = (this.csvDataList.get(i));
	    }
	    return dataLine;
	  }
	  
	  public String[] nextLine()
	  {
	    String[] line = this.csvDataList.get(0);
	    this.csvDataList.remove(0);
	    return line;
	  }
	  
	  public int countDataLine()
	  {
	    return this.csvDataList.size();
	  }
	  
	  public boolean hasMoreDataLine()
	  {
	    if (this.csvDataList.size() <= 0) {
	      return false;
	    }
	    return true;
	  }
}
