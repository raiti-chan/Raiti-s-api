package raiti.RaitisAPI.io.csv;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import raiti.RaitisAPI.io.File;

/**
 * <h1>CsvWriter</h1> 
 * CSVファイルのライター<br>
 * CSVファイルを書き込みます。<br>
 * 
 * @author Raiti
 * @version 1.0.0
 *
 */
public class CsvWriter extends BufferedWriter {
	/**
	 * データのリスト
	 */
	private ArrayList<String[]> csvDataList = new ArrayList<String[]>();
	
	/**
	 * ここに読み込まれている{@link FileOutputStream}
	 */
	private FileOutputStream OutputStream;
	
	/**
	 * ここに読み込まれている{@link FileOutputStream}の一時バッファー
	 */
	private static FileOutputStream OutputStreamBuffer;
	
	/**
	 * <B>コンストラクター</B><br>
	 * @param in Writer
	 */
	public CsvWriter(Writer in) {
		super(in);
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * @param output {@link java.io.OutputStreamWriter OutputStreamWriter}
	 * @param charsetName サポートされている{@link java.nio.charset.Charset charset}の名前 
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	public CsvWriter(OutputStream output, String charsetName) throws UnsupportedEncodingException {
		this(new OutputStreamWriter(output, charsetName));
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * 文字コードはデフォルトでUTF-8になります
	 * @param output {@link java.io.OutputStreamWriter OutputStreamWriter}
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	public CsvWriter(OutputStream output) throws UnsupportedEncodingException {
		this(new OutputStreamWriter(output, "UTF-8"));
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * @param file CSVファイル
	 * @param charsetName サポートされている{@link java.nio.charset.Charset charset}の名前
	 * @throws FileNotFoundException ファイルが存在しないか、通常ファイルではなくディレクトリであるか、またはなんらかの理由で開くことができない場合。 
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	public CsvWriter(File file, String charsetName) throws FileNotFoundException, UnsupportedEncodingException {
		this(makeOutput(file), charsetName);
		this.OutputStream = OutputStreamBuffer;
		OutputStreamBuffer = null;
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * 文字コードはファイルから解析します。
	 * @param file CSVファイル
	 * @throws FileNotFoundException ファイルが存在しないか、通常ファイルではなくディレクトリであるか、
	 * またはなんらかの理由で開くことができない場合。
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	public CsvWriter(File file) throws FileNotFoundException, UnsupportedEncodingException {
		this(makeOutput(file));
		this.OutputStream = OutputStreamBuffer;
		OutputStreamBuffer = null;
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * @param URL CSVファイルパス
	 * @param charsetName サポートされている{@link java.nio.charset.Charset charset}の名前
	 * @throws FileNotFoundException ファイルが存在しないか、通常ファイルではなくディレクトリであるか、またはなんらかの理由で開くことができない場合。 
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	public CsvWriter(String URL, String charsetName) throws FileNotFoundException, UnsupportedEncodingException {
		this(makeOutput(URL), charsetName);
		this.OutputStream = OutputStreamBuffer;
		OutputStreamBuffer = null;
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * 文字コードはファイルから解析します。
	 * @param URL CSVファイルパス
	 * @throws FileNotFoundException ファイルが存在しないか、通常ファイルではなくディレクトリであるか、
	 * またはなんらかの理由で開くことができない場合。
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	public CsvWriter(String URL) throws FileNotFoundException, UnsupportedEncodingException {
		this(makeOutput(URL));
		this.OutputStream = OutputStreamBuffer;
		OutputStreamBuffer = null;
	}
	
	/**
	 * <h1>makeOutput</h1>
	 * {@link FileInputStream}の参照をメンバに保存するために使用するメソッド<br>
	 * @param file CSVファイル
	 * @return 作成され参照が保管された{@link FileOutputStream}
	 * @throws FileNotFoundException ファイルが存在しないか、通常ファイルではなくディレクトリであるか、またはなんらかの理由で開くことができない場合。
	 */
	private static FileOutputStream makeOutput(File file) throws FileNotFoundException {
		FileOutputStream fi = new FileOutputStream(file);
		OutputStreamBuffer = fi;
		return fi;
	}
	
	/**
	 * <h1>makeOutput</h1>
	 * {@link FileInputStream}の参照をメンバに保存するために使用するメソッド<br>
	 * @param URL CSVファイルパス
	 * @return 作成され参照が保管された{@link FileOutputStream}
	 * @throws FileNotFoundException ファイルが存在しないか、通常ファイルではなくディレクトリであるか、またはなんらかの理由で開くことができない場合。
	 */
	private static FileOutputStream makeOutput(String URL) throws FileNotFoundException {
		FileOutputStream fi = new FileOutputStream(URL);
		OutputStreamBuffer = fi;
		return fi;
	}
	
	/**
	 * <h1>add</h1>
	 * データを一番下に追加します<br>
	 * @param data 行データ
	 */
	public void add(String... data) {
		this.csvDataList.add(data);
	}
	
	/**
	 * <h1>add</h1>
	 * データを指定した位置に追加します<br>
	 * @param index 位置
	 * @param data 行データ
	 */
	public void add(int index, String... data) {
		this.csvDataList.add(index, data);
	}
	
	/**
	 * <h1>add</h1>
	 * 行データリスト形で一番下に追加します<br>
	 * @param csvDataList 追加する行データ
	 */
	public void add(List<String[]> csvDataList) {
		csvDataList.forEach(datalint -> add(datalint));
	}
	
	/**
	 * <h1>setCsvDataList</h1>
	 * データリストをセットします。<br>
	 * 前にあったデータリストは置き換えられます。
	 * @param csvDataList データリスト
	 * @return 前にあったデータリストが返されます。
	 */
	public ArrayList<String[]> setCsvDataList(ArrayList<String[]> csvDataList) {
		ArrayList<String[]> listbuffer = this.csvDataList;
		this.csvDataList = csvDataList;
		return listbuffer;
	}
	
	
	/**
	 * <h1>writeCSV</h1>
	 * 指定した区切り字でCSVファイルを書き込みます。<br>
	 * @param delim 区切り字
	 * @throws IOException 入出力エラーが発生した場合 
	 */
	public void writeCSV(String delim) throws IOException {
		for (String[] line : this.csvDataList) {
			for (int i = 0,loop = line.length; i < loop; i++) {
				super.write(line[i]);
				if (i < loop - 1) {
					super.write(delim);
				}
			}
			super.newLine();
		}
		this.csvDataList = new ArrayList<String[]>();
	}
	
	
	/**
	 * <h1>write</h1>
	 * CSVファイルを書き込みます。<br>
	 * 区切り字はデフォルト','を使用します。
	 * @throws IOException 入出力エラーが発生した場合 
	 */
	public void write() throws IOException {
		writeCSV(",");
	}
	
	/**<h1>close</h1>
	 * オーバーライド
	 * @see java.io.BufferedWriter#close()
	 */
	@Override
	public void close() throws IOException {
		super.close();
		this.OutputStream.close();
		
	};
	
	
	@Override
	@Deprecated
	public void newLine() throws IOException {
		super.newLine();
	}
	
	@Override
	@Deprecated
	public void write(char[] cbuf, int off, int len) throws IOException {
		super.write(cbuf, off, len);
	}

	@Override
	@Deprecated
	public void write(int c) throws IOException {
		super.write(c);
	}

	@Override
	@Deprecated
	public void write(String s, int off, int len) throws IOException {
		super.write(s, off, len);
	}

	@Override
	@Deprecated
	public void write(char[] cbuf) throws IOException {
		super.write(cbuf);
	}

	@Override
	@Deprecated
	public void write(String str) throws IOException {
		super.write(str);
	}
}
