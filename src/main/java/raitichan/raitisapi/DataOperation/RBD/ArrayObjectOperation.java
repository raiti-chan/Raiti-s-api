package raitichan.raitisapi.DataOperation.RBD;

import java.util.*;

import raitichan.raitisapi.DataOperation.RBD.Data.IntData;
import raitichan.raitisapi.DataOperation.RBD.Data.NFD;
import raitichan.raitisapi.arrays.ArraysUtility;

/**
 * <h1>ArrayObjectOperation</h1>
 * Objectデータの配列を操作するためのベースクラスです<br>
 * オブジェクト名とマップ名が一致していない場合は一部メソッドがエラーを出す可能性があります。
 * オブジェクト名とマップ名の不一致は非推奨です。
 * このデータもシュールはキーにインデックスが存在します
 *
 * @author Raiti
 * @version 1.0.0
 */
public abstract class ArrayObjectOperation {
	
	/**
	 * 格納されてるデータ配列
	 */
	protected HashMap<String, NFD<?>> map;
	
	/**
	 * 格納されているキーのリスト
	 */
	@SuppressWarnings("WeakerAccess")
	protected ArrayList<String> keyList;
	
	/**
	 * データのサイズ
	 */
	protected int byteSize = 0;
	
	/**
	 * このデータが変更されているか
	 */
	@SuppressWarnings("WeakerAccess")
	protected boolean changedData = false;
	
	//------------------------------------------------------コンストラクター
	
	/**
	 * 新しいデータモジュールを作成します。<br>
	 *
	 * @param data 初期値のマップデータ
	 */
	public ArrayObjectOperation (HashMap<String, NFD<?>> data) {
		this.keyList = new ArrayList<>();
		this.map = data;
		String[] keys = new String[0];
		keys = data.keySet().toArray(keys);
		for (String key : keys) {
			addKey(key);
		}
	}
	
	
	//------------------------------------------------------add
	
	/**
	 * 指定された値と指定されたキーをこのデータマップに追加します。
	 * 以前にこのキーのデータを保持していた場合、古い値が置き換えられます。<br>
	 * このメソッドでデータを追加した場合、オブジェクトデータの固有名と、
	 * キーの名前が一致されない場合があるので非推奨です。
	 * オブジェクト名とマップ名が一致していない場合は一部メソッドがエラーを出す可能性があります。
	 *
	 * @param key  データ名
	 * @param data 追加するデータ
	 * @return keyに以前に追加されていたデータ。
	 * keyのマッピングが存在しなかった場合はnull。戻り値nullは、マップが以前にnullとkeyを関連付けていたことを示す場合もある。
	 */
	@SuppressWarnings("WeakerAccess")
	protected NFD<?> add (String key, NFD<?> data) {
		NFD<?> retData = map.put(key, data);
		if (!addKey(key)) {
			keyIsLast(key);
		}
		changedData = true;
		return retData;
	}
	
	/**
	 * 指定された値と指定されたキーを指定したインデックスでこのデータマップに追加します。
	 * 以前にこのキーのデータを保持していた場合、古い値が置き換えられます。<br>
	 * このメソッドでデータを追加した場合、オブジェクトデータの固有名と、
	 * キーの名前が一致されない場合があるので非推奨です。
	 * オブジェクト名とマップ名が一致していない場合は一部メソッドがエラーを出す可能性があります。
	 *
	 * @param index データインデックス
	 * @param key   データキー
	 * @param data  追加するデータ
	 * @return keyに以前に追加されていたデータ。
	 * keyのマッピングが存在しなかった場合はnull。戻り値nullは、マップが以前にnullとkeyを関連付けていたことを示す場合もある。
	 * @throws IndexOutOfBoundsException インデックスが範囲外の場合(index < 0||index>= size())
	 */
	@SuppressWarnings("unused")
	protected NFD<?> add (int index, String key, NFD<?> data) {
		if (!addKey(index, key)) {
			indexMove(key, index);
		}
		NFD<?> retData = map.put(key, data);
		changedData = true;
		return retData;
	}
	
