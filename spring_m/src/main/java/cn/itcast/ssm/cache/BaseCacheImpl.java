package cn.itcast.ssm.cache;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 基础的缓存实现
 * 
 * @author candy
 *
 */
public class BaseCacheImpl {
	protected Logger logger = Logger.getLogger(getClass());

	public static final String NAME_SPACE = "fm:portal:";

	@Resource
	protected RedisTemplate<String, Object> redisTemplate;

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

}
