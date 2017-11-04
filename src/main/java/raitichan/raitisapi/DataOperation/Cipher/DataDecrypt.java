package raitichan.raitisapi.DataOperation.Cipher;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * 暗号化データ復号クラス。<br>
 * このクラスは<br>
 * ・パスワード<br>
 * ・反復数(イテレータカウント)<br>
 * ・ソルト値<br>
 * の3つのパラメータを指定して鍵を生成します。
 * 但し、ソルト値はデフォルトで<br>
 * {@code -57, 115, 33, -116, 126, -56, -18, -103}<br>
 * がセットされています。
 * 暗号化に使用した鍵と、ここで生成した鍵が一致すれば複合化できます
 *
 * @author Raiti
 * @version 1.0.0
 */
public class DataDecrypt {
	
	/**
	 * パスワード
	 */
	private String pass;
	
	/**
	 * 暗号化化するデータ
	 */
	private byte[] bytes;
	
	/**
	 * 反復数
	 */
	private int Count;
	
	/**
	 * ソルト値
	 */
	private byte[] salt = {-57, 115, 33, -116, 126, -56, -18, -103};
	
	/**
	 * 生成されたPBEパラメーター
	 */
	private PBEParameterSpec pbeParameter;
	
	/**
	 * 生成された鍵
	 */
	private SecretKey key;
	
	/**
	 * 暗号化・複合化エンジン
	 */
	private Cipher cipher;
	
	/**
	 * パスワード、反復数を指定して、復号化オブジェクトを生成します。
	 *
	 * @param data  暗号化するデータ
	 * @param pass  暗号化パスワード
	 * @param count 反復数
	 */
	@SuppressWarnings("WeakerAccess")
	public DataDecrypt (byte[] data, String pass, int count) {
		this.bytes = data;
		this.pass = pass;
		this.Count = count;
	}
	
	/**
	 * パスワードを指定して、複号化オブジェクトを生成します。
	 * 反復数は2048でセットされます。
	 *
	 * @param data 暗号化するデータ
	 * @param pass 暗号化パスワード
	 */
	@SuppressWarnings("WeakerAccess")
	public DataDecrypt (byte[] data, String pass) {
		this(data, pass, 2048);
	}
	
	/**
	 * 反復数を指定して、複号化オブジェクトを生成します。
	 * パスワードは"NoPass"になります。
	 *
	 * @param data  暗号化するデータ
	 * @param count 反復数
	 */
	@SuppressWarnings("unused")
	public DataDecrypt (byte[] data, int count) {
		this(data, "NoPass", count);
	}
	
	/**
	 * 何も指定せずに、複号化オブジェクトを生成します。
	 * パスは"NoPass"<br>
	 * 反復数は2048<br>
	 * になります。
	 *
	 * @param data 暗号化するデータ
	 */
	@SuppressWarnings("unused")
	public DataDecrypt (byte[] data) {
		this(data, "NoPass");
	}
	
	/**
	 * PBEパラメーターを生成します。<br>
	 */
	@SuppressWarnings("unused")
	public void pBEParameterBuilder () {
		this.pbeParameter = new PBEParameterSpec(this.salt, this.Count);
	}
	
	/**
	 * 複号化する鍵を生成します。<br>
	 * PBEパラメータを生成してから実行してください。
	 */
	@SuppressWarnings({"unused", "Duplicates"})
	public void keyCreate () {
		try {
			char[] password = this.pass.toCharArray();
			PBEKeySpec pbeKey = new PBEKeySpec(password);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
			this.key = keyFactory.generateSecret(pbeKey);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 復号化をする直前の準備をします。<br>
	 * 全ての事前セットアップ。(鍵の生成)をしてから実行して下さい)
	 */
	@SuppressWarnings({"WeakerAccess", "unused"})
	public void setUp () {
		try {
			this.cipher = Cipher.getInstance("PBEWithMD5AndDES");
			this.cipher.init(2, this.key, this.pbeParameter);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | InvalidKeyException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * データを複号化します。<br>
	 * {@link DataDecrypt#setUp()}を実行してから実行してください。
	 *
	 * @return 複合化されたデータ
	 * @throws IllegalBlockSizeException この暗号がブロック暗号であり、パディングが要求されておらず(暗号化モードの場合のみ)、
	 *                                   この暗号で処理されたデータの入力長の合計がブロック・サイズの倍数でない場合。
	 *                                   または、この暗号化アルゴリズムが、指定された入力データを処理できない場合。
	 * @throws BadPaddingException       この暗号が復号化モードであり、パディング(またはパディング解除)が要求されたが、
	 *                                   復号化されたデータが適切なパディング・バイトでバインドされない場合。
	 */
	@SuppressWarnings("unused")
	public byte[] decrypt () throws IllegalBlockSizeException, BadPaddingException {
		return this.cipher.doFinal(this.bytes);
	}
	
	/**
	 * パスワードの取得<br>
	 *
	 * @return パスワード
	 */
	@SuppressWarnings("unused")
	public String getPass () {
		return this.pass;
	}
	
	/**
	 * パスワードの変更<br>
	 * 途中で実行するのはお勧めしません。
	 *
	 * @param pass パスワード
	 */
	@SuppressWarnings("unused")
	public void setPass (String pass) {
		this.pass = pass;
	}
	
	/**
	 * セットされたデータの取得<br>
	 *
	 * @return セットされたデータ
	 */
	@SuppressWarnings("unused")
	public byte[] getBytes () {
		return this.bytes;
	}
	
	/**
	 * 暗号化するデータのセット<br>
	 * 前のデータと置き換わります。
	 *
	 * @param bytes データ
	 */
	@SuppressWarnings("unused")
	public void setBytes (byte[] bytes) {
		this.bytes = bytes;
	}
	
	/**
	 * 反復数の取得<br>
	 *
	 * @return 反復数
	 */
	@SuppressWarnings("unused")
	public int getCount () {
		return this.Count;
	}
	
	/**
	 * 反復数のセット<br>
	 * 途中で実行するのはお勧めしません。
	 *
	 * @param count 反復数
	 */
	@SuppressWarnings("unused")
	public void setCount (int count) {
		this.Count = count;
	}
	
	/**
	 * ソルト値を取得します。<br>
	 *
	 * @return ソルト値
	 */
	@SuppressWarnings("unused")
	public byte[] getSalt () {
		return this.salt;
	}
	
	/**
	 * ソルト値をセットします。<br>
	 * 途中で実行するのはお勧めしません。
	 *
	 * @param salt ソルト値
	 */
	@SuppressWarnings("unused")
	public void setSalt (byte[] salt) {
		this.salt = salt;
	}
}
