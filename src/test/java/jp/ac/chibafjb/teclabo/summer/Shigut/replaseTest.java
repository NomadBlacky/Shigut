package jp.ac.chibafjb.teclabo.summer.Shigut;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class replaseTest {

	@Test
	public void test() {

		String actual = "運営チームの意地を見せたい #shigut".replace("#shigut", "");
		System.out.println(actual);
		assertThat(actual, is("運営チームの意地を見せたい "));
	}

}
