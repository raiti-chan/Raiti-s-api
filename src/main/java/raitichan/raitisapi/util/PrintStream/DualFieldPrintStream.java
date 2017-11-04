package raitichan.raitisapi.util.PrintStream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import raitichan.raitisapi.util.RSystem;

/**
 * print1,print2の<br>
 * 2つのPrintStreamをフィールドとして持ち、両方を同時に操作できます<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public class DualFieldPrintStream extends PrintStream {
	/**
	 * 大元の共通インスタンスのOutputStreamです。
	 */
	@SuppressWarnings("WeakerAccess")
	protected static final OutputStreamOfThisClass MAIN_OUT_STREAM = new OutputStreamOfThisClass();
	
	/**
	 * 1番PrintStream
	 */
	@SuppressWarnings("WeakerAccess")
	protected PrintStream print1;
	
	/**
	 * 2番PrintStream
	 */
	@SuppressWarnings("WeakerAccess")
	protected PrintStream print2;
	
	/**
	 * PrintStream1に出力時刻をダンプするか<br>
	 * デフォルトはtrue
	 */
	@SuppressWarnings("WeakerAccess")
	protected boolean isTimeDumpOfPrint1 = true;
	
	/**
	 * PrintStream2に出力時刻をダンプするか<br>
	 * デフォルトはtrue
	 */
	@SuppressWarnings("WeakerAccess")
	protected boolean isTimeDumpOfPrint2 = true;
	
	//-------------------------------------コンストラクター
	
	/**
	 * 新しいDualFieldPrintStreamを作成します。このストリームは、自動的にフラッシュすることはありません。
	 */
	@SuppressWarnings("unused")
	public DualFieldPrintStream () {
		super(MAIN_OUT_STREAM);
	}
	
	/**
	 * 新しいDualFieldPrintStreamを作成します
	 *
	 * @param autoFlush boolean値。trueの場合、バイト配列が書き込まれたとき、printlnメソッドの1つが呼び出されたとき、
	 *                  あるいは改行文字またはバイト('\n')が書き込まれたときに必ず出力バッファがフラッシュされる
	 */
	@SuppressWarnings("unused")
	public DualFieldPrintStream (boolean autoFlush) {
		super(MAIN_OUT_STREAM, autoFlush);
	}
	
	/**
	 * PrintStreamをセットした新しいDualFieldPrintStreamを作成します。このストリームは、自動的にフラッシュすることはありません。
	 *
	 * @param print1 PrintStream1
	 * @param print2 PrintStream2
	 */
	@SuppressWarnings("unused")
	public DualFieldPrintStream (PrintStream print1, PrintStream print2) {
		super(MAIN_OUT_STREAM);
		this.print1 = print1;
		this.print2 = print2;
	}
	
	/**
	 * PrintStreamをセットした新しいDualFieldPrintStreamを作成します。
	 *
	 * @param print1    PrintStream1
	 * @param print2    PrintStream2
	 * @param autoFlush boolean値。trueの場合、バイト配列が書き込まれたとき、printlnメソッドの1つが呼び出されたとき、
	 *                  あるいは改行文字またはバイト('\n')が書き込まれたときに必ず出力バッファがフラッシュされる
	 */
	public DualFieldPrintStream (PrintStream print1, PrintStream print2, boolean autoFlush) {
		super(MAIN_OUT_STREAM, autoFlush);
		this.print1 = print1;
		this.print2 = print2;
	}
	
	
	/**
	 * PrintStream1か2のどちらかがnullでないか調べます。<br>
	 *
	 * @throws NullPointerException print1/print2のどちらか1つでもnullだった場合スローされます。
	 */
	private void NullCheck () throws NullPointerException {
		if (print1 == null | print2 == null) {
			throw new NullPointerException((print1 == null ? "print1" : "print2") + "がnullです。");
		}
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#flush()
	 */
	@Override
	public void flush () {
		NullCheck();
		super.flush();
		print1.flush();
		print2.flush();
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#close()
	 */
	@Override
	public void close () {
		NullCheck();
		super.close();
		print1.close();
		print2.close();
	}
	
	/**
	 * {@link DualFieldPrintStream#print1}の取得<br>
	 *
	 * @return print1
	 */
	@SuppressWarnings("unused")
	public PrintStream getPrint1 () {
		return this.print1;
	}
	
	/**
	 * {@link DualFieldPrintStream#print1}をセットします<br>
	 *
	 * @param print1 セットする print1
	 */
	@SuppressWarnings("unused")
	public void setPrint1 (PrintStream print1) {
		this.print1 = print1;
	}
	
	/**
	 * {@link DualFieldPrintStream#print2}の取得<br>
	 *
	 * @return print2
	 */
	@SuppressWarnings("unused")
	public PrintStream getPrint2 () {
		return this.print2;
	}
	
	/**
	 * {@link DualFieldPrintStream#print2}をセットします<br>
	 *
	 * @param print2 セットする print2
	 */
	@SuppressWarnings("unused")
	public void setPrint2 (PrintStream print2) {
		this.print2 = print2;
	}
	
	/**
	 * {@link DualFieldPrintStream#isTimeDumpOfPrint1}の取得<br>
	 *
	 * @return isTimeDumpOfPrint1
	 */
	@SuppressWarnings("unused")
	public boolean isTimeDumpOfPrint1 () {
		return this.isTimeDumpOfPrint1;
	}
	
	/**
	 * {@link DualFieldPrintStream#isTimeDumpOfPrint1}をセットします<br>
	 *
	 * @param timeDumpOfPrint1 セットする isTimeDumpOfPrint1
	 */
	@SuppressWarnings("unused")
	public void setTimeDumpOfPrint1 (boolean timeDumpOfPrint1) {
		this.isTimeDumpOfPrint1 = timeDumpOfPrint1;
	}
	
	/**
	 * {@link DualFieldPrintStream#isTimeDumpOfPrint2}の取得<br>
	 *
	 * @return isTimeDumpOfPrint2
	 */
	@SuppressWarnings("unused")
	public boolean isTimeDumpOfPrint2 () {
		return this.isTimeDumpOfPrint2;
	}
	
	/**
	 * {@link DualFieldPrintStream#isTimeDumpOfPrint2}をセットします<br>
	 *
	 * @param timeDumpOfPrint2 セットする isTimeDumpOfPrint2
	 */
	@SuppressWarnings("unused")
	public void setTimeDumpOfPrint2 (boolean timeDumpOfPrint2) {
		this.isTimeDumpOfPrint2 = timeDumpOfPrint2;
	}
	
	//------------------------------------------------------Override
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(boolean)
	 */
	@Override
	public void print (boolean b) {
		print1.print(b);
		print2.print(b);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(char)
	 */
	@Override
	public void print (char c) {
		print1.print(c);
		print2.print(c);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(int)
	 */
	@Override
	public void print (int i) {
		print1.print(i);
		print2.print(i);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(long)
	 */
	@Override
	public void print (long l) {
		print1.print(l);
		print2.print(l);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(float)
	 */
	@Override
	public void print (float f) {
		print1.print(f);
		print2.print(f);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(double)
	 */
	@Override
	public void print (double d) {
		print1.print(d);
		print2.print(d);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(char[])
	 */
	@Override
	public void print (char[] s) {
		print1.print(s);
		print2.print(s);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(java.lang.String)
	 */
	@Override
	public void print (String s) {
		print1.print(s);
		print2.print(s);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#print(java.lang.Object)
	 */
	@Override
	public void print (Object obj) {
		print1.print(obj);
		print2.print(obj);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println()
	 */
	@Override
	public void println () {
		print1.println();
		print2.println();
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println(boolean)
	 */
	@Override
	public void println (boolean x) {
		String nowTime = null;
		if (isTimeDumpOfPrint1 | isTimeDumpOfPrint2) {
			nowTime = RSystem.getDateTime();
		}
		
		print1.println(isTimeDumpOfPrint1 ? nowTime + " " + x : x);
		print2.println(isTimeDumpOfPrint2 ? nowTime + " " + x : x);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println(char)
	 */
	@Override
	public void println (char x) {
		print1.println(x);
		String nowTime = null;
		if (isTimeDumpOfPrint1 | isTimeDumpOfPrint2) {
			nowTime = RSystem.getDateTime();
		}
		
		print1.println(isTimeDumpOfPrint1 ? nowTime + " " + x : x);
		print2.println(isTimeDumpOfPrint2 ? nowTime + " " + x : x);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println(int)
	 */
	@Override
	public void println (int x) {
		String nowTime = null;
		if (isTimeDumpOfPrint1 | isTimeDumpOfPrint2) {
			nowTime = RSystem.getDateTime();
		}
		
		print1.println(isTimeDumpOfPrint1 ? nowTime + " " + x : x);
		print2.println(isTimeDumpOfPrint2 ? nowTime + " " + x : x);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println(long)
	 */
	@Override
	public void println (long x) {
		String nowTime = null;
		if (isTimeDumpOfPrint1 | isTimeDumpOfPrint2) {
			nowTime = RSystem.getDateTime();
		}
		
		print1.println(isTimeDumpOfPrint1 ? nowTime + " " + x : x);
		print2.println(isTimeDumpOfPrint2 ? nowTime + " " + x : x);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println(float)
	 */
	@Override
	public void println (float x) {
		String nowTime = null;
		if (isTimeDumpOfPrint1 | isTimeDumpOfPrint2) {
			nowTime = RSystem.getDateTime();
		}
		
		print1.println(isTimeDumpOfPrint1 ? nowTime + " " + x : x);
		print2.println(isTimeDumpOfPrint2 ? nowTime + " " + x : x);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println(double)
	 */
	@Override
	public void println (double x) {
		String nowTime = null;
		if (isTimeDumpOfPrint1 | isTimeDumpOfPrint2) {
			nowTime = RSystem.getDateTime();
		}
		
		print1.println(isTimeDumpOfPrint1 ? nowTime + " " + x : x);
		print2.println(isTimeDumpOfPrint2 ? nowTime + " " + x : x);
	}
	
	/**
	 * <h1>println</h1>
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println(char[])
	 */
	@Override
	public void println (char[] x) {
		String nowTime = null;
		String xString = null;
		if (isTimeDumpOfPrint1 | isTimeDumpOfPrint2) {
			nowTime = RSystem.getDateTime();
			xString = String.valueOf(x);
		}
		
		print1.println(isTimeDumpOfPrint1 ? nowTime + " " + xString : x);
		print2.println(isTimeDumpOfPrint2 ? nowTime + " " + xString : x);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println(java.lang.String)
	 */
	@Override
	public void println (String x) {
		String nowTime = null;
		if (isTimeDumpOfPrint1 | isTimeDumpOfPrint2) {
			nowTime = RSystem.getDateTime();
		}
		
		print1.println(isTimeDumpOfPrint1 ? nowTime + " " + x : x);
		print2.println(isTimeDumpOfPrint2 ? nowTime + " " + x : x);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.PrintStream#println(java.lang.Object)
	 */
	@Override
	public void println (Object x) {
		String nowTime = null;
		if (isTimeDumpOfPrint1 | isTimeDumpOfPrint2) {
			nowTime = RSystem.getDateTime();
		}
		
		print1.println(isTimeDumpOfPrint1 ? nowTime + " " + x : x);
		print2.println(isTimeDumpOfPrint2 ? nowTime + " " + x : x);
	}
	
	
}

/**
 * 何もしない、OutputStreamです。<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
class OutputStreamOfThisClass extends OutputStream {
	
	
	/**
	 * オーバーライド
	 *
	 * @see java.io.OutputStream#write(int)
	 */
	@Override
	public void write (int b) throws IOException {
	}
}
