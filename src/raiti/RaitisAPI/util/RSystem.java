package raiti.RaitisAPI.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import raiti.RaitisAPI.util.FileCharDetecter;

/**
 * <h1>RSystem</h1>
 * RSystemクラス<br>
 * 色々なユーティリティーStaticメソッド群<br>
 * @author Raiti
 * @version 1.0.0
 *
 */
public final class RSystem {
	
	/**
	 * <B>コンストラクター</B><br>
	 * 未使用
	 */
	private RSystem() {
	}
	
	/**
	 * <h1>getFileChar</h1>
	 * テキストファイルの文字コードを取得します。<br>
	 * 英語のみの場合UTF-8が返されます。
	 * @param filepath 文字コードを取得するファイルのパス
	 * @return 文字コード
	 * @throws IOException 入出力エラーが発生した場合。 
	 */
	public static String getFileChar(String filepath) throws IOException {
		FileCharDetecter detecter = new FileCharDetecter(filepath);
		return detecter.detector();
	}
	
	/**
	 * 日付の標準フォーマットです。
	 */
	public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]");
	
	/**
	 * <h1>getDateTime</h1>
	 * 現在の日付を標準ファーマットで取得します。<br>
	 * 標準フォーマット"[yyyy-MM-dd HH:mm:ss]"<br>
	 * ex->2015-12-2 15:54:33
	 * @return 日付文字列。
	 */
	public static String getDateTime() {
		return FORMATTER.format(new Date());
	}
	
	/**
	 * <h1>getDateTime</h1>
	 * 現在の日付を指定したファーマットで取得します。<br>
	 * @param format 日付のフォーマット文字列。
	 * @return 日付文字列。
	 */
	public static String getDateTime(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(new Date());
	}
	
}
