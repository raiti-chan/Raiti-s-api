package raitichan.raitisapi.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;

/**
 * {@link java.io.File}を拡張したFileクラス<br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public class File extends java.io.File {
	
	/**
	 * エラーが発生した際に処理するクラス。
	 */
	private IFileErrorProgram Program = null;
	
	/**
	 * 指定されたfile: URIを抽象パス名に変換して、新しいFileのインスタンスを生成します。
	 *
	 * @param uri ファイルパス
	 */
	@SuppressWarnings("unused")
	public File (URI uri) {
		super(uri);
	}
	
	/**
	 * 親パス名文字列および子パス名文字列から新しいFileのインスタンスを生成します。
	 *
	 * @param parent 親パス名文字列
	 * @param child  子パス名文字列
	 */
	@SuppressWarnings("unused")
	public File (String parent, String child) {
		super(parent, child);
	}
	
	/**
	 * 指定されたパス名文字列を抽象パス名に変換して、新しいFileのインスタンスを生成します。
	 * 指定された文字列が空の文字列の場合、結果は空の抽象パス名になります。
	 *
	 * @param pathname パス名文字列
	 */
	@SuppressWarnings("WeakerAccess")
	public File (String pathname) {
		super(pathname);
	}
	
	/**
	 * 親抽象パス名および子パス名文字列から新しいFileのインスタンスを生成します。
	 *
	 * @param parent 親抽象パス名
	 * @param child  子パス名文字列
	 */
	@SuppressWarnings("unused")
	public File (java.io.File parent, String child) {
		super(parent, child);
	}
	
	/**
	 * ファイルを指定したパスにコピーします。<br>
	 *
	 * @param URL コピー先パス
	 * @return コピーされたファイル
	 * @throws IOException 読み取りまたは書込み中に入出力エラーが発生した場合。
	 */
	@SuppressWarnings("unused")
	public File Copy (String URL) throws IOException {
		File out = new File(URL);
		boolean result = out.makeDir();
		try (FileOutputStream output = new FileOutputStream(URL)) {
			Files.copy(toPath(), output);
			output.close();
		}
		return out;
	}
	
	/**
	 * ファイルを作成します<br>
	 * 親フォルダーも一緒に作成します<br>
	 * このメソッドは例外をスローしません。<br>
	 * 作成できない(例外が発生した)場合の処理は{@link IFileErrorProgram}に記載します。
	 *
	 * @return 作成できた場合はtrue、できなければfalse、ファイルが既に存在する場合は作成できません。
	 */
	@SuppressWarnings({"WeakerAccess", "unused"})
	public boolean MakeFile () {
		String Path = getPath();
		if (exists()) {
			return false;
		}
		String[] dirs = Path.split("\\\\");
		StringBuilder directory = new StringBuilder();
		for (int i = 0; i < dirs.length - 1; i++) {
			directory.append(dirs[i]).append("\\");
		}
		File directoryFile = new File(directory.toString());
		if (!directoryFile.exists()) {
			boolean result = directoryFile.mkdirs();
		}
		try {
			boolean result = this.createNewFile();
		} catch (IOException e) {
			if (this.Program != null) {
				this.Program.Invoke(e);
			}
			return false;
		}
		return true;
	}
	
	/**
	 * 親フォルダーを作成します。<br>
	 * このファイルオブジェクト自体のファイル、及びフォルダーは作成されません。
	 *
	 * @return 作成できた場合true、できなかった場合false
	 */
	@SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
	public boolean makeDir () {
		String Path = getPath();
		String[] dirs = Path.split("\\\\");
		StringBuilder directory = new StringBuilder();
		for (int i = 0; i < dirs.length - 1; i++) {
			directory.append(dirs[i]).append("\\");
		}
		File directoryFile = new File(directory.toString());
		return directoryFile.mkdirs();
	}
	
	/**
	 * セットされたエラー処理用クラスを取得します。<br>
	 *
	 * @return {@link IFileErrorProgram}エラー処理クラス。
	 */
	@SuppressWarnings("unused")
	public IFileErrorProgram getProgram () {
		return this.Program;
	}
	
	/**
	 * エラー処理クラスをセットします<br>
	 *
	 * @param program {@link IFileErrorProgram}エラー処理クラス。
	 */
	@SuppressWarnings("unused")
	public void setProgram (IFileErrorProgram program) {
		this.Program = program;
	}
	
	/**
	 * エラー処理クラスを未設定(null)にします。<br>
	 */
	@SuppressWarnings("unused")
	public void removeProgram () {
		this.Program = null;
	}
}
