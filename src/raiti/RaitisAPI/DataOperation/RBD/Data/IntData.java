/*
 * 
 */
package raiti.RaitisAPI.DataOperation.RBD.Data;

import raiti.RaitisAPI.util.ByteUtility;

/** <h1>IntData</h1>
 * Int型データをサポートします<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class IntData extends NFDBase<Integer>{
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = INT;
	
	
	//-------------------------------------コンストラクター

	/**<B>コンストラクター</B><br>
	 * Int型データを新しく生成します
	 * @param name データ名
	 * @param data データ
	 */
	public IntData(String name,Integer data) {
		super(name,data);
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
		String text = this.getName()+" : 3(Integer) : "+this.data.intValue();
		return text;
	}


	
	/**<h1>dataToByte</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#DataToByte()
	 */
	@Override
	public byte[] DataToByte() {
		return ByteUtility.IntToByte(data.intValue());
	}


	
	/**<h1>getDataSize</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFDBase#getDataSize()
	 */
	@Override
	public int getDataSize() {
		return ByteUtility.INTSIZE;
	}
	

	
	

}
