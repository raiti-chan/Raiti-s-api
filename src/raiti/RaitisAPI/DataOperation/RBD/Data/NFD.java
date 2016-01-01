/*
 * 
 */
package raiti.RaitisAPI.DataOperation.RBD.Data;

import raiti.RaitisAPI.DataOperation.RBD.ArrayObjectOperation;
import raiti.RaitisAPI.util.ByteUtility;

/** <h1>NFD</h1>
 * RBDDataの大本となるインターフェイスです<br>
 * オブジェクトの実態は<br>
 * Name:Format:Datas;で構成されます。
 * @author Raiti
 * @version 1.0.0
 * 
 */
public interface NFD<T> {
	
	/**
	 * <h1>getData</h1>
	 * 保持しているデータを取得します<br>
	 * @return 保持しているデータ
	 */
	public T getData();
	
	/**
	 * <h1>setData</h1>
	 * データを格納します。<br>
	 * 既にデータがセットされていた場合は新しいデータに置き換わります。
	 * @param data 格納するデータ
	 * @return data データが置き換わった場合前に格納されていたデータが返されます。新しく格納した場合はnullが返ります。
	 */
	public T setData(T data);
	
	/**
	 * <h1>toString</h1>
	 * データを文字表記で現します。<br>
	 * データ名 : フォーマット : データ
	 * @return 文字表記のデータ
	 */
	@Override
	public String toString();
	
	/**
	 * <h1>toByte</h1>
	 * Byte形データに変換します。<br>
	 * @return byte配列に変換されたデータ
	 */
	public byte[] toByte();
	
	/**
	 * <h1>isGroup</h1>
	 * このデータがグループ型データかを取得します<br>
	 * @return グループデータの場合true。固体データの場合はfalseが返されます
	 */
	public boolean isGroup();
	
	/**
	 * <h1>getName</h1>
	 * このオブジェクトデータの固有名を取得します<br>
	 * @return このデータの固有名
	 */
	public String getName();
	
	/**
	 * <h1>setName</h1>
	 * このオブジェクトデータの固有名を設定します<br>
	 * このメソッドを利用してグループに保管されたオブジェクト名を変更した場合グループ登録名と一致しなくなります。
	 * 一致させた状態でリネームする場合は{@link ArrayObjectOperation}
	 * @return 前に付けられていた名前
	 */
	public String setName(String name);
	
	/**
	 * <h1>getFormat</h1>
	 * フォーマットを取得します。<br>
	 * @return 設定されているフォーマット
	 */
	public int getFormat();
	
	/**
	 * <h1>bytesize</h1>
	 * このデータのbyteサイズを取得します。<br>
	 * @return このデータをbyteにした際のデータサイズ
	 */
	public int bytesize();
	
	/**
	 * <h1>NameToByte</h1>
	 * このデータの持っている名前をbyteデータに変換します<br>
	 * @return 名前をbyteデータに変換したもの
	 */
	public byte[] NameToByte();
	
	/**
	 * <h1>dataToByte</h1>
	 * 保持データをbyte型に変換します。<br>
	 * @return 保持データをbyte型に変換した配列
	 */
	public byte[] DataToByte();
	
	/**
	 * <h1>DataUpData</h1>
	 * データのサイズをアップデートします<br>
	 */
	public void DatasizeUpData();
	
	//==================================================================================================================
	
	/**
	 * グループデータフォーマット値
	 */
	public static final int GROUPDATA = 0;
	
	/**
	 * byteデータフォーマット
	 */
	public static final int BYTE = 1;
	
	/**
	 * shirtデータフォーマット
	 */
	public static final int SHORT = 2;
	
	/**
	 * intデータフォーマット
	 */
	public static final int INT = 3;
	
	/**
	 * longデータフォーマット
	 */
	public static final int LONG = 4;
	
	/**
	 * floatデータフォーマット
	 */
	public static final int FLOAT = 5;
	
