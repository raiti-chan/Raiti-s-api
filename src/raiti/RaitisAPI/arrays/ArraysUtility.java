package raiti.RaitisAPI.arrays;

/**
 * <h1>ArraysUtility</h1><br>
 * 配列操作の便利メソッド群です<br>
 * 
 * @author Raiti
 * @version 1.0.0
 *
 */
public class ArraysUtility {
	/**
	 * <B>コンストラクター</B><br>
	 *使用しません
	 */
	private ArraysUtility() {}
	
	/**
	 * <h1>remove</h1>
	 * 指定したインデックスの配列要素の消去<br>
	 * 戻り値を配列に再び格納してください。
	 * @param arrays 消去する配列
	 * @param index 消去するインデックス
	 * @return 消去した配列
	 */
	public static Object[] remove(Object[] arrays, int index) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		if (arrays.length <= index) {
			throw new ArrayIndexOutOfBoundsException("インデックスが有効範囲を超えて居ます->index:"+index);
		}
		
		Object[] buffer = arrays.clone();
		arrays = new Object[arrays.length - 1];
		System.arraycopy(buffer, 0, arrays, 0, index);
		System.arraycopy(buffer, index + 1, arrays, index, buffer.length - index - 1);
		buffer = null;
		return arrays;
	}
	
	/**
	 * <h1>remove</h1>
	 * 指定したインデックスの配列要素の消去<br>
	 * 戻り値を配列に再び格納してください。
	 * @param arrays 消去する配列
	 * @param index 消去するインデックス
	 * @return 消去した配列
	 */
	public static String[] remove(String[] arrays, int index) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		if (arrays.length <= index) {
			throw new ArrayIndexOutOfBoundsException("インデックスが有効範囲を超えて居ます->index:"+index);
		}
		
		Object[] buffer = arrays.clone();
		arrays = new String[arrays.length - 1];
		System.arraycopy(buffer, 0, arrays, 0, index);
		System.arraycopy(buffer, index + 1, arrays, index, buffer.length - index - 1);
		buffer = null;
		return arrays;
	}
	
	/**
	 * <h1>remove</h1>
	 * 指定したインデックスの配列要素の消去<br>
	 * 戻り値を配列に再び格納してください。
	 * @param arrays 消去する配列
	 * @param index 消去するインデックス
	 * @return 消去した配列
	 */
	public static byte[] remove(byte[] arrays, int index) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		if (arrays.length <= index) {
			throw new ArrayIndexOutOfBoundsException("インデックスが有効範囲を超えて居ます");
		}
		byte[] buffer = arrays.clone();
		arrays = new byte[arrays.length - 1];
		System.arraycopy(buffer, 0, arrays, 0, index);
		System.arraycopy(buffer, index + 1, arrays, index, buffer.length - index - 1);
		buffer = null;
		return arrays;
	}
	
	/**
	 * <h1>remove</h1>
	 * 指定したインデックスの配列要素の消去<br>
	 * 戻り値を配列に再び格納してください。
	 * @param arrays 消去する配列
	 * @param index 消去するインデックス
	 * @return 消去した配列
	 */
	public static int[] remove(int[] arrays, int index) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		if (arrays.length <= index) {
			throw new ArrayIndexOutOfBoundsException("インデックスが有効範囲を超えて居ます");
		}
		int[] buffer = arrays.clone();
		arrays = new int[arrays.length - 1];
		System.arraycopy(buffer, 0, arrays, 0, index);
		System.arraycopy(buffer, index + 1, arrays, index, buffer.length - index - 1);
		buffer = null;
		return arrays;
	}
	
	/**
	 * <h1>remove</h1>
	 * 指定したインデックスの配列要素の消去<br>
	 * 戻り値を配列に再び格納してください。
	 * @param arrays 消去する配列
	 * @param index 消去するインデックス
	 * @return 消去した配列
	 */
	public static boolean[] remove(boolean[] arrays, int index) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		if (arrays.length <= index) {
			throw new ArrayIndexOutOfBoundsException("インデックスが有効範囲を超えて居ます");
		}
		boolean[] buffer = arrays.clone();
		arrays = new boolean[arrays.length - 1];
		System.arraycopy(buffer, 0, arrays, 0, index);
		System.arraycopy(buffer, index + 1, arrays, index, buffer.length - index - 1);
		buffer = null;
		return arrays;
	}
	
	/**
	 * <h1>remove</h1>
	 * 配列の中から指定した番地から指定した数の要素を消去します。<br>
	 * 戻り値を配列に再び格納してください。
	 * @param arrays 消去する配列
	 * @param index 消去するインデックス
	 * @param length 消去する数
	 * @return 消去した配列
	 */
	public static Object[] remove(Object[] arrays, int index, int length) {
		for (int i = 0; i < length; i++) {
			remove(arrays, index);
		}
		return arrays;
	}
	
	/**
	 * <h1>remove</h1>
	 * 配列の中から指定した番地から指定した数の要素を消去します。<br>
	 * 戻り値を配列に再び格納してください。
	 * @param arrays 消去する配列
	 * @param index 消去するインデックス
	 * @param length 消去する数
	 * @return 消去した配列
	 */
	public static byte[] remove(byte[] arrays, int index, int length) {
		for (int i = 0; i < length; i++) {
			remove(arrays, index);
		}
		return arrays;
	}
	
	/**
	 * <h1>remove</h1>
	 * 配列の中から指定した番地から指定した数の要素を消去します。<br>
	 * 戻り値を配列に再び格納してください。
	 * @param arrays 消去する配列
	 * @param index 消去するインデックス
	 * @param length 消去する数
	 * @return 消去した配列
	 */
	public static int[] remove(int[] arrays, int index, int length) {
		for (int i = 0; i < length; i++) {
			remove(arrays, index);
		}
		return arrays;
	}
	
	/**
	 * <h1>remove</h1>
	 * 配列の中から指定した番地から指定した数の要素を消去します。<br>
	 * 戻り値を配列に再び格納してください。
	 * @param arrays 消去する配列
	 * @param index 消去するインデックス
	 * @param length 消去する数
	 * @return 消去した配列
	 */
	public static boolean[] remove(boolean[] arrays, int index, int length) {
		for (int i = 0; i < length; i++) {
			remove(arrays, index);
		}
		return arrays;
	}
	
	/**
	 * <h1>removeString</h1>
	 * String配列から、指定した文字列要素を消去します<br>
	 * <br>
	 * 1:string1<br>
	 * 2:string2<br>
	 * 3:string3<br>
	 * 4:string0<br>
	 * 5:string4<br>
	 * ↓removeString(配列,"string0");<br>
	 * 1:string1<br>
	 * 2:string2<br>
	 * 3:string3<br>
	 * 4:string4<br>
	 * となります。<br>
	 * 無い文字列は無視されます。また、同じ文字が複数あった場合、<b><U>全て</U><b>消去されます。
	 * 
	 * @param arrays 消去する配列
	 * @param target 消去する文字列
	 * @return 消去した配列
	 */
	public static String[] removeString(String[] arrays, String target) {
		String[] arraysBuffer = new String[arrays.length];
		System.arraycopy(arrays, 0, arraysBuffer, 0, arrays.length);
		int Bufferlength = arraysBuffer.length;
		for (int i = 0; i < Bufferlength; i++) {
			if (arraysBuffer[i].equals(target)) {
				arraysBuffer = remove(arraysBuffer, i);
				Bufferlength--;
				i--;
			}
		}
		arrays = new String[arraysBuffer.length];
		System.arraycopy(arraysBuffer, 0, arrays, 0, arraysBuffer.length);
		return arrays;
	}
	
	/**
	 * <h1>removeStringAll</h1>
	 * String配列から、指定した文字列要素を消去します<br>
	 * {@link ArraysUtility#removeString(String[], String)}の上位で、複数の文字列の指定ができます。
	 * @param arrays 消去する配列
	 * @param targets 消去する文字列
	 * @return 消去した配列
	 * @see ArraysUtility#removeString(String[], String)
	 */
	public static String[] removeStringAll(String[] arrays, String... targets) {
		for(String target:targets) {
			arrays = removeString(arrays, target);
		}
		return arrays;
	}
	
	/**
	 * <h1>ArraysPrint</h1>
	 * 配列を全て、標準出力に出力します<br>
	 * @param arraya
	 */
	public static void ArraysPrint(Object[] arraya) {
		Object[] arrayOfObject = arraya;
		int j = arraya.length;
		for (int i = 0; i < j; i++) {
			Object object = arrayOfObject[i];
			System.out.println(object);
		}
	}
	
	/**
	 * <h1>ArraysPrint</h1>
	 * 配列を全て、標準出力に出力します<br>
	 * @param arraya
	 */
	public static void ArraysPrint(int[] arraya) {
		int[] arrayOfInt = arraya;
		int j = arraya.length;
		for (int i = 0; i < j; i++) {
			int object = arrayOfInt[i];
			System.out.println(object);
		}
	}
	
	/**
	 * <h1>ArraysPrint</h1>
	 * 配列を全て、標準出力に出力します<br>
	 * @param arraya
	 */
	public static void ArraysPrint(byte[] arraya) {
		byte[] arrayOfByte = arraya;
		int j = arraya.length;
		for (int i = 0; i < j; i++) {
			byte object = arrayOfByte[i];
			System.out.println(object);
		}
	}
	
	/**
	 * <h1>ArraysPrint</h1>
	 * 配列を全て、標準出力に出力します<br>
	 * @param arraya
	 */
	public static void ArraysPrint(boolean[] arraya) {
		boolean[] arrayOfBoolean = arraya;
		int j = arraya.length;
		for (int i = 0; i < j; i++) {
			boolean object = arrayOfBoolean[i];
			System.out.println(object);
		}
	}
}
