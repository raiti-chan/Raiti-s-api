package raitichan.raitisapi.arrays;


/**
 * 配列操作の便利メソッド群
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class ArraysUtility {
	
	/**
	 * 使用しません
	 */
	private ArraysUtility () {
	}
	
	//==================================================================================================================
	//------------------------------------------------------add
	
	/**
	 * 配列の一番最後に要素を追加します<br>
	 *
	 * @param arrays 追加する配列
	 * @param value  追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static Object[] add (Object[] arrays, Object value) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		Object[] buffer = arrays.clone();
		arrays = new Object[arrays.length + 1];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		arrays[arrays.length - 1] = value;
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を追加します<br>
	 *
	 * @param arrays 追加する配列
	 * @param value  追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static String[] add (String[] arrays, String value) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		String[] buffer = arrays.clone();
		arrays = new String[arrays.length + 1];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		arrays[arrays.length - 1] = value;
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を追加します<br>
	 *
	 * @param arrays 追加する配列
	 * @param value  追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static byte[] add (byte[] arrays, byte value) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		byte[] buffer = arrays.clone();
		arrays = new byte[arrays.length + 1];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		arrays[arrays.length - 1] = value;
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を追加します<br>
	 *
	 * @param arrays 追加する配列
	 * @param value  追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static short[] add (short[] arrays, short value) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		short[] buffer = arrays.clone();
		arrays = new short[arrays.length + 1];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		arrays[arrays.length - 1] = value;
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を追加します<br>
	 *
	 * @param arrays 追加する配列
	 * @param value  追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static int[] add (int[] arrays, int value) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		int[] buffer = arrays.clone();
		arrays = new int[arrays.length + 1];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		arrays[arrays.length - 1] = value;
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を追加します<br>
	 *
	 * @param arrays 追加する配列
	 * @param value  追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static long[] add (long[] arrays, long value) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		long[] buffer = arrays.clone();
		arrays = new long[arrays.length + 1];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		arrays[arrays.length - 1] = value;
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を追加します<br>
	 *
	 * @param arrays 追加する配列
	 * @param value  追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static float[] add (float[] arrays, float value) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		float[] buffer = arrays.clone();
		arrays = new float[arrays.length + 1];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		arrays[arrays.length - 1] = value;
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を追加します<br>
	 *
	 * @param arrays 追加する配列
	 * @param value  追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static double[] add (double[] arrays, double value) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		double[] buffer = arrays.clone();
		arrays = new double[arrays.length + 1];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		arrays[arrays.length - 1] = value;
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を追加します<br>
	 *
	 * @param arrays 追加する配列
	 * @param value  追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static boolean[] add (boolean[] arrays, boolean value) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		boolean[] buffer = arrays.clone();
		arrays = new boolean[arrays.length + 1];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		arrays[arrays.length - 1] = value;
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を追加します<br>
	 *
	 * @param arrays 追加する配列
	 * @param value  追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static char[] add (char[] arrays, char value) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		char[] buffer = arrays.clone();
		arrays = new char[arrays.length + 1];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		arrays[arrays.length - 1] = value;
		return arrays;
	}
	
	//==================================================================================================================
	//------------------------------------------------------addAll
	
	/**
	 * 配列の一番最後に要素を複数追加します<br>
	 *
	 * @param arrays    追加先要素
	 * @param addArrays 追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("WeakerAccess")
	public static Object[] addAll (Object[] arrays, Object... addArrays) {
		if (arrays == null | addArrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		Object[] buffer = arrays.clone();
		arrays = new Object[arrays.length + addArrays.length];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		System.arraycopy(addArrays, 0, arrays, buffer.length, addArrays.length);
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を複数追加します<br>
	 *
	 * @param arrays    追加先要素
	 * @param addArrays 追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("WeakerAccess")
	public static String[] addAll (String[] arrays, String... addArrays) {
		if (arrays == null | addArrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		String[] buffer = arrays.clone();
		arrays = new String[arrays.length + addArrays.length];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		System.arraycopy(addArrays, 0, arrays, buffer.length, addArrays.length);
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を複数追加します<br>
	 *
	 * @param arrays    追加先要素
	 * @param addArrays 追加する要素
	 * @return 追加された配列
	 */
	public static byte[] addAll (byte[] arrays, byte... addArrays) {
		if (arrays == null | addArrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		byte[] buffer = arrays.clone();
		arrays = new byte[arrays.length + addArrays.length];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		System.arraycopy(addArrays, 0, arrays, buffer.length, addArrays.length);
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を複数追加します<br>
	 *
	 * @param arrays    追加先要素
	 * @param addArrays 追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("WeakerAccess")
	public static short[] addAll (short[] arrays, short... addArrays) {
		if (arrays == null | addArrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		short[] buffer = arrays.clone();
		arrays = new short[arrays.length + addArrays.length];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		System.arraycopy(addArrays, 0, arrays, buffer.length, addArrays.length);
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を複数追加します<br>
	 *
	 * @param arrays    追加先要素
	 * @param addArrays 追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("WeakerAccess")
	public static int[] addAll (int[] arrays, int... addArrays) {
		if (arrays == null | addArrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		int[] buffer = arrays.clone();
		arrays = new int[arrays.length + addArrays.length];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		System.arraycopy(addArrays, 0, arrays, buffer.length, addArrays.length);
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を複数追加します<br>
	 *
	 * @param arrays    追加先要素
	 * @param addArrays 追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("WeakerAccess")
	public static long[] addAll (long[] arrays, long... addArrays) {
		if (arrays == null | addArrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		long[] buffer = arrays.clone();
		arrays = new long[arrays.length + addArrays.length];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		System.arraycopy(addArrays, 0, arrays, buffer.length, addArrays.length);
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を複数追加します<br>
	 *
	 * @param arrays    追加先要素
	 * @param addArrays 追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("WeakerAccess")
	public static float[] addAll (float[] arrays, float... addArrays) {
		if (arrays == null | addArrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		float[] buffer = arrays.clone();
		arrays = new float[arrays.length + addArrays.length];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		System.arraycopy(addArrays, 0, arrays, buffer.length, addArrays.length);
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を複数追加します<br>
	 *
	 * @param arrays    追加先要素
	 * @param addArrays 追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("WeakerAccess")
	public static double[] addAll (double[] arrays, double... addArrays) {
		if (arrays == null | addArrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		double[] buffer = arrays.clone();
		arrays = new double[arrays.length + addArrays.length];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		System.arraycopy(addArrays, 0, arrays, buffer.length, addArrays.length);
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を複数追加します<br>
	 *
	 * @param arrays    追加先要素
	 * @param addArrays 追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("WeakerAccess")
	public static boolean[] addAll (boolean[] arrays, boolean... addArrays) {
		if (arrays == null | addArrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		boolean[] buffer = arrays.clone();
		arrays = new boolean[arrays.length + addArrays.length];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		System.arraycopy(addArrays, 0, arrays, buffer.length, addArrays.length);
		return arrays;
	}
	
	/**
	 * 配列の一番最後に要素を複数追加します<br>
	 *
	 * @param arrays    追加先要素
	 * @param addArrays 追加する要素
	 * @return 追加された配列
	 */
	@SuppressWarnings("WeakerAccess")
	public static char[] addAll (char[] arrays, char... addArrays) {
		if (arrays == null | addArrays == null) {
			throw new NullPointerException("配列がありません");
		}
		
		char[] buffer = arrays.clone();
		arrays = new char[arrays.length + addArrays.length];
		System.arraycopy(buffer, 0, arrays, 0, buffer.length);
		System.arraycopy(addArrays, 0, arrays, buffer.length, addArrays.length);
		return arrays;
	}
	
	//==================================================================================================================
	
	/**
	 * 指定した配列を全て1つの配列にまとめます。<br>
	 *
	 * @param arrays    追加先配列
	 * @param addArrays 追加する配列
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static Object[] addAll (Object[] arrays, Object[]... addArrays) {
		for (Object[] addArray : addArrays) {
			arrays = addAll(arrays, addArray);
		}
		return arrays;
	}
	
	/**
	 * 指定した配列を全て1つの配列にまとめます。<br>
	 *
	 * @param arrays    追加先配列
	 * @param addArrays 追加する配列
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static String[] addAll (String[] arrays, String[]... addArrays) {
		for (String[] addArray : addArrays) {
			arrays = addAll(arrays, addArray);
		}
		return arrays;
	}
	
	/**
	 * 指定した配列を全て1つの配列にまとめます。<br>
	 *
	 * @param arrays    追加先配列
	 * @param addArrays 追加する配列
	 * @return 追加された配列
	 */
	public static byte[] addAll (byte[] arrays, byte[]... addArrays) {
		for (byte[] addArray : addArrays) {
			arrays = addAll(arrays, addArray);
		}
		return arrays;
	}
	
	/**
	 * 指定した配列を全て1つの配列にまとめます。<br>
	 *
	 * @param arrays    追加先配列
	 * @param addArrays 追加する配列
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static short[] addAll (short[] arrays, short[]... addArrays) {
		for (short[] addArray : addArrays) {
			arrays = addAll(arrays, addArray);
		}
		return arrays;
	}
	
	/**
	 * 指定した配列を全て1つの配列にまとめます。<br>
	 *
	 * @param arrays    追加先配列
	 * @param addArrays 追加する配列
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static int[] addAll (int[] arrays, int[]... addArrays) {
		for (int[] addArray : addArrays) {
			arrays = addAll(arrays, addArray);
		}
		return arrays;
	}
	
	/**
	 * 指定した配列を全て1つの配列にまとめます。<br>
	 *
	 * @param arrays    追加先配列
	 * @param addArrays 追加する配列
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static long[] addAll (long[] arrays, long[]... addArrays) {
		for (long[] addArray : addArrays) {
			arrays = addAll(arrays, addArray);
		}
		return arrays;
	}
	
	/**
	 * 指定した配列を全て1つの配列にまとめます。<br>
	 *
	 * @param arrays    追加先配列
	 * @param addArrays 追加する配列
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static float[] addAll (float[] arrays, float[]... addArrays) {
		for (float[] addArray : addArrays) {
			arrays = addAll(arrays, addArray);
		}
		return arrays;
	}
	
	/**
	 * 指定した配列を全て1つの配列にまとめます。<br>
	 *
	 * @param arrays    追加先配列
	 * @param addArrays 追加する配列
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static double[] addAll (double[] arrays, double[]... addArrays) {
		for (double[] addArray : addArrays) {
			arrays = addAll(arrays, addArray);
		}
		return arrays;
	}
	
	/**
	 * 指定した配列を全て1つの配列にまとめます。<br>
	 *
	 * @param arrays    追加先配列
	 * @param addArrays 追加する配列
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static boolean[] addAll (boolean[] arrays, boolean[]... addArrays) {
		for (boolean[] addArray : addArrays) {
			arrays = addAll(arrays, addArray);
		}
		return arrays;
	}
	
	/**
	 * 指定した配列を全て1つの配列にまとめます。<br>
	 *
	 * @param arrays    追加先配列
	 * @param addArrays 追加する配列
	 * @return 追加された配列
	 */
	@SuppressWarnings("unused")
	public static char[] addAll (char[] arrays, char[]... addArrays) {
		for (char[] addArray : addArrays) {
			arrays = addAll(arrays, addArray);
		}
		return arrays;
	}
	
	//==================================================================================================================
	//------------------------------------------------------remove
	
	/**
	 * 指定したインデックスの配列要素の消去<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @return 消去した配列
	 */
	@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
	public static Object[] remove (Object[] arrays, int index) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		if (arrays.length <= index) {
			throw new ArrayIndexOutOfBoundsException("インデックスが有効範囲を超えて居ます->index:" + index);
		}
		
		Object[] buffer = arrays.clone();
		arrays = new Object[arrays.length - 1];
		System.arraycopy(buffer, 0, arrays, 0, index);
		System.arraycopy(buffer, index + 1, arrays, index, buffer.length - index - 1);
		return arrays;
	}
	
	/**
	 * 指定したインデックスの配列要素の消去<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @return 消去した配列
	 */
	@SuppressWarnings("WeakerAccess")
	public static String[] remove (String[] arrays, int index) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		if (arrays.length <= index) {
			throw new ArrayIndexOutOfBoundsException("インデックスが有効範囲を超えて居ます->index:" + index);
		}
		
		String[] buffer = arrays.clone();
		arrays = new String[arrays.length - 1];
		System.arraycopy(buffer, 0, arrays, 0, index);
		System.arraycopy(buffer, index + 1, arrays, index, buffer.length - index - 1);
		return arrays;
	}
	
	/**
	 * 指定したインデックスの配列要素の消去<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @return 消去した配列
	 */
	@SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
	public static byte[] remove (byte[] arrays, int index) {
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
		return arrays;
	}
	
	/**
	 * 指定したインデックスの配列要素の消去<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @return 消去した配列
	 */
	@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
	public static short[] remove (short[] arrays, int index) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		if (arrays.length <= index) {
			throw new ArrayIndexOutOfBoundsException("インデックスが有効範囲を超えて居ます");
		}
		short[] buffer = arrays.clone();
		arrays = new short[arrays.length - 1];
		System.arraycopy(buffer, 0, arrays, 0, index);
		System.arraycopy(buffer, index + 1, arrays, index, buffer.length - index - 1);
		return arrays;
	}
	
	/**
	 * 指定したインデックスの配列要素の消去<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @return 消去した配列
	 */
	@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
	public static int[] remove (int[] arrays, int index) {
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
		return arrays;
	}
	
	/**
	 * 指定したインデックスの配列要素の消去<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @return 消去した配列
	 */
	@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
	public static long[] remove (long[] arrays, int index) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		if (arrays.length <= index) {
			throw new ArrayIndexOutOfBoundsException("インデックスが有効範囲を超えて居ます");
		}
		long[] buffer = arrays.clone();
		arrays = new long[arrays.length - 1];
		System.arraycopy(buffer, 0, arrays, 0, index);
		System.arraycopy(buffer, index + 1, arrays, index, buffer.length - index - 1);
		return arrays;
	}
	
	/**
	 * 指定したインデックスの配列要素の消去<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @return 消去した配列
	 */
	@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
	public static float[] remove (float[] arrays, int index) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		if (arrays.length <= index) {
			throw new ArrayIndexOutOfBoundsException("インデックスが有効範囲を超えて居ます");
		}
		float[] buffer = arrays.clone();
		arrays = new float[arrays.length - 1];
		System.arraycopy(buffer, 0, arrays, 0, index);
		System.arraycopy(buffer, index + 1, arrays, index, buffer.length - index - 1);
		return arrays;
	}
	
	/**
	 * 指定したインデックスの配列要素の消去<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @return 消去した配列
	 */
	@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
	public static double[] remove (double[] arrays, int index) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		if (arrays.length <= index) {
			throw new ArrayIndexOutOfBoundsException("インデックスが有効範囲を超えて居ます");
		}
		double[] buffer = arrays.clone();
		arrays = new double[arrays.length - 1];
		System.arraycopy(buffer, 0, arrays, 0, index);
		System.arraycopy(buffer, index + 1, arrays, index, buffer.length - index - 1);
		return arrays;
	}
	
	/**
	 * 指定したインデックスの配列要素の消去<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @return 消去した配列
	 */
	@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
	public static boolean[] remove (boolean[] arrays, int index) {
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
		return arrays;
	}
	
	/**
	 * 指定したインデックスの配列要素の消去<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @return 消去した配列
	 */
	@SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
	public static char[] remove (char[] arrays, int index) {
		if (arrays == null) {
			throw new NullPointerException("配列がありません");
		}
		if (arrays.length <= index) {
			throw new ArrayIndexOutOfBoundsException("インデックスが有効範囲を超えて居ます");
		}
		char[] buffer = arrays.clone();
		arrays = new char[arrays.length - 1];
		System.arraycopy(buffer, 0, arrays, 0, index);
		System.arraycopy(buffer, index + 1, arrays, index, buffer.length - index - 1);
		return arrays;
	}
	
	//==================================================================================================================
	//------------------------------------------------------remove
	
	/**
	 * 配列の中から指定した番地から指定した数の要素を消去します。<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @param length 消去する数
	 * @return 消去した配列
	 */
	@SuppressWarnings("unused")
	public static Object[] remove (Object[] arrays, int index, int length) {
		for (int i = 0; i < length; i++) {
			remove(arrays, index);
		}
		return arrays;
	}
	
	/**
	 * 配列の中から指定した番地から指定した数の要素を消去します。<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @param length 消去する数
	 * @return 消去した配列
	 */
	@SuppressWarnings("unused")
	public static String[] remove (String[] arrays, int index, int length) {
		for (int i = 0; i < length; i++) {
			remove(arrays, index);
		}
		return arrays;
	}
	
	/**
	 * 配列の中から指定した番地から指定した数の要素を消去します。<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @param length 消去する数
	 * @return 消去した配列
	 */
	@SuppressWarnings("unused")
	public static byte[] remove (byte[] arrays, int index, int length) {
		for (int i = 0; i < length; i++) {
			remove(arrays, index);
		}
		return arrays;
	}
	
	/**
	 * 配列の中から指定した番地から指定した数の要素を消去します。<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @param length 消去する数
	 * @return 消去した配列
	 */
	@SuppressWarnings("unused")
	public static short[] remove (short[] arrays, int index, int length) {
		for (int i = 0; i < length; i++) {
			remove(arrays, index);
		}
		return arrays;
	}
	
	/**
	 * 配列の中から指定した番地から指定した数の要素を消去します。<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @param length 消去する数
	 * @return 消去した配列
	 */
	@SuppressWarnings("unused")
	public static int[] remove (int[] arrays, int index, int length) {
		for (int i = 0; i < length; i++) {
			remove(arrays, index);
		}
		return arrays;
	}
	
	/**
	 * 配列の中から指定した番地から指定した数の要素を消去します。<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @param length 消去する数
	 * @return 消去した配列
	 */
	@SuppressWarnings("unused")
	public static long[] remove (long[] arrays, int index, int length) {
		for (int i = 0; i < length; i++) {
			remove(arrays, index);
		}
		return arrays;
	}
	
	/**
	 * 配列の中から指定した番地から指定した数の要素を消去します。<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @param length 消去する数
	 * @return 消去した配列
	 */
	@SuppressWarnings("unused")
	public static float[] remove (float[] arrays, int index, int length) {
		for (int i = 0; i < length; i++) {
			remove(arrays, index);
		}
		return arrays;
	}
	
	/**
	 * 配列の中から指定した番地から指定した数の要素を消去します。<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @param length 消去する数
	 * @return 消去した配列
	 */
	@SuppressWarnings("unused")
	public static double[] remove (double[] arrays, int index, int length) {
		for (int i = 0; i < length; i++) {
			remove(arrays, index);
		}
		return arrays;
	}
	
	/**
	 * 配列の中から指定した番地から指定した数の要素を消去します。<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @param length 消去する数
	 * @return 消去した配列
	 */
	@SuppressWarnings("unused")
	public static boolean[] remove (boolean[] arrays, int index, int length) {
		for (int i = 0; i < length; i++) {
			remove(arrays, index);
		}
		return arrays;
	}
	
	/**
	 * 配列の中から指定した番地から指定した数の要素を消去します。<br>
	 * 戻り値を配列に再び格納してください。
	 *
	 * @param arrays 消去する配列
	 * @param index  消去するインデックス
	 * @param length 消去する数
	 * @return 消去した配列
	 */
	@SuppressWarnings("unused")
	public static char[] remove (char[] arrays, int index, int length) {
		for (int i = 0; i < length; i++) {
			remove(arrays, index);
		}
		return arrays;
	}
	
	
	//==================================================================================================================
	
	/**
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
	 * 無い文字列は無視されます。また、同じ文字が複数あった場合、<b><U>全て</U></b>消去されます。
	 *
	 * @param arrays 消去する配列
	 * @param target 消去する文字列
	 * @return 消去した配列
	 */
	@SuppressWarnings("WeakerAccess")
	public static String[] removeString (String[] arrays, String target) {
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
	 * String配列から、指定した文字列要素を消去します<br>
	 * {@link ArraysUtility#removeString(String[], String)}の上位で、複数の文字列の指定ができます。
	 *
	 * @param arrays  消去する配列
	 * @param targets 消去する文字列
	 * @return 消去した配列
	 * @see ArraysUtility#removeString(String[], String)
	 */
	@SuppressWarnings("unused")
	public static String[] removeStringAll (String[] arrays, String... targets) {
		for (String target : targets) {
			arrays = removeString(arrays, target);
		}
		return arrays;
	}
	
	
	//==================================================================================================================
	
	/**
	 * 配列を全て、標準出力に出力します<br>
	 *
	 * @param arrays 出力する配列
	 */
	@SuppressWarnings("unused")
	public static void arraysPrint (Object[] arrays) {
		for (Object object : arrays) {
			System.out.println(object);
		}
	}
	
	/**
	 * 配列を全て、標準出力に出力します<br>
	 *
	 * @param arrays 出力する配列
	 */
	@SuppressWarnings("unused")
	public static void arraysPrint (String[] arrays) {
		for (String object : arrays) {
			System.out.println(object);
		}
	}
	
	/**
	 * 配列を全て、標準出力に出力します<br>
	 *
	 * @param arrays 出力する配列
	 */
	@SuppressWarnings("unused")
	public static void arraysPrint (int[] arrays) {
		for (int object : arrays) {
			System.out.println(object);
		}
	}
	
	/**
	 * 配列を全て、標準出力に出力します<br>
	 *
	 * @param arrays 出力する配列
	 */
	@SuppressWarnings("unused")
	public static void arraysPrint (byte[] arrays) {
		for (byte object : arrays) {
			System.out.println(object);
		}
	}
	
	/**
	 * 配列を全て、標準出力に出力します<br>
	 *
	 * @param arrays 出力する配列
	 */
	@SuppressWarnings("unused")
	public static void arraysPrint (boolean[] arrays) {
		for (boolean object : arrays) {
			System.out.println(object);
		}
	}
	
	
}
