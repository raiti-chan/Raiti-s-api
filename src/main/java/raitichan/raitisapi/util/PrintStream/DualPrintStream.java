package raitichan.raitisapi.util.PrintStream;

import java.io.*;

import raitichan.raitisapi.util.RSystem;


/**
 * 二つのPrintStreamを併用したPrintStreamを作成するクラスです。<br>
 * 用途は、標準出力をコンソール(デフォルト)と、その他(ファイルや、logエリア)に同時に出力したい場合などに使用します。
 *
 * @author Raiti
 * @version 1.0.0
 */
public class DualPrintStream extends PrintStream {
	
	/**
	 * 併用する、もうひとつの{@link PrintStream}です。
	 */
	private PrintStream subStream;
	
	/**
	 * メインのPrintStreamに出力時刻をダンプするか<br>
	 * デフォルトはtrue
	 */
	private boolean timeDumpOfMain = true;
	
	/**
	 * サブのPrintStreamに出力時刻をダンプするか<br>
	 * デフォルトはtrue
	 */
	private boolean timeDumpOfSub = true;
	
	//-------------------------------------コンストラクター
	
	/**
	 * 行の自動フラッシュは行わずに、指定のファイルで新しい出力ストリームを作成します。
	 * この便利なコンストラクタは必要な中間OutputStreamWriterを作成し、
	 * これが指定された文字セットを使用して文字をエンコードします。
	 *
	 * @param file この出力ストリームの宛先として使用するファイル。
	 *             ファイルが存在する場合、サイズ0に切り詰められる。
	 *             ファイルがなければ新しいファイルが作成される。
	 *             出力はファイルに書き込まれ、バッファに格納される。
	 * @param csn  サポートされているcharsetの名前
	 * @throws FileNotFoundException        指定されたファイル・オブジェクトが既存のファイルを示さない場合、
	 *                                      書込み可能な通常ファイルおよび新規の通常ファイルがその名前で作成できない場合、
	 *                                      またはファイルのオープンまたは作成中にその他のエラーが発生した場合
	 * @throws SecurityException            セキュリティ・マネージャが存在し、{@link SecurityManager#checkWrite checkWrite(file.getPath())}
	 *                                      がファイルへの書込みアクセスを拒否した場合
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	@SuppressWarnings("unused")
	public DualPrintStream (File file, String csn) throws FileNotFoundException, SecurityException, UnsupportedEncodingException {
		super(file, csn);
	}
	
	/**
	 * 行の自動フラッシュは行わずに、指定のファイルで新しい出力ストリームを作成します。
	 * この便利なコンストラクタは必要な中間OutputStreamWriterを作成し、
	 * これがJava仮想マシンのこのインスタンス用にデフォルト文字セットを使用して文字をエンコードします。
	 *
	 * @param file この出力ストリームの宛先として使用するファイル。
	 *             ファイルが存在する場合、サイズ0に切り詰められる。
	 *             ファイルがなければ新しいファイルが作成される。
	 *             出力はファイルに書き込まれ、バッファに格納される。
	 * @throws FileNotFoundException 指定されたファイル・オブジェクトが既存のファイルを示さない場合、
	 *                               書込み可能な通常ファイルおよび新規の通常ファイルがその名前で作成できない場合、
	 *                               またはファイルのオープンまたは作成中にその他のエラーが発生した場合
	 * @throws SecurityException     セキュリティ・マネージャが存在し、{@link SecurityManager#checkWrite checkWrite(file.getPath())}
	 *                               がファイルへの書込みアクセスを拒否した場合
	 */
	@SuppressWarnings("unused")
	public DualPrintStream (File file) throws FileNotFoundException, SecurityException {
		super(file);
	}
	
	/**
	 * 新しいPrintStreamを作成します。
	 *
	 * @param out       値とオブジェクトが出力される出力ストリーム
	 * @param autoFlush boolean値。
	 *                  trueの場合、バイト配列が書き込まれたとき、printlnメソッドの1つが呼び出されたとき、
	 *                  あるいは改行文字またはバイト('\n')が書き込まれたときに必ず出力バッファがフラッシュされる
	 * @param encoding  サポートされる文字エンコーディングの名前
	 * @throws UnsupportedEncodingException 指定されたエンコーディングがサポートされていない場合
	 */
	@SuppressWarnings("unused")
	public DualPrintStream (OutputStream out, boolean autoFlush, String encoding) throws UnsupportedEncodingException {
		super(out, autoFlush, encoding);
	}
	
	/**
	 * 新しいPrintStreamを作成します。
	 *
	 * @param out       値とオブジェクトが出力される出力ストリーム
	 * @param autoFlush boolean値。
	 *                  trueの場合、バイト配列が書き込まれたとき、printlnメソッドの1つが呼び出されたとき、
	 *                  あるいは改行文字またはバイト('\n')が書き込まれたときに必ず出力バッファがフラッシュされる
	 */
	@SuppressWarnings("unused")
	public DualPrintStream (OutputStream out, boolean autoFlush) {
		super(out, autoFlush);
	}
	
