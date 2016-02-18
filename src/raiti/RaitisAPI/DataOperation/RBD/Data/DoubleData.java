/*
 * 
 */
package raiti.RaitisAPI.DataOperation.RBD.Data;

import raiti.RaitisAPI.util.ByteUtility;

/** <h1>DoubleData</h1>
 * Double型データをサポートします<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class DoubleData extends NFDBase<Double> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = DOUBLE;
	
	//-------------------------------------コンストラクター
	/**
	 * <B>コンストラクター</B><br>
	 * Double型データを新しく生成します
	 * @param name データ名
	 * @param data データ
	 */
	public DoubleData(String name,double data) {
		super(name,data);
	}
	
	/**<h1>toString</h1>
	 * オーバーライド
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String text = this.getName()+" : 6(Double) : "+this.data.doubleValue();
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
		return ByteUtility.DoubleToByte(data);
	}

	/**<h1>getDataSize</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFDBase#getDataSize()
	 */
	@Override
	public int getDataSize() {
		return ByteUtility.DOUBLESIZE;
	}
}
