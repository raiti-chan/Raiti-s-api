package raiti.RaitisAPI.arrays.sort;

import java.util.Comparator;

/**
 * <h1>OrderDescending</h1> 
 * int形数値を大きい順(降順)にソートするコンパレーターです。<br>
 * 
 * @author Raiti
 * @version 1.0.0
 *
 */
public class OrderDescending implements Comparator<Integer> {

	public OrderDescending() {
	}

	/**
	 * <h1>compare</h1> オーバーライド
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Integer o1, Integer o2) {
		if (o1 == o2) {
			return 0;
		}
		if (o1.intValue() < o2.intValue()) {
			return -1;
		}
		if (o1.intValue() > o2.intValue()) {
			return 1;
		}
		return 0;
	}
}
