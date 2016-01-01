package raiti.RaitisAPI.util;

import java.io.PrintStream;

import raiti.RaitisAPI.util.PrintStream.DualFieldPrintStream;
import raiti.RaitisAPI.util.PrintStream.DualPrintStream;

/**
 * <h1>SystemOutSeter</h1>
 * 標準出力及び、標準エラー出力のユーティリティーです。<br>
 * @author Raiti
 * @version 1.0.0
 *
 */
public class SystemOutUtility {
	
	/**
	 * <h1>OutSeter</h1>
	 * 標準出力に、現在の標準出力をサブにセットした、{@link DualPrintStream}を標準出力に設定します。<br>
	 * 標準出力を変更していなければコンソールと設定したPrintStreamに出力できます。
	 * @param sps セットするDualPrintStream
	 */
	public static void OutSeter(DualPrintStream sps) {
		PrintStream defps = System.out;
		sps.setSubStream(defps);
		System.setOut(sps);
		
	}
	
	/**
	 * <h1>ErrSeter</h1>
	 * 標準エラー出力に、現在の標準出力をサブにセットした、{@link DualPrintStream}を標準出力に設定します。<br>
	 * 標準エラー出力を変更していなければコンソールと設定したPrintStreamに出力できます。
	 * @param sps セットするDualPrintStream
	 */
	public static void ErrSeter(DualPrintStream sps) {
		PrintStream defps = System.err;
		sps.setSubStream(defps);
		System.setErr(sps);
		
	}
	
	/**
	 * <h1>OutSeter</h1>
	 * 標準出力に、現在の標準出力を{@link DualFieldPrintStream print2}にセットした、{@link PrintStream}を標準出力に設定します。<br>
	 * 標準出力を変更していなければコンソールと設定したPrintStreamに出力できます。
	 * @param print セットするPrintStream
	 * @return セットされたDualFieldPrintStream
	 * @see DualFieldPrintStream
	 */
	public static DualFieldPrintStream OutSeter(PrintStream print) {
		PrintStream defaultprint = System.out;
		
		DualFieldPrintStream dualprint = new DualFieldPrintStream(defaultprint, print,true);
		
		System.setOut(dualprint);
		return dualprint;
	}
	
	/**
	 * <h1>ErrSeter</h1>
	 * 標準エラー出力に、現在の標準出力を{@link DualFieldPrintStream print2}にセットした、{@link PrintStream}を標準出力に設定します。<br>
	 * 標準エラー出力を変更していなければコンソールと設定したPrintStreamに出力できます。
	 * @param print セットするPrintStream
	 * @return セットされたDualFieldPrintStream
	 * @see DualFieldPrintStream
	 */
	public static DualFieldPrintStream ErrSeter(PrintStream print) {
		PrintStream defaultprint = System.err;
		
		DualFieldPrintStream dualprint = new DualFieldPrintStream(defaultprint, print,true);
		
		System.setErr(dualprint);
		return dualprint;
	}
	
}
