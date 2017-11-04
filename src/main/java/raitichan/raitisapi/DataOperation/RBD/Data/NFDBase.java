package raitichan.raitisapi.DataOperation.RBD.Data;

import raitichan.raitisapi.arrays.ArraysUtility;
import raitichan.raitisapi.util.ByteUtility;

/**
 * <br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public abstract class NFDBase<T> implements NFD<T> {
	
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
	 * データを生成します
	 *
	 * @param name データ名
	 */
	@SuppressWarnings("unused")
	public NFDBase (String name) {
		this.name = name;
	}
	
	/**
	 * 初期データを格納してデータを生成します。
	 *
	 * @param name データ名
	 * @param data 格納データ
	 */
	public NFDBase (String name, T data) {
		this.data = data;
		this.name = name;
		dataSizeUpData();
	}
	
	/**
	 * オーバーライド
	 *
	 * @see NFD#getData()
	 */
	@Override
	public T getData () {
		return data;
	}
	
	/**
	 * オーバーライド
	 *
	 * @throws ClassCastException 格納データとNFDデータのフォーマットが一致していない場合にスローされます
	 * @see NFD#setData(java.lang.Object)
	 */
	@Override
	public T setData (T data) {
		T Provisional = this.data;
		this.data = data;
		dataSizeUpData();
		return Provisional;
	}
	
	/**
	 * オーバーライド
	 *
	 * @see NFD#setDataO(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object setDataO (Object data) {
		Object Provisional = this.data;
		this.data = (T) data;
		return Provisional;
	}
	
	/**
	 * オーバーライド。
	 * falseを返します。
	 *
	 * @see NFD#isGroup()
	 */
	@Override
	public boolean isGroup () {
		return false;
	}
	
	/**
	 * オーバーライド
	 *
	 * @see NFD#getName()
	 */
	@Override
	public String getName () {
		return name;
	}
	
	/**
	 * オーバーライド
	 */
	@Override
	public String setName (String name) {
		String buffer = this.name;
		this.name = name;
		dataSizeUpData();
		return buffer;
	}
	
	/**
	 * オーバーライド
	 *
	 * @see NFD#byteSize()
	 */
	@Override
	public int byteSize () {
		return size;
	}
	
	/**
	 * データのサイズを取得します<br>
	 *
	 * @return データサイズ
	 */
	public abstract int getDataSize ();
	
	/**
	 * オーバーライド
	 *
	 * @see NFD#nameToByte()
	 */
	@Override
	public byte[] nameToByte () {
		return ByteUtility.StringToByte(name);
	}
	
	/**
	 * オーバーライド
	 *
	 * @see NFD#dataSizeUpData()
	 */
	@Override
	public void dataSizeUpData () {
		int size = nameToByte().length;
		size += DELIMITED_MARK_SIZE + 4 + 4 + dataToByte().length;
		this.size = size;
	}
	
	/**
	 * オーバーライド
	 */
	@Override
	public void stringOutput (String Header) {
		System.out.println(Header + this.toString());
	}
	
	/**
	 * オーバーライド
	 */
	@SuppressWarnings("Duplicates")
	@Override
	public byte[] toByte () {
		byte[] name = nameToByte();
		byte[] format = ByteUtility.IntToByte(getFormat());
		byte[] data = dataToByte();
		byte[] sizeData = ByteUtility.IntToByte(data.length);
		
		this.size = name.length + DELIMITED_MARK_SIZE + format.length + 4 + data.length;
		
		return ArraysUtility.addAll(name, DELIMITED_MARK, format, sizeData, data);
	}
	
}
