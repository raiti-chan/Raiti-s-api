package raiti.RaitisAPI.math;

/**
 * <h1>Bezier</h1> 
 * ベジエ関数のメソッド群<br>
 * 
 * @author Raiti
 * @version 1.0.0
 *
 */
public class Bezier {
	
	/**
	 * <B>コンストラクター</B><br>
	 * 不使用
	 */
	private Bezier() {
	}
	
	/**
	 * <h1>bezier2D</h1>
	 * 2次ベジエ関数<br>
	 * p0から出てp1に引っ張られp2で終わる曲線
	 * @param p0 始点
	 * @param p1 ポイント1
	 * @param p2 終点
	 * @param t 0 =&lt; t =&lt; 1 の線の描写値
	 * @return ベジエ値
	 */
	public static float bezier2D(int p0, int p1, int p2, float t) {
		return (1.0F - t) * (1.0F - t) * p0 + 2.0F * (1.0F - t) * t * p1 + t * t * p2;
	}
	
	/**
	 * <h1>bezier2D</h1>
	 * 2次ベジエ関数<br>
	 * p0から出てp1に引っ張られp2で終わる曲線
	 * @param p0 始点
	 * @param p1 ポイント1
	 * @param p2 終点
	 * @param t 0 =&lt; t =&lt; 1 の線の描写値
	 * @return ベジエ値
	 */
	public static float bezier2D(float p0, float p1, float p2, float t) {
		return (1.0F - t) * (1.0F - t) * p0 + 2.0F * (1.0F - t) * t * p1 + t * t * p2;
	}
	
	/**
	 * <h1>bezier2DAll</h1>
	 * 2次ベジエ関数<br>
	 * p0から出てp1を通りp2で終わる曲線
	 * @param p0 始点
	 * @param p1 ポイント1
	 * @param p2 終点
	 * @param t 0 =&lt; t =&lt; 1 の線の描写値
	 * @return ベジエ値
	 */
	public static float bezier2DAll(int p0, int p1, int p2, float t) {
		return (1.0F - t) * (1.0F - t) * p0 + 2.0F * (1.0F - t) * t * getPoint(p0, p1, p2) + t * t * p2;
	}
	
	/**
	 * <h1>bezier2DAll</h1>
	 * 2次ベジエ関数<br>
	 * p0から出てp1を通りp2で終わる曲線
	 * @param p0 始点
	 * @param p1 ポイント1
	 * @param p2 終点
	 * @param t 0 =&lt; t =&lt; 1 の線の描写値
	 * @return ベジエ値
	 */
	public static float bezier2DAll(float p0, float p1, float p2, float t) {
		return (1.0F - t) * (1.0F - t) * p0 + 2.0F * (1.0F - t) * t * getPoint(p0, p1, p2) + t * t * p2;
	}
	
	/**
	 * <h1>bezier3D</h1>
	 * 3次ベジエ関数<br>
	 * p0から出てp1,p2に引っ張られp3で終わる曲線
	 * @param p0 始点
	 * @param p1 ポイント1
	 * @param p2 ポイント2
	 * @param p3 終点
	 * @param t 0 =&lt; t =&lt; 1 の線の描写値
	 * @return ベジエ値
	 */
	public static float bezier3D(int p0, int p1, int p2, int p3, float t) {
		return (1.0F - t) * (1.0F - t) * (1.0F - t) * p0 + 3.0F * (1.0F - t) * (1.0F - t) * t * p1
				+ 3.0F * (1.0F - t) * t * t * p2 + t * t * t * p3;
	}
	
	/**
	 * <h1>bezier3D</h1>
	 * 3次ベジエ関数<br>
	 * p0から出てp1,p2に引っ張られp3で終わる曲線
	 * @param p0 始点
	 * @param p1 ポイント1
	 * @param p2 ポイント2
	 * @param p3 終点
	 * @param t 0 =&lt; t =&lt; 1 の線の描写値
	 * @return ベジエ値
	 */
	public static float bezier3D(float p0, float p1, float p2, float p3, float t) {
		return (1.0F - t) * (1.0F - t) * (1.0F - t) * p0 + 3.0F * (1.0F - t) * (1.0F - t) * t * p1
				+ 3.0F * (1.0F - t) * t * t * p2 + t * t * t * p3;
	}
	
	/**
	 * <h1>bezierCurve</h1>
	 * 多次元ベジエ関数<br>
	 * startから出て、各ポイントに引っ張られendで終わる
	 * @param start 始点
	 * @param p 各ポイント
	 * @param end 終点
	 * @param t 0 =&lt; t =&lt; 1 の線の描写値
	 * @return ベジエ値
	 */
	public static float bezierCurve(int start, int end, float t, int... p) {
		int length = p.length + 1;
		if (length == 1) {
			IndexOutOfBoundsException e = new IndexOutOfBoundsException("ポイントがありません");
			throw e;
		}
		if (length == 2) {
			return bezier2D(start, p[0], end, t);
		}
		if (length == 3) {
			return bezier3D(start, p[0], p[1], end, t);
		}
		float rp = 0.0F;
		float[] ip = new float[length - 1];

		int i = 0;
		int c = ip.length;
		while (i < c) {
			if (i == 0) {
				ip[i] = bezier2D(start, p[i], p[(i + 1)], t);
			} else if (i == c - 1) {
				ip[i] = bezier2D(p[(i - 1)], p[i], end, t);
			} else {
				ip[i] = bezier2D(p[(i - 1)], p[i], p[(i + 1)], t);
			}
			i++;
		}
		rp = bezierCurve(t, ip);
		return rp;
	}
	
