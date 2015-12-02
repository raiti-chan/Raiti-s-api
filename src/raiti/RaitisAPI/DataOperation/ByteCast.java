package raiti.RaitisAPI.DataOperation;

/**
 * <h1>ByteCast</h1> 
 * 不明クラス。<br>
 * 用途無し。 一部別クラスに引継ぎ、消去予定
 * 
 * @author Raiti
 * @version 1.0.0
 *
 */
public class ByteCast {
	public ByteCast() {
	}

	public static byte[] toByte(String txt) {
		byte[] data = txt.getBytes();

		return data;
	}

	public static int byteFull(byte data) {
		return data & 0xFF;
	}

	public static int toInt(byte[] bytes) {
		int[] intger = new int[bytes.length];
		byte[] datas = new byte[bytes.length];
		int index = datas.length - 1;
		for (int i = 0; i < datas.length; i++) {
			datas[i] = bytes[index];
			index--;
		}
		for (int i = 0; i < datas.length; i++) {
			if (i == 0) {
				datas[i] &= 0xFF;
			} else {
				intger[i] = ((int) ((datas[i] & 0xFF) * Math.pow(256.0D, i)));
			}
		}
		int data = 0;
		for (int i : intger) {
			data += i;
		}
		return data;
	}

	public static byte[] toByte(int data) {
		int dataa = data;
		byte[] datasX = new byte[1];
		for (int i = 0;; i++) {
			int datab = dataa / 256;
			if (datab == 0) {
				datasX[i] = ((byte) (int) Math.IEEEremainder(dataa, 256.0D));
				break;
			}
			datasX[i] = ((byte) (int) Math.IEEEremainder(dataa, 256.0D));
			dataa = datab;

			byte[] Buffer = new byte[datasX.length];
			System.arraycopy(datasX, 0, Buffer, 0, datasX.length);
			datasX = new byte[Buffer.length + 1];
			System.arraycopy(Buffer, 0, datasX, 0, Buffer.length);
		}
		byte[] datas = new byte[datasX.length];
		int index = datas.length - 1;
		for (int i = 0; i < datas.length; i++) {
			datas[i] = datasX[index];
			index--;
		}
		return datas;
	}

	public static String getName(byte[] datas) {
		int index = 0;
		for (index = 0; index < datas.length; index++) {
			if ((datas[index] == -29) && (datas[(index + 1)] == -125) && (datas[(index + 2)] == -69)) {
				break;
			}
		}
		byte[] data = new byte[index];
		index--;
		for (int i = 0; i < index + 1; i++) {
			data[i] = datas[i];
		}
		return new String(data);
	}

	public static String getFormatString(byte[] datas) {
		int index = toByte(getName(datas)).length;
		index += 3;
		if (datas[index] == 0) {
			return "RBDEntry";
		}
		if (datas[index] == 1) {
			return "Int";
		}
		if (datas[index] == 2) {
			return "String";
		}
		if (datas[index] == 3) {
			return "Byte";
		}
		if (datas[index] == 4) {
			return "Byte255";
		}
		return null;
	}

	public static byte[] getData(byte[] datas) {
		int index = toByte(getName(datas)).length + 3 + 4;
		byte[] data = new byte[datas.length - index - 3];
		for (int i = 0; i < datas.length - index - 3; i++) {
			data[i] = datas[(index + i)];
		}
		return data;
	}

	public static String getStringData(byte[] datas) {
		return new String(getData(datas));
	}

	public static int getIntData(byte[] datas) {
		return toInt(getData(datas));
	}

	public static byte getByteData(byte[] datas) {
		return getData(datas)[0];
	}

	public static String NFDtoString(byte[] datas) {
		String data = getName(datas) + ":" + getFormatString(datas) + ":";
		if (getFormatString(datas).equals("RBDEntry")) {
			data = data + getIntData(datas) + ";";
		} else if (getFormatString(datas).equals("Int")) {
			data = data + getIntData(datas) + ";";
		} else if (getFormatString(datas).equals("String")) {
			data = data + getStringData(datas) + ";";
		} else if (getFormatString(datas).equals("Byte")) {
			data = data + getByteData(datas) + ";";
		} else if (getFormatString(datas).equals("Byte255")) {
			data = data + (getByteData(datas) & 0xFF) + ";";
		}
		return data;
	}
}
