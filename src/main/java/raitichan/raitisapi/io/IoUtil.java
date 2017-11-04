package raitichan.raitisapi.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * ファイル操作の便利メソッド群<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public class IoUtil {
	
	/**
	 * 未使用
	 */
	private IoUtil () {
	}
	
	/**
	 * UTF-8の文字コードのテキストファイルのBOMを消去します。<br>
	 *
	 * @param file BOMを消去するファイルパス
	 * @return 消去した{@link FileInputStream}
	 * @throws IOException 入出力エラーが発生した場合。
	 */
	@SuppressWarnings("unused")
	public static FileInputStream removeBOM (String file) throws IOException {
		byte[] bom = new byte[3];
		try (FileInputStream in = new FileInputStream(file);
			 FileInputStream sub = new FileInputStream(file)) {
			if (in.read(bom, 0, 3) < 3) {
				in.close();
				return sub;
			}
			if ((bom[0] != -17) || (bom[1] != -69) || (bom[2] != -65)) {
				in.close();
				return sub;
			}
			sub.close();
			return in;
		}
		
	}
	
	
}
