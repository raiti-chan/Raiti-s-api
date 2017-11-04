package raitichan.raitisapi.io;

import java.io.IOException;

/**
 * {@link File}クラスのエラー処理用<br>
 * @author Raiti
 * @version 1.0.0
 *
 */
@FunctionalInterface
public interface IFileErrorProgram {
	/**
	 * 例外が発生したときの呼び出しメソッド
	 * @param paramIOException 発生した例外
	 */
	void Invoke(IOException paramIOException);
}
