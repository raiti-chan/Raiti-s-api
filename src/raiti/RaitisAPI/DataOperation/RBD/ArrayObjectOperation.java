/**
 * 
 */
package raiti.RaitisAPI.DataOperation.RBD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import raiti.RaitisAPI.DataOperation.RBD.Data.NFD;

/** <h1>ArrayObjectOperation</h1>
 * Objectデータの配列を操作するためのベースクラスです<br>
 * オブジェクト名とマップ名が一致していない場合は一部メソッドがエラーを出す可能性があります。
 * オブジェクト名とマップ名の不一致は非推奨です。
 * @author Raiti
 * @version 1.0.0
 * 
 */
public abstract class ArrayObjectOperation {
	
	/**
	 * 格納されてるデータ配列
	 */
	protected HashMap<String, NFD<?>> map;
	
	//------------------------------------------------------add
	/**
	 * <h1>add</h1>
	 * 指定された値と指定されたキーをこの配列に追加します。
	 * 以前にこのキーのデータを保持していた場合、古い値が置き換えられます。<br>
	 * このメソッドでデータを追加した場合、オブジェクトデータの固有名と、
	 * キーの名前が一致されない場合があるので非推奨です。
	 * オブジェクト名とマップ名が一致していない場合は一部メソッドがエラーを出す可能性があります。
	 * @param key データ名
	 * @param data 追加するデータ
	 * @return keyに以前に追加されていたデータ。
	 * keyのマッピングが存在しなかった場合はnull。戻り値nullは、マップが以前にnullとkeyを関連付けていたことを示す場合もある。
	 */
	public NFD<?> add(String key,NFD<?> data){
		return map.put(key, data);
	}
	
	/**
	 * <h1>add</h1>
	 * 指定されたデータ({@link NFD})とそのデータの固有名をキーとしてこの配列に追加します。
	 * 以前に同じ名前のデータが格納されていた場合、古いデータが置き換えられます。<br>
	 * @param data 追加するデータ
	 * @return 以前に同じ名前で追加されていたデータ。
	 * 同じ名前が存在しなかった場合はnull
	 */
	public NFD<?> add(NFD<?> data){
		return map.put(data.getName(),data);
	}
	
	/**
	 * <h1>addAll</h1>
	 * 指定されたデータ({@link NFD})配列とそのデータの固有名をキーとしてこの配列に追加します。
	 * 以前に同じ名前のデータが格納されていた場合、古いデータが置き換えられます。<br>
	 * @param datas 追加するデータ配列
	 * @return 以前に同じ名前で追加されていたデータ配列。
	 */
	public NFD<?>[] addAll(NFD<?> ... datas) {
		NFD<?>[] buffer = new NFD<?>[datas.length];
		int loop = 0;
		for(NFD<?> data : datas) {
			buffer[loop] = this.map.put(data.getName(), data);
			loop++;
		}
		return buffer;
	}
	
	/**
	 * <h1>addAll</h1>
	 * 指定されたデータ({@link NFD})のリストをこの配列に追加します。
	 * 以前に同じ名前のデータが格納されていた場合、古いデータが置き換えられます。<br>
	 * @param datas 追加するデータリスト
	 * @return 以前に同じ名前で追加されていたデータ配列。
	 */
	public NFD<?>[] addAll(List<NFD<?>> datas) {
		NFD<?>[] buffer = new NFD<?>[1];
		return addAll(datas.toArray(buffer));
	}
	
	/**
	 * <h1>addMap</h1>
	 * マップを追加します。<br>
	 * データ名と対応するデータを引継ぎます。既に存在する名前のデータは前のデータが置き換わります。
	 * @param datamap 追加するマップ
	 * @return 以前に同じ名前で追加されていたデータ配列。
	 */
	public NFD<?>[] addMap(Map<String, NFD<?>> datamap){
		String[] names = new String[1];
		NFD<?>[] buffer = new NFD[datamap.size()];
		names = datamap.keySet().toArray(names);
		int i = 0;
		for(String name : names) {
			buffer[i] = add(name,datamap.get(name));
			i++;
		}
		return buffer;
	}
	
