package raitichan.raitisapi.util;

import java.io.PrintStream;

import raitichan.raitisapi.util.PrintStream.DualFieldPrintStream;
import raitichan.raitisapi.util.PrintStream.DualPrintStream;

/**
 * 標準出力及び、標準エラー出力のユーティリティーです。<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public class SystemOutUtility {
	
	/**
	 * 標準出力に、現在の標準出力をサブにセットした、{@link DualPrintStream}を標準出力に設定します。<br>
	 * 標準出力を変更していなければコンソールと設定したPrintStreamに出力できます。
	 *
	 * @param sps セットするDualPrintStream
	 */
	@SuppressWarnings("unused")
	public static void setOut (DualPrintStream sps) {
		PrintStream defaultPs = System.out;
		sps.setSubStream(defaultPs);
		System.setOut(sps);
		
	}
	
	/**
	 * 標準エラー出力に、現在の標準出力をサブにセットした、{@link DualPrintStream}を標準出力に設定します。<br>
	 * 標準エラー出力を変更していなければコンソールと設定したPrintStreamに出力できます。
	 *
	 * @param sps セットするDualPrintStream
	 */
	@SuppressWarnings("unused")
	public static void setErr (DualPrintStream sps) {
		PrintStream defaultPs = System.err;
		sps.setSubStream(defaultPs);
		System.setErr(sps);
		
	}
	
	/**
	 * 標準出力に、現在の標準出力を{@link DualFieldPrintStream print2}にセットした、{@link PrintStream}を標準出力に設定します。<br>
	 * 標準出力を変更していなければコンソールと設定したPrintStreamに出力できます。
	 *
	 * @param print セットするPrintStream
	 * @return セットされたDualFieldPrintStream
	 * @see DualFieldPrintStream
	 */
	@SuppressWarnings("unused")
	public static DualFieldPrintStream setOut (PrintStream print) {
		PrintStream defaultPrint = System.out;
		
		DualFieldPrintStream dualPrint = new DualFieldPrintStream(defaultPrint, print, true);
		
		System.setOut(dualPrint);
		return dualPrint;
	}
	
	/**
	 * 標準エラー出力に、現在の標準出力を{@link DualFieldPrintStream print2}にセットした、{@link PrintStream}を標準出力に設定します。<br>
	 * 標準エラー出力を変更していなければコンソールと設定したPrintStreamに出力できます。
	 *
	 * @param print セットするPrintStream
	 * @return セットされたDualFieldPrintStream
	 * @see DualFieldPrintStream
	 */
	@SuppressWarnings("unused")
	public static DualFieldPrintStream setErr (PrintStream print) {
		PrintStream defaultPrint = System.err;
		
		DualFieldPrintStream dualPrint = new DualFieldPrintStream(defaultPrint, print, true);
		
		System.setErr(dualPrint);
		return dualPrint;
	}
	
}
