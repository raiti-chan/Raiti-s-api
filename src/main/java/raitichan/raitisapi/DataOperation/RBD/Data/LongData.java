package raitichan.raitisapi.DataOperation.RBD.Data;

import raitichan.raitisapi.util.ByteUtility;

/**
 * Long型データのサポート<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public class LongData extends NFDBase<Long> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = LONG;
	
	//-------------------------------------コンストラクター
	
	/**
	 * Long型データを新しく生成します
	 *
	 * @param name データ名
	 * @param data 格納するデータ
	 */
	public LongData (String name, long data) {
		super(name, data);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {
		return this.getName() + " : 4(Long) : " + this.data;
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
		return ByteUtility.LongToByte(data);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see NFDBase#getDataSize()
	 */
	@Override
	public int getDataSize () {
		return ByteUtility.LONG_SIZE;
	}
	
}
