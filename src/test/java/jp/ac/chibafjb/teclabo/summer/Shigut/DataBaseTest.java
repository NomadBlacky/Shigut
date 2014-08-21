package jp.ac.chibafjb.teclabo.summer.Shigut;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.List;

import jp.ac.chibafjb.teclabo.summer.annotetion.Order;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataBaseTest {

	static DataBase db;

	@BeforeClass
	public static void setupClass() throws Exception {

		db = new DataBase("jdbc:sqlite:db/test.db");
	}

	@Test
	@Order(order=1)
	public void createPhraseTabletest() throws Exception {

		db.createPhraseTable();
	}

	@Test
	@Order(order=2)
	public void insertPhraseTest() throws Exception {

		db.insertPhrase(new Phrase("hogeuser", "ほげ～", 100));
		db.insertPhrase("hogeuser", "ふぉー", 40);
	}

	@Test
	@Order(order=3)
	public void getPhrasesByUserTest() throws Exception {

		List<Phrase> phrases = db.getPhrasesByUser("hogeuser");
		assertThat(phrases, hasItems(
				new Phrase("hogeuser", "ほげ～", 100),
				new Phrase("hogeuser", "ふぉー", 40))
				);
	}

	@Test
	@Order(order=4)
	public void printPhrasesTest() throws Exception {

		db.printPhrases();
	}

	@AfterClass
	@Order(order=5)
	public static void afterClass() throws Exception {
		db.deletePhrases();
	}

}
