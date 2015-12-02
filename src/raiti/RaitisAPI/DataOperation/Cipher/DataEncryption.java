package raiti.RaitisAPI.DataOperation.Cipher;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * <h1>DataEncryption</h1>
 * データ暗号化クラス<br>
 * このクラスは<br>
 * ・パスワード<br>
 * ・反復数(イテレータカウント)<br>
 * ・ソルト値<br>
 * の3つのパラメータを指定して鍵を生成します。
 * 但し、ソルト値はデフォルトで<br>
 * {@code -57, 115, 33, -116, 126, -56, -18, -103}<br>
 * がセットされています。
 * @author Raiti
 * @version 1.0.0
 *
 */
public class DataEncryption {
	
	/**
	 * パスワード
	 */
	private String pass;
	
	/**
	 * 暗号化するデータ
	 */
	private byte[] datas;
	
	/**
	 * 反復数
	 */
	private int Count;
	
	/**
	 * ソルト値
	 */
	private byte[] salt = { -57, 115, 33, -116, 126, -56, -18, -103 };
	
	/**
	 * 生成されたPBEパラメーター
	 */
	private PBEParameterSpec pbeParameter;
	
	/**
	 * 生成されたPBEキー
	 */
	private PBEKeySpec pbeKey;
	
	/**
	 * 生成されたキーファクトリー
	 */
	private SecretKeyFactory keyFactory;
	
	/**
	 * 生成された鍵
	 */
	private SecretKey key;
	
	/**
	 * 暗号化・複合化エンジン
	 */
	private Cipher cipher;
	
	/**
	 * <B>コンストラクター</B><br>
	 * @param data 暗号化するデータ
	 * @param pass 暗号化パスワード
	 * @param count 反復数
	 */
	public DataEncryption(byte[] data, String pass, int count) {
		setDatas(data);
		setPass(pass);
		setCount(count);
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * 反復数は2048でセットされます。
	 * @param data 暗号化するデータ
	 * @param pass 暗号化パスワード
	 */
	public DataEncryption(byte[] data, String pass) {
		this(data, pass, 2048);
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * パスワードは"NoPass"になります。
	 * @param data 暗号化するデータ
	 * @param count 反復数
	 */
	public DataEncryption(byte[] data, int count) {
		this(data, "NoPass", count);
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * パスは"NoPass"<br>
	 * 反復数は2048<br>
	 * になります。
	 * @param data 暗号化するデータ
	 */
	public DataEncryption(byte[] data) {
		this(data, "NoPass");
	}
	
	/**
	 * <h1>PBEParameterBuilder</h1>
	 * PBEパラメーターを生成します。<br>
	 */
	public void PBEParameterBuilder() {
		this.pbeParameter = new PBEParameterSpec(this.salt, this.Count);
	}
	
	/**
	 * <h1>KeyCreate</h1>
	 * 暗号化する鍵を生成します。<br>
	 * PBEパラメータを生成してから実行してください。
	 */
	public void KeyCreate() {
		try {
			char[] password = this.pass.toCharArray();
			this.pbeKey = new PBEKeySpec(password);
			this.keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
			this.key = this.keyFactory.generateSecret(this.pbeKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <h1>SetUp</h1>
	 * 暗号化をする直前の準備をします。<br>
	 * 全ての事前セットアップ。(鍵の生成)をしてから実行して下さい)
	 */
	public void SetUp() {
		try {
			this.cipher = Cipher.getInstance("PBEWithMD5AndDES");
			this.cipher.init(1, this.key, this.pbeParameter);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <h1>Encryption</h1>
	 * データを暗号化します。<br>
	 * {@link DataEncryption#SetUp()}を実行してから実行してください。
	 * @return 暗号化されたデータ
	 * @throws IllegalBlockSizeException この暗号がブロック暗号であり、パディングが要求されておらず(暗号化モードの場合のみ)、この暗号で処理されたデータの入力長の合計がブロック・サイズの倍数でない場合。または、この暗号化アルゴリズムが、指定された入力データを処理できない場合。
	 * @throws BadPaddingException この暗号が復号化モードであり、パディング(またはパディング解除)が要求されたが、復号化されたデータが適切なパディング・バイトでバインドされない場合。 
	 */
	public byte[] Encryption() throws IllegalBlockSizeException, BadPaddingException {
		byte[] cipherData = this.cipher.doFinal(this.datas);
		return cipherData;
	}
	
	/**
	 * <h1>getPass</h1>
	 * パスワードの取得<br>
	 * @return パスワード
	 */
	public String getPass() {
		return this.pass;
	}
	
	/**
	 * <h1>setPass</h1>
	 * パスワードの変更<br>
	 * 途中で実行するのはお勧めしません。
	 * @param pass パスワード
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * <h1>getDatas</h1>
	 * セットされたデータの取得<br>
	 * @return セットされたデータ
	 */
	public byte[] getDatas() {
		return this.datas;
	}
	
	/**
	 * <h1>setDatas</h1>
	 * 暗号化するデータのセット<br>
	 * 前のデータと置き換わります。
	 * @param datas データ
	 */
	public void setDatas(byte[] datas) {
		this.datas = datas;
	}
	
	/**
	 * <h1>getCount</h1>
	 * 反復数の取得<br>
	 * @return 反復数
	 */
	public int getCount() {
		return this.Count;
	}
	
	/**
	 * <h1>setCount</h1>
	 * 反復数のセット<br>
	 * 途中で実行するのはお勧めしません。
	 * @param count 反復数
	 */
	public void setCount(int count) {
		this.Count = count;
	}
	
	/**
	 * <h1>getSalt</h1>
	 * ソルト値を取得します。<br>
	 * @return ソルト値
	 */
	public byte[] getSalt() {
		return this.salt;
	}
	
	/**
	 * <h1>setSalt</h1>
	 * ソルト値をセットします。<br>
	 * 途中で実行するのはお勧めしません。
	 * @param salt ソルト値
	 */
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
}
