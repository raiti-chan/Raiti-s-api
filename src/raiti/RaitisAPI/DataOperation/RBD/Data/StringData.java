/*
 * 
 */
package raiti.RaitisAPI.DataOperation.RBD.Data;

import raiti.RaitisAPI.util.ByteUtility;

/** <h1>StringData</h1>
 * String型データのサポート<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class StringData extends NFDBase<String> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = STRING;
	
	//-------------------------------------コンストラクター
	/**
	 * <B>コンストラクター</B><br>
	 * String型データを新しく生成します
	 * @param name データ名
	 * @param Data データ
	 */
	public StringData(String name,String Data) {
		super(name,Data);
	}

	/**<h1>getFormat</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#getFormat()
	 */
	@Override
	public int getFormat() {
		return FORMAT;
	}
	
	/**<h1>toString</h1>
	 * オーバーライド
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String text = this.getName()+" : 9(String) : "+data;
		return text;
	}

	/**<h1>DataToByte</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#DataToByte()
	 */
	@Override
	public byte[] DataToByte() {
		return ByteUtility.StringToByte(data);
	}

	/**<h1>getDataSize</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFDBase#getDataSize()
	 */
	@Override
	public int getDataSize() {
		
		return DataToByte().length;
	}


}
