/*
 * 
 */
package raiti.RaitisAPI.DataOperation.RBD.Data;

import raiti.RaitisAPI.util.ByteUtility;

/** <h1>FloatData</h1>
 * Float型データをサポートします<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class FloatData extends NFDBase<Float> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = FLOAT;
	
	//-------------------------------------コンストラクター
	/**
	 * <B>コンストラクター</B><br>
	 * Float型データを新しく生成します。
	 * @param name データ名
	 * @param data データ
	 */
	public FloatData(String name,float data) {
		super(name,data);
	}
	
	/**<h1>toString</h1>
	 * オーバーライド
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String text = this.getName()+" : 5(Float) : "+this.data.floatValue();
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
		return ByteUtility.FloatToByte(data);
	}

	/**<h1>getDataSize</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFDBase#getDataSize()
	 */
	@Override
	public int getDataSize() {
		return ByteUtility.FLOATSIZE;
	}
}
