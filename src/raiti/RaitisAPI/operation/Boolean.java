package raiti.RaitisAPI.operation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 演算子のまとめクラス boolean
 * @author Raiti
 * @version 1.0.0
 *
 */
public class Boolean {
	
	/**
	 * パターン化したテキストを照合します
	 * @param txt 照合する文字列
	 * @param target パターン文字列
	 * @return 一致する場合true しない場合false
	 */
	public static boolean characterEvaluation(String txt,String target) {
		Pattern pattern = Pattern.compile(target);
		Matcher M = pattern.matcher(txt);
		return M.find();
	}
	
	
}
