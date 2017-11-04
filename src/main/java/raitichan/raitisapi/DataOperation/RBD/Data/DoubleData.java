package raitichan.raitisapi.DataOperation.RBD.Data;

import raitichan.raitisapi.util.ByteUtility;

/**
 * Double型データをサポートします<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public class DoubleData extends NFDBase<Double> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = DOUBLE;
	
	//-------------------------------------コンストラクター
	
	/**
	 * Double型データを新しく生成します
	 *
	 * @param name データ名
	 * @param data データ
	 */
	public DoubleData (String name, double data) {
		super(name, data);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {
		return this.getName() + " : 6(Double) : " + this.data;
	}
	
	/**
	 * オーバーライド
	 *
	 * @see NFD#getFormat()
	 */
	@Override
	public int getFormat () {
		return FORMAT;
	}
	
	/**
	 * オーバーライド
	 *
	 * @see NFD#dataToByte()
	 */
	@Override
	public byte[] dataToByte () {
		return ByteUtility.DoubleToByte(data);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see NFDBase#getDataSize()
	 */
	@Override
	public int getDataSize () {
		return ByteUtility.DOUBLE_SIZE;
	}
}
