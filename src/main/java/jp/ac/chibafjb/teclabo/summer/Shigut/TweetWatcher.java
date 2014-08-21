package jp.ac.chibafjb.teclabo.summer.Shigut;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TweetWatcher {
	public void Watcher() {

		// 認証キーを設定
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setOAuthConsumerKey("b85u4uPoSjmQGxpw8ecz0hkNV");
		builder.setOAuthConsumerSecret("sqSnRgTHrust2ApC34my4xCaoXKFsXnwlA9LDaAipLCQjROQYW");
		builder.setOAuthAccessToken("2751215797-OurAxPurG3DD50LoiNj9gXHfsAu0RB3l1jHyNCq");
		builder.setOAuthAccessTokenSecret("A0QdIpDP79N52OthL6pMbJW52zfdkdW1bv1gTRDd9FX2U");
		Configuration conf = builder.build();
		System.out.println("認証完了");

		TwitterStream stream = new TwitterStreamFactory(conf).getInstance();
		System.out.println("!!!!!");

		// /////////////////

		StatusListener statusListener = new StatusListener() {

			@Override
			public void onException(Exception arg0) {
				// TODO 自動生成されたメソッド・スタブ

			}

			@Override
			public void onTrackLimitationNotice(int arg0) {
				// TODO 自動生成されたメソッド・スタブ

			}

			@Override
			public void onStatus(Status status) {
				System.out.println(status.getText());
			}

			@Override
			public void onStallWarning(StallWarning arg0) {
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
		};

		// ///////////////

		stream.addListener(statusListener);

		FilterQuery filterQuery = new FilterQuery();

		filterQuery.track(new String[] {"#ff14"});
		stream.filter(filterQuery);
	}

	public static void main(String[] args) {
		TweetWatcher watcher = new TweetWatcher();
		watcher.Watcher();

	}

}
