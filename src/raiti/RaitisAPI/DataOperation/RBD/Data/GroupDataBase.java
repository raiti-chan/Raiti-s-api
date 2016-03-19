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
		super(new HashMap<String,NFD<?>>());
		this.name = name;
	}
	
	/**<B>コンストラクター</B><br>
	 * 配列をセットし、グループデータを生成します
	 * @param datas 設定するデータ配列 
	 * @param name データ名
	 */
	public GroupDataBase(String name,HashMap<String, NFD<?>> datas) {
		super(datas);
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
		byte[] datas = DataToByte();
		byte[] sizedata = ByteUtility.IntToByte(datas.length);
		
		this.size = name.length + DELIMITEDMARKSIZE + format.length + 4 + datas.length;
		
		byte[] retDatas = ArraysUtility.addAll(name, DELIMITEDMARK, format,sizedata,datas);
		
		return retDatas;
	}
	
	/**<h1>DatasizeUpData</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#DatasizeUpData()
	 */
	@Override
	public void DatasizeUpData() {
		int size = NameToByte().length;
		size += DELIMITEDMARKSIZE + 4 + 4 + bytesize();
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
	
	/**
	 * <h1>getDataSize</h1>
	 * このデータのバイトサイズを取得します<br>
	 * @return このデータのバイトサイズ
	 */
	public int getDataSize() {
		return size;
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
