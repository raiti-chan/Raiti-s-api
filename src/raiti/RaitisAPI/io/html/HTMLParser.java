package raiti.RaitisAPI.io.html;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import raiti.RaitisAPI.io.File;
import raiti.RaitisAPI.io.html.Tag;

public class HTMLParser {
	private static Pattern tagPattern = Pattern.compile("(<([^ >]+)([^>]*)>)([^<]*)");
	  private Matcher matcher;
	  private Tag tag;
	  int pos;
	  
	  public HTMLParser(String src)
	  {
	    this.matcher = tagPattern.matcher(src);
	  }
	  
	  public HTMLParser(StringBuffer buf)
	  {
	    this(buf.toString());
	  }
	  
	  public HTMLParser(File file)
	    throws IOException
	  {
	    FileInputStream in = new FileInputStream(file);
	    InputStreamReader read = new InputStreamReader(in, "UTF-8");
	    BufferedReader reader = new BufferedReader(read);
	    StringBuffer bufstr = new StringBuffer();
	    String str;
	    while ((str = reader.readLine()) != null)
	    {
	      bufstr.append(str);
	    }
	    reader.close();
	    this.matcher = tagPattern.matcher(bufstr.toString());
	  }
	  
	  public boolean hasNext()
	  {
	    boolean found = this.matcher.find();
	    if (found) {
	      this.tag = new Tag(this.matcher.group(1), this.matcher.group(2), this.matcher.group(3), this.matcher.group(4));
	    }
	    return found;
	  }
	  
	  public Tag next()
	  {
	    return this.tag;
	  }
	  
	  public void reset()
	  {
	    this.matcher.reset();
	  }
	  
	  public Tag getTag(String TagName)
	  {
	    while (hasNext())
	    {
	      this.tag = next();
	      if (this.tag.getTagName().equals(TagName)) {
	        return this.tag;
	      }
	    }
	    return null;
	  }
}
