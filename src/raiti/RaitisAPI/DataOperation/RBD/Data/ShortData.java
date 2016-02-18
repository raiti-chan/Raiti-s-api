/*
 * 
 */
package raiti.RaitisAPI.DataOperation.RBD.Data;

import raiti.RaitisAPI.util.ByteUtility;

/** <h1>ShoryData</h1>
 * Short型データをサポートします<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class ShortData extends NFDBase<Short> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = SHORT;
	
	//-------------------------------------コンストラクター
	/**
	 * <B>コンストラクター</B><br>
	 * Shortデータを新しく生成します
	 * @param name データ名
	 * @param data データ
	 */
	public ShortData(String name,short data) {
		super(name, data);
	}
	
	/**<h1>toString</h1>
	 * オーバーライド
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String text = this.getName()+" : 2(Short) : "+this.data.shortValue();
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
		return ByteUtility.ShortToByte(data);
	}

	/**<h1>getDataSize</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFDBase#getDataSize()
	 */
	@Override
	public int getDataSize() {
		return ByteUtility.SHORTSIZE;
	}
}
