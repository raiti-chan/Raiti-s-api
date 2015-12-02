package raiti.RaitisAPI.io;

import raiti.RaitisAPI.io.File;

import java.util.ArrayList;


public class FileChecker {
	
	  public File file;
	  public String[] urlList;
	  
	  public FileChecker(File file)
	  {
	    if ((file.isFile()) || (!file.exists())) {
	      return;
	    }
	    this.file = file;
	    this.urlList = file.list();
	  }
	  
	  public String Backkeyget(String text)
	  {
	    String[] returnURL = BackketgetAll(text);
	    
	    return returnURL[0];
	  }
	  
	  public String[] BackketgetAll(String text)
	  {
	    char[] textchar = text.toCharArray();
	    
	    ArrayList<String> returnURLList = new ArrayList<String>();
	    for (int i = 0; i < this.urlList.length; i++)
	    {
	      char[] urlchar = this.urlList[i].toCharArray();
	      for (int ii = 0; ii < textchar.length; ii++)
	      {
	        if (urlchar[(urlchar.length - 1 - ii)] != textchar[(textchar.length - 1 - ii)]) {
	          break;
	        }
	        if (ii == textchar.length - 1) {
	          returnURLList.add(this.urlList[i]);
	        }
	      }
	    }
	    String[] UrlList = new String[returnURLList.size()];
	    for(int i = 0,l = UrlList.length;i < l;i++) {
	    	UrlList[i] = returnURLList.get(i);
	    }
	    return UrlList;
	  }
	
}
