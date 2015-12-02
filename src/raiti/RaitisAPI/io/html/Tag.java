package raiti.RaitisAPI.io.html;

public class Tag {
	  private String tagStr;
	  private String tagName;
	  private String tagAttribute;
	  private String tagText;
	  
	  public Tag(String tagStr, String tagName, String tagAttribute, String tagText)
	  {
	    this.tagStr = tagStr;
	    this.tagName = tagName;
	    this.tagAttribute = tagAttribute;
	    this.tagText = tagText;
	  }
	  
	  @Override
	public String toString()
	  {
	    return "タグ:[" + this.tagName + "], 属性:[" + this.tagAttribute + "], テキスト: [" + this.tagText + "]";
	  }
	  
	  public String getTagAttribute()
	  {
	    return this.tagAttribute;
	  }
	  
	  public String getTagName()
	  {
	    return this.tagName;
	  }
	  
	  public String getTagStr()
	  {
	    return this.tagStr;
	  }
	  
	  public String getTagText()
	  {
	    return this.tagText;
	  }
}
