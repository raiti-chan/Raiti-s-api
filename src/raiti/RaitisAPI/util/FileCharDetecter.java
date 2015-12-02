package raiti.RaitisAPI.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.mozilla.universalchardet.UniversalDetector;

/**
 * <h1>FileCharDetecter</h1>
 * テキストファイルの文字コードを取得します。<br>
 * 文字コードが取得できない(例 文字が全て共通コード(英語)のみ)場合はUTF-8が返されます。
 * @author Raiti
 * @version 1.0.0
 *
 */
public class FileCharDetecter {
	private String path;
	
	/**
	 * <B>コンストラクター</B><br>
	 * @param path コードを取得するファイルパス
	 */
	public FileCharDetecter(String path) {
		this.path = path;
	}
	
	/**
	 * <h1>detector</h1>
	 * 文字コードを取得します<br>
	 * @return 文字コード
	 * @throws IOException 入出力エラーが発生した場合。 
	 */
	public String detector() throws IOException {
		byte[] buf = new byte[4096];
		String filePath = this.path;
		FileInputStream fileIn = new FileInputStream(filePath);
		FileInputStream filesub = new FileInputStream(filePath);

		byte[] bom = new byte[3];
		fileIn.read(bom, 0, 3);
		if ((bom[0] != -17) || (bom[1] != -69) || (bom[2] != -65)) {
			fileIn.close();
			fileIn = filesub;
		}else {
			filesub.close();
		}
		UniversalDetector detector = new UniversalDetector(null);
		int nread;
		while (((nread = fileIn.read(buf)) > 0) && (!detector.isDone())) {
			detector.handleData(buf, 0, nread);
		}
		detector.dataEnd();

		String encTyle = detector.getDetectedCharset();
		if (encTyle != null) {
			System.out.println("@System:文字コード:" + encTyle);
		} else {
			System.err.println("文字コードが判別できませんでした");
		}
		fileIn.close();
		filesub.close();
		fileIn = null;
		filesub = null;
		detector.reset();
		if (encTyle == null) {
			return "UTF-8";
		}
		return encTyle;
	}
}
