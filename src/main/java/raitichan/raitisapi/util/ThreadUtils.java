package raitichan.raitisapi.util;

/**
 * スレッドのユーティリティークラス<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public class ThreadUtils {
	
	/**
	 * 呼び出し元メソッド
	 */
	@SuppressWarnings("unused")
	public static final int CALL_METHOD = 3;
	
	/**
	 * このメソッド
	 */
	@SuppressWarnings("unused")
	public static final int THIS_METHOD = 2;
	
	/**
	 * <B>コンストラクター</B><br>
	 * 不使用
	 */
	private ThreadUtils () {
	}
	
	/**
	 * メソッド名を取得します。<br>
	 * 0:getStackTrace<br>
	 * 1:getMethod<br>
	 * 2:getMethodを呼び出したメソッド<br>
	 * 3:getMethodを呼び出すメソッドを呼び出したメソッド。<br>
	 * ...
	 *
	 * @param N メソッドのインデックス。
	 * @return メソッドの名前
	 */
	@SuppressWarnings("WeakerAccess")
	public static String getMethod (int N) {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[N];
		return ste.getMethodName();
	}
	
	/**
	 * クラス名を取得します<br>
	 * 0:Thread<br>
	 * 1:ThreadUtil<br>
	 * 2:ThreadUtilを呼び出したクラス<br>
	 * 3:ThreadUtilを呼び出すクラスを呼び出したクラス。<br>
	 * ...
	 *
	 * @param N クラスのインデックス。
	 * @return クラス名
	 */
	@SuppressWarnings("WeakerAccess")
	public static String getClass (int N) {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[N];
		return ste.getClassName();
	}
	
	/**
	 * コードの行を取得します。<br>
	 *
	 * @param N 行のインデックス
	 * @return 行数
	 */
	@SuppressWarnings("WeakerAccess")
	public static int getLine (int N) {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[N];
		return ste.getLineNumber();
	}
	
	/**
	 * 呼び出し位置を文字列化して取得します。<br>
	 * <p>
	 * Class(Line):Method
	 *
	 * @param N 呼び出し元のインデックス
	 * @return Class(Line):Method 文字列
	 */
	@SuppressWarnings("unused")
	public static String getCallPoint (int N) {
		return getClass(N + 1) + "(" + getLine(N + 1) + "):" + getMethod(N + 1);
	}
	
}
