/**
 * 
 */
package raiti.RaitisAPI.DataOperation.RBD;

import java.util.HashMap;

import raiti.RaitisAPI.DataOperation.RBD.Data.NFD;

/** <h1>RBD</h1>
 * <br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class RBD extends ArrayObjectOperation{
	
	//-------------------------------------コンストラクター
	/**<B>コンストラクター</B><br>
	 * 
	 */
	public RBD() {
		super(new HashMap<String,NFD<?>>());
	}
	
	public RBD(HashMap<String, NFD<?>> datas) {
		super(datas);
	}
	
	
	//==================================================================================================================
	//------------------------------------------------------
	/**
	 * <h1>AllStringOutput</h1>
	 * データを全て標準出力へ文字列化して出力します。<br>
	 */
	public void AllStringOutput() {
		NFD<?>[] datas = getAll();
		for(NFD<?> data : datas) {
			data.StringOutput("");
		}
	}
	
}