	/**
	 * 新しいPrintStreamを作成します。このストリームは、自動的にフラッシュすることはありません。
	 *
	 * @param out 値とオブジェクトが出力される出力ストリーム
	 */
	@SuppressWarnings("unused")
	public DualPrintStream (OutputStream out) {
		super(out);
	}
	
	/**
	 * 行の自動フラッシュは行わずに、指定の名前と文字セットで新しい出力ストリームを作成します。
	 * この便利なコンストラクタは必要な中間OutputStreamWriterを作成し、これが指定された文字セットを使用して文字をエンコードします。
	 *
	 * @param fileName この出力ストリームの宛先として使用するファイルの名前。
	 *                 ファイルが存在する場合、サイズ0に切り詰められる。
	 *                 ファイルがなければ新しいファイルが作成される。
	 *                 出力はファイルに書き込まれ、バッファに格納される。
	 * @param csn      サポートされているcharsetの名前
	 * @throws FileNotFoundException        指定されたファイル・オブジェクトが既存のファイルを示さない場合、
	 *                                      書込み可能な通常ファイルおよび新規の通常ファイルがその名前で作成できない場合、
	 *                                      またはファイルのオープンまたは作成中にその他のエラーが発生した場合
	 * @throws SecurityException            セキュリティ・マネージャが存在し、{@link SecurityManager#checkWrite checkWrite(file.getPath())}
	 *                                      がファイルへの書込みアクセスを拒否した場合
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	@SuppressWarnings("unused")
	public DualPrintStream (String fileName, String csn) throws FileNotFoundException, SecurityException, UnsupportedEncodingException {
		super(fileName, csn);
	}
	
	/**
	 * 行の自動フラッシュは行わずに、指定の名前で新しい出力ストリームを作成します。
	 * この便利なコンストラクタは必要な中間OutputStreamWriterを作成し、
	 * これがJava仮想マシンのこのインスタンス用にデフォルト文字セットを使用して文字をエンコードします。
	 *
	 * @param fileName この出力ストリームの宛先として使用するファイルの名前。
	 *                 ファイルが存在する場合、サイズ0に切り詰められる。
	 *                 ファイルがなければ新しいファイルが作成される。
	 *                 出力はファイルに書き込まれ、バッファに格納される。
	 * @throws FileNotFoundException 指定されたファイル・オブジェクトが既存のファイルを示さない場合、
	 *                               書込み可能な通常ファイルおよび新規の通常ファイルがその名前で作成できない場合、
	 *                               またはファイルのオープンまたは作成中にその他のエラーが発生した場合
	 * @throws SecurityException     セキュリティ・マネージャが存在し、{@link SecurityManager#checkWrite checkWrite(file.getPath())}
	 *                               がファイルへの書込みアクセスを拒否した場合
	 */
	@SuppressWarnings("unused")
	public DualPrintStream (String fileName) throws FileNotFoundException, SecurityException {
		super(fileName);
	}
	
	
	//------------------------------------------------------setter/getter
	
	/**
	 * {@link DualPrintStream#subStream}の取得<br>
	 *
	 * @return subStream
	 */
	@SuppressWarnings("unused")
	public PrintStream getSubStream () {
		return this.subStream;
	}
	
	/**
	 * {@link DualPrintStream#subStream}をセットします<br>
	 *
	 * @param subStream セットする subStream
	 */
	public void setSubStream (PrintStream subStream) {
		this.subStream = subStream;
	}
	
	/**
	 * {@link DualPrintStream#timeDumpOfSub}の取得<br>
	 *
	 * @return timeDumpOfSub
	 */
	@SuppressWarnings("unused")
	public boolean isTimeDumpOfSub () {
		return this.timeDumpOfSub;
	}
	
	/**
	 * {@link DualPrintStream#timeDumpOfSub}をセットします<br>
	 *
	 * @param timeDumpOfSub セットする timeDumpOfSub
	 */
	@SuppressWarnings("unused")
	public void setTimeDumpOfSub (boolean timeDumpOfSub) {
		this.timeDumpOfSub = timeDumpOfSub;
	}
	
	/**
	 * {@link DualPrintStream#timeDumpOfMain}の取得<br>
	 *
	 * @return timeDumpOfMain
	 */
	@SuppressWarnings("unused")
	public boolean isTimeDumpOfMain () {
		return this.timeDumpOfMain;
	}
	
	/**
	 * {@link DualPrintStream#timeDumpOfMain}をセットします<br>
	 *
	 * @param timeDumpOfMain セットする timeDumpOfMain
	 */
	@SuppressWarnings("unused")
	public void setTimeDumpOfMain (boolean timeDumpOfMain) {
		this.timeDumpOfMain = timeDumpOfMain;
	}
	
