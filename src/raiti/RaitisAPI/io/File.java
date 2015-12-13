package raiti.RaitisAPI.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;

import raiti.RaitisAPI.io.File;
import raiti.RaitisAPI.io.FileErrorProgran;

/**
 * <h1>File</h1>
 * {@link java.io.File}を拡張したFileクラス<br>
 * @author Raiti
 * @version 1.0.0
 *
 */
public class File extends java.io.File {
	
	/**
	 * エラーが発生した際に処理するクラス。
	 */
	private FileErrorProgran Program = null;
	
	/**
	 * <B>コンストラクター</B><br>
	 * @param uri ファイルパス
	 */
	public File(URI uri) {
		super(uri);
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * @param parent 親パス名文字列
	 * @param child 子パス名文字列
	 */
	public File(String parent, String child) {
		super(parent, child);
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * @param pathname パス名文字列
	 */
	public File(String pathname) {
		super(pathname);
	}
	
	/**
	 * <B>コンストラクター</B><br>
	 * @param parent 親抽象パス名
	 * @param child 子パス名文字列
	 */
	public File(java.io.File parent, String child) {
		super(parent, child);
	}
	
	/**
	 * <h1>Copy</h1>
	 * ファイルを指定したパスにコピーします。<br>
	 * @param URL コピー先パス
	 * @return コピーされたファイル
	 * @throws FileNotFoundException ファイルが存在するが通常ファイルではなくディレクトリである場合、存在せず作成もできない場合、またはなんらかの理由で開くことができない場合
	 * @throws IOException 読み取りまたは書込み中に入出力エラーが発生した場合。
	 */
	public File Copy(String URL) throws FileNotFoundException, IOException {
		File out = new File(URL);
		out.MakeDir();
		FileOutputStream output = new FileOutputStream(URL);
		Files.copy(toPath(), output);
		output.close();
		return out;
	}
	
	/**
	 * <h1>MakeFile</h1>
	 * ファイルを作成します<br>
	 * 親フォルダーも一緒に作成します<br>
	 * このメソッドは例外をスローしません。<br>
	 * 作成できない(例外が発生した)場合の処理は{@link FileErrorProgran}に記載します。
	 * @return 作成できた場合はtrue、できなければfalse、ファイルが既に存在する場合は作成できません。
	 */
	public boolean MakeFile() {
		String Path = getPath();
		if (exists()) {
			return false;
		}
		String[] dirs = Path.split("\\\\");
		String directry = "";
		for (int i = 0; i < dirs.length - 1; i++) {
			directry = directry + dirs[i] + "\\";
		}
		File directryFile = new File(directry);
		if (!directryFile.exists()) {
			directryFile.mkdirs();
		}
		try {
			createNewFile();
		} catch (IOException e) {
			if (this.Program != null) {
				this.Program.MakeFileError(e);
			}
			return false;
		}
		return true;
	}
	
	/**
	 * <h1>MakeDir</h1>
	 * 親フォルダーを作成します。<br>
	 * このファイルオブジェクト自体のファイル、及びフォルダーは作成されません。
	 * @return 作成できた場合true、できなかった場合false
	 */
	public boolean MakeDir() {
		String Path = getPath();
		String[] dirs = Path.split("\\\\");
		String directry = "";
		for (int i = 0; i < dirs.length - 1; i++) {
			directry = directry + dirs[i] + "\\";
		}
		File directryFile = new File(directry);
		if (directryFile.exists()) {
			return false;
		}
		directryFile.mkdirs();
		return true;
	}
	
	/**
	 * <h1>getProgram</h1>
	 * セットされたエラー処理用クラスを取得します。<br>
	 * @return {@link FileErrorProgran}エラー処理クラス。
	 */
	public FileErrorProgran getProgram() {
		return this.Program;
	}
	
	/**
	 * <h1>setProgram</h1>
	 * エラー処理クラスをセットします<br>
	 * @param program {@link FileErrorProgran}エラー処理クラス。
	 */
	public void setProgram(FileErrorProgran program) {
		this.Program = program;
	}
	
	/**
	 * <h1>removeProgran</h1>
	 * エラー処理クラスを未設定(null)にします。<br>
	 */
	public void removeProgran() {
		this.Program = null;
	}
}
