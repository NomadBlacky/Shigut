package jp.ac.chibafjb.teclabo.summer.Shigut;

import java.util.Random;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;

public class TwiBot {

	Random random;

	public TwiBot() {
		random = new Random();
	}

	Twitter twitter = null;

	String[] texts = {
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

		String tweetText = String.format(texts[random.nextInt(texts.length)], word);
		twitter.updateStatus(tweetText);
	}
}
