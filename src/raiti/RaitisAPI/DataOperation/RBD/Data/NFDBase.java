/**
 * 
 */
package raiti.RaitisAPI.DataOperation.RBD.Data;

import raiti.RaitisAPI.arrays.ArraysUtility;
import raiti.RaitisAPI.util.ByteUtility;

/** <h1>NFDBase</h1>
 * <br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public abstract class NFDBase <T> implements NFD<T>{
	
	/**
	 * 格納されているデータ
	 */
	protected T data;
	
	/**
	 * このデータのサイズ
	 */
	private int size;
	
	/**
	 * データ名
	 */
	private String name;
	
	//-------------------------------------コンストラクター
	/**
	 * <B>コンストラクター</B><br>
	 * データを生成します
	 */
	public NFDBase(String name) {
		this.name = name;
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * 初期データを格納してデータを生成します。
	 * @param data
	 */
	public NFDBase(String name,T data) {
		this.data = data;
		this.name = name;
		DatasizeUpData();
	}

	/**<h1>getData</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#getData()
	 */
	@Override
	public T getData() {
		return data;
	}

	/**<h1>setData</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#setData(java.lang.Object)
	 */
	@Override
	public T setData(T data) {
		T Provisional = this.data; 
		this.data = data;
		DatasizeUpData();
		return Provisional;
	}
	
	/**
	 * <h1>isGroup</h1>
	 * オーバーライド。
	 * falseを返します。
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#isGroup()
	 */
	@Override
	public boolean isGroup() {
		return false;
	};
	
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
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#setName()
	 */
	@Override
	public String setName(String name) {
		String buffer = this.name;
		this.name = name;
		DatasizeUpData();
		return buffer;
	}
	
	/**<h1>bytesize</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#bytesize()
	 */
	@Override
	public int bytesize() {
		return size;
	}
	
	/**
	 * <h1>getDataSize</h1>
	 * データのサイズを取得します<br>
	 * @return データサイズ
	 */
	public abstract int getDataSize();
	
	/**<h1>NameToByte</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#NameToByte()
	 */
	@Override
	public byte[] NameToByte() {
		return ByteUtility.StringToByte(name);
	}
	
	/**<h1>DatasizeUpData</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#DatasizeUpData()
	 */
	@Override
	public void DatasizeUpData() {
		int size = NameToByte().length;
		size += DELIMITEDMARKSIZE + 4 + 4 + DataToByte().length;
		this.size = size;
	}
	
	/**<h1>StringOutput</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#StringOutput()
	 */
	@Override
	public void StringOutput(String Header) {
		System.out.println(Header + this.toString());
	}
	
	/**<h1>toByte</h1>
	 * オーバーライド
	 * @see raiti.RaitisAPI.DataOperation.RBD.Data.NFD#toByte()
	 */
	@Override
	public byte[] toByte() {
		byte[] name = NameToByte();
		byte[] format = ByteUtility.IntToByte(getFormat());
		byte[] data = DataToByte();
		byte[] sizedata = ByteUtility.IntToByte(data.length);
		
		this.size = name.length + DELIMITEDMARKSIZE + format.length + 4 + data.length;
		
		byte[] datas = ArraysUtility.addAll(name, DELIMITEDMARK , format , sizedata , data);
		
		return datas;
	}
	
}
