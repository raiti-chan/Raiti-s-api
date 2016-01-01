/**
 * 
 */
package raiti.RaitisAPI.util.PrintStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import raiti.RaitisAPI.util.RSystem;

/** <h1>DualPrintStream</h1>
 * 二つのPrintStreamを併用したPrintStreamを作成するクラスです。<br>
 * 用途は、標準出力をコンソール(デフォルト)と、その他(ファイルや、logエリア)に同時に出力したい場合などに使用します。
 * @author Raiti
 * @version 1.0.0
 * 
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
	private boolean timeDumpofMain = true;
	
	/**
	 * サブのPrintStreamに出力時刻をダンプするか<br>
	 * デフォルトはtrue
	 */
	private boolean timeDumpofSub = true;
	
	//-------------------------------------コンストラクター
	
	/**<B>コンストラクター</B><br>
	 * 行の自動フラッシュは行わずに、指定のファイルで新しい出力ストリームを作成します。
	 * この便利なコンストラクタは必要な中間OutputStreamWriterを作成し、
	 * これが指定された文字セットを使用して文字をエンコードします。
	 * @param file この出力ストリームの宛先として使用するファイル。
	 * ファイルが存在する場合、サイズ0に切り詰められる。
	 * ファイルがなければ新しいファイルが作成される。
	 * 出力はファイルに書き込まれ、バッファに格納される。
	 * @param csn サポートされているcharsetの名前
	 * 
	 * @throws FileNotFoundException 指定されたファイル・オブジェクトが既存のファイルを示さない場合、
	 * 書込み可能な通常ファイルおよび新規の通常ファイルがその名前で作成できない場合、
	 * またはファイルのオープンまたは作成中にその他のエラーが発生した場合
	 * 
	 * @throws SecurityException セキュリティ・マネージャが存在し、{@link SecurityManager#checkWrite checkWrite(file.getPath())}
	 * がファイルへの書込みアクセスを拒否した場合
	 * 
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	public DualPrintStream(File file, String csn) throws FileNotFoundException, SecurityException, UnsupportedEncodingException {
		super(file, csn);
	}

	/**<B>コンストラクター</B><br>
	 * 行の自動フラッシュは行わずに、指定のファイルで新しい出力ストリームを作成します。
	 * この便利なコンストラクタは必要な中間OutputStreamWriterを作成し、
	 * これがJava仮想マシンのこのインスタンス用にデフォルト文字セットを使用して文字をエンコードします。
	 * @param file この出力ストリームの宛先として使用するファイル。
	 * ファイルが存在する場合、サイズ0に切り詰められる。
	 * ファイルがなければ新しいファイルが作成される。
	 * 出力はファイルに書き込まれ、バッファに格納される。
	 * 
	 * @throws FileNotFoundException 指定されたファイル・オブジェクトが既存のファイルを示さない場合、
	 * 書込み可能な通常ファイルおよび新規の通常ファイルがその名前で作成できない場合、
	 * またはファイルのオープンまたは作成中にその他のエラーが発生した場合
	 * @throws SecurityException セキュリティ・マネージャが存在し、{@link SecurityManager#checkWrite checkWrite(file.getPath())}
	 * がファイルへの書込みアクセスを拒否した場合
	 */
	public DualPrintStream(File file) throws FileNotFoundException, SecurityException {
		super(file);
	}

	/**<B>コンストラクター</B><br>
	 * 新しいPrintStreamを作成します。
	 * @param out 値とオブジェクトが出力される出力ストリーム
	 * @param autoFlush boolean値。
	 * trueの場合、バイト配列が書き込まれたとき、printlnメソッドの1つが呼び出されたとき、
	 * あるいは改行文字またはバイト('\n')が書き込まれたときに必ず出力バッファがフラッシュされる
	 * @param encoding サポートされる文字エンコーディングの名前
	 * @throws UnsupportedEncodingException 指定されたエンコーディングがサポートされていない場合
	 */
	public DualPrintStream(OutputStream out, boolean autoFlush, String encoding) throws UnsupportedEncodingException {
		super(out, autoFlush, encoding);
	}

	/**<B>コンストラクター</B><br>
	 * 新しいPrintStreamを作成します。
	 * @param out 値とオブジェクトが出力される出力ストリーム
	 * @param autoFlush boolean値。
	 * trueの場合、バイト配列が書き込まれたとき、printlnメソッドの1つが呼び出されたとき、
	 * あるいは改行文字またはバイト('\n')が書き込まれたときに必ず出力バッファがフラッシュされる
	 */
	public DualPrintStream(OutputStream out, boolean autoFlush) {
		super(out, autoFlush);
	}

	/**<B>コンストラクター</B><br>
	 * 新しいPrintStreamを作成します。このストリームは、自動的にフラッシュすることはありません。
	 * @param out 値とオブジェクトが出力される出力ストリーム
	 */
	public DualPrintStream(OutputStream out) {
		super(out);
	}

	/**<B>コンストラクター</B><br>
	 * 行の自動フラッシュは行わずに、指定の名前と文字セットで新しい出力ストリームを作成します。
	 * この便利なコンストラクタは必要な中間OutputStreamWriterを作成し、これが指定された文字セットを使用して文字をエンコードします。
	 * @param fileName この出力ストリームの宛先として使用するファイルの名前。
	 * ファイルが存在する場合、サイズ0に切り詰められる。
	 * ファイルがなければ新しいファイルが作成される。
	 * 出力はファイルに書き込まれ、バッファに格納される。
	 * @param csn サポートされているcharsetの名前
	 * @throws FileNotFoundException 指定されたファイル・オブジェクトが既存のファイルを示さない場合、
	 * 書込み可能な通常ファイルおよび新規の通常ファイルがその名前で作成できない場合、
	 * またはファイルのオープンまたは作成中にその他のエラーが発生した場合
	 * 
	 * @throws SecurityException セキュリティ・マネージャが存在し、{@link SecurityManager#checkWrite checkWrite(file.getPath())}
	 * がファイルへの書込みアクセスを拒否した場合
	 * 
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	public DualPrintStream(String fileName, String csn) throws FileNotFoundException, SecurityException, UnsupportedEncodingException {
		super(fileName, csn);
	}

	/**<B>コンストラクター</B><br>
	 * 行の自動フラッシュは行わずに、指定の名前で新しい出力ストリームを作成します。
	 * この便利なコンストラクタは必要な中間OutputStreamWriterを作成し、
	 * これがJava仮想マシンのこのインスタンス用にデフォルト文字セットを使用して文字をエンコードします。
	 * @param fileName この出力ストリームの宛先として使用するファイルの名前。
	 * ファイルが存在する場合、サイズ0に切り詰められる。
	 * ファイルがなければ新しいファイルが作成される。
	 * 出力はファイルに書き込まれ、バッファに格納される。
	 * @throws FileNotFoundException 指定されたファイル・オブジェクトが既存のファイルを示さない場合、
	 * 書込み可能な通常ファイルおよび新規の通常ファイルがその名前で作成できない場合、
	 * またはファイルのオープンまたは作成中にその他のエラーが発生した場合
	 * @throws SecurityException セキュリティ・マネージャが存在し、{@link SecurityManager#checkWrite checkWrite(file.getPath())}
	 * がファイルへの書込みアクセスを拒否した場合
	 */
	public DualPrintStream(String fileName) throws FileNotFoundException, SecurityException {
		super(fileName);
	}



	

	
	
	//------------------------------------------------------setter/getter
	/** <h1>getSubStream</h1>
	 * {@link DualPrintStream#subStream}の取得<br>
	 * @return subStream
	 */
	public PrintStream getSubStream() {
		return this.subStream;
	}

	/** <h1>setSubStream</h1>
	 * {@link DualPrintStream#subStream}をセットします<br>
	 * @param subStream セットする subStream
	 */
	public void setSubStream(PrintStream subStream) {
		this.subStream = subStream;
	}

	/** <h1>isTimeDumpofSub</h1>
	 * {@link DualPrintStream#timeDumpofSub}の取得<br>
	 * @return timeDumpofSub
	 */
	public boolean isTimeDumpofSub() {
		return this.timeDumpofSub;
	}

	/** <h1>setTimeDumpofSub</h1>
	 * {@link DualPrintStream#timeDumpofSub}をセットします<br>
	 * @param timeDumpofSub セットする timeDumpofSub
	 */
	public void setTimeDumpofSub(boolean timeDumpofSub) {
		this.timeDumpofSub = timeDumpofSub;
	}

	//------------------------------------------------------Override
	/**<h1>flush</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#flush()
	 */
	@Override
	public void flush() {
		this.subStream.flush();
		super.flush();
	}

	/**<h1>close</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#close()
	 */
	@Override
	public void close() {
		this.subStream.close();
		super.close();
	}

	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(boolean)
	 */
	@Override
	public void print(boolean b) {
		String nowtime = null;
		if(timeDumpofMain | timeDumpofSub) {
			nowtime = RSystem.getDateTime();
		}
		this.subStream.print(timeDumpofSub ? nowtime+" "+b: b);
		super.print(timeDumpofMain ? nowtime+" "+b: b);
	}

	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(char)
	 */
	@Override
	public void print(char c) {
		String nowtime = null;
		if(timeDumpofMain | timeDumpofSub) {
			nowtime = RSystem.getDateTime();
		}
		this.subStream.print(timeDumpofSub ? nowtime+" "+c: c);
		super.print(timeDumpofMain ? nowtime+" "+c: c);
	}

	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(int)
	 */
	@Override
	public void print(int i) {
		String nowtime = null;
		if(timeDumpofMain | timeDumpofSub) {
			nowtime = RSystem.getDateTime();
		}
		this.subStream.print(timeDumpofSub ? nowtime+" "+i: i);
		super.print(timeDumpofMain ? nowtime+" "+i: i);
	}

	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(long)
	 */
	@Override
	public void print(long l) {
		String nowtime = null;
		if(timeDumpofMain | timeDumpofSub) {
			nowtime = RSystem.getDateTime();
		}
		this.subStream.print(timeDumpofSub ? nowtime+" "+l: l);
		super.print(timeDumpofMain ? nowtime+" "+l: l);
	}

	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(float)
	 */
	@Override
	public void print(float f) {
		String nowtime = null;
		if(timeDumpofMain | timeDumpofSub) {
			nowtime = RSystem.getDateTime();
		}
		this.subStream.print(timeDumpofSub ? nowtime+" "+f: f);
		super.print(timeDumpofMain ? nowtime+" "+f: f);
	}

	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(double)
	 */
	@Override
	public void print(double d) {
		String nowtime = null;
		if(timeDumpofMain | timeDumpofSub) {
			nowtime = RSystem.getDateTime();
		}
		this.subStream.print(timeDumpofSub ? nowtime+" "+d: d);
		super.print(timeDumpofMain ? nowtime+" "+d: d);
	}

	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(char[])
	 */
	@Override
	public void print(char[] s) {
		String nowtime = null;
		if(timeDumpofMain | timeDumpofSub) {
			nowtime = RSystem.getDateTime();
		}
		String sString = String.valueOf(s);
		this.subStream.print(timeDumpofSub ? nowtime+" "+sString: sString);
		super.print(timeDumpofMain ? nowtime+" "+sString: sString);
	}

	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(java.lang.String)
	 */
	@Override
	public void print(String s) {
		String nowtime = null;
		if(timeDumpofMain | timeDumpofSub) {
			nowtime = RSystem.getDateTime();
		}
		this.subStream.print(timeDumpofSub ? nowtime+" "+s: s);
		super.print(timeDumpofMain ? nowtime+" "+s: s);
	}

	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(java.lang.Object)
	 */
	@Override
	public void print(Object obj) {
		String nowtime = null;
		if(timeDumpofMain | timeDumpofSub) {
			nowtime = RSystem.getDateTime();
		}
		String objString = String.valueOf(obj);
		this.subStream.print(timeDumpofSub ? nowtime+" "+objString: objString);
		super.print(timeDumpofMain ? nowtime+" "+objString: objString);
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println()
	 */
	@Override
	public void println() {
		this.subStream.println();
		super.println();
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println(boolean)
	 */
	@Override
	public void println(boolean x) {
		this.subStream.println(x);
		super.println(x);
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println(int)
	 */
	@Override
	public void println(int x) {
		this.subStream.println(x);
		super.println(x);
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println(long)
	 */
	@Override
	public void println(long x) {
		this.subStream.println(x);
		super.println(x);
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println(float)
	 */
	@Override
	public void println(float x) {
		this.subStream.println(x);
		super.println(x);
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println(double)
	 */
	@Override
	public void println(double x) {
		this.subStream.println(x);
		super.println(x);
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println(char[])
	 */
	@Override
	public void println(char[] x) {
		this.subStream.println(x);
		super.println(x);
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println(java.lang.String)
	 */
	@Override
	public void println(String x) {
		this.subStream.println(x);
		super.println(x);
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println(java.lang.Object)
	 */
	@Override
	public void println(Object x) {
		this.subStream.println(x);
		super.println(x);
	}

}
