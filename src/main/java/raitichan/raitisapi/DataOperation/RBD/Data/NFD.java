package raitichan.raitisapi.DataOperation.RBD.Data;

import raitichan.raitisapi.DataOperation.RBD.ArrayObjectOperation;
import raitichan.raitisapi.util.ByteUtility;

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
	T getData ();
	
	/**
	 * <h1>setData</h1>
	 * データを格納します。<br>
	 * 既にデータがセットされていた場合は新しいデータに置き換わります。
	 * @param data 格納するデータ
	 * @return data データが置き換わった場合前に格納されていたデータが返されます。新しく格納した場合はnullが返ります。
	 */
	T setData (T data);
	
	/**
	 * <h1>setDataO</h1>
	 * データをオブジェクトとして格納します。<br>
	 * 既にデータがセットされていた場合は新しいデータに置き換わります。
	 * @param data 格納するデータ
	 * @return データが置き換わった場合前に格納されていたデータが返されます。新しく格納した場合はnullが返ります。
	 */
	Object setDataO (Object data);
	
	/**
	 * <h1>toString</h1>
	 * データを文字表記で現します。<br>
	 * データ名 : フォーマット : データ
	 * @return 文字表記のデータ
	 */
	@Override
	String toString ();
	
	/**
	 * <h1>toByte</h1>
	 * Byte形データに変換します。<br>
	 * @return byte配列に変換されたデータ
	 */
	byte[] toByte ();
	
	/**
	 * <h1>isGroup</h1>
	 * このデータがグループ型データかを取得します<br>
	 * @return グループデータの場合true。固体データの場合はfalseが返されます
	 */
	boolean isGroup ();
	
	/**
	 * <h1>getName</h1>
	 * このオブジェクトデータの固有名を取得します<br>
	 * @return このデータの固有名
	 */
	String getName ();
	
	/**
	 * <h1>setName</h1>
	 * このオブジェクトデータの固有名を設定します<br>
	 * このメソッドを利用してグループに保管されたオブジェクト名を変更した場合グループ登録名と一致しなくなります。
	 * 一致させた状態でリネームする場合は{@link ArrayObjectOperation}
	 * @param name 変更する名前
	 * @return 前に付けられていた名前
	 */
	String setName (String name);
	
	/**
	 * <h1>getFormat</h1>
	 * フォーマットを取得します。<br>
	 * @return 設定されているフォーマット
	 */
	int getFormat ();
	
	/**
	 * <h1>byteSize</h1>
	 * このデータのbyteサイズを取得します。<br>
	 * @return このデータをbyteにした際のデータサイズ
	 */
	int byteSize ();
	
	/**
	 * <h1>nameToByte</h1>
	 * このデータの持っている名前をbyteデータに変換します<br>
	 * @return 名前をbyteデータに変換したもの
	 */
	byte[] nameToByte ();
	
	/**
	 * <h1>dataToByte</h1>
	 * 保持データをbyte型に変換します。<br>
	 * @return 保持データをbyte型に変換した配列
	 */
	byte[] dataToByte ();
	
	/**
	 * <h1>DataUpData</h1>
	 * データのサイズをアップデートします<br>
	 */
	void dataSizeUpData ();
	
	/**
	 * <h1>stringOutput</h1>
	 * データを文字列として標準出力します。<br>
	 * @param Header 出力より前に入る文字列
	 */
	void stringOutput (String Header);
	
	//==================================================================================================================
	
	/**
	 * グループデータフォーマット値
	 */
	int GROUP_DATA = 0;
	
	/**
	 * byteデータフォーマット
	 */
	int BYTE = 1;
	
	/**
	 * shirtデータフォーマット
	 */
	int SHORT = 2;
	
	/**
	 * intデータフォーマット
	 */
	int INT = 3;
	
	/**
	 * longデータフォーマット
	 */
	int LONG = 4;
	
	/**
	 * floatデータフォーマット
	 */
	int FLOAT = 5;
	
	/**
	 * doubleデータフォーマット
	 */
	int DOUBLE = 6;
	
	/**
	 * booleanデータフォーマット
	 */
	int BOOLEAN = 7;
	
	/**
	 * charデータフォーマット
	 */
	int CHAR = 8;
	
	/**
	 * Stringデータフォーマット
	 */
	int STRING = 9;
	
	/**
	 * データの区切りしるし<br>
	 * Name:Format:Data;
	 * の:の部分
	 */
	byte[] DELIMITED_MARK = {0x00,0x2F,0x3A};
	
	/**
	 * データ区切りのしるしのサイズ
	 */
	int DELIMITED_MARK_SIZE = DELIMITED_MARK.length;
	
	/**
	 * 1つのNFDバイトデータをString形式に変換します<br>
	 * @param NFDData String形式に変換するデータ
	 * @return 文字列かされたデータ
	 */
	@SuppressWarnings("unused")
	static String NFDByteToString (byte[] NFDData) {
		int mark = 0;
		for(int i = 0 ,loop = NFDData.length; i < loop ; i++ ) {
			if(NFDData[i] == 0x00) {
				if(NFDData[i+1] == 0x2f) {
					if(NFDData[i+2] == 0x3A) {
						mark = i;
					}
				}
			}
		}
		
		byte[] name = new byte[mark];
		byte[] format = new byte[4];
		byte[] data = new byte[NFDData.length-(mark+ DELIMITED_MARK_SIZE +8)];
		
		System.arraycopy(NFDData, 0, name, 0, mark);
		System.arraycopy(NFDData, mark+ DELIMITED_MARK_SIZE, format, 0, 4);
		System.arraycopy(NFDData, mark+ DELIMITED_MARK_SIZE +4, data, 0, data.length);
		
		int formatInt = ByteUtility.ByteToInt(format);
		
		String dataString = new String(name);
		dataString += " : Format " + formatInt;
		dataString += ": Data " + dataToString(formatInt, data)+";";
		return dataString;
	}
	
	/**
	 * データをフォーマットに合わせた文字列に変換します。
	 * <br>
	 * @param format フォーマット
	 * @param data 変換するデータ
	 * @return Format#data形式のデータ文字列
	 */
	static String dataToString (int format, byte[] data) {
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
			//TODO:対象外のサポート
		}
		
		return null;
	}
	
}
