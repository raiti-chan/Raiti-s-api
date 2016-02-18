/*
 * 
 */
package raiti.RaitisAPI.DataOperation.RBD.Data;


/** <h1>ByteData</h1>
 * Byte型データをサポートします<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class ByteData extends NFDBase<Byte> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final  int FORMAT = BYTE;
	
	//-------------------------------------コンストラクター
	/**
	 * <B>コンストラクター</B><br>
	 * Byte型データを新しく生成します
	 * @param name データ名
	 * @param data データ
	 */
	public ByteData(String name, byte data) {
		super(name, data);
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
		byte[] datas = {data};
		return datas;
	}

	/**<h1>getDataSize</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFDBase#getDataSize()
	 */
	@Override
	public int getDataSize() {
		return 1;
	}
	
	/**<h1>toString</h1>
	 * オーバーライド
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String text = this.getName()+" : 1(Byte) : "+data;
		return text;
	}
	
}
