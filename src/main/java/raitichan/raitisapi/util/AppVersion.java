package raitichan.raitisapi.util;

import raitichan.raitisapi.annotation.Version;

/**
 * Version定義を取得するインターフェイスです。<br>
 * 実装したクラスに付けられた、{@link Version}アノテーションの情報を取得します。
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AppVersion {
	
	/**
	 * 引数で渡されたクラスにつけられたVersionを取得します。
	 *
	 * @param clazz Versionを取得するクラス
	 * @return Version
	 * @throws NullPointerException {@link Version}アノテーションがつけられてない場合にスローされます。
	 */
	@SuppressWarnings("unused")
	static String getVersionFromClass (Class<?> clazz) {
		if (clazz == null) throw new NullPointerException("引数のクラスがnullです");
		Version versionA = clazz.getAnnotation(Version.class);
		//TODO:独自例外に
		if (versionA == null) throw new NullPointerException("クラスが Versionアノテーションを持っていません！！");
		return versionA.value();
	}
	
	/**
	 * クラスにつけられたVersionを取得します。
	 *
	 * @return Version文字列
	 * @throws NullPointerException {@link Version}アノテーションがつけられてない場合にスローされます。
	 */
	default String getVersion () {
		Version versionA = this.getClass().getAnnotation(Version.class);
		//TODO:独自例外に
		if (versionA == null) throw new NullPointerException("クラスが Versionアノテーションを持っていません！！");
		return versionA.value();
	}
}
