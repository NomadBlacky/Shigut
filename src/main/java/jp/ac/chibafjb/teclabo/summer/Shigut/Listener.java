package jp.ac.chibafjb.teclabo.summer.Shigut;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.User;

public class Listener extends TweetWatcher implements StatusListener {

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
		TweetBot tb = new TweetBot();
		 pushDb(phraseData);
		try {
			tb.tweet2(text);
		} catch (TwitterException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
	}

}
