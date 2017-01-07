package raiti.RaitisAPI.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * アプリケーション及びクラスのバージョンのアノテーションです。<br>
 * {@link raiti.RaitisAPI.util.AppVersion}インターフェイスを使用すると簡単にVersionが取得できます。
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
	String value() default "1.0.0";
}