	//------------------------------------------------------Override
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#flush()
	 */
	@Override
	public void flush () {
		this.subStream.flush();
		super.flush();
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#close()
	 */
	@Override
	public void close () {
		this.subStream.close();
		super.close();
	}
	
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(boolean)
	 */
	@Override
	public void print (boolean b) {
		String nowTime = null;
		if (timeDumpOfMain | timeDumpOfSub) {
			nowTime = RSystem.getDateTime();
		}
		this.subStream.print(timeDumpOfSub ? nowTime + " " + b : b);
		super.print(timeDumpOfMain ? nowTime + " " + b : b);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(char)
	 */
	@Override
	public void print (char c) {
		String nowTime = null;
		if (timeDumpOfMain | timeDumpOfSub) {
			nowTime = RSystem.getDateTime();
		}
		this.subStream.print(timeDumpOfSub ? nowTime + " " + c : c);
		super.print(timeDumpOfMain ? nowTime + " " + c : c);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(int)
	 */
	@Override
	public void print (int i) {
		String nowTime = null;
		if (timeDumpOfMain | timeDumpOfSub) {
			nowTime = RSystem.getDateTime();
		}
		this.subStream.print(timeDumpOfSub ? nowTime + " " + i : i);
		super.print(timeDumpOfMain ? nowTime + " " + i : i);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(long)
	 */
	@Override
	public void print (long l) {
		String nowTime = null;
		if (timeDumpOfMain | timeDumpOfSub) {
			nowTime = RSystem.getDateTime();
		}
		this.subStream.print(timeDumpOfSub ? nowTime + " " + l : l);
		super.print(timeDumpOfMain ? nowTime + " " + l : l);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(float)
	 */
	@Override
	public void print (float f) {
		String nowTime = null;
		if (timeDumpOfMain | timeDumpOfSub) {
			nowTime = RSystem.getDateTime();
		}
		this.subStream.print(timeDumpOfSub ? nowTime + " " + f : f);
		super.print(timeDumpOfMain ? nowTime + " " + f : f);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(double)
	 */
	@Override
	public void print (double d) {
		String nowTime = null;
		if (timeDumpOfMain | timeDumpOfSub) {
			nowTime = RSystem.getDateTime();
		}
		this.subStream.print(timeDumpOfSub ? nowTime + " " + d : d);
		super.print(timeDumpOfMain ? nowTime + " " + d : d);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(char[])
	 */
	@SuppressWarnings("Duplicates")
	@Override
	public void print (char[] s) {
		String nowTime = null;
		if (timeDumpOfMain | timeDumpOfSub) {
			nowTime = RSystem.getDateTime();
		}
		String sString = String.valueOf(s);
		this.subStream.print(timeDumpOfSub ? nowTime + " " + sString : sString);
		super.print(timeDumpOfMain ? nowTime + " " + sString : sString);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(java.lang.String)
	 */
	@Override
	public void print (String s) {
		String nowTime = null;
		if (timeDumpOfMain | timeDumpOfSub) {
			nowTime = RSystem.getDateTime();
		}
		this.subStream.print(timeDumpOfSub ? nowTime + " " + s : s);
		super.print(timeDumpOfMain ? nowTime + " " + s : s);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(java.lang.Object)
	 */
	@SuppressWarnings("Duplicates")
	@Override
	public void print (Object obj) {
		String nowTime = null;
		if (timeDumpOfMain | timeDumpOfSub) {
			nowTime = RSystem.getDateTime();
		}
		String objString = String.valueOf(obj);
		this.subStream.print(timeDumpOfSub ? nowTime + " " + objString : objString);
		super.print(timeDumpOfMain ? nowTime + " " + objString : objString);
	}
	
	
	//XXX:printlnの際、subStreamのprintが2度呼び出される！!
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println()
	 */
	@Override
	public void println () {
		this.subStream.println();
		super.println();
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println(boolean)
	 */
	@Override
	public void println (boolean x) {
		this.subStream.println(x);
		super.println(x);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println(int)
	 */
	@Override
	public void println (int x) {
		this.subStream.println(x);
		super.println(x);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println(long)
	 */
	@Override
	public void println (long x) {
		this.subStream.println(x);
		super.println(x);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println(float)
	 */
	@Override
	public void println (float x) {
		this.subStream.println(x);
		super.println(x);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println(double)
	 */
	@Override
	public void println (double x) {
		this.subStream.println(x);
		super.println(x);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println(char[])
	 */
	@Override
	public void println (char[] x) {
		this.subStream.println(x);
		super.println(x);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println(java.lang.String)
	 */
	@Override
	public void println (String x) {
		this.subStream.println(x);
		super.println(x);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println(java.lang.Object)
	 */
	@Override
	public void println (Object x) {
		this.subStream.println(x);
		super.println(x);
	}
	
}
