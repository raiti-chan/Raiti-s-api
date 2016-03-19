package raiti.RaitisAPI.io;

import raiti.RaitisAPI.io.File;

import java.util.ArrayList;

/**
 * <h1>FileChecker</h1>
 * ファイル、及びフォルダーのチェッククラス。<br>
 * ファイル名の検索などをします。
 * @author Raiti
 * @version 1.0.0
 *
 */
public class FileChecker {
	
	/**
	 * チェックするファイル及びフォルダー
	 */
	private File file;
	
	/**
	 * フォルダ内のファイル及びフォルダーパスリスト
	 */
	private String[] urlList;
	
	/**
	 * <B>コンストラクター</B><br>
	 * @param file 読み込むファイル及びフォルダー
	 */
	public FileChecker(File file) {
		if ((file.isFile()) || (!file.exists())) {
			this.file = file;
			return;
		}
		this.file = file;
		this.urlList = file.list();
	}
	
	/**
	 * <h1>ReverseCheck</h1>
	 * ファイルを後ろから名前の照合をし、一致したもので一番初めの1つを取得します<br>
	 * 一致しなかった場合nullが返されます<br>
	 * @param text 照合する文字列
	 * @return 後ろから照合し、取得した最初のファイルパス。一致しなかった場合null
	 */
	public String ReverseCheck(String text) {
		String[] returnURLS = ReverseCheckAll(text);
		if(returnURLS == null) {
			return null;
		}
		String returnURL = returnURLS[0];
		returnURLS = null;
		return returnURL;
	}
	
	/**
	 * <h1>ReverseCheckAll</h1>
	 * ファイル名を後ろから照合し、一致したものを全て取得します<br>
	 * フォルダー内に<br>
	 * ・File1.txt<br>
	 * ・File2.txt<br>
	 * ・File3.png<br>
	 * ・File4.txt<br>
	 * とファイルがあり、このメソッドを".txt"指定で実行すると<br>
	 * File1.txt,File2.txt,file4.txt が返されます<br>
	 * ファイルが1つも一致しなかった場合nullが返されます
	 * @param text 照合する文字列
	 * @return 照合し一致したファイルパス。1つも一致しなかった場合null
	 */
	public String[] ReverseCheckAll(String text) {
		char[] textchar = text.toCharArray();

		ArrayList<String> returnURLList = new ArrayList<String>();
		for (int i = 0; i < this.urlList.length; i++) {
			char[] urlchar = this.urlList[i].toCharArray();
			for (int ii = 0; ii < textchar.length; ii++) {
				if (urlchar[(urlchar.length - 1 - ii)] != textchar[(textchar.length - 1 - ii)]) {
					break;
				}
				if (ii == textchar.length - 1) {
					returnURLList.add(this.urlList[i]);
				}
			}
		}
		if(returnURLList.size() == 0) {
			return null;
		}
		String[] UrlList = new String[returnURLList.size()];
		for (int i = 0, l = UrlList.length; i < l; i++) {
			UrlList[i] = returnURLList.get(i);
		}
		return UrlList;
	}

	/**
	 * @return file
	 */
	public File getFile() {
		return this.file;
	}

	/**
	 * @param file セットする file
	 */
	public void setFile(File file) {
		this.file = file;
	}
	
	
}
