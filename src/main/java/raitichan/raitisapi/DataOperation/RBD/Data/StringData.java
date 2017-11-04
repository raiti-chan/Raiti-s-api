package raitichan.raitisapi.DataOperation.RBD.Data;

import raitichan.raitisapi.util.ByteUtility;

/**
 * String型データのサポート<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public class StringData extends NFDBase<String> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = STRING;
	
	//-------------------------------------コンストラクター
	
	/**
	 * String型データを新しく生成します
	 *
	 * @param name データ名
	 * @param Data データ
	 */
	public StringData (String name, String Data) {
		super(name, Data);
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
		return this.getName() + " : 9(String) : " + data;
	}
	
	/**
	 * オーバーライド
	 *
	 * @see NFD#dataToByte()
	 */
	@Override
	public byte[] dataToByte () {
		return ByteUtility.StringToByte(data);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see NFDBase#getDataSize()
	 */
	@Override
	public int getDataSize () {
		
		return dataToByte().length;
	}
	
	
}