	/**
	 * 指定されたデータ({@link NFD})とそのデータの固有名をキーとしてこのデータマップに追加します。
	 * 以前に同じ名前のデータが格納されていた場合、古いデータが置き換えられます。<br>
	 * 置き換えた場合、データインデックスは最後になります。
	 * データインデックスを変えない場合は{@link #changeData(int, Object)}を使用してください
	 *
	 * @param data 追加するデータ
	 * @return 以前に同じ名前で追加されていたデータ。
	 * 同じ名前が存在しなかった場合はnull
	 */
	@SuppressWarnings("unused")
	public NFD<?> add (NFD<?> data) {
		NFD<?> retData = map.put(data.getName(), data);
		if (!addKey(data.getName())) {
			keyIsLast(data.getName());
		}
		changedData = true;
		return retData;
	}
	
	/**
	 * 指定されたデータ({@link NFD})とそのデータの固有名をキーとしてこのデータマップに追加します。
	 * 以前に同じ名前のデータが格納されていた場合、古いデータが置き換えられます。<br>
	 *
	 * @param index データインデックス
	 * @param data  追加するデータ
	 * @return 以前に同じ名前で追加されていたデータ。
	 * 同じ名前が存在しなかった場合はnull
	 * @throws IndexOutOfBoundsException インデックスが範囲外の場合(index < 0||index>= size())
	 */
	@SuppressWarnings("unused")
	public NFD<?> add (int index, NFD<?> data) {
		if (!addKey(index, data.getName())) {
			indexMove(data.getName(), index);
		}
		NFD<?> retData = map.put(data.getName(), data);
		changedData = true;
		return retData;
	}
	
	/**
	 * 指定されたデータ({@link NFD})配列とそのデータの固有名をキーとしてこの配列に追加します。
	 * 以前に同じ名前のデータが格納されていた場合、古いデータが置き換えられます。<br>
	 * 置き換えた場合、データインデックスは最後になります。
	 *
	 * @param datas 追加するデータ配列
	 * @return 以前に同じ名前で追加されていたデータ配列。
	 */
	@SuppressWarnings("WeakerAccess")
	public NFD<?>[] addAll (NFD<?>... datas) {
		NFD<?>[] buffer = new NFD<?>[datas.length];
		int loop = 0;
		for (NFD<?> data : datas) {
			buffer[loop] = this.map.put(data.getName(), data);
			if (!addKey(data.getName())) {
				keyIsLast(data.getName());
			}
			loop++;
		}
		changedData = true;
		return buffer;
	}
	
	/**
	 * 未実装
	 *
	 * @param index インデックス
	 * @param datas データ
	 * @return 以前に同じ名前で追加されていたデータ配列。
	 */
	@Deprecated
	@SuppressWarnings("unused")
	public NFD<?>[] addAll (int index, NFD<?>... datas) {
		return null;
	}
	
	/**
	 * 指定されたデータ({@link NFD})のリストをこの配列に追加します。
	 * 以前に同じ名前のデータが格納されていた場合、古いデータが置き換えられます。<br>
	 *
	 * @param datas 追加するデータリスト
	 * @return 以前に同じ名前で追加されていたデータ配列。
	 */
	@SuppressWarnings("unused")
	public NFD<?>[] addAll (List<NFD<?>> datas) {
		NFD<?>[] buffer = new NFD<?>[1];
		changedData = true;
		return addAll(datas.toArray(buffer));
	}
	
	/**
	 * マップを追加します。<br>
	 * データ名と対応するデータを引継ぎます。既に存在する名前のデータは前のデータが置き換わります。
	 *
	 * @param dataMap 追加するマップ
	 * @return 以前に同じ名前で追加されていたデータ配列。
	 */
	@SuppressWarnings("unused")
	public NFD<?>[] addMap (Map<String, NFD<?>> dataMap) {
		String[] names = new String[1];
		NFD<?>[] buffer = new NFD[dataMap.size()];
		names = dataMap.keySet().toArray(names);
		int i = 0;
		for (String name : names) {
			buffer[i] = add(name, dataMap.get(name));
			i++;
		}
		changedData = true;
		return buffer;
	}
	
