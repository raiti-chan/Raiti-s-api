package raiti.RaitisAPI.util;

/**
 * <h1>ThreadUtils</h1> スレッドのユーティリティークラス<br>
 * 
 * @author Raiti
 * @version 1.0.0
 *
 */
public class ThreadUtils {
	
	/**
	 * 呼び出し元メソッド
	 */
	public static final int CallMETHOD = 3;
	
	/**
	 * このメソッド
	 */
	public static final int THISMETHOD = 2;
	
	/**
	 * <B>コンストラクター</B><br>
	 * 不使用
	 */
	private ThreadUtils() {
	}
	
	/**
	 * <h1>getMethod</h1>
	 * メソッド名を取得します。<br>
	 * 0:getStackTrace<br>
	 * 1:getMethod<br>
	 * 2:getMethodを呼び出したメソッド<br>
	 * 3:getMethodを呼び出すメソッドを呼び出したメソッド。<br>
	 * ...
	 * @param N メソッドのインデックス。
	 * @return メソッドの名前
	 */
	public static String getMethod(int N) {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[N];
		return ste.getMethodName();
	}
	
	/**
	 * <h1>getClass</h1>
	 * クラス名を取得します<br>
	 * 0:Thread<br>
	 * 1:ThreadUtil<br>
	 * 2:ThreadUtilを呼び出したクラス<br>
	 * 3:ThreadUtilを呼び出すクラスを呼び出したクラス。<br>
	 * ...
	 * @param N クラスのインデックス。
	 * @return クラス名
	 */
	public static String getClass(int N) {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[N];
		return ste.getClassName();
	}
	
	/**
	 * <h1>getLine</h1>
	 * コードの行を取得します。<br>
	 * @param N 行のインデックス
	 * @return 行数
	 */
	public static int getLine(int N) {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[N];
		return ste.getLineNumber();
	}
	
	/**
	 * <h1>getCallPoint</h1>
	 * 呼び出し位置を文字列化して取得します。<br>
	 * 
	 * Class(Line):Method
	 * @param N
	 * @return Class(Line):Method 文字列
	 */
	public static String getCallPoint(int N) {
		return getClass(N + 1) + "(" + getLine(N + 1) + "):" + getMethod(N + 1);
	}
	
}
