package raitichan.raitisapi.DataOperation.RBD.Data;

import raitichan.raitisapi.util.ByteUtility;

/**
 * Float型データをサポートします<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
@SuppressWarnings("unused")
public class FloatData extends NFDBase<Float> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = FLOAT;
	
	//-------------------------------------コンストラクター
	
	/**
	 * Float型データを新しく生成します。
	 *
	 * @param name データ名
	 * @param data データ
	 */
	public FloatData (String name, float data) {
		super(name, data);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {
		return this.getName() + " : 5(Float) : " + this.data;
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
		return ByteUtility.FloatToByte(data);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see NFDBase#getDataSize()
	 */
	@Override
	public int getDataSize () {
		return ByteUtility.FLOAT_SIZE;
	}
}
