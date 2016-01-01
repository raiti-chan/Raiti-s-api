/**
 * 
 */
package raiti.RaitisAPI.util.PrintStream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import raiti.RaitisAPI.util.RSystem;

/** <h1>DualFieldPrintStream</h1>
 * print1,ptint2の<br>
 * 2つのPrintStreamをフィールドとして持ち、両方を同時に操作できます<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class DualFieldPrintStream extends PrintStream{
	/**
	 * 大元の共通インスタンスのOutputStramです。
	 */
	protected static final OutputStreamofthisclass MAINOUTSTREAM = new OutputStreamofthisclass();
	
	/**
	 * 1番PrintStream
	 */
	protected PrintStream print1;
	
	/**
	 * 2番PrintStream
	 */
	protected PrintStream print2;
	
	/**
	 * PrintStream1に出力時刻をダンプするか<br>
	 * デフォルトはtrue
	 */
	protected boolean timeDumpofprint1 = true;
	
	/**
	 * PrintStream2に出力時刻をダンプするか<br>
	 * デフォルトはtrue
	 */
	protected boolean timeDumpofprint2 = true;
	
	//-------------------------------------コンストラクター
	/**<B>コンストラクター</B><br>
	 * 新しいDualFieldPrintStreamを作成します。このストリームは、自動的にフラッシュすることはありません。
	 */
	public DualFieldPrintStream() {
		super(MAINOUTSTREAM);
	}
	
	/**<B>コンストラクター</B><br>
	 * 新しいDualFieldPrintStreamを作成します
	 * @param autoFlush boolean値。trueの場合、バイト配列が書き込まれたとき、printlnメソッドの1つが呼び出されたとき、
	 * あるいは改行文字またはバイト('\n')が書き込まれたときに必ず出力バッファがフラッシュされる
	 */
	public DualFieldPrintStream(boolean autoFlush) {
		super(MAINOUTSTREAM,autoFlush);
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * PrintStreamをセットした新しいDualFieldPrintStreamを作成します。このストリームは、自動的にフラッシュすることはありません。
	 * @param print1 PrintStream1
	 * @param print2 PrintStream2
	 */
	public DualFieldPrintStream(PrintStream print1,PrintStream print2){
		super(MAINOUTSTREAM);
		this.print1 = print1;
		this.print2 = print2;
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * PrintStreamをセットした新しいDualFieldPrintStreamを作成します。
	 * @param print1 PrintStream1
	 * @param print2 PrintStream2
	 * @param autoFlush boolean値。trueの場合、バイト配列が書き込まれたとき、printlnメソッドの1つが呼び出されたとき、
	 * あるいは改行文字またはバイト('\n')が書き込まれたときに必ず出力バッファがフラッシュされる
	 */
	public DualFieldPrintStream(PrintStream print1,PrintStream print2,boolean autoFlush){
		super(MAINOUTSTREAM,autoFlush);
		this.print1 = print1;
		this.print2 = print2;
	}
	
	
	/**
	 * <h1>NullCheck</h1>
	 * PrintStream1か2のどちらかがnullでないか調べます。<br>
	 * @throws NullPointerException print1/print2のどちらか1つでもnullだった場合スローされます。
	 */
	private void NullCheck() throws NullPointerException{
		if(print1 == null | print2 == null) {
			throw new NullPointerException((print1==null ? "print1" : "print2") +"がnullです。");
		}
	}
	
	/**<h1>flush</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#flush()
	 */
	@Override
	public void flush() {
		NullCheck();
		super.flush();
		print1.flush();
		print2.flush();
	}
	
	/**<h1>close</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#close()
	 */
	@Override
	public void close() {
		NullCheck();
		super.close();
		print1.close();
		print2.close();
	}
	
	/** <h1>getPrint1</h1>
	 * {@link DualFieldPrintStream#print1}の取得<br>
	 * @return print1
	 */
	public PrintStream getPrint1() {
		return this.print1;
	}

	/** <h1>setPrint1</h1>
	 * {@link DualFieldPrintStream#print1}をセットします<br>
	 * @param print1 セットする print1
	 */
	public void setPrint1(PrintStream print1) {
		this.print1 = print1;
	}

	/** <h1>getPrint2</h1>
	 * {@link DualFieldPrintStream#print2}の取得<br>
	 * @return print2
	 */
	public PrintStream getPrint2() {
		return this.print2;
	}

	/** <h1>setPrint2</h1>
	 * {@link DualFieldPrintStream#print2}をセットします<br>
	 * @param print2 セットする print2
	 */
	public void setPrint2(PrintStream print2) {
		this.print2 = print2;
	}
	
	/** <h1>isTimeDumpofprint1</h1>
	 * {@link DualFieldPrintStream#timeDumpofprint1}の取得<br>
	 * @return timeDumpofprint1
	 */
	public boolean isTimeDumpofprint1() {
		return this.timeDumpofprint1;
	}

	/** <h1>setTimeDumpofprint1</h1>
	 * {@link DualFieldPrintStream#timeDumpofprint1}をセットします<br>
	 * @param timeDumpofprint1 セットする timeDumpofprint1
	 */
	public void setTimeDumpofprint1(boolean timeDumpofprint1) {
		this.timeDumpofprint1 = timeDumpofprint1;
	}

	/** <h1>isTimeDumpofprint2</h1>
	 * {@link DualFieldPrintStream#timeDumpofprint2}の取得<br>
	 * @return timeDumpofprint2
	 */
	public boolean isTimeDumpofprint2() {
		return this.timeDumpofprint2;
	}

	/** <h1>setTimeDumpofprint2</h1>
	 * {@link DualFieldPrintStream#timeDumpofprint2}をセットします<br>
	 * @param timeDumpofprint2 セットする timeDumpofprint2
	 */
	public void setTimeDumpofprint2(boolean timeDumpofprint2) {
		this.timeDumpofprint2 = timeDumpofprint2;
	}

	//------------------------------------------------------Override
	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(boolean)
	 */
	@Override
	public void print(boolean b) {
		print1.print(b);
		print2.print(b);
	}

	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(char)
	 */
	@Override
	public void print(char c) {
		print1.print(c);
		print2.print(c);
	}

	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(int)
	 */
	@Override
	public void print(int i) {
		print1.print(i);
		print2.print(i);
	}

	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(long)
	 */
	@Override
	public void print(long l) {
		print1.print(l);
		print2.print(l);
	}

	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(float)
	 */
	@Override
	public void print(float f) {
		print1.print(f);
		print2.print(f);
	}

	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(double)
	 */
	@Override
	public void print(double d) {
		print1.print(d);
		print2.print(d);
	}

	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(char[])
	 */
	@Override
	public void print(char[] s) {
		print1.print(s);
		print2.print(s);
	}

	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(java.lang.String)
	 */
	@Override
	public void print(String s) {
		print1.print(s);
		print2.print(s);
	}

	/**<h1>print</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#print(java.lang.Object)
	 */
	@Override
	public void print(Object obj) {
		print1.print(obj);
		print2.print(obj);
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println()
	 */
	@Override
	public void println() {
		print1.println();
		print2.println();
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println(boolean)
	 */
	@Override
	public void println(boolean x) {
		String nowtime = null;
		if(timeDumpofprint1 | timeDumpofprint2) {
			nowtime = RSystem.getDateTime();
		}
		
		print1.println(timeDumpofprint1 ? nowtime + " "+x:x);
		print2.println(timeDumpofprint2 ? nowtime + " "+x:x);
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println(char)
	 */
	@Override
	public void println(char x) {
		print1.println(x);
		String nowtime = null;
		if(timeDumpofprint1 | timeDumpofprint2) {
			nowtime = RSystem.getDateTime();
		}
		
		print1.println(timeDumpofprint1 ? nowtime + " "+x:x);
		print2.println(timeDumpofprint2 ? nowtime + " "+x:x);
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println(int)
	 */
	@Override
	public void println(int x) {
		String nowtime = null;
		if(timeDumpofprint1 | timeDumpofprint2) {
			nowtime = RSystem.getDateTime();
		}
		
		print1.println(timeDumpofprint1 ? nowtime + " "+x:x);
		print2.println(timeDumpofprint2 ? nowtime + " "+x:x);
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println(long)
	 */
	@Override
	public void println(long x) {
		String nowtime = null;
		if(timeDumpofprint1 | timeDumpofprint2) {
			nowtime = RSystem.getDateTime();
		}
		
		print1.println(timeDumpofprint1 ? nowtime + " "+x:x);
		print2.println(timeDumpofprint2 ? nowtime + " "+x:x);
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println(float)
	 */
	@Override
	public void println(float x) {
		String nowtime = null;
		if(timeDumpofprint1 | timeDumpofprint2) {
			nowtime = RSystem.getDateTime();
		}
		
		print1.println(timeDumpofprint1 ? nowtime + " "+x:x);
		print2.println(timeDumpofprint2 ? nowtime + " "+x:x);
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println(double)
	 */
	@Override
	public void println(double x) {
		String nowtime = null;
		if(timeDumpofprint1 | timeDumpofprint2) {
			nowtime = RSystem.getDateTime();
		}
		
		print1.println(timeDumpofprint1 ? nowtime + " "+x:x);
		print2.println(timeDumpofprint2 ? nowtime + " "+x:x);
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println(char[])
	 */
	@Override
	public void println(char[] x) {
		String nowtime = null;
		String xString = null;
		if(timeDumpofprint1 | timeDumpofprint2) {
			nowtime = RSystem.getDateTime();
			xString = String.valueOf(x);
		}
		
		print1.println(timeDumpofprint1 ? nowtime + " "+xString:x);
		print2.println(timeDumpofprint2 ? nowtime + " "+xString:x);
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println(java.lang.String)
	 */
	@Override
	public void println(String x) {
		String nowtime = null;
		if(timeDumpofprint1 | timeDumpofprint2) {
			nowtime = RSystem.getDateTime();
		}
		
		print1.println(timeDumpofprint1 ? nowtime + " "+x:x);
		print2.println(timeDumpofprint2 ? nowtime + " "+x:x);
	}

	/**<h1>println</h1>
	 * オーバーライド
	 * @see java.io.PrintStream#println(java.lang.Object)
	 */
	@Override
	public void println(Object x) {
		String nowtime = null;
		if(timeDumpofprint1 | timeDumpofprint2) {
			nowtime = RSystem.getDateTime();
		}
		
		print1.println(timeDumpofprint1 ? nowtime + " "+x:x);
		print2.println(timeDumpofprint2 ? nowtime + " "+x:x);
	}
	
	
	
}

/**
 * <h1>OutputStreamofthisclass</h1>
 * 何もしない、OutputStreamです。<br>
 * @author Raiti
 * @version 1.0.0
 *
 */
class OutputStreamofthisclass extends OutputStream{
	

	/**<h1>write</h1>
	 * オーバーライド
	 * @see java.io.OutputStream#write(int)
	 */
	@Override
	public void write(int b) throws IOException {
	}
}