	/**
	 * doubleデータフォーマット
	 */
	public static final int DOUBLE = 6;
	
	/**
	 * booleanデータフォーマット
	 */
	public static final int BOOLEAN = 7;
	
	/**
	 * charデータフォーマット
	 */
	public static final int CHAR = 8;
	
	/**
	 * Stringデータフォーマット
	 */
	public static final int STRING = 9;
	
	/**
	 * データの区切りしるし<br>
	 * Name:Format:Data;
	 * の:の部分
	 */
	public static final byte[] DELIMITEDMARK = {0x00,0x2F,0x3A};
	
	/**
	 * データ区切りのしるしのサイズ
	 */
	public static final int DELIMITEDMARKSIZE = DELIMITEDMARK.length;
	
	/**
	 * NFDデータの終端部分のしるし<br>
	 * Name:Format:Data;
	 * の;の部分
	 */
	public static final byte[] FINISHMARK = {0x00,0x3B,-0x7F,-0x09};
	
	/**
	 * データ終端部分のしるしのサイズ
	 */
	public static final int FINISHMARKSIZE = FINISHMARK.length;
	
	/**
	 * <h1>NFDByteToString</h1>
	 * 1つのNFDバイトデータをString形式に変換します<br>
	 * @param NFDdata String形式に変換するデータ
	 * @return 文字列かされたデータ
	 */
	public static String NFDByteToString(byte[] NFDdata) {
		int mark = 0;
		for(int i = 0 ,loop = NFDdata.length; i < loop ; i++ ) {
			if(NFDdata[i] == 0x00) {
				if(NFDdata[i+1] == 0x2f) {
					if(NFDdata[i+2] == 0x3A) {
						mark = i;
					};
				}
			}
		}
		
		byte[] name = new byte[mark];
		byte[] format = new byte[4];
		byte[] data = new byte[NFDdata.length-(mark+DELIMITEDMARKSIZE+8)];
		
		System.arraycopy(NFDdata, 0, name, 0, mark);
		System.arraycopy(NFDdata, mark+DELIMITEDMARKSIZE, format, 0, 4);
		System.arraycopy(NFDdata, mark+DELIMITEDMARKSIZE+4, data, 0, data.length);
		
		int formatint = ByteUtility.ByteToInt(format);
		
		String dataString = new String(name);
		dataString += " : Format " + formatint;
		dataString += ": Data " + dataTotring(formatint, data)+";";
		return dataString;
	}
	
	/**
	 * <h1>dataTotring</h1>
	 * データをフォーマットに合わせた文字列に変換します。
	 * <br>
	 * @param format フォーマット
	 * @param data 変換するデータ
	 * @return Format#data形式のデータ文字列
	 */
	public static String dataTotring(int format,byte[] data) {
		switch (format) {
		//------------------------------------------------------groupData
		case 0:
			
			break;
		//------------------------------------------------------byteData
		case 1:
			return "byte#"+data[0];
		//------------------------------------------------------shortData
		case 2:
			return "short#"+ByteUtility.ByteToShort(data);
		//------------------------------------------------------intData
		case 3:
			return "int#"+ByteUtility.ByteToInt(data);
		//------------------------------------------------------longData
		case 4:
			return "long#"+ByteUtility.ByteToLong(data);
		//------------------------------------------------------floatData
		case 5:
			return "float#"+ByteUtility.ByteToFloat(data);
		//------------------------------------------------------doubleData
		case 6:
			return "double#"+ByteUtility.ByteToDouble(data);
		//------------------------------------------------------boolean
		case 7:
			return "boolean#"+ByteUtility.ByteToBoolean(data);
		//------------------------------------------------------char
		case 8:
			return "char#"+ByteUtility.ByteToChar(data);
		//------------------------------------------------------String
		case 9:
			return "String#"+ByteUtility.ByteToString(data);
		//------------------------------------------------------対象外
		default:
			//TODO 対象外のサポート
		}
		
		return null;
	}
	
}
