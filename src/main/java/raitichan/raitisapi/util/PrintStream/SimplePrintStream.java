package raitichan.raitisapi.util.PrintStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;

import raitichan.raitisapi.util.RSystem;

/**
 * 簡易的な出力ストリームを提供します。<br>
 * ※機能はそこまでありません。<br>
 * 指定した{@link OutputStream},{@link File},ファイルへのパスへ出力します。
 *
 * @author Raiti
 * @version 1.0.0
 */
public class SimplePrintStream extends PrintStream {
	
	/**
	 * <B>コンストラクター</B><br>
	 *
	 * @param out 出力ストリーム
	 */
	@SuppressWarnings("unused")
	public SimplePrintStream (OutputStream out) {
		super(out);
	}
	
	/**
	 * @param file 出力ファイル
	 * @throws FileNotFoundException 指定されたファイル・オブジェクトが既存のファイルを示さない場合、
	 *                               書込み可能な通常ファイルおよび新規の通常ファイルがその名前で作成できない場合、
	 *                               またはファイルのオープンまたは作成中にその他のエラーが発生した場合
	 */
	@SuppressWarnings("WeakerAccess")
	public SimplePrintStream (File file) throws FileNotFoundException {
		super(file);
	}
	
	/**
	 * @param url ファイルのパス
	 * @throws FileNotFoundException 指定されたファイル・オブジェクトが既存のファイルを示さない場合、
	 *                               書込み可能な通常ファイルおよび新規の通常ファイルがその名前で作成できない場合、
	 *                               またはファイルのオープンまたは作成中にその他のエラーが発生した場合
	 */
	@SuppressWarnings("unused")
	public SimplePrintStream (String url) throws FileNotFoundException {
		this(new File(url));
	}
	
	/**
	 * @param out       値とオブジェクトが出力される出力ストリーム
	 * @param autoFlush boolean値。trueの場合、
	 *                  バイト配列が書き込まれたとき、printlnメソッドの1つが呼び出されたとき、
	 *                  あるいは改行文字またはバイト('\n')が書き込まれたときに必ず出力バッファがフラッシュされる
	 */
	@SuppressWarnings("unused")
	public SimplePrintStream (OutputStream out, boolean autoFlush) {
		super(out, autoFlush);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(boolean)
	 */
	@Override
	public void print (boolean b) {
		super.print(RSystem.getDateTime() + b);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(char)
	 */
	@Override
	public void print (char c) {
		super.print(RSystem.getDateTime() + c);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(char[])
	 */
	@Override
	public void print (char[] s) {
		super.print(RSystem.getDateTime() + String.valueOf(s));
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(double)
	 */
	@Override
	public void print (double d) {
		super.print(RSystem.getDateTime() + d);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(float)
	 */
	@Override
	public void print (float f) {
		super.print(RSystem.getDateTime() + f);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(int)
	 */
	@Override
	public void print (int i) {
		super.print(RSystem.getDateTime() + i);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(long)
	 */
	@Override
	public void print (long l) {
		super.print(RSystem.getDateTime() + l);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(java.lang.String)
	 */
	@Override
	public void print (String s) {
		super.print(RSystem.getDateTime() + s);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(java.lang.Object)
	 */
	@Override
	public void print (Object obj) {
		super.print(RSystem.getDateTime() + String.valueOf(obj));
	}
}
