package raitichan.raitisapi.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * Byte型整数をほかのプリミティブ型へ相互変換<br>
 * 及びbyte配列操作を楽にする
 * メソッド群です。<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public class ByteUtility {
	
	/**
	 * trueの場合のbyteデータ値
	 */
	@SuppressWarnings("WeakerAccess")
	public static final byte TRUE = 1;
	
	//==================================================================================================================
	//------------------------------------------------------boolean
	/**
	 * falseの場合のbyteデータ値
	 */
	@SuppressWarnings("WeakerAccess")
	public static final byte FALSE = 0;
	/**
	 * shortをbyteへ変換する際のbyteサイズ
	 */
	public static final int SHORT_SIZE = Short.SIZE / Byte.SIZE;
	/**
	 * intをbyteへ変換する際のbyteサイズ
	 */
	public static final int INT_SIZE = Integer.SIZE / Byte.SIZE;
	/**
	 * longをbyteへ変換する際のbyteサイズ
	 */
	public static final int LONG_SIZE = Long.SIZE / Byte.SIZE;
	/**
	 * floatをbyteへ変換する際のbyteサイズ
	 */
	public static final int FLOAT_SIZE = Float.SIZE / Byte.SIZE;
	/**
	 * doubleをbyteへ変換する際のbyteサイズ
	 */
	public static final int DOUBLE_SIZE = Double.SIZE / Byte.SIZE;
	
	//==================================================================================================================
	//------------------------------------------------------short
	/**
	 * charをbyteへ変換する際のbyteサイズ
	 */
	public static final int CHAR_SIZE = Character.SIZE / Byte.SIZE;
	
	/**
	 * 使用しません。
	 */
	private ByteUtility () {
	}
	
	/**
	 * boolean型論理値をbyteに変換します。<br>
	 *
	 * @param value 変換するboolean型論理値
	 * @return 変換されたbyte数値
	 */
	@SuppressWarnings({"WeakerAccess", "unused"})
	public static byte BooleanToByte (Boolean value) {
		return value ? TRUE : FALSE;
	}
	
	//==================================================================================================================
	//------------------------------------------------------ int
	
	/**
	 * Byte型数値をboolean型論理値に変換します。<br>
	 *
	 * @param data 変換するbyte値
	 * @return 変換されたboolean型論理値
	 */
	@SuppressWarnings({"WeakerAccess", "unused"})
	public static boolean ByteToBoolean (byte data) {
		return data == TRUE;
	}
	
	/**
	 * {@link #ByteToBoolean(byte)}をbyte配列に対応させた物です。<br>
	 * byte配列の0番目の値を使用します。
	 *
	 * @param data 変換するbyte配列
	 * @return 変換されたboolean型論理値
	 */
	public static boolean ByteToBoolean (byte[] data) {
		return data[0] == TRUE;
	}
	
	/**
	 * {@link #BooleanToByte(Boolean)}の戻り値をsize1のbyte配列にした物です。<br>
	 *
	 * @param value 変換するboolean型論理値
	 * @return 変換されたbyte配列
	 */
	public static byte[] BooleanToByteArray (Boolean value) {
		return new byte[]{value ? TRUE : FALSE};
	}
	
	//==================================================================================================================
	//------------------------------------------------------long
	
	/**
	 * short型整数をByte配列に変換します。<br>
	 * 変換されたByte配列は{@link #INT_SIZE}に依存します
	 *
	 * @param value 変換するshort型整数
	 * @return 変換されたbyte配列
	 */
	public static byte[] ShortToByte (short value) {
		ByteBuffer buffer = ByteBuffer.allocate(SHORT_SIZE);
		return buffer.putShort(value).array();
	}
	
	/**
	 * Byte配列をshortに変換します。<br>
	 *
	 * @param bytes byte配列
	 * @return 変換されたshort型整数
	 */
	public static short ByteToShort (byte[] bytes) {
		return ByteBuffer.wrap(bytes).getShort();
	}
	
	/**
	 * int型整数をByte配列に変換します。<br>
	 * 変換されたByte配列は{@link #INT_SIZE}に依存します
	 *
	 * @param value 変換するint型整数
	 * @return 変換されたbyte配列
	 */
	public static byte[] IntToByte (int value) {
		ByteBuffer buffer = ByteBuffer.allocate(INT_SIZE);
		return buffer.putInt(value).array();
	}
	
	//==================================================================================================================
	//------------------------------------------------------float
	
	/**
	 * Byte配列をInt形に変換します。<br>
	 *
	 * @param bytes byte配列
	 * @return 変換されたint型整数
	 */
	public static int ByteToInt (byte[] bytes) {
		return ByteBuffer.wrap(bytes).getInt();
	}
	
	/**
	 * long型整数をByte配列に変換します。<br>
	 * 変換されたByte配列は{@link #LONG_SIZE}に依存します
	 *
	 * @param value 変換するlong型整数
	 * @return 変換されたbyte配列
	 */
	public static byte[] LongToByte (long value) {
		ByteBuffer buffer = ByteBuffer.allocate(LONG_SIZE);
		return buffer.putLong(value).array();
	}
	
	/**
	 * Byte配列をlong形に変換します。<br>
	 *
	 * @param bytes byte配列
	 * @return 変換されたlong型整数
	 */
	public static long ByteToLong (byte[] bytes) {
		return ByteBuffer.wrap(bytes).getLong();
	}
	
	//==================================================================================================================
	//------------------------------------------------------double
	
	/**
	 * float型浮動小数をbyte配列に変換します。<br>
	 * 変換されたbyte配列は{@link #FLOAT_SIZE}に依存します
	 *
	 * @param value 変換するfloat型浮動小数
	 * @return 変換されたbyte配列
	 */
	public static byte[] FloatToByte (float value) {
		ByteBuffer buffer = ByteBuffer.allocate(FLOAT_SIZE);
		return buffer.putFloat(value).array();
	}
	
	/**
	 * byte配列をfloat型浮動小数に変換します<br>
	 *
	 * @param bytes byte配列
	 * @return 変換されたfloat型浮動小数
	 */
	public static float ByteToFloat (byte[] bytes) {
		return ByteBuffer.wrap(bytes).getFloat();
	}
	
	/**
	 * double型浮動小数をbyte配列に変換します。<br>
	 * 変換されたbyte配列は{@link #DOUBLE_SIZE}に依存します
	 *
	 * @param value 変換するdouble型浮動小数
	 * @return 変換されたbyte配列
	 */
	public static byte[] DoubleToByte (double value) {
		ByteBuffer buffer = ByteBuffer.allocate(DOUBLE_SIZE);
		return buffer.putDouble(value).array();
	}
	
	//==================================================================================================================
	//------------------------------------------------------char
	
	/**
	 * byte配列をdouble型浮動小数に変換します<br>
	 *
	 * @param bytes byte配列
	 * @return 変換されたdouble型浮動小数
	 */
	public static double ByteToDouble (byte[] bytes) {
		return ByteBuffer.wrap(bytes).getDouble();
	}
	
	/**
	 * char型文字をbyte配列に変換します。<br>
	 * 変換されたbyte配列は{@link #CHAR_SIZE}に依存します
	 *
	 * @param value 変換するchar型文字
	 * @return 変換されたbyte配列
	 */
	public static byte[] CharToByte (char value) {
		ByteBuffer buffer = ByteBuffer.allocate(CHAR_SIZE);
		return buffer.putChar(value).array();
	}
	
	/**
	 * byte配列をchar型文字に変換します。<br>
	 *
	 * @param bytes 変換するbyte配列
	 * @return 変換されたchar文字
	 */
	public static char ByteToChar (byte[] bytes) {
		return ByteBuffer.wrap(bytes).getChar();
	}
	
	//==================================================================================================================
	//------------------------------------------------------String
	
	/**
	 * String型文字列をbyte配列へ変換します<br>
	 * 使用する文字コードはUTF-8です。UTF-8が使用できない場合はスタックトレースを出力し、
	 * デフォルトの文字コードを使用します
	 *
	 * @param value 変換するString型文字列
	 * @return 変換されたbyte配列
	 */
	public static byte[] StringToByte (String value) {
		try {
			return value.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return value.getBytes();
		}
	}
	
	/**
	 * String型文字列をbyte配列へ変換します<br>
	 * 使用する文字コードはcharsetNameで指定します。
	 *
	 * @param value       変換するString配列
	 * @param charsetName 変換に使用する文字コードの名前
	 * @return 変換されたbyte配列
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	@SuppressWarnings("unused")
	public static byte[] StringToByte (String value, String charsetName) throws UnsupportedEncodingException {
		return value.getBytes(charsetName);
	}
	
	/**
	 * byte配列をString文字列へ変換します。<br>
	 * 使用する文字コードはUTF-8です。UTF-8が使用できない場合はスタックトレースを出力し、
	 * デフォルトの文字コードを使用します
	 *
	 * @param bytes 変換するbyte配列
	 * @return 変換されたString配列
	 */
	public static String ByteToString (byte[] bytes) {
		try {
			return new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new String(bytes);
		}
	}
	
	/**
	 * byte配列をString文字列へ変換します。<br>
	 * 使用する文字コードはcharsetNameで指定します。
	 *
	 * @param bytes       変換するbyte配列
	 * @param charsetName 変換に使用する文字コードの名前
	 * @return 変換されたString配列
	 * @throws UnsupportedEncodingException 指定された文字セットがサポートされていない場合
	 */
	@SuppressWarnings("unused")
	public static String ByteToString (byte[] bytes, String charsetName) throws UnsupportedEncodingException {
		return new String(bytes, charsetName);
	}
	
	
}