	/**
	 * キーリストにキーを追加します。<br>
	 * キーがすでに存在している場合、追加せずfalseを返します
	 *
	 * @param key 追加するキー
	 * @return 追加された場合true、されなかった場合false
	 */
	@SuppressWarnings("WeakerAccess")
	protected boolean addKey (String key) {
		if (hasKey(key)) return false;
		keyList.add(key);
		return true;
	}
	
	/**
	 * キーリストに指定したインデックスにキーを追加します<br>
	 * キーがすでに存在している場合、追加せずfalseを返します。
	 *
	 * @param index 追加するインデックス
	 * @param key   追加するキー
	 * @return 追加された場合true、されなかった場合false
	 * @throws IndexOutOfBoundsException インデックスが範囲外の場合(index &lt; 0||index &gt;= size())
	 */
	@SuppressWarnings("WeakerAccess")
	protected boolean addKey (int index, String key) {
		if (hasKey(key)) return false;
		keyList.add(index, key);
		return true;
	}
	
	
	//------------------------------------------------------get
	
	/**
	 * 指定した名前のデータを取得します。指定した名前のデータが存在しない場合はnullが返ります。<br>
	 *
	 * @param dataName 取得するデータ名
	 * @return 指定した名前のデータ。その名前のデータが存在しない場合はnull
	 */
	@SuppressWarnings("WeakerAccess")
	public NFD<?> get (String dataName) {
		return map.get(dataName);
	}
	
	/**
	 * 指定したインデックスのデータを取得します。<br>
	 *
	 * @param index 取得するデータのインデックス
	 * @return 指定したインデックスのデータ
	 * @throws IndexOutOfBoundsException - インデックスが範囲外の場合(index < 0||index>= size())
	 */
	@SuppressWarnings("WeakerAccess")
	public NFD<?> get (int index) {
		return map.get(keyList.get(index));
	}
	
	/**
	 * 指定した名前のデータを複数取得します。指定した名前のデータが存在しない場合はnullが返ります。<br>
	 *
	 * @param dataNames 取得するデータ名
	 * @return 取得データの配列
	 */
	@SuppressWarnings("WeakerAccess")
	public NFD<?>[] getAll (String... dataNames) {
		NFD<?>[] datas = new NFD[dataNames.length];
		for (int i = 0, loop = datas.length; i < loop; i++) {
			datas[i] = this.map.get(dataNames[i]);
		}
		return datas;
	}
	
	/**
	 * 指定した名前リストのデータを複数取得します。指定した名前のデータが存在しない場合はnullが返ります。<br>
	 *
	 * @param dataNames 取得するデータ名リスト
	 * @return 取得データの配列
	 */
	@SuppressWarnings("unused")
	public NFD<?>[] getAll (List<String> dataNames) {
		String[] buffer = new String[1];
		return getAll(dataNames.toArray(buffer));
	}
	
	/**
	 * 格納されている全てのデータを配列で取得します。<br>
	 *
	 * @return 格納されている全てのデータ
	 */
	@SuppressWarnings("WeakerAccess")
	public NFD<?>[] getAll () {
		String[] names = new String[1];
		names = this.keyList.toArray(names);
		return getAll(names);
		
	}
	
	/**
	 * 格納されているMapを取得します。ここで取得したMapは内部のMapと連動します。<br>
	 *
	 * @return 格納されているMap
	 */
	@SuppressWarnings("unused")
	public HashMap<String, NFD<?>> getMap () {
		return this.map;
	}
	
