/**
 * 
 */
package raiti.RaitisAPI.DataOperation.RBD.Data;

import java.util.HashMap;

import raiti.RaitisAPI.DataOperation.RBD.ArrayObjectOperation;
import raiti.RaitisAPI.arrays.ArraysUtility;
import raiti.RaitisAPI.util.ByteUtility;

/** <h1>GroupData</h1>
 * グループデータのベースクラスです。
 * グループデータは&lt;T&gt;のジェネリスクに自身のクラスを指定し、
 * {@link NFD#getData()}に自身のインスタンスを返すようにしてください<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public abstract class GroupDataBase<T> extends ArrayObjectOperation implements NFD<T>{
	
	/**
	 * このデータのバイトサイズ
	 */
	private int size = 0;
	
	/**
	 * データ名
	 */
	protected String name;
	
	//-------------------------------------コンストラクター
	
	/**
	 * <B>コンストラクター</B><br>
	 * データを生成します
	 * @param name データ名
	 */
	public GroupDataBase(String name) {
		this.map = new HashMap<String,NFD<?>>();
		this.name = name;
	}
	
	/**<B>コンストラクター</B><br>
	 * 配列をセットし、グループデータを生成します
	 * @param datas 設定するデータ配列 
	 * @param name データ名
	 */
	public GroupDataBase(String name,HashMap<String, NFD<?>> datas) {
		this.map = datas;
		this.name = name;
	}
	
	/**<h1>toByte</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#toByte()
	 */
	@Override
	public byte[] toByte() {
		byte[] name = NameToByte();
		byte[] format = ByteUtility.IntToByte(getFormat());
		byte[] data = ByteUtility.IntToByte(size);
		byte[] datas = DataToByte();
		
		this.size = name.length + DELIMITEDMARKSIZE + format.length + data.length + datas.length + FINISHMARKSIZE;
		
		byte[] retDatas = ArraysUtility.addAll(name, DELIMITEDMARK, format,data,datas,FINISHMARK);
		
		return retDatas;
	}
	
	/**<h1>DatasizeUpData</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#DatasizeUpData()
	 */
	@Override
	public void DatasizeUpData() {
		int size = NameToByte().length;
		size += DELIMITEDMARKSIZE + 4 + 4 + bytesize() + FINISHMARKSIZE;
		this.size = size;
	}

	/**<h1>isGroup</h1>
	 * オーバーライド
	 * trueを返します
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#isGroup()
	 */
	@Override
	public boolean isGroup() {
		return true;
	}

	/**<h1>getName</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	

	
	/**<h1>setName</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#setName(java.lang.String)
	 */
	@Override
	public String setName(String name) {
		String buffer = this.name;
		this.name = name;
		return buffer;
	}
	
	/**<h1>NameToByte</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#NameToByte()
	 */
	@Override
	public byte[] NameToByte() {
		return ByteUtility.StringToByte(name);
	}
	
}
