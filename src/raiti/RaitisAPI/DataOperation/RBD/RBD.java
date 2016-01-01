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
		this.map = new HashMap<String,NFD<?>>();
	}
	
	public RBD(HashMap<String, NFD<?>> datas) {
		this.map = datas;
	}
	
}