	//------------------------------------------------------get
	/**
	 * <h1>get</h1>
	 * 指定した名前のデータを取得します。指定した名前のデータが存在しない場合はnullが返ります。<br>
	 * @param dataname 取得するデータ名
	 * @return 指定した名前のデータ。その名前のデータが存在しない場合はnull
	 */
	public NFD<?> get(String dataname){
		return map.get(dataname);
	}
	
	/**
	 * <h1>getAll</h1>
	 * 指定した名前のデータを複数取得します。指定した名前のデータが存在しない場合はnullが返ります。<br>
	 * @param datanames 取得するデータ名
	 * @return 取得データの配列
	 */
	public NFD<?>[] getAll(String ... datanames){
		NFD<?>[] datas = new NFD[datanames.length];
		for(int i = 0,loop = datas.length;i < loop;i++) {
			datas[i] = this.map.get(datanames[i]);
		}
		return datas;
	}
	
	/**
	 * <h1>getAll</h1>
	 * 指定した名前リストのデータを複数取得します。指定した名前のデータが存在しない場合はnullが返ります。<br>
	 * @param datanames 取得するデータ名リスト
	 * @return 取得データの配列
	 */
	public NFD<?>[] getAll(List<String> datanames){
		String[] buffer = new String[1];
		return getAll(datanames.toArray(buffer));
	}
	
	/**
	 * <h1>getAll</h1>
	 * 格納されている全てのデータを配列で取得します。<br>
	 * @return 格納されている全てのデータ
	 */
	public NFD<?>[] getAll(){
		String[] names = new String[1];
		names = this.map.keySet().toArray(names);
		return getAll(names);
		
	}
	
	/**
	 * <h1>getmap</h1>
	 * 格納されているMapを取得します。ここで取得したMapは内部のMapと連動します。<br>
	 * @return 格納されているMap
	 */
	public HashMap<String, NFD<?>> getmap(){
		return this.map;
	}
	
	/**
	 * <h1>getNFD</h1>
	 * NFDを指定したオブジェクトで取得します。<br>
	 * @param dataname データ名
	 * @return 指定したデータ名のオブジェクト
	 */
	@SuppressWarnings("unchecked")
	public <F extends NFD<?>> F getNFD(String dataname) {
		return (F) get(dataname);
	}
	
	//------------------------------------------------------remove
	/**
	 * <h1>remove</h1>
	 * 指定した名前のデータを消去します。<br>
	 * @param name 消去するデータ名ｓ
	 * @return 消去したデータ
	 */
	public NFD<?> remove(String name) {
		return this.map.remove(name);
	}
	
	/**
	 * <h1>removeAll</h1>
	 * 指定した名前のデータを消去します。<br>
	 * @param names 消去するデータ名
	 * @return 消去したデータ
	 */
	public NFD<?>[] removeAll(String ... names){
		NFD<?>[] datas = new NFD[names.length];
		int i = 0;
		for(String name:names) {
			datas[i] = this.map.remove(name);
			i++;
		}
		return datas;
	}
	
	//------------------------------------------------------rename
	/**
	 * <h1>rename</h1>
	 * オブジェクト名及びオブジェクトマップ名を変更します<br>
	 * オブジェクト名と
	 * @param oldName
	 * @param newName
	 * @return 前の名前
	 */
	public String rename(String oldName,String newName) {
		NFD<?> data = get(oldName);
		String oldDataname = data.getName();
		data.setName(newName);
		remove(oldName);
		add(data);
		return oldDataname;
	}
	
	
	//------------------------------------------------------その他
	/**
	 * <h1>clear</h1>
	 * データを全て消去します<br>
	 */
	public void clear() {
		this.map.clear();
	}
	
	/**
	 * <h1>AllDataSizeUpdate</h1>
	 * 格納されているデータのsizeを全てUアップデートします<br>
	 */
	public void AllDataSizeUpdate() {
		NFD<?>[] datas = getAll();
		for(NFD<?> data : datas) {
			data.DatasizeUpData();
		}
	}
	

	
}
