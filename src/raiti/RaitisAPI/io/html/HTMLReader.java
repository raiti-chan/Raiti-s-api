package raiti.RaitisAPI.io.html;

import raiti.RaitisAPI.io.File;

//TODO : 未完成

/**
 * <h1>HTMLReader</h1> 
 * HTMLを読み込みます<br>
 * 未完成
 * 
 * @author Raiti
 * @version 1.0.0
 *
 */
public class HTMLReader {
	
	/**
	 * <B>コンストラクター</B><br>
	 * @param file ファイル
	 */
	public HTMLReader(File file) {

	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * @param URL ファイルへのパス
	 */
	public HTMLReader(String URL) {
		this(new File(URL));
	}

}