	/**
	 * NFDを指定したオブジェクトで取得します。<br>
	 *
	 * @param dataMame データ名
	 * @param <F>      取得するデータ形式のクラス
	 * @return 指定したデータ名のオブジェクト
	 */
	@SuppressWarnings({"WeakerAccess", "unchecked"})
	public <F extends NFD<?>> F getNFD (String dataMame) {
		return (F) get(dataMame);
	}
	
	
	/**
	 * このグループ内のキーリストを取得します<br>
	 * 取得されるリストと内部のリストは同期しています。
	 * 分離して取得したい場合は{@link #getKeyList(List)}及び
	 *
	 * @return {@link #keyList}の参照
	 */
	@SuppressWarnings("unused")
	public ArrayList<String> getKeyList () {
		return keyList;
	}
	
	/**
	 * キーリストを取得します<br>
	 *
	 * @param list キーリスト格納先リスト
	 */
	@SuppressWarnings({"WeakerAccess", "unused"})
	public void getKeyList (List<String> list) {
		String[] keys = new String[keyList.size()];
		keyList.toArray(keys);
		Collections.addAll(list, keys);
	}
	
	/**
	 * キーリストの{@link List #toArray(Object[])}を実行します<br>
	 *
	 * @param list 配列が十分な大きさを持つ場合は、このリストの要素の格納先の配列。配列のサイズが十分でない場合は、同じ実行時の型で新しい配列が格納用として割り当てられる。
	 * @return リストの要素が格納されている配列
	 */
	@SuppressWarnings("unused")
	public String[] toKeyArray (String[] list) {
		return keyList.toArray(list);
	}
	
	/**
	 * 指定された要素がこのリスト内で検出された位置のインデックスを返します。
	 * 指定された要素がこのリストにない場合は -1を返します。
	 * つまり、(o==null ? get(i)==null : o.equals(get(i)))となる、インデックスiを返します。
	 * そのようなインデックスが存在しない場合は -1を返します。<br>
	 *
	 * @param key 検索する要素
	 * @return 指定された要素がリスト内で検出された位置のインデックス。その要素がリストにない場合は -1
	 */
	@SuppressWarnings("WeakerAccess")
	public int getKeyIndex (String key) {
		return keyList.indexOf(key);
	}
	
	/**
	 * 指定したインデックスのキーを取得します<br>
	 *
	 * @param index 取得するキーのインデックス
	 * @return 取得したキー
	 * @throws IndexOutOfBoundsException インデックスが範囲外の場合(index &lt; 0||index &gt;= size())
	 */
	@SuppressWarnings("WeakerAccess")
	public String getKey (int index) {
		return keyList.get(index);
	}
	
	/**
	 * <h1>getIntNFD</h1>
	 * NFDデータをInt型データとして取得します。フォーマットが違った場合はnullが返されます。<br>
	 *
	 * @param dataName データ名
	 * @return IntDataにキャストされたデータ。フォーマットが違った場合null
	 */
	@SuppressWarnings("unused")
	public IntData getIntNFD (String dataName) {
		NFD<?> data = getNFD(dataName);
		if (data.getFormat() == NFD.INT) {
			return (IntData) data;
		}
		return null;
	}
	
	//------------------------------------------------------remove
	
	/**
	 * 指定した名前のデータを消去します。<br>
	 *
	 * @param name 消去するデータ名ｓ
	 * @return 消去したデータ
	 */
	@SuppressWarnings("unused")
	public NFD<?> remove (String name) {
		NFD<?> retData = this.map.remove(name);
		keyRemove(name);
		changedData = true;
		return retData;
	}
	
	/**
	 * 指定した名前のデータを消去します。<br>
	 *
	 * @param names 消去するデータ名
	 * @return 消去したデータ
	 */
	@SuppressWarnings("unused")
	public NFD<?>[] removeAll (String... names) {
		NFD<?>[] datas = new NFD[names.length];
		int i = 0;
		for (String name : names) {
			datas[i] = this.map.remove(name);
			keyRemove(name);
			i++;
		}
		changedData = true;
		return datas;
	}
	
