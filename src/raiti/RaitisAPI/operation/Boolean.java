package raiti.RaitisAPI.operation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ���Z�q�̂܂Ƃ߃N���X boolean
 * @author Raiti
 * @version 1.0.0
 *
 */
public class Boolean {
	
	/**
	 * �p�^�[���������e�L�X�g���ƍ����܂�
	 * @param txt �ƍ����镶����
	 * @param target �p�^�[��������
	 * @return ��v����ꍇtrue ���Ȃ��ꍇfalse
	 */
	public static boolean characterEvaluation(String txt,String target) {
		Pattern pattern = Pattern.compile(target);
		Matcher M = pattern.matcher(txt);
		return M.find();
	}
	
}