	/**
	 * <h1>bezierCurve</h1>
	 * 多次元ベジエ関数<br>
	 * startから出て、各ポイントに引っ張られendで終わる
	 * @param start 始点
	 * @param p 各ポイント
	 * @param end 終点
	 * @param t 0 =&lt; t =&lt; 1 の線の描写値
	 * @return ベジエ値
	 */
	public static float bezierCurve(float start, float end, float t, float... p) {
		int length = p.length + 1;
		if (length == 1) {
			IndexOutOfBoundsException e = new IndexOutOfBoundsException("ポイントがありません");
			throw e;
		}
		if (length == 2) {
			return bezier2D(start, p[0], end, t);
		}
		if (length == 3) {
			return bezier3D(start, p[0], p[1], end, t);
		}
		float rp = 0.0F;
		float[] ip = new float[length - 1];

		int i = 0;
		int c = ip.length;
		while (i < c) {
			if (i == 0) {
				ip[i] = bezier2D(start, p[i], p[(i + 1)], t);
			} else if (i == c - 1) {
				ip[i] = bezier2D(p[(i - 1)], p[i], end, t);
			} else {
				ip[i] = bezier2D(p[(i - 1)], p[i], p[(i + 1)], t);
			}
			i++;
		}
		rp = bezierCurve(t, ip);
		return rp;
	}
	
	/**
	 * <h1>bezierCurve</h1>
	 * 多次元ベジエ関数<br>
	 * p[0]から出て、各ポイントに引っ張られp配列の最後の値で終わる曲線
	 * @param p 各ポイント
	 * @param t 0 =&lt; t =&lt; 1 の線の描写値
	 * @return ベジエ値
	 */
	public static float bezierCurve(float t, int... p) {
		int length = p.length - 1;
		if (length <= 1) {
			IndexOutOfBoundsException e = new IndexOutOfBoundsException("ポイント数が有効範囲外、ポイントがありません。ポイントは必ず3つ以上指定して下さい");

			throw e;
		}
		if (length == 2) {
			return bezier2D(p[0], p[1], p[2], t);
		}
		if (length == 3) {
			return bezier3D(p[0], p[1], p[2], p[3], t);
		}
		float rp = 0.0F;
		float[] ip = new float[length - 1];

		int i = 0;
		int c = ip.length;
		while (i < c) {
			ip[i] = bezier2D(p[i], p[(i + 1)], p[(i + 2)], t);
			i++;
		}
		rp = bezierCurve(t, ip);

		return rp;
	}
	
	/**
	 * <h1>bezierCurve</h1>
	 * 多次元ベジエ関数<br>
	 * p[0]から出て、各ポイントに引っ張られp配列の最後の値で終わる曲線
	 * @param p 各ポイント
	 * @param t 0 =&lt; t =&lt; 1 の線の描写値
	 * @return ベジエ値
	 */
	public static float bezierCurve(float t, float... p) {
		int length = p.length - 1;
		if (length <= 1) {
			IndexOutOfBoundsException e = new IndexOutOfBoundsException("ポイント数が有効範囲外、ポイントがありません。ポイントは必ず3つ以上指定して下さい");

			throw e;
		}
		if (length == 2) {
			return bezier2D(p[0], p[1], p[2], t);
		}
		if (length == 3) {
			return bezier3D(p[0], p[1], p[2], p[3], t);
		}
		float rp = 0.0F;
		float[] ip = new float[length - 1];

		int i = 0;
		int c = ip.length;
		while (i < c) {
			ip[i] = bezier2D(p[i], p[(i + 1)], p[(i + 2)], t);
			i++;
		}
		rp = bezierCurve(t, ip);

		return rp;
	}
	
	// TODO 未完成
	public static float bezierConnectionCurve2D(int start, int end, float t, int... p) {
		return 0.0F;
	}

	public static float bezierConnectionCurve2D(float start, float end, float t, float... p) {
		return 0.0F;
	}

	public static float bezierConnectionCurve2D(float t, int... p) {
		return 0.0F;
	}

	public static float bezierConnectionCurve2D(float t, float... p) {
		return 0.0F;
	}
	
	/**
	 * <h1>getPoint</h1>
	 * 全ての点を通る2次曲線のポイントを取得<br>
	 * @param p0 ポイント1
	 * @param p1 ポイント2
	 * @param p2 ポイント3
	 * @return 計算されたポイント
	 */
	public static float getPoint(int p0, int p1, int p2) {
		return (float) ((4 * p1 - p0 - p2) / 2.0D);
	}
	
	/**
	 * <h1>getPoint</h1>
	 * 全ての点を通る2次曲線のポイントを取得<br>
	 * @param p0 ポイント1
	 * @param p1 ポイント2
	 * @param p2 ポイント3
	 * @return 計算されたポイント
	 */
	public static float getPoint(float p0, float p1, float p2) {
		return (float) ((4.0F * p1 - p0 - p2) / 2.0D);
	}
}
