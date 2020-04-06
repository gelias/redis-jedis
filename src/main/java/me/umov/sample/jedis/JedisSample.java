package me.umov.sample.jedis;

import redis.clients.jedis.Jedis;

public class JedisSample {

	private static Jedis jedis;

	public JedisSample() {
		Jedis jedis = database();
	}

	public void addValue(String key, String value) {

		try {
			System.out.println("Connecting to JEDIS ... ");
			System.out.println("Selecting index 2");
			database().select(2);
			database().set(key, value);
			System.out.println(database().get(key));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Jedis database() {

		if (jedis != null)
			return jedis;

		return new Jedis("192.168.150.56", 6379);
	}

	public void removeValue(String keyToDel) {
		database().del(keyToDel);
	}

	public void closeDatabase() {
		database().close();
	}
}
