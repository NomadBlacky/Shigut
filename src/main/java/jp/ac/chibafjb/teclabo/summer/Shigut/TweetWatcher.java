package jp.ac.chibafjb.teclabo.summer.Shigut;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TweetWatcher {
	public void Watcher() {

	}

	public static void main(String[] args) throws TwitterException {
//		TweetWatcher watcher = new TweetWatcher();
//		watcher.Watcher();




			// 認証キーを設定
			ConfigurationBuilder builder = new ConfigurationBuilder();
			builder.setOAuthConsumerKey("b85u4uPoSjmQGxpw8ecz0hkNV");
			builder.setOAuthConsumerSecret("sqSnRgTHrust2ApC34my4xCaoXKFsXnwlA9LDaAipLCQjROQYW");
			builder.setOAuthAccessToken("2751215797-OurAxPurG3DD50LoiNj9gXHfsAu0RB3l1jHyNCq");
			builder.setOAuthAccessTokenSecret("A0QdIpDP79N52OthL6pMbJW52zfdkdW1bv1gTRDd9FX2U");
			Configuration conf = builder.build();
			System.out.println("認証完了");

			//初期化
			Twitter twitter = new TwitterFactory(conf).getInstance();
			Query query = new Query();
			System.out.println("初期化完了");
			//検索条件
			query.setQuery("バルス");
			query.setCount(1);
			System.out.println("条件完了");

			QueryResult result = twitter.search(query);
			System.out.println("ヒット数" + result.getTweets().size());
	}
}
