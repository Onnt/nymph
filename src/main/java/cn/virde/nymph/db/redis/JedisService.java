package cn.virde.nymph.db.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis服务
 * @author Virde
 * 2018年7月27日 下午1:32:48
 */
public class JedisService {
	
	private JedisPool jedisPool;
	
	public void setConfig(JedisPoolConfig config,String host,int port,String auth,int timeout) {
		initConfig(config,host,port,auth,timeout);
	}
	public JedisService(JedisPoolConfig config,String host,int port,String auth,int timeout) {
		initConfig(config,host,port,auth,timeout);
	}
	public JedisService(String host,int port,String auth,int timeout) {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(500);
		config.setMaxIdle(500);
		config.setMaxWaitMillis(1000);
		config.setTestOnBorrow(true);
		initConfig(config,host,port,auth,timeout);
	}
	public JedisService(String host,String auth) {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(500);
		config.setMaxIdle(500);
		config.setMaxWaitMillis(1000);
		config.setTestOnBorrow(true);
		initConfig(config,host,6379,auth,10_000);
	}
	private void initConfig(JedisPoolConfig config,String host,int port,String auth,int timeout) {
		if (auth != null && !"".equals(auth)) {
			jedisPool = new JedisPool(config, host, port, timeout, auth);
		} else {
			jedisPool = new JedisPool(config, host, port, timeout);
		}
	}
	public void shutdown() {
//		logger.info("JedisPool server shutdown!");
		if (jedisPool != null) {
			jedisPool.destroy();
		}
	}

	public Jedis getJedis() {
		try {
			return jedisPool.getResource();
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		}
	}

	public void close(Jedis jedis) {
		try {
			if (jedis != null) {
				jedis.close();
			}
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		}
	}

	public Map<String, String> hgetAll(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.hgetAll(key);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public String set(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.set(key, value);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public String get(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.get(key);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public long del(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.del(key);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}



	public String type(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.type(key);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}


	public boolean exists(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.exists(key);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public Long lrem(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.lrem(key, 0, value);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public List<String> lrange(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.lrange(key, 0, -1);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public long lpush(String key, String... strings) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.lpush(key, strings);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}
	public long rpush(String key, String... strings) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.rpush(key, strings);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public String brpop(int timeout, String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			List<String> popList = jedis.brpop(timeout, key);
			if (popList != null) {
				return popList.get(1);
			} else {
				return null;
			}
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public String rpop(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.rpop(key);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public String rpoplpush(String srckey, String dstkey) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.rpoplpush(srckey, dstkey);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public String rpoplpush(String key) {
		try {
			return rpoplpush(key, key);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		}
	}

	public String hmset(String key, Map<String, String> hash) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.hmset(key, hash);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public long hset(String key, String field, String value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.hset(key, field, value);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public String hget(String key, String field) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.hget(key, field);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public long hincrBy(String key, String field, long value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.hincrBy(key, field, value);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public long publish(String channel, String message) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.publish(channel, message);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public long sadd(String key, String... members) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.sadd(key, members);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public String spop(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.spop(key);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public long srem(String key, String... members) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.srem(key, members);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public long expire(String key, int seconds) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.expire(key, seconds);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public double hincrByFloat(String key, String field, Double value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.hincrByFloat(key, field, value);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public List<String> lrange(String key, int start, int end) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.lrange(key, start, end);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public Set<String> smembers(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.smembers(key);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public long hdel(String key, String... fields) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.hdel(key, fields);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public Set<String> keys(String pattern) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.keys(pattern);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public String flushAll() {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.flushAll();
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public long dbSize() {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.dbSize();
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public long llen(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.llen(key);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

	public boolean sismember(String key, String member) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.sismember(key, member);
		} catch (Exception e) {
//			logger.error("jedis error " + e.getMessage(), e);
			throw e;
		} finally {
			close(jedis);
		}
	}

}