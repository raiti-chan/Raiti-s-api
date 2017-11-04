package raitichan.raitisapi.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import raitichan.raitisapi.util.AppVersion;


/**
 * アプリケーション及びクラスのバージョンのアノテーションです。<br>
 * {@link AppVersion}インターフェイスを使用すると簡単にVersionが取得できます。
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Version {
	
	/**
	 * バージョンデータのStringデータ<br>
	 * デフォルトは、"1.0.0"
	 *
	 * @return Stringバージョンデータ
	 */
	String value () default "1.0.0";
}
