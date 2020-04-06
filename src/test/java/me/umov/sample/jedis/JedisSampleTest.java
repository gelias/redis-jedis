package me.umov.sample.jedis;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class JedisSampleTest {

	private JedisSample jedis;

	@Before
	public void setup() {
		this.jedis = new JedisSample();
	}
	
	@Test
	public void shouldAddValueIntoRedis() {
		String keyToAdd = new Random(1231231232).toString();
		String valueToAdd = new Random(5555555).toString();
		jedis.addValue(keyToAdd, valueToAdd);
		jedis.removeValue(keyToAdd);
		jedis.closeDatabase();
	}
}