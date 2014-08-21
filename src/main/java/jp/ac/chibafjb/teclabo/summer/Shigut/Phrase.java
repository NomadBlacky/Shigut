package jp.ac.chibafjb.teclabo.summer.Shigut;

/**
 * キーフレーズ抽出APIから返されるフレーズとスコアを保持するクラス
 * @author Blacky
 *
 */
public class Phrase {

	private String user;
	private String phrase;
	private int score;

	public Phrase(String userid, String phrase, int score) {
		this.user = userid;
		this.phrase = phrase;
		this.score = score;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
