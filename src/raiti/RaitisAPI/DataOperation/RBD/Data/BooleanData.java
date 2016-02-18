/*
 * 
 */
package raiti.RaitisAPI.DataOperation.RBD.Data;

import raiti.RaitisAPI.util.ByteUtility;

/** <h1>BooleanData</h1>
 * Boolean型データをサポートします<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class BooleanData extends NFDBase<Boolean> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = BOOLEAN;
	
	//-------------------------------------コンストラクター
	/**
	 * <B>コンストラクター</B><br>
	 * Boolean型データを新しく生成します
	 * @param name データ名
	 * @param data データ
	 */
	public BooleanData(String name,boolean data) {
		super(name,data);
	}
	
	/**<h1>toString</h1>
	 * オーバーライド
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String text = this.getName()+" : 7(Integer) : "+this.data.booleanValue();
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
		return ByteUtility.BooleanToByteArray(data);
	}

	/**<h1>getDataSize</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFDBase#getDataSize()
	 */
	@Override
	public int getDataSize() {
		return 1;
	}
}
