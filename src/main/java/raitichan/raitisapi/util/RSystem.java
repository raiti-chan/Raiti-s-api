package raitichan.raitisapi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * RSystemクラス<br>
 * 色々なユーティリティーStaticメソッド群<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public final class RSystem {
	
	/**
	 * 日付の標準フォーマットです。
	 */
	@SuppressWarnings("WeakerAccess")
	public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]");
	
	/**
	 * 未使用
	 */
	private RSystem () {
	}
	
	/**
	 * 現在の日付を標準ファーマットで取得します。<br>
	 * 標準フォーマット"[yyyy-MM-dd HH:mm:ss]"<br>
	 * ex-&gt;2015-12-2 15:54:33
	 *
	 * @return 日付文字列。
	 */
	public static String getDateTime () {
		return FORMATTER.format(new Date());
	}
	
	/**
	 * 現在の日付を指定したファーマットで取得します。<br>
	 *
	 * @param format 日付のフォーマット文字列。
	 * @return 日付文字列。
	 */
	@SuppressWarnings("unused")
	public static String getDateTime (String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(new Date());
	}
	
}