	/**
	 * キーリスト内から指定したインデックスの要素を消去します<br>
	 *
	 * @param index 消去する要素のインデックス
	 * @return 消去した要素
	 * @throws IndexOutOfBoundsException インデックスが範囲外の場合(index &lt; 0||index &gt;= size())
	 */
	@SuppressWarnings("WeakerAccess")
	protected String keyRemove (int index) {
		return keyList.remove(index);
	}
	
	/**
	 * キーリスト内から指定したキーを消去します<br>
	 *
	 * @param key 消去するキー
	 * @return 消去したキー、キーが存在しなかった場合null
	 */
	@SuppressWarnings("WeakerAccess")
	protected String keyRemove (String key) {
		int keyIndex = getKeyIndex(key);
		return keyIndex == -1 ? null : keyList.remove(keyIndex);
	}
	
	//------------------------------------------------------rename
	
	/**
	 * オブジェクト名及びオブジェクトマップ名を変更します<br>
	 * 変更先の名前がすでに登録されている場合nullを返して、名前変更を行いません。
	 *
	 * @param index   変更するデータインデックス
	 * @param newName 変更する名前
	 * @return 変更前の名前が返されます。変更先の名前がすでに登録されていた場合nullを返します
	 * @throws IndexOutOfBoundsException インデックスが範囲外の場合(index < 0||index>= size())
	 */
	@SuppressWarnings("WeakerAccess")
	public String rename (int index, String newName) {
		NFD<?> data = get(index);
		if (map.containsKey(newName)) return null;
		return data.setName(newName);
	}
	
	/**
	 * オブジェクト名及びオブジェクトマップ名を変更します<br>
	 * 変更するデータキーが登録されていない場合nullを返します。
	 * 変更先の名前がすでに登録されている場合nullを返して、名前変更を行いません。
	 *
	 * @param oldName 変更するデータ名
	 * @param newName 変更させる名前
	 * @return 変更前の名前が返されます。変更先の名前がすでに登録されていた場合nullを返します
	 */
	@SuppressWarnings("unused")
	public String rename (String oldName, String newName) {
		int index = keyList.indexOf(oldName);
		if (index == -1) return null;
		return rename(index, newName);
	}
	
	
	//------------------------------------------------------change
	
	/**
	 * 指定したインデックスのデータを書き換えます<br>
	 *
	 * @param index   データインデックス
	 * @param newData 書き換えるデータ
	 * @param <T>     書き換えるデータ形式のクラス
	 * @return 書き換える前のデータ
	 * @throws IndexOutOfBoundsException インデックスが範囲外の場合(index < 0||index>= size())
	 * @throws ClassCastException        変更するデータ型がすでにあるエントリーのフォーマットと一致しない場合にスローされます
	 */
	@SuppressWarnings({"unchecked", "WeakerAccess"})
	public <T> T changeData (int index, T newData) {
		NFD<?> data = get(index);
		Object oldData = data.setDataO(newData);
		return (T) oldData;
	}
	
	/**
	 * 指定したキーのデータを書き換えます<br>
	 * 指定した名前のデータが存在しない場合nullが返ります
	 *
	 * @param key     データキー
	 * @param newData 書き換えるデータ
	 * @param <T>     書き換えるデータ形式のクラス
	 * @return 書き換える前のデータ。データが存在しなかった場合null
	 * @throws ClassCastException 変更するデータ型がすでにあるエントリーのフォーマットと一致しない場合にスローされます
	 */
	@SuppressWarnings("unused")
	public <T> T changeData (String key, T newData) {
		int index = this.getKeyIndex(key);
		if (index == -1) {
			return null;
		}
		return changeData(index, newData);
	}
	
	
	//------------------------------------------------------その他
	
	/**
	 * データを全て消去します<br>
	 */
	@SuppressWarnings("unused")
	public void clear () {
		this.map.clear();
		this.keyList.clear();
		changedData = true;
	}
	
	/**
	 * 格納されているデータのsizeを全てUアップデートします<br>
	 */
	@SuppressWarnings("unused")
	public void allDataSizeUpdate () {
		NFD<?>[] datas = getAll();
		for (NFD<?> data : datas) {
			data.dataSizeUpData();
		}
	}
	
