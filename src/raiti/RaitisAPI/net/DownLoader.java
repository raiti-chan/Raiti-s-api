/*
 * 
 */
package raiti.RaitisAPI.net;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/** <h1>DownLoader</h1>
 * httpサーバー上のファイルをダウンロードします<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class DownLoader {
	
	/**
	 * ログを出力するか。trueの場合出力します
	 */
	private boolean logOut = false;
	
	/**
	 * ダウンロードするファイルのURLです
	 */
	private URL url;
	
	/**
	 * URLへの接続オブジェクト
	 */
	private URLConnection connection;
	
	
	//-------------------------------------コンストラクター
	/**
	 * <B>コンストラクター</B><br>
	 * ダウンローダーを作成します
	 * @param url ファイルのURL
	 * @throws MalformedURLException プロトコルが指定されていないか、不明なプロトコルが見つかったか、specがnullの場合。
	 */
	public DownLoader(String url) throws MalformedURLException {
		this.url = new URL(url);
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * ダウンローダーを作成します
	 * @param url ファイルのURL
	 * @param logOutput Logを出力するか。trueの場合出力します
	 * @throws MalformedURLException プロトコルが指定されていないか、不明なプロトコルが見つかったか、specがnullの場合。
	 */
	public DownLoader(String url , boolean logOutput) throws MalformedURLException {
		this(url);
		this.logOut = logOutput;
	}
	
	
	/**
	 * <h1>Connecting</h1>
	 * URLへ接続し、接続オブジェクトを生成します<br>
	 * @throws IOException 入出力例外が発生した場合。
	 */
	public void Connecting() throws IOException {
		printLogs("Connecting:["+url.toString()+"]");
		connection = url.openConnection();
	}
	
	/**
	 * <h1>getDataInputStream</h1>
	 * URLのDataInputStreamを取得します<br>
	 * @return ダウンロードするデータの入力ストリーム
	 * @throws IOException 入力ストリームの作成中に入出力エラーが発生した場合。
	 */
	public DataInputStream getDataInputStream() throws IOException {
		return new DataInputStream(connection.getInputStream());
	}
	
	/**
	 * <h1>download</h1>
	 * ファイルをダウンロードします。<br>
	 * @param file ダウンロード先ファイル
	 * @return ダウンロードが完了したファイル
	 * @throws IOException 入出力エラーが発生した場合
	 */
	public File download(File file) throws IOException {
		if(!file.exists()) {
			file.createNewFile();
		}
		if(file.isDirectory()) throw new IOException("パスがディレクトリです");
		
		FileOutputStream out = new FileOutputStream(file);
		int loadsize = 0;
		byte[] bytes = new byte[1048576];
		int ret = 0;
		DataInputStream datainput = getDataInputStream();
		while(true) {
			ret = datainput.read(bytes);
			if(ret <= 0) break;
			out.write(bytes,0,ret);
			loadsize += ret;
			printLogs("Downloading - "+loadsize);
		}
		datainput.close();
		out.close();
		printLogs("Finish!!");
		return file;
	}
	
	/**
	 * <h1>download</h1>
	 * ファイルをダウンロードします。<br>
	 * @param path ダウンロード先ファイルパス
	 * @return ダウンロードしたファイル
	 * @throws IOException 入出力例外が発生した場合。
	 */
	public File download(String path) throws IOException {
		return download(new File(path));
	}
	
	
	/**
	 * <h1>printLogs</h1>
	 * 標準出力へlogを出力します<br>
	 * @param log 出力Log
	 */
	private void printLogs(String log) {
		if(logOut) System.out.println("DownLoader:"+log);
	}
	
	/**
	 * <h1>Download</h1>
	 * サーバー上ファイルをダウンロードします<br>
	 * @param url ファイルのURL
	 * @param path 保存先ファイルパス
	 * @return ダウンロードしたファイル
	 * @throws IOException 入出力例外が発生した場合。
	 */
	public static File Download(String url,String path) throws IOException {
		DownLoader dl = new DownLoader(url);
		dl.Connecting();
		return dl.download(path);
	}
	
	
	
}
