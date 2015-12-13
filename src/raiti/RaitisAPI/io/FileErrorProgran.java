package raiti.RaitisAPI.io;

import java.io.IOException;

/**
 * <h1>FileErrorProgran</h1>
 * {@link File}クラスのエラー処理用クラス<br>
 * @author Raiti
 * @version 1.0.0
 *
 */
public abstract class FileErrorProgran {
	
	/**
	 * <B>コンストラクター</B><br>
	 * 未使用
	 */
	private FileErrorProgran() {

	}
	
	/**
	 * <h1>MakeFileError</h1>
	 * {@link File#MakeFile()}メソッドの例外時の処理クラス。<br>
	 * @param paramIOException スローされた例外
	 */
	public abstract void MakeFileError(IOException paramIOException);
}
