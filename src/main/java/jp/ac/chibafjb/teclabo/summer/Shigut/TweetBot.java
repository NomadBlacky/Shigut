package jp.ac.chibafjb.teclabo.summer.Shigut;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TweetBot extends Listener{

	public void tweet2(String txt) throws TwitterException{

		// 認証キーを設定
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setOAuthConsumerKey("b85u4uPoSjmQGxpw8ecz0hkNV");
		builder.setOAuthConsumerSecret("sqSnRgTHrust2ApC34my4xCaoXKFsXnwlA9LDaAipLCQjROQYW");
		builder.setOAuthAccessToken("2751215797-OurAxPurG3DD50LoiNj9gXHfsAu0RB3l1jHyNCq");
		builder.setOAuthAccessTokenSecret("A0QdIpDP79N52OthL6pMbJW52zfdkdW1bv1gTRDd9FX2U");
		Configuration conf = builder.build();
		System.out.println("ok?");
		// 初期設定
		Twitter twitter = new TwitterFactory(conf).getInstance();

		Status status = twitter.updateStatus(txt+"を覚えたよ！！お兄ちゃん！！！！！！！！！！！！！");


	}

}
