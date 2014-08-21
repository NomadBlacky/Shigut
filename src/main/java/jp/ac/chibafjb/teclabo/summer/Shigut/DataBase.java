package jp.ac.chibafjb.teclabo.summer.Shigut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * データベース操作を行うクラス
 * @author Blacky
 *
 */
public class DataBase {

	private Connection connection = null;
	private Statement statement = null;

	public DataBase(String path) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection(path);
		statement  = connection.createStatement();
	}

	/**
	 * Phraseテーブルが無ければ作成する
	 * @throws SQLException
	 */
	public void createPhraseTable() throws SQLException {

		Statement statement  = connection.createStatement();
		statement.executeUpdate("create table if not exists phrase(userid text, phrase text, score int)");
		statement.close();
	}

	/**
	 * フレーズ情報をテーブルに挿入
	 * @param userid ツイート発言ユーザ名
	 * @param phrase フレーズ
	 * @param score スコア
	 * @throws SQLException
	 */
	public void insertPhrase(String userid, String phrase, int score) throws SQLException {

		String sql = String.format(
				"insert into phrase values('%s', '%s', %d)",
				userid, phrase, score);

		statement.executeUpdate(sql);
	}

	/**
	 * フレーズ情報をテーブルに挿入
	 * @param phrase フレーズ情報
	 * @throws SQLException
	 */
	public void insertPhrase(Phrase phrase) throws SQLException {

		insertPhrase(phrase.getUser(), phrase.getPhrase(), phrase.getScore());
	}

	/**
	 * ユーザIDからフレーズ情報を取得
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public List<Phrase> getPhrasesByUser(String userId) throws SQLException {

		String sql = String.format(
				"select * from phrase where userid = '%s'", userId);
		ResultSet rSet = statement.executeQuery(sql);
		List<Phrase> phrases = new ArrayList<>();
		while (rSet.next()) {
			phrases.add(
					new Phrase(
							rSet.getString("userid"),
							rSet.getString("phrase"),
							rSet.getInt("score")
							));
		}

		return phrases;
	}

	/**
	 * 保存されているすべてのフレーズ情報を表示
	 */
	public void printPhrases() throws SQLException {

		ResultSet rSet = statement.executeQuery("select * from Phrase");
		int columnCount = rSet.getMetaData().getColumnCount();
		while (rSet.next()) {
			for(int i = 1; i <= columnCount; i++) {
				System.out.print(rSet.getString(i) + ", ");
			}
			System.out.println();
		}
	}

	/**
	 * フレーズ情報をすべて削除
	 * @throws SQLException
	 *
	 */
	public void deletePhrases() throws SQLException {

		statement.executeUpdate("delete from phrase");
	}
}
