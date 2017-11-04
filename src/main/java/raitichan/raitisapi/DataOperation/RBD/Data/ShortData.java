package raitichan.raitisapi.DataOperation.RBD.Data;

import raitichan.raitisapi.util.ByteUtility;

/**
 * Short型データをサポートします<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public class ShortData extends NFDBase<Short> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = SHORT;
	
	//-------------------------------------コンストラクター
	
	/**
	 * Shortデータを新しく生成します
	 *
	 * @param name データ名
	 * @param data データ
	 */
	public ShortData (String name, short data) {
		super(name, data);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {
		return this.getName() + " : 2(Short) : " + this.data;
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
		return ByteUtility.ShortToByte(data);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see NFDBase#getDataSize()
	 */
	@Override
	public int getDataSize () {
		return ByteUtility.SHORT_SIZE;
	}
}