	/**
	 * データのサイズを更新します<br>
	 */
	@SuppressWarnings("WeakerAccess")
	public void byteSizeUpdate () {
		NFD<?>[] datas = getAll();
		for (NFD<?> data : datas) {
			byteSize += data.byteSize();
		}
		changedData = false;
	}
	
	/**
	 * このデータのバイトサイズを取得します<br>
	 *
	 * @return このデータのバイトサイズ
	 */
	@SuppressWarnings("WeakerAccess")
	public int byteSize () {
		if (changedData) {
			byteSizeUpdate();
		}
		return byteSize;
	}
	
	/**
	 * データをbyte配列に変換します<br>
	 *
	 * @return byte配列データ
	 */
	@SuppressWarnings("WeakerAccess")
	public byte[] toByte () {
		byte[] bytes = null;
		NFD<?>[] datas = getAll();
		for (NFD<?> data : datas) {
			try {
				bytes = ArraysUtility.addAll(bytes, data.toByte());
			} catch (NullPointerException e) {
				bytes = data.toByte();
			}
		}
		return bytes;
	}
	
	/**
	 * キーリストに指定したキーがマップされているかを取得します。<br>
	 *
	 * @param paramKey マップされているかを取得するキー
	 * @return マップされていた場合true、そうでない場合false
	 */
	@SuppressWarnings("WeakerAccess")
	public boolean hasKey (String paramKey) {
		return keyList.contains(paramKey);
	}
	
	
	//------------------------------------------------------Sort
	
	/**
	 * 指定したインデックスのキーを指定した位置に移動させます<br>
	 * index から to 間の要素は、<br>
	 * index &lt; to の場合 左に <br>
	 * index &gt; to の場合 右にシフトされます
	 *
	 * @param index 移動させるキーインデックス
	 * @param to    移動先
	 * @throws IndexOutOfBoundsException インデックスが範囲外の場合(index &lt; 0||index &gt;= size())
	 */
	@SuppressWarnings("WeakerAccess")
	public void indexMove (int index, int to) {
		String key = keyRemove(index);
		addKey(to, key);
	}
	
	/**
	 * 指定したキーを指定した位置に移動させます<br>
	 * 指定したキーが存在していなかった場合falseが返されます
	 *
	 * @param key 移動させるキー
	 * @param to  移動先
	 * @return 移動が成功した場合true、キーが存在しない、及び、何らかのエラーで移動に失敗した場合false
	 * @throws IndexOutOfBoundsException インデックスが範囲外の場合(index &lt; 0||index &gt;= size())
	 */
	@SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
	public boolean indexMove (String key, int to) {
		if (!hasKey(key)) return false;
		indexMove(getKeyIndex(key), to);
		return true;
	}
	
	
	/**
	 * 指定したキーを最後の要素に移動させます<br>
	 * "key1","key2","key3"<br><br>
	 * <p>
	 * KeyLast("key1");<br><br>
	 * <p>
	 * "key2","key3","key1"<br>
	 * となります。キーが存在しなかった場合は-1を返し、キーリストには何も行いません
	 *
	 * @param key 最後にするキー
	 * @return キーがもともとあったインデックスを返します。キーが存在していなかった場合-1を返します
	 */
	@SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
	public int keyIsLast (String key) {
		int index = getKeyIndex(key);
		if (index == -1) return -1;
		addKey(keyRemove(key));
		return index;
	}
	
	/**
	 * <h1>keyIsLast</h1>
	 * 指定したインデックスのキー要素を最後の要素に移動させます<br>
	 *
	 * @param index 移動させるキーのインデックス
	 * @return キーがもともとあったインデックスを返します。キーが存在していなかった場合-1を返します
	 */
	@SuppressWarnings("unused")
	public String keyIsLast (int index) {
		String key = getKey(index);
		addKey(keyRemove(index));
		return key;
	}
	
}
