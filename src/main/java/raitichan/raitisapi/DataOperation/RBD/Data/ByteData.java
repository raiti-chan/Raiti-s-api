package raitichan.raitisapi.DataOperation.RBD.Data;


/**
 * Byte型データをサポートします<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public class ByteData extends NFDBase<Byte> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = BYTE;
	
	//-------------------------------------コンストラクター
	
	/**
	 * Byte型データを新しく生成します
	 *
	 * @param name データ名
	 * @param data データ
	 */
	public ByteData (String name, byte data) {
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
	 * @see NFD#dataToByte()
	 */
	@Override
	public byte[] dataToByte () {
		return new byte[]{data};
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
	
	/**
	 * オーバーライド
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {
		return this.getName() + " : 1(Byte) : " + data;
	}
	
}
