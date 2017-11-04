package raitichan.raitisapi.DataOperation.RBD.Data;

import raitichan.raitisapi.util.ByteUtility;

/**
 * Boolean型データをサポートします<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public class BooleanData extends NFDBase<Boolean> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = BOOLEAN;
	
	//-------------------------------------コンストラクター
	
	/**
	 * Boolean型データを新しく生成します
	 *
	 * @param name データ名
	 * @param data データ
	 */
	public BooleanData (String name, boolean data) {
		super(name, data);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {
		return this.getName() + " : 7(Integer) : " + this.data;
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
		return ByteUtility.BooleanToByteArray(data);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see NFDBase#getDataSize()
	 */
	@Override
	public int getDataSize () {
		return 1;
	}
}
