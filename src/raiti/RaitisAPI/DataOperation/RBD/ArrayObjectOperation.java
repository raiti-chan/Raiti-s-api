/**
 * 
 */
package raiti.RaitisAPI.DataOperation.RBD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import raiti.RaitisAPI.DataOperation.RBD.Data.IntData;
import raiti.RaitisAPI.DataOperation.RBD.Data.NFD;
import raiti.RaitisAPI.arrays.ArraysUtility;

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
	
	/**
	 * 格納されているキーのリスト
	 */
	protected ArrayList<String> keyList;
	
	/**
	 * データのサイズ
	 */
	protected int bytesize = 0;
	
	/**
	 * このデータが変更されているか
	 */
	protected boolean changedData = false;
	
	//------------------------------------------------------コンストラクター
	public ArrayObjectOperation(HashMap<String, NFD<?>> datas) {
		this.keyList = new ArrayList<String>();
		this.map = datas;
		String[] keys = new String[0];
		keys = datas.keySet().toArray(keys);
		for(String key : keys) {
			addKey(key);
		}
	}
	
	
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
	protected NFD<?> add(String key,NFD<?> data){
		NFD<?> retData = map.put(key, data);
		if(!addKey(key)) {
			KeyisLast(key);
		}
		changedData = true;
		return retData;
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
		NFD<?> retData = map.put(data.getName(), data);
		if(!addKey(data.getName())) {
			KeyisLast(data.getName());
		}
		changedData = true;
		return retData;
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
			if(!addKey(data.getName())) {
				KeyisLast(data.getName());
			}
			loop++;
		}
		changedData = true;
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
		changedData = true;
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
		changedData = true;
		return buffer;
	}
	
	/**
	 * <h1>addKey</h1>
	 * キーリストにキーを追加します。<br>
	 * キーがすでに存在している場合、追加せずfalseを返します
	 * @param key 追加するキー
	 * @return 追加された場合true、されなかった場合false
	 */
	protected boolean addKey(String key) {
		if(hasKey(key)) return false;
		keyList.add(key);
		return true;
	}
	
	/**
	 * <h1>addKey</h1>
	 * キーリストに指定したインデックスにキーを追加します<br>
	 * キーがすでに存在している場合、追加せずfalseを返します。
	 * @param index 追加するインデックス
	 * @param key 追加するキー
	 * @return 追加された場合true、されなかった場合false
	 * @throws IndexOutOfBoundsException インデックスが範囲外の場合(index &lt; 0||index &gt;= size())
	 */
	protected boolean addKey(int index , String key) {
		if(hasKey(key)) return false;
		keyList.add(index, key);
		return true;
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
	 * @param <F> 取得するデータ形式のクラス
	 * @return 指定したデータ名のオブジェクト
	 */
	@SuppressWarnings("unchecked")
	public <F extends NFD<?>> F getNFD(String dataname){
		F data = (F) get(dataname);
		return data;
	}
	
	
	/**
	 * <h1>getKeyList</h1>
	 * このグループ内のキーリストを取得します<br>
	 * 取得されるリストと内部のリストは同期しています。
	 * 分離して取得したい場合は{@link #getKeyList(List)}及び
	 * @return {@link #keyList}の参照
	 */
	public ArrayList<String> getKeyList(){
		return keyList;
	}
	
	/**
	 * <h1>getKeyList</h1>
	 * キーリストを取得します<br>
	 * @param list キーリスト格納先リスト
	 */
	public void getKeyList(List<String> list) {
		String[] keys = new String[keyList.size()];
		keyList.toArray(keys);
		for(String key : keys) {
			list.add(key);
		}
	}
	
	/**
	 * <h1>toKeyArray</h1>
	 * キーリストの{@link List #toArray(Object[])}を実行します<br>
	 * @param list 配列が十分な大きさを持つ場合は、このリストの要素の格納先の配列。配列のサイズが十分でない場合は、同じ実行時の型で新しい配列が格納用として割り当てられる。
	 * @return リストの要素が格納されている配列
	 */
	public String[] toKeyArray(String[] list) {
		return keyList.toArray(list);
	}
	
	/**
	 * <h1>getKeyIndex</h1>
	 * 指定された要素がこのリスト内で検出された位置のインデックスを返します。
	 * 指定された要素がこのリストにない場合は -1を返します。
	 * つまり、(o==null ? get(i)==null : o.equals(get(i)))となる、インデックスiを返します。
	 * そのようなインデックスが存在しない場合は -1を返します。<br>
	 * @param key 検索する要素
	 * @return 指定された要素がリスト内で検出された位置のインデックス。その要素がリストにない場合は -1
	 */
	public int getKeyIndex(String key) {
		return keyList.indexOf(key);
	}
	
	/**
	 * <h1>getKey</h1>
	 * 指定したインデックスのキーを取得します<br>
	 * @param index 取得するキーのインデックス
	 * @return 取得したキー
	 * @throws IndexOutOfBoundsException インデックスが範囲外の場合(index &lt; 0||index &gt;= size())
	 */
	public String getKey(int index) {
		return keyList.get(index);
	}
	
	/**
	 * <h1>getIntNFD</h1>
	 * NFDデータをInt型データとして取得します。フォーマットが違った場合はnullが返されます。<br>
	 * @param dataname データ名
	 * @return IntDataにキャストされたデータ。フォーマットが違った場合null
	 */
	public IntData getIntNFD(String dataname) {
		NFD<?> data = getNFD(dataname);
		if(data.getFormat() == NFD.INT) {
			return (IntData) data;
		}
		return null;
	}
	
	//------------------------------------------------------remove
	/**
	 * <h1>remove</h1>
	 * 指定した名前のデータを消去します。<br>
	 * @param name 消去するデータ名ｓ
	 * @return 消去したデータ
	 */
	public NFD<?> remove(String name) {
		NFD<?> retData = this.map.remove(name);
		changedData = true;
		return retData;
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
		changedData = true;
		return datas;
	}
	
	/**
	 * <h1>Keyremove</h1>
	 * キーリスト内から指定したインデックスの要素を消去します<br>
	 * @param index 消去する要素のインデックス
	 * @return 消去した要素
	 * @throws IndexOutOfBoundsException インデックスが範囲外の場合(index &lt; 0||index &gt;= size())
	 */
	protected String Keyremove(int index) {
		return keyList.remove(index);
	}
	
	/**
	 * <h1>Keyremove</h1>
	 * キーリスト内から指定したキーを消去します<br>
	 * @param key 消去するキー
	 * @return 消去したキー、キーが存在しなかった場合null
	 */
	protected String Keyremove(String key) {
		int keyindex = getKeyIndex(key);
		return keyindex == -1 ? null : keyList.remove(keyindex);
	}
	
	//------------------------------------------------------rename
	/**
	 * <h1>rename</h1>
	 * オブジェクト名及びオブジェクトマップ名を変更します<br>
	 * オブジェクト名と
	 * @param oldName 変更するデータ名
	 * @param newName 変更させる名前
	 * @return 前の名前
	 */
	public String rename(String oldName,String newName) {
		NFD<?> data = get(oldName);
		String oldDataname = data.getName();
		data.setName(newName);
		remove(oldName);
		add(data);
		changedData = true;
		return oldDataname;
	}
	
	
	//------------------------------------------------------その他
	/**
	 * <h1>clear</h1>
	 * データを全て消去します<br>
	 */
	public void clear() {
		this.map.clear();
		this.keyList.clear();
		changedData = true;
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
	
	/**
	 * <h1>byteSizeUpdate</h1>
	 * データのサイズを更新します<br>
	 */
	public void byteSizeUpdate() {
		NFD<?>[] datas = getAll();
		for(NFD<?>data : datas) {
			bytesize += data.bytesize();
		}
		changedData = false;
	}
	
	/**
	 * <h1>bytesize</h1>
	 * このデータのバイトサイズを取得します<br>
	 * @return このデータのバイトサイズ
	 */
	public int bytesize() {
		if(changedData) {
			byteSizeUpdate();
		}
		return bytesize;
	}
	
	/**
	 * <h1>toByte</h1>
	 * データをbyte配列に変換します<br>
	 * @return byte配列データ
	 */
	public byte[] ToByte() {
		byte[] bytes = null;
		NFD<?>[] datas = getAll();
		for(NFD<?> data : datas) {
			try {
				bytes = ArraysUtility.addAll(bytes, data.toByte());
			}catch(NullPointerException e) {
				bytes = data.toByte();
			}
		}
		return bytes;
	}
	
	/**
	 * <h1>hasKey</h1>
	 * キーリストに指定したキーがマップされているかを取得します。<br>
	 * @param paramKey マップされているかを取得するキー
	 * @return マップされていた場合true、そうでない場合false
	 */
	public boolean hasKey(String paramKey) {
		return keyList.contains(paramKey);
	}
	
	
	//------------------------------------------------------Sort
	/**
	 * <h1>IndexMove</h1>
	 * 指定したインデックスのキーを指定した位置に移動させます<br>
	 * index から to 間の要素は、<br>
	 * index &lt; to の場合 左に <br>
	 * index &gt; to の場合 右にシフトされます
	 * 
	 * @param index 移動させるキーインデックス
	 * @param to 移動先
	 * @throws IndexOutOfBoundsException インデックスが範囲外の場合(index &lt; 0||index &gt;= size())
	 */
	public void IndexMove(int index,int to) {
		String key = Keyremove(index);
		addKey(to, key);
	}
	
	/**
	 * <h1>IndexMove</h1>
	 * 指定したキーを指定した位置に移動させます<br>
	 * 指定したキーが存在していなかった場合falseが返されます
	 * @param key 移動させるキー
	 * @param to 移動先
	 * @return 移動が成功した場合true、キーが存在しない、及び、何らかのエラーで移動に失敗した場合false
	 * @throws IndexOutOfBoundsException インデックスが範囲外の場合(index &lt; 0||index &gt;= size())
	 */
	public boolean IndexMove(String key,int to) {
		if(!hasKey(key)) return false;
		IndexMove(getKeyIndex(key), to);
		return true;
	}
	
	
	/**
	 * <h1>KeyisLast</h1>
	 * 指定したキーを最後の要素に移動させます<br>
	 * "key1","key2","key3"<br><br>
	 * 
	 * KeyLast("key1");<br><br>
	 * 
	 * "key2","key3","key1"<br>
	 * となります。キーが存在しなかった場合は-1を返し、キーリストには何も行いません
	 * @param key 最後にするキー
	 * @return キーがもともとあったインデックスを返します。キーが存在していなかった場合-1を返します
	 */
	public int KeyisLast(String key) {
		int index = getKeyIndex(key);
		if(index == -1) return -1;
		addKey(Keyremove(key));
		return index;
	}
	
	/**
	 * <h1>KeyisLast</h1>
	 * 指定したインデックスのキー要素を最後の要素に移動させます<br>
	 * @param index 移動させるキーのインデックス
	 * @return キーがもともとあったインデックスを返します。キーが存在していなかった場合-1を返します
	 */
	public String KeyisLast(int index) {
		String key = getKey(index);
		addKey(Keyremove(index));
		return key;
	}
	
}
