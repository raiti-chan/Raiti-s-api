package raitichan.raitisapi.DataOperation.RBD.Data;

import java.util.HashMap;

/**
 * データのグループ化をサポートします<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
@SuppressWarnings("unused")
public class groupData extends GroupDataBase<HashMap<String, NFD<?>>> {
	
	/**
	 * このデータのフォーマット
	 */
	public static final int FORMAT = GROUP_DATA;
	
	//-------------------------------------コンストラクター
	
	/**
	 * 新しいグループデータを作成します
	 *
	 * @param name  データ名
	 * @param datas 格納データ
	 */
	@SuppressWarnings("unused")
	public groupData (String name, HashMap<String, NFD<?>> datas) {
		super(name, datas);
	}
	
	/**
	 * 新しいグループデータを作成します
	 *
	 * @param name データ名
	 */
	@SuppressWarnings("unused")
	public groupData (String name) {
		super(name);
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
	 * このデータのbyteサイズを取得します。<br>
	 *
	 * @return このデータをbyteにした際のデータサイズ
	 */
	@Override
	public int byteSize () {
		return 0;
	}
	
	/**
	 * オーバーライド
	 *
	 * @see NFD#dataToByte()
	 */
	@Override
	public byte[] dataToByte () {
		return toByte();
	}
	
	
	/**
	 * オーバーライド
	 *
	 * @see NFD#stringOutput(java.lang.String)
	 */
	@Override
	public void stringOutput (String Header) {
		System.out.println(Header + toString());
		NFD<?>[] datas = getAll();
		for (NFD<?> data : datas) {
			if (data != null) {
				data.stringOutput(Header + " ");
			}
		}
	}
	
	/**
	 * オーバーライド
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {
		return this.getName() + " : 0(Group) : " + this.byteSize + " Byte : " + this.map.size() + " Data";
	}
	
	
	/**
	 * オーバーライド<br>
	 * このグループのマップが返されます
	 *
	 * @see NFD#getData()
	 */
	@Override
	public HashMap<String, NFD<?>> getData () {
		return map;
	}
	
	
	/**
	 * オーバーライド
	 *
	 * @see NFD#setData(java.lang.Object)
	 */
	@Override
	public HashMap<String, NFD<?>> setData (HashMap<String, NFD<?>> data) {
		HashMap<String, NFD<?>> oldData = map;
		map = data;
		return oldData;
	}
	
	/**
	 * オーバーライド
	 *
	 * @throws ClassCastException 格納データがHashMap&lt;String,NFD&lt;?&gt;&gt;にキャストできない場合にスローされます
	 * @see NFD#setDataO(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object setDataO (Object data) {
		HashMap<String, NFD<?>> oldData = map;
		map = (HashMap<String, NFD<?>>) data;
		return oldData;
	}
	
}
