package cn.virde.nymph.test.jedis;

import java.util.List;

import cn.virde.nymph.db.redis.JedisService;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {
	
	static {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(1000);
		config.setMaxIdle(1000);
		config.setMaxWaitMillis(10000);
		config.setTestOnBorrow(true);
		
		JedisService.setConfig(config, "172.16.20.83", 6379, "Chuanglan@%#253", 10_000);
	
	}
	public static void main(String[] args) {
		Jedis jedis = JedisService.getJedis();
//		jedis.sadd("hahahaa", "p1","p2","p3");
		
//		jedis.lpush("testl", "p1","p2","p3");
		
		List<String> list = jedis.brpop(11,"testl");
//		
		list.forEach((a)->System.out.println(a));
		
	}
}
