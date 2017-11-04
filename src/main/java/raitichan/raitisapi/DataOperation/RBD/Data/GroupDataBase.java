package raitichan.raitisapi.DataOperation.RBD.Data;

import java.util.HashMap;

import raitichan.raitisapi.DataOperation.RBD.ArrayObjectOperation;
import raitichan.raitisapi.arrays.ArraysUtility;
import raitichan.raitisapi.util.ByteUtility;

/**
 * <h1>groupData</h1>
 * グループデータのベースクラスです。
 * グループデータは&lt;T&gt;のジェネリスクに自身のクラスを指定し、
 * {@link NFD#getData()}に自身のインスタンスを返すようにしてください<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public abstract class GroupDataBase<T> extends ArrayObjectOperation implements NFD<T> {
	
	/**
	 * データ名
	 */
	protected String name;
	/**
	 * このデータのバイトサイズ
	 */
	private int size = 0;
	
	//-------------------------------------コンストラクター
	
	/**
	 * <B>コンストラクター</B><br>
	 * データを生成します
	 *
	 * @param name データ名
	 */
	@SuppressWarnings("WeakerAccess")
	public GroupDataBase (String name) {
		super(new HashMap<>());
		this.name = name;
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * 配列をセットし、グループデータを生成します
	 *
	 * @param datas 設定するデータ配列
	 * @param name  データ名
	 */
	@SuppressWarnings("WeakerAccess")
	public GroupDataBase (String name, HashMap<String, NFD<?>> datas) {
		super(datas);
		this.name = name;
	}
	
	/**
	 * <h1>toByte</h1>
	 * オーバーライド
	 *
	 * @see NFD#toByte()
	 */
	@SuppressWarnings("Duplicates")
	@Override
	public byte[] toByte () {
		byte[] name = nameToByte();
		byte[] format = ByteUtility.IntToByte(getFormat());
		byte[] datas = dataToByte();
		byte[] sizeData = ByteUtility.IntToByte(datas.length);
		
		this.size = name.length + DELIMITED_MARK_SIZE + format.length + 4 + datas.length;
		
		return ArraysUtility.addAll(name, DELIMITED_MARK, format, sizeData, datas);
	}
	
	/**
	 * <h1>dataSizeUpData</h1>
	 * オーバーライド
	 *
	 * @see NFD#dataSizeUpData()
	 */
	@Override
	public void dataSizeUpData () {
		int size = nameToByte().length;
		size += DELIMITED_MARK_SIZE + 4 + 4 + byteSize();
		this.size = size;
	}
	
	/**
	 * <h1>isGroup</h1>
	 * オーバーライド
	 * trueを返します
	 *
	 * @see NFD#isGroup()
	 */
	@Override
	public boolean isGroup () {
		return true;
	}
	
	/**
	 * <h1>getName</h1>
	 * オーバーライド
	 *
	 * @see NFD#getName()
	 */
	@Override
	public String getName () {
		return name;
	}
	
	/**
	 * <h1>getDataSize</h1>
	 * このデータのバイトサイズを取得します<br>
	 *
	 * @return このデータのバイトサイズ
	 */
	public int getDataSize () {
		return size;
	}
	
	
	/**
	 * <h1>setName</h1>
	 * オーバーライド
	 *
	 * @see NFD#setName(java.lang.String)
	 */
	@Override
	public String setName (String name) {
		String buffer = this.name;
		this.name = name;
		return buffer;
	}
	
	/**
	 * <h1>nameToByte</h1>
	 * オーバーライド
	 *
	 * @see NFD#nameToByte()
	 */
	@Override
	public byte[] nameToByte () {
		return ByteUtility.StringToByte(name);
	}
	
}
