/*
 * 
 */
package raiti.RaitisAPI.DataOperation.RBD.Data;

import java.util.HashMap;

/** <h1>GroupData</h1>
 * データのグループ化をサポートします<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class GroupData extends GroupDataBase<HashMap<String, NFD<?>>> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = GROUPDATA;
	
	//-------------------------------------コンストラクター
	/**
	 * <B>コンストラクター</B><br>
	 * 新しいグループデータを作成します
	 * @param name データ名
	 * @param datas 格納データ
	 */
	public GroupData(String name,HashMap<String, NFD<?>> datas) {
		super(name,datas);
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * 新しいグループデータを作成します
	 * @param name データ名
	 */
	public GroupData(String name) {
		super(name);
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
		return ToByte();
	}
	

	/**<h1>StringOutput</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#StringOutput(java.lang.String)
	 */
	@Override
	public void StringOutput(String Header) {
		System.out.println(Header+toString());
		NFD<?>[] datas = getAll();
		for(NFD<?> data : datas) {
			if(data != null) {
				data.StringOutput(Header+" ");
			}
		}
	}
	
	/**<h1>toString</h1>
	 * オーバーライド
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String text =this.getName()+" : 0(Group) : "+ 
						this.bytesize +" Byte : " +this.map.size()+" Data";
		return text;
	}
	

	/**<h1>getData</h1>
	 * オーバーライド<br>
	 * このグループのマップが返されます
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#getData()
	 */
	@Override
	public HashMap<String, NFD<?>> getData() {
		return map;
	}
	

	/**<h1>setData</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#setData(java.lang.Object)
	 */
	@Override
	public HashMap<String, NFD<?>> setData(HashMap<String, NFD<?>> data) {
		HashMap<String, NFD<?>> olddata = map;
		map = data;
		return olddata;
	}
	
	/**<h1>setDataO</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#setDataO(java.lang.Object)
	 * @throws ClassCastException 格納データがHashMap&lt;String,NFD&lt;?&gt;&gt;にキャストできない場合にスローされます
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object setDataO(Object data) {
		HashMap<String, NFD<?>> olddata = map;
		map = (HashMap<String, NFD<?>>) data;
		return olddata;
	}
	
}
