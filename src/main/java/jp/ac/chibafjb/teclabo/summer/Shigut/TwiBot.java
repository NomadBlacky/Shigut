package jp.ac.chibafjb.teclabo.summer.Shigut;

import java.util.Random;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;

public class TwiBot {

	Twitter twitter = null;

	static String[] texts = {
			"%sに行きたいなぁ(*^_^*)",
			"%sが食べたいなぁ(*´▽｀*)",
			"%s買いたいなぁ(>_<)",
			"%sってなんだろう？(´-ω-`)",
			"%sがゴミのようだ！( *｀ω´)",
			"%s(/ω＼*)",
			"%s！",
			"%s～",
			"%sって美味しいよね(*´▽｀*)"
	};

	public TwiBot(Configuration config) {

		twitter = new TwitterFactory(config).getInstance();
	}

	public void tweet(String text) throws TwitterException {

		twitter.updateStatus(text);
	}

	public void tweetLearn(String word) throws TwitterException {

		twitter.updateStatus(word + "を覚えたよ。");
	}

	public void tweetRandom(String word) throws TwitterException {

		int i = new Random().nextInt(texts.length);
		System.out.println(texts[i]);
		String tweetText = String.format(texts[i], word);
		System.out.println("[TwiBot]" + tweetText);
		twitter.updateStatus(tweetText);
	}
}
