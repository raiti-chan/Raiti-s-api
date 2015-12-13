package raiti.RaitisAPI.io.csv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import raiti.RaitisAPI.io.File;
import raiti.RaitisAPI.util.RSystem;

/**
 * <h1>CsvReader</h1>
 * CSVファイルのリーダー<br>
 * CSVファイルを読み込みます。<br>
 * データはString形2次配列[行][区切り]で格納されます。<br>
 * 行は{@link ArrayList}を使用しています。<br>
 * @author Raiti
 * @version 1.0.0
 * @see ArrayList
 * @see BufferedReader
 */
public class CsvReader extends BufferedReader {
	
	/**
	 * データ格納リスト
	 */
	private ArrayList<String[]> csvDataList = new ArrayList<String[]>();
	
	/**
	 * リスト全体でもっとも長いString配列の要素数。<br>
	 * {{"aaa","bbb","ccc"},<br>
	 *  {"AAA",BBB","CCC",DDD"},<br>
	 *  {"111","222","333"}}<br>
	 *  の場合4
	 */
	private int Maxindex;
	
	/**
	 * ここに読み込まれている{@link FileInputStream}
	 */
	private FileInputStream InputStream;
	
	/**
	 * ここに読み込まれている{@link FileInputStream}の一時バッファー
	 */
	private static FileInputStream InputStreamBuffer;
	
	/**
	 * <B>コンストラクター</B><br>
	 * @param in Reader
	 */
	public CsvReader(Reader in) {
		super(in);
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * @param input {@link java.io.InputStreamReader InputStreamReader}
	 * @param charsetName サポートされている{@link java.nio.charset.Charset charset}の名前 
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	public CsvReader(FileInputStream input, String charsetName) throws UnsupportedEncodingException {
		this(new InputStreamReader(input, charsetName));
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * 文字コードはデフォルトでUTF-8になります
	 * @param input {@link java.io.InputStreamReader InputStreamReader}
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	public CsvReader(FileInputStream input) throws UnsupportedEncodingException {
		this(new InputStreamReader(input, "UTF-8"));
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * @param file CSVファイル
	 * @param charsetName サポートされている{@link java.nio.charset.Charset charset}の名前
	 * @throws FileNotFoundException ファイルが存在しないか、通常ファイルではなくディレクトリであるか、またはなんらかの理由で開くことができない場合。 
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	public CsvReader(File file, String charsetName) throws FileNotFoundException, UnsupportedEncodingException {
		this(makeInput(file), charsetName);
		this.InputStream = InputStreamBuffer;
		InputStreamBuffer = null;
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * 文字コードはファイルから解析します。
	 * @param file CSVファイル
	 * @throws IOException 入出力エラーが発生した場合。
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	public CsvReader(File file) throws IOException, UnsupportedEncodingException {
		this(makeInput(file), RSystem.getFileChar(file.getPath()));
		this.InputStream = InputStreamBuffer;
		InputStreamBuffer = null;
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * @param URL CSVファイルパス
	 * @param charsetName サポートされている{@link java.nio.charset.Charset charset}の名前
	 * @throws FileNotFoundException ファイルが存在しないか、通常ファイルではなくディレクトリであるか、またはなんらかの理由で開くことができない場合。 
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	public CsvReader(String URL, String charsetName) throws FileNotFoundException, UnsupportedEncodingException {
		this(makeInput(URL), charsetName);
		this.InputStream = InputStreamBuffer;
		InputStreamBuffer = null;
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * 文字コードはファイルから解析します。
	 * @param URL CSVファイルパス
	 * @throws IOException 入出力エラーが発生した場合。
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	public CsvReader(String URL) throws IOException, UnsupportedEncodingException {
		this(makeInput(URL), RSystem.getFileChar(URL));
		this.InputStream = InputStreamBuffer;
		InputStreamBuffer = null;
	}
	
	/**
	 * <h1>makeInput</h1>
	 * {@link FileInputStream}の参照をメンバに保存するために使用するメソッド<br>
	 * @param file CSVファイル
	 * @return 作成され参照が保管された{@link FileInputStream}
	 * @throws FileNotFoundException ファイルが存在しないか、通常ファイルではなくディレクトリであるか、またはなんらかの理由で開くことができない場合。
	 */
	private static FileInputStream makeInput(File file) throws FileNotFoundException {
		FileInputStream fi = new FileInputStream(file);
		InputStreamBuffer = fi;
		return fi;
	}
	
	/**
	 * <h1>makeInput</h1>
	 * {@link FileInputStream}の参照をメンバに保存するために使用するメソッド<br>
	 * @param URL CSVファイルパス
	 * @return 作成され参照が保管された{@link FileInputStream}
	 * @throws FileNotFoundException ファイルが存在しないか、通常ファイルではなくディレクトリであるか、またはなんらかの理由で開くことができない場合。
	 */
	private static FileInputStream makeInput(String URL) throws FileNotFoundException {
		FileInputStream fi = new FileInputStream(URL);
		InputStreamBuffer = fi;
		return fi;
	}
	
	/**<h1>finalize</h1>
	 * オーバーライド
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		close();
		
	}
	
	/**
	 * <h1>load</h1>
	 * CSVファイルを読み込み、データを作成します。<br>
	 * @param delim データの区切り字
	 * @throws IOException 入出力エラーが発生した場合 
	 */
	public void load(String delim) throws IOException {
		int index = 0;
		String line;
		while ((line = readLine()) != null) {
			StringTokenizer token = new StringTokenizer(line, delim);
			String[] data = new String[token.countTokens()];
			while (token.hasMoreTokens()) {
				data[index] = token.nextToken();
				index++;
			}
			this.csvDataList.add(data);
			if (index + 1 >= this.Maxindex) {
				this.Maxindex = (index + 1);
			}
			index = 0;
		}
	}
	
	/**
	 * <h1>load</h1>
	 *  CSVファイルを読み込み、データを作成します。<br>
	 *  区切り字はデフォルトの','を使用します。
	 * @throws IOException CSVファイルを読み込み、データを作成します。
	 */
	public void load() throws IOException {
		load(",");
	}
	
	/**
	 * <h1>getDataLineList</h1>
	 * データ配列を取得します。<br>
	 * @return データ配列
	 */
	public String[][] getDataLineList() {
		String[][] dataLine = new String[this.csvDataList.size()][this.Maxindex];
		for (int i = 0; i < this.csvDataList.size(); i++) {
			dataLine[i] = (this.csvDataList.get(i));
		}
		return dataLine;
	}
	
	/**
	 * <h1>nextLine</h1>
	 * 行ごとのデータ配列を上から1つ取り出します。<br>
	 * 取り出したデータは破棄されます。
	 * @return 1行のStringデータ配列
	 */
	public String[] nextLine() {
		String[] line = this.csvDataList.get(0);
		this.csvDataList.remove(0);
		return line;
	}
	
	/**
	 * <h1>countDataLine</h1>
	 * 格納されているデータの行数を取得します<br>
	 * @return データの行数
	 */
	public int countDataLine() {
		return this.csvDataList.size();
	}
	
	/**
	 * <h1>hasMoreDataLine</h1>
	 * まだデータがここに残っているかの検証<br>
	 * @return データが残っている場合はtrue、残って無ければfalse
	 */
	public boolean hasMoreDataLine() {
		if (this.csvDataList.size() <= 0) {
			return false;
		}
		return true;
	}
	
	/**<h1>close</h1>
	 * オーバーライド
	 * @see java.io.BufferedReader#close()
	 */
	@Override
	public void close() throws IOException {
		super.close();
		InputStream.close();
	}
}
