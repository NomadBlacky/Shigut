package jp.ac.chibafjb.teclabo.summer.Shigut;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.conf.Configuration;

public class Listener extends TweetWatcher implements StatusListener {
public Listener(Configuration con) {
	bot = new TwiBot(conf);
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

	@Override
	public void onStatus(Status status) {

		String txtdata = status.getText();
		User user = status.getUser();
		String userId = user.getScreenName();

		// フレーズへ引数を渡す
		Phrase phraseData = KeyPhraseApi.getKeyPhrase(userId, txtdata);
		String text = phraseData.getPhrase();
		 pushDb(phraseData);
		try {
			bot.tweet("つぶやき");
		} catch (TwitterException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
	}

}
