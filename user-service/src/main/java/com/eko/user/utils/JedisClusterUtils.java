package com.eko.user.utils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

public class JedisClusterUtils {
	// 配置master名称
	private static final String MASTER_NAME = "mymaster";
	// 配置master密码
	private static final String MASTER_PASSWORD = "123456";
	// 配置哨兵地址，多个地址用“,”隔开
	private static final String SENTINEL_HOSTS = "192.168.56.203:26379,192.168.56.204:26379,192.168.56.205:26379";
	
	private static JedisSentinelPool jedisPool;

	static {
		// 连接池配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(5000);
		config.setMaxIdle(256);
		config.setMaxWaitMillis(5000L);
		config.setTestOnBorrow(true);
		config.setTestOnReturn(true);
		config.setTestWhileIdle(true);
		config.setMinEvictableIdleTimeMillis(60000L);
		config.setTimeBetweenEvictionRunsMillis(3000L);
		config.setNumTestsPerEvictionRun(-1);

		Set<String> sentinels = new HashSet<String>();
		for (String sentinelHost : SENTINEL_HOSTS.split(",")) {
			sentinels.add(sentinelHost);			
		}
		
		jedisPool = new JedisSentinelPool(MASTER_NAME, sentinels, config, MASTER_PASSWORD);
	}


	@SuppressWarnings("deprecation")
	public static String get(String key) {
		String value = null;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			value = jedis.get(key);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
		return value;
	}

	@SuppressWarnings("deprecation")
	public static void close(Jedis jedis) {
		try {
			jedisPool.returnResource(jedis);
		} catch (Exception e) {
			if (jedis.isConnected()) {
				jedis.quit();
				jedis.disconnect();
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static byte[] get(byte[] key) {
		byte[] value = null;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			value = jedis.get(key);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}

		return value;
	}

	@SuppressWarnings("deprecation")
	public static void set(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
	}

	@SuppressWarnings("deprecation")
	public static void set(String key, String value, int time) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
			jedis.expire(key, time);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
	}

	@SuppressWarnings("deprecation")
	public static void set(byte[] key, byte[] value, int time) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
			jedis.expire(key, time);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
	}

	@SuppressWarnings("deprecation")
	public static void hset(byte[] key, byte[] field, byte[] value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.hset(key, field, value);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
	}

	@SuppressWarnings("deprecation")
	public static void hset(String key, String field, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.hset(key, field, value);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
	}

	@SuppressWarnings("deprecation")
	public static String hget(String key, String field) {
		String value = null;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			value = jedis.hget(key, field);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}

		return value;
	}

	@SuppressWarnings("deprecation")
	public static byte[] hget(byte[] key, byte[] field) {
		byte[] value = null;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			value = jedis.hget(key, field);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}

		return value;
	}

	@SuppressWarnings("deprecation")
	public static void hdel(byte[] key, byte[] field) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.hdel(key, new byte[][] { field });
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
	}

	@SuppressWarnings("deprecation")
	public static void lpush(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.lpush(key, new String[] { value });
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
	}

	@SuppressWarnings("deprecation")
	public static void rpush(byte[] key, byte[] value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.rpush(key, new byte[][] { value });
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
	}

	@SuppressWarnings("deprecation")
	public static void rpoplpush(byte[] key, byte[] destination) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.rpoplpush(key, destination);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
	}

	@SuppressWarnings("deprecation")
	public static List<byte[]> lpopList(byte[] key) {
		List<byte[]> list = null;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			list = jedis.lrange(key, 0L, -1L);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}

		return list;
	}

	@SuppressWarnings("deprecation")
	public static String rpop(String key) {
		String bytes = null;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			bytes = jedis.rpop(key);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}

		return bytes;
	}

	@SuppressWarnings("deprecation")
	public static List<byte[]> lrange(byte[] key, int from, int to) {
		List<byte[]> result = null;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.lrange(key, from, to);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}

		return result;
	}

	@SuppressWarnings("deprecation")
	public static void del(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.del(key);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
	}

	@SuppressWarnings("deprecation")
	public static long llen(byte[] key) {
		long len = 0L;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.llen(key);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			close(jedis);
		}
		return len;
	}
}