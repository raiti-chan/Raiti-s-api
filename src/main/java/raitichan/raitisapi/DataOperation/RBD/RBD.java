package raitichan.raitisapi.DataOperation.RBD;

import java.util.HashMap;

import raitichan.raitisapi.DataOperation.RBD.Data.NFD;

/**
 * <br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public class RBD extends ArrayObjectOperation {
	
	//-------------------------------------コンストラクター
	
	/**
	 */
	public RBD () {
		super(new HashMap<>());
	}
	
	public RBD (HashMap<String, NFD<?>> datas) {
		super(datas);
	}
	
	
	//==================================================================================================================
	//------------------------------------------------------
	
	/**
	 * データを全て標準出力へ文字列化して出力します。<br>
	 */
	@SuppressWarnings("unused")
	public void allStringOutput () {
		NFD<?>[] datas = getAll();
		for (NFD<?> data : datas) {
			data.stringOutput("");
		}
	}
	
}
