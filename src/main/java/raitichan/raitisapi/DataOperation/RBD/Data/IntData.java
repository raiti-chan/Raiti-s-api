package raitichan.raitisapi.DataOperation.RBD.Data;

import raitichan.raitisapi.util.ByteUtility;

/**
 * Int型データをサポートします<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public class IntData extends NFDBase<Integer> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = INT;
	
	
	//-------------------------------------コンストラクター
	
	/**
	 * Int型データを新しく生成します
	 *
	 * @param name データ名
	 * @param data データ
	 */
	public IntData (String name, Integer data) {
		super(name, data);
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {
		return this.getName() + " : 3(Integer) : " + this.data;
	}
	
	
	/**
	 * オーバーライド
	 *
	 * @see NFD#dataToByte()
	 */
	@Override
	public byte[] dataToByte () {
		return ByteUtility.IntToByte(data);
	}
	
	
	/**
	 * オーバーライド
	 *
	 * @see NFDBase#getDataSize()
	 */
	@Override
	public int getDataSize () {
		return ByteUtility.INT_SIZE;
	}
	
	
}
