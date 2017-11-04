package raitichan.raitisapi.DataOperation.RBD.Data;

import raitichan.raitisapi.util.ByteUtility;

/**
 * Char型データをサポートします<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public class CharData extends NFDBase<Character> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = CHAR;
	
	//-------------------------------------コンストラクター
	
	/**
	 * Char型データを新しく生成します
	 *
	 * @param name データ名
	 * @param data データ
	 */
	public CharData (String name, char data) {
		super(name, data);
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
		return ByteUtility.CharToByte(data);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see NFDBase#getDataSize()
	 */
	@Override
	public int getDataSize () {
		return ByteUtility.CHAR_SIZE;
	}
}
