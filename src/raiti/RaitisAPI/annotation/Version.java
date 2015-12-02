package raiti.RaitisAPI.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <h1>Version</h1>
 * アプリケーション及びクラスのバージョンのアノテーションです。
 * <h2>使い方</h2>
 * {@code Version ver = 取得するバージョンのクラス.class.getAnnotation(Version.class);}<br>
 * {@code String verText = ver.value;}<br>
 * とする
 * 
 * @author Raiti
 * @version 1.0.0
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Version {
	/**
	 * <h1>value</h1><br>
	 * バージョンデータのStringデータ<br>
	 * デフォルトは、"1.0.0"
	 * @return Stringバージョンデータ
	 */
	String value() default "1.0.0";
}
