package raiti.RaitisAPI.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/** <h1>ByteUtility</h1>
 * Byte型整数をほかのプリミティブ型へ相互変換<br>
 * 及びbyte配列操作を楽にする
 * メソッド群です。<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class ByteUtility {
	
	/**
	 * <B>コンストラクター</B><br>
	 * 使用しません。
	 */
	private ByteUtility() {}
	
	//==================================================================================================================
	//------------------------------------------------------boolean
	/**
	 * trueの場合のbyteデータ値
	 */
	public static final byte TRUE = 1;
	
	/**
	 * falseの場合のbyteデータ値
	 */
	public static final byte FALSE = 0;
	
	/**
	 * <h1>BooleanToByte</h1>
	 * boolean型論理値をbyteに変換します。<br>
	 * @param value 変換するboolean型論理値
	 * @return 変換されたbyte数値
	 */
	public static byte BooleanToByte(Boolean value) {
		return value ? TRUE : FALSE;
	}
	
	/**
	 * <h1>ByteToBoolean</h1>
	 * Byte型数値をboolean型論理値に変換します。<br>
	 * @param data 変換するbyte値
	 * @return 変換されたboolean型論理値
	 */
	public static boolean ByteToBoolean(byte data) {
		return data == TRUE ? true : false;
	}
	
	/**
	 * <h1>ByteToBoolean</h1>
	 * {@link #ByteToBoolean(byte)}をbyte配列に対応させた物です。<br>
	 * byte配列の0番目の値を使用します。
	 * @param data 変換するbyte配列
	 * @return 変換されたboolean型論理値
	 */
	public static boolean ByteToBoolean(byte[] data) {
		return data[0] == TRUE ? true : false;
	}
	
	/**
	 * <h1>BooleanToByteArray</h1>
	 * {@link #BooleanToByte(Boolean)}の戻り値をsize1のbyte配列にした物です。<br>
	 * @param value 変換するboolean型論理値
	 * @return 変換されたbyte配列
	 */
	public static byte[] BooleanToByteArray(Boolean value) {
		byte[] bytes = {value ? TRUE : FALSE};
		return bytes;
	}
	
	//==================================================================================================================
	//------------------------------------------------------short
	/**
	 * shortをbyteへ変換する際のbyteサイズ
	 */
	public static final int SHORTSIZE = Short.SIZE / Byte.SIZE;
	
	/**
	 * <h1>ShortToByte</h1>
	 * short型整数をByte配列に変換します。<br>
	 * 変換されたByte配列は{@link #INTSIZE}に依存します
	 * @param value 変換するshort型整数
	 * @return 変換されたbyte配列
	 */
	public static byte[] ShortToByte(short value) {
		ByteBuffer buffer = ByteBuffer.allocate(SHORTSIZE);
		return buffer.putShort(value).array();
	}
	
	/**
	 * <h1>ByteToShort</h1>
	 * Byte配列をshortに変換します。<br>
	 * @param bytes byte配列
	 * @return 変換されたshort型整数
	 */
	public static short ByteToShort(byte[] bytes) {
		return ByteBuffer.wrap(bytes).getShort();
	}
	
	//==================================================================================================================
	//------------------------------------------------------ int
	/**
	 * intをbyteへ変換する際のbyteサイズ
	 */
	public static final int INTSIZE = Integer.SIZE / Byte.SIZE;
	
	/**
	 * <h1>IntToByte</h1>
	 * int型整数をByte配列に変換します。<br>
	 * 変換されたByte配列は{@link #INTSIZE}に依存します
	 * @param value 変換するint型整数
	 * @return 変換されたbyte配列
	 */
	public static byte[] IntToByte(int value) {
		ByteBuffer buffer = ByteBuffer.allocate(INTSIZE);
		return buffer.putInt(value).array();
	}
	
	
	/**
	 * <h1>ByteToInt</h1>
	 * Byte配列をInt形に変換します。<br>
	 * @param bytes byte配列
	 * @return 変換されたint型整数
	 */
	public static int ByteToInt(byte[] bytes) {
		return ByteBuffer.wrap(bytes).getInt();
	}
	
	//==================================================================================================================
	//------------------------------------------------------long
	/**
	 * longをbyteへ変換する際のbyteサイズ
	 */
	public static final int LONGSIZE = Long.SIZE / Byte.SIZE;
	
	/**
	 * <h1>LongToByte</h1>
	 * long型整数をByte配列に変換します。<br>
	 * 変換されたByte配列は{@link #LONGSIZE}に依存します
	 * @param value 変換するlong型整数
	 * @return 変換されたbyte配列
	 */
	public static byte[] LongToByte(long value) {
		ByteBuffer buffer = ByteBuffer.allocate(LONGSIZE);
		return buffer.putLong(value).array();
	}
	
	/**
	 * <h1>ByteToInt</h1>
	 * Byte配列をlong形に変換します。<br>
	 * @param bytes byte配列
	 * @return 変換されたlong型整数
	 */
	public static long ByteToLong(byte[] bytes) {
		return ByteBuffer.wrap(bytes).getLong();
	}
	
	//==================================================================================================================
	//------------------------------------------------------float
	/**
	 * floatをbyteへ変換する際のbyteサイズ
	 */
	public static final int FLOATSIZE = Float.SIZE / Byte.SIZE;
	
	/**
	 * <h1>FloatToByte</h1>
	 * float型浮動小数をbyte配列に変換します。<br>
	 * 変換されたbyte配列は{@link #FLOATSIZE}に依存します
	 * @param value 変換するfloat型浮動小数
	 * @return 変換されたbyte配列
	 */
	public static byte[] FloatToByte(float value) {
		ByteBuffer buffer = ByteBuffer.allocate(FLOATSIZE);
		return buffer.putFloat(value).array();
	}
	
	/**
	 * <h1>ByteToFloat</h1>
	 * byte配列をfloat型浮動小数に変換します<br>
	 * @param bytes byte配列
	 * @return 変換されたfloat型浮動小数
	 */
	public static float ByteToFloat(byte[] bytes) {
		return ByteBuffer.wrap(bytes).getFloat();
	}
	
	//==================================================================================================================
	//------------------------------------------------------double
	/**
	 * doubleをbyteへ変換する際のbyteサイズ
	 */
	public static final int DOUBLESIZE = Double.SIZE / Byte.SIZE;
	
	/**
	 * <h1>DoubleToByte</h1>
	 * double型浮動小数をbyte配列に変換します。<br>
	 * 変換されたbyte配列は{@link #DOUBLESIZE}に依存します
	 * @param value 変換するdouble型浮動小数
	 * @return 変換されたbyte配列
	 */
	public static byte[] DoubleToByte(double value) {
		ByteBuffer buffer = ByteBuffer.allocate(DOUBLESIZE);
		return buffer.putDouble(value).array();
	}
	
	/**
	 * <h1>ByteToDouble</h1>
	 * byte配列をdouble型浮動小数に変換します<br>
	 * @param bytes byte配列
	 * @return 変換されたdouble型浮動小数
	 */
	public static double ByteToDouble(byte[] bytes) {
		return ByteBuffer.wrap(bytes).getDouble();
	}
	
	//==================================================================================================================
	//------------------------------------------------------char
	/**
	 * charをbyteへ変換する際のbyteサイズ
	 */
	public static final int CHARSIZE = Character.SIZE / Byte.SIZE;
	
	/**
	 * <h1>CharToByte</h1>
	 * char型文字をbyte配列に変換します。<br>
	 * 変換されたbyte配列は{@link #CHARSIZE}に依存します
	 * @param value 変換するchar型文字
	 * @return 変換されたbyte配列
	 */
	public static byte[] CharToByte(char value) {
		ByteBuffer buffer = ByteBuffer.allocate(CHARSIZE);
		return buffer.putChar(value).array();
	}
	
	/**
	 * <h1>ByteToChar</h1>
	 * byte配列をchar型文字に変換します。<br>
	 * @param bytes 変換するbyte配列
	 * @return 変換されたchar文字
	 */
	public static char ByteToChar(byte[] bytes) {
		return ByteBuffer.wrap(bytes).getChar();
	}
	
	//==================================================================================================================
	//------------------------------------------------------String
	
	/**
	 * <h1>StringToByte</h1>
	 * String型文字列をbyte配列へ変換します<br>
	 * 使用する文字コードはUTF-8です。UTF-8が使用できない場合はスタックトレースを出力し、
	 * デフォルトの文字コードを使用します
	 * @param value 変換するString型文字列
	 * @return 変換されたbyte配列
	 */
	public static byte[] StringToByte(String value) {
		try {
			return value.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return value.getBytes();
		}
	}
	
	/**
	 * <h1>StringToByte</h1>
	 * String型文字列をbyte配列へ変換します<br>
	 * 使用する文字コードはcharsetNameで指定します。
	 * @param value 変換するString配列
	 * @param charsetName 変換に使用する文字コードの名前
	 * @return 変換されたbyte配列
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	public static byte[] StringToByte(String value,String charsetName) throws UnsupportedEncodingException {
		return value.getBytes(charsetName);
	}
	
	/**
	 * <h1>ByteToString</h1>
	 * byte配列をString文字列へ変換します。<br>
	 * 使用する文字コードはUTF-8です。UTF-8が使用できない場合はスタックトレースを出力し、
	 * デフォルトの文字コードを使用します
	 * @param bytes 変換するbyte配列
	 * @return 変換されたString配列
	 */
	public static String ByteToString(byte[] bytes) {
		try {
			return new String(bytes,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new String(bytes);
		}
	}
	
	/**
	 * <h1>ByteToString</h1>
	 * byte配列をString文字列へ変換します。<br>
	 * 使用する文字コードはcharsetNameで指定します。
	 * @param bytes 変換するbyte配列
	 * @param charsetName 変換に使用する文字コードの名前
	 * @return 変換されたString配列
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	public static String ByteToString(byte[] bytes,String charsetName) throws UnsupportedEncodingException {
		return new String(bytes,charsetName);
	}
	
	
	
}
