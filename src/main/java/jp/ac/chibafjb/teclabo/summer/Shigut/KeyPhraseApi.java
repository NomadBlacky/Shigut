package jp.ac.chibafjb.teclabo.summer.Shigut;


/**
 * キーフレーズAPI利用クラス
 * ユーザーIDと調べたい文章を渡して一番重要度の高いキーフレーズを返す
 * @author RaimuEr
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class KeyPhraseApi {
	//appid/url
	private static String appid		="dj0zaiZpPUxOYkJjMDBKaURwZCZzPWNvbnN1bWVyc2VjcmV0Jng9NzA-";
	private static String base_url	="http://jlp.yahooapis.jp/KeyphraseService/V1/extract";

	public static Phrase getKeyPhrase(String userId,String sentence){
		//return
		Phrase result=null;
		try {
			sentence = sentence.replaceAll("#shigut","");
			sentence = sentence.trim();
			System.out.println(sentence);
			sentence = URLEncoder.encode(sentence, "UTF-8");
			System.out.println(sentence);
			String urlString = base_url+"?appid="+appid+"&sentence="+sentence;
			URL url = new URL(urlString);
			System.out.println(url);
			//connection
			HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();
//			httpCon.setRequestMethod("GET");
			httpCon.setRequestMethod("POST");
			httpCon.setInstanceFollowRedirects(false);
			httpCon.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
			//phrasechk
			reader.readLine();
			reader.readLine();
			reader.readLine();
			String topKeyPhrase=reader.readLine().split("<|>")[2];
			int topScore=Integer.parseInt(reader.readLine().split("<|>")[2]);
			reader.readLine();
			String nowKeyPhrase;
			int nowScore;
			while(!reader.readLine().equals("</ResultSet>")){
				nowKeyPhrase=reader.readLine().split("<|>")[2];
				nowScore=Integer.parseInt(reader.readLine().split("<|>")[2]);
				if(topScore<nowScore){
					topKeyPhrase=nowKeyPhrase;
					topScore=nowScore;
				}
				reader.readLine();
			}
			//result
			System.out.println(topKeyPhrase);
			result=new Phrase(userId,topKeyPhrase,topScore);
			//close,disconnect
			reader.close();
			httpCon.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
/*
	public static void main(String[] args) {
		System.out.println(getKeyPhrase("Raimu","本日の調子はいかがでしょうか？体調がいいようでしたら、バハへいきませんか？").getPhrase());
	}
*/
}
