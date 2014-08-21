package jp.ac.chibafjb.teclabo.summer.Shigut;

/**
 * ハッシュタグ[#shigut]を監視して、発言内容をString型として格納するクラス
 * @author Shigure242
 *
 */
import java.sql.SQLException;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TweetWatcher {

	public TweetWatcher() {

		try {
			db = new DataBase("jdbc:sqlite:db/test.db");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public String x = "aaaa";
	DataBase db = null;
	Configuration conf = null;

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

		stream.addListener(new Listener());

		// フィルタ
		FilterQuery filterQuery = new FilterQuery();

		filterQuery.track(new String[] { "#shigut" });
		stream.filter(filterQuery);
	}

	public static void main(String[] args) {
		TweetWatcher watcher = new TweetWatcher();
		watcher.Watcher();

	}

	public void pushDb(Phrase phraseData) {

		try {
			db.insertPhrase(phraseData);
			db.printPhrases();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Configuration getConf() {
		return conf;
	}
}
