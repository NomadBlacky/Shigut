package jp.ac.chibafjb.teclabo.summer.Shigut;

/**
 * ハッシュタグ[#shigut]を監視して、発言内容をString型として格納するクラス
 * @author Shigure242
 *
 */
import java.sql.SQLException;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TweetWatcher implements StatusListener {
	public TweetWatcher() {
		try {
			db = new DataBase("jdbc:sqlite:db/test.db");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	DataBase db = null;

	public void Watcher() {

		// 認証キーを設定
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setOAuthConsumerKey("b85u4uPoSjmQGxpw8ecz0hkNV");
		builder.setOAuthConsumerSecret("sqSnRgTHrust2ApC34my4xCaoXKFsXnwlA9LDaAipLCQjROQYW");
		builder.setOAuthAccessToken("2751215797-OurAxPurG3DD50LoiNj9gXHfsAu0RB3l1jHyNCq");
		builder.setOAuthAccessTokenSecret("A0QdIpDP79N52OthL6pMbJW52zfdkdW1bv1gTRDd9FX2U");
		Configuration conf = builder.build();

		// 初期設定
		TwitterStream stream = new TwitterStreamFactory(conf).getInstance();
		System.out.println("!!!!!");

		stream.addListener(new TweetWatcher());

		// フィルタ
		FilterQuery filterQuery = new FilterQuery();

		filterQuery.track(new String[] { "#ff14" });
		stream.filter(filterQuery);
	}

	public static void main(String[] args) {
		TweetWatcher watcher = new TweetWatcher();
		watcher.Watcher();

	}

	@Override
	public void onException(Exception arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

	/**
	 *あとで記入
	 */
	@Override
	public void onStatus(Status status) {
		String txtdata = status.getText();
		User user = status.getUser();
		String userId = user.getName();
		// フレーズへ引数を渡す
		Phrase phraseData = KeyPhraseApi.getKeyPhrase(userId, txtdata);
		pushDb(phraseData);

	}

	/**
	 * あとで記入
	 * @param phraseData フレーズデータ
	 */
	public void pushDb(Phrase phraseData) {

		try {
			db.insertPhrase(phraseData);
			db.printPhrases();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
