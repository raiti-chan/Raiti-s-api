package raiti.RaitisAPI.io.html;

/**
 * <h1>Tag</h1>
 * タグの簡易オブジェクト<br>
 * タグの構成は "&lt;tag Property1 = "No.1" Property2 = "No.2">Text&lt;/tag>"<br>
 * タグ本体"&lt;tag Property1 = "No.1" Property2 = "No.2">"<br>
 * タグの名前 tag<br>
 * プロパティー文字列 Property1 = "No.1" Property2 = "No.2" <br>
 * タグ内テキスト Text<br>
 * となります。
 * @author Raiti
 * @version 1.0.0
 *
 */
public class Tag {
	
	/**
	 * タグ本体
	 */
	private String tagStr;
	
	/**
	 * タグの名前
	 */
	private String tagName;
	
	/**
	 * タグのプロパティー
	 */
	private String tagAttribute;
	
	/**
	 * タグの間のテキスト
	 */
	private String tagText;
	
	/**
	 * <B>コンストラクター</B><br>
	 * タグデータの生成
	 * @param tagStr タグ本体
	 * @param tagName タグの名前
	 * @param tagAttribute タグのプロパティー
	 * @param tagText タグの間のテキスト
	 */
	public Tag(String tagStr, String tagName, String tagAttribute, String tagText) {
		this.tagStr = tagStr;
		this.tagName = tagName;
		this.tagAttribute = tagAttribute;
		this.tagText = tagText;
	}
	
	/**
	 * <h1>toString</h1>
	 * オーバーライド
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "タグ:[" + this.tagName + "], 属性:[" + this.tagAttribute + "], テキスト: [" + this.tagText + "]";
	}
	
	/**
	 * <h1>getTagAttribute</h1>
	 * タグのプロパティー文字列の取得<br>
	 * @return プロパティー文字列
	 */
	public String getTagAttribute() {
		return this.tagAttribute;
	}
	
	/**
	 * <h1>getTagName</h1>
	 * タグの名前の取得<br>
	 * @return タグの名前
	 */
	public String getTagName() {
		return this.tagName;
	}
	
	/**
	 * <h1>getTagStr</h1>
	 * タグ本体文字列の取得<br>
	 * @return タグ本体
	 */
	public String getTagStr() {
		return this.tagStr;
	}
	
	/**
	 * <h1>getTagText</h1>
	 * タグの間の文字列を取得<br>
	 * @return タグ間の文字列
	 */
	public String getTagText() {
		return this.tagText;
	}
}
