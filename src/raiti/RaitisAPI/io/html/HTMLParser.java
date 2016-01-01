package raiti.RaitisAPI.io.html;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import raiti.RaitisAPI.io.File;
import raiti.RaitisAPI.io.html.Tag;

/**
 * <h1>HTMLParser</h1>
 * HTMLのタグを簡易的に解析します。<br>
 * 構造化解析はできません。<br>
 * タグとタグの間を解析するので&lt;/&gt;もタグとして解析してしまいます。
 * @author Raiti
 * @version 1.0.0
 *
 */
public class HTMLParser {
	/**
	 * HTMLデータの解析パターン
	 */
	private static Pattern tagPattern = Pattern.compile("(<([^ >]+)([^>]*)>)([^<]*)");
	
	/**
	 * 解析パターンのマッチエンジン
	 */
	private Matcher matcher;
	
	/**
	 * ストリームのバッファー
	 */
	private Tag tag;
	
	/**
	 * <B>コンストラクター</B><br>
	 * String文字列をHTML解析します。
	 * @param src String文字列
	 */
	public HTMLParser(String src) {
		this.matcher = tagPattern.matcher(src);
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * {@link StringBuffer}文字列をHTML解析します。
	 * @param buf {@link StringBuffer}文字列
	 */
	public HTMLParser(StringBuffer buf) {
		this(buf.toString());
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * {@link File}のテキストデータをHTML解析します。
	 * @param file 読み込むファイル
	 * @throws IOException 入出力エラーが発生した場合
	 */
	public HTMLParser(File file) throws IOException {
		FileInputStream in = new FileInputStream(file);
		InputStreamReader read = new InputStreamReader(in, "UTF-8");
		BufferedReader reader = new BufferedReader(read);
		StringBuffer bufstr = new StringBuffer();
		String str;
		while ((str = reader.readLine()) != null) {
			bufstr.append(str);
		}
		reader.close();
		this.matcher = tagPattern.matcher(bufstr.toString());
	}
	
	/**
	 * <h1>hasNext</h1>
	 * 次のタグが存在するかを判断します。<br>
	 * その際、存在する場合はストリームバッファーに保持されます。
	 * @return 次のタグが存在する場合true、それ以外はfalse
	 */
	public boolean hasNext() {
		boolean found = this.matcher.find();
		if (found) {
			this.tag = new Tag(this.matcher.group(1), this.matcher.group(2), this.matcher.group(3),
					this.matcher.group(4));
		}
		return found;
	}
	
	/**
	 * <h1>next</h1>
	 * ストリームバッファーに読み込まれたタグを取得します。<br>
	 * @return ストリームバッファーにあるタグ
	 */
	public Tag next() {
		return this.tag;
	}
	
	/**
	 * <h1>reset</h1>
	 * 解析エンジンをリセットします。<br>
	 * テキストを読み込んだだけの状態になります。<br>
	 * また最初からタグの取得が可能になります。
	 */
	public void reset() {
		this.matcher.reset();
	}
	
	/**
	 * <h1>getTag</h1>
	 * 指定した名前のタグを取得します。<br>
	 * 取得したタグの前のデータは破棄されます。<br>
	 * 再び読み込む場合はresetメソッドを使用してください。<br>
	 * タグが複数存在した場合は最初の物が返ります。<br>
	 * @param TagName タグの名前
	 * @return 指定した名前のタグ
	 */
	public Tag getTag(String TagName) {
		while (hasNext()) {
			this.tag = next();
			if (this.tag.getTagName().equals(TagName)) {
				return this.tag;
			}
		}
		return null;
	}
}
