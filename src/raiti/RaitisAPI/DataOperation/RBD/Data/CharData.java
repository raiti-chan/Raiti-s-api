/*
 * 
 */
package raiti.RaitisAPI.DataOperation.RBD.Data;

import raiti.RaitisAPI.util.ByteUtility;

/** <h1>CherData</h1>
 * Char型データをサポートします<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class CharData extends NFDBase<Character> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = CHAR;
	
	//-------------------------------------コンストラクター
	/**
	 * <B>コンストラクター</B><br>
	 * Char型データを新しく生成します
	 * @param name データ名
	 * @param data データ
	 */
	public CharData(String name,char data) {
		super(name,data);
	}
	
	/**<h1>toString</h1>
	 * オーバーライド
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String text = this.getName()+" : 3(Integer) : "+this.data.charValue();
		return text;
	}

	/**<h1>getFormat</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#getFormat()
	 */
	@Override
	public int getFormat() {
		return FORMAT;
	}

	/**<h1>DataToByte</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#DataToByte()
	 */
	@Override
	public byte[] DataToByte() {
		return ByteUtility.CharToByte(data);
	}

	/**<h1>getDataSize</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFDBase#getDataSize()
	 */
	@Override
	public int getDataSize() {
		return ByteUtility.CHARSIZE;
	}
}
