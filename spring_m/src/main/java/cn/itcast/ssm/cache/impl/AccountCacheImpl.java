package cn.itcast.ssm.cache.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Repository;

import cn.itcast.ssm.cache.BaseCacheImpl;
import cn.itcast.ssm.cache.dao.AccountCacheDao;

@Repository
public class AccountCacheImpl extends BaseCacheImpl implements AccountCacheDao {

	final String KEY_TOKEN_UID = NAME_SPACE + "user:token:uid:";
	final String KEY_UID_TOKEN = NAME_SPACE + "user:uid:token:";
	final String KEY_VCODE = NAME_SPACE + "user:phone:vcode:";

	final String KEY_PHONE_CHECK_TOKEN = NAME_SPACE + "user:phone:checktoken:";
	final String KEY_CHECK_TOKEN_PHONE = NAME_SPACE + "user:checktoken:phone:";

	final String KEY_WALLET_MONEY = NAME_SPACE + "user:wallet:moeny:";

	final String KEY_ORDER_TOKEN_UID = NAME_SPACE + "user:order:token:uid:";
	final String KEY_ORDER_UID_TOKEN = NAME_SPACE + "user:order:uid:token:";

	final String KEY_SEC_VCODE = NAME_SPACE + "security:phone:vcode:";

	final String KEY_TOKEN_SID = NAME_SPACE + "security:token:secId:";
	final String KEY_SID_TOKEN = NAME_SPACE + "security:secId:token:";

	final String KEY_SEC_PHONE_CHECK_TOKEN = NAME_SPACE + "security:phone:checktoken:";
	final String KEY_SEC_CHECK_TOKEN_PHONE = NAME_SPACE + "security:checktoken:phone:";

	@Override
	public boolean setVCode(int type, String phone, String vcode, long expireTime) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection con) {
				byte[] key = (KEY_VCODE + type + ":" + phone).getBytes();
				byte[] value = vcode.getBytes();
				con.set(key, value);
				con.expire(key, expireTime);
				return true;
			}
		});
	}

	@Override
	public String getVCode(int type, String phone) {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection con) {
				byte[] key = (KEY_VCODE + type + ":" + phone).getBytes();
				byte[] value = con.get(key);
				if (value != null && value.length > 0) {
					return new String(value);
				}
				return null;
			}
		});
	}

	@Override
	public boolean clearVCode(int type, String phone) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection con) throws DataAccessException {
				byte[] key = (KEY_VCODE + type + ":" + phone).getBytes();
				con.del(key);
				return true;
			}

		});
	}

	@Override
	public String getUidByToken(String token) {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] key = (KEY_TOKEN_UID + token).getBytes();
				byte[] value = connection.get(key);
				String uid = null;
				if (value != null && value.length > 0) {
					uid = new String(value);
				}
				return uid;
			}
		});
	}

	@Override
	public boolean setToken(String token, String uidJson, long expireTime) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection con) throws DataAccessException {
				byte[] key = (KEY_UID_TOKEN + uidJson).getBytes();
				byte[] value = con.get(key);
				if (value != null && value.length > 0) {
					con.del((KEY_TOKEN_UID + new String(value)).getBytes());
				}

				con.set(key, token.getBytes());
				con.expire(key, expireTime);

				key = (KEY_TOKEN_UID + token).getBytes();
				con.set(key, uidJson.getBytes());
				con.expire(key, expireTime);

				return true;
			}

		});
	}

	@Override
	public String getUidByToken(String token, Long delayTime) {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection con) throws DataAccessException {
				byte[] key = (KEY_TOKEN_UID + token).getBytes();
				byte[] value = con.get(key);

				long expire = 0;
				if (delayTime == null) {
					expire = 7 * 24 * 3600l;
				} else {
					expire = delayTime;
				}

				if (value != null && value.length > 0) {

					con.expire(key, expire);
					String uid = new String(value);

					key = (KEY_UID_TOKEN + uid).getBytes();
					con.expire(key, expire);

					return uid;
				}
				return null;
			}
		});
	}

	@Override
	public String getTokenByUid(String uid) {
		return redisTemplate.execute(new RedisCallback<String>() {

			@Override
			public String doInRedis(RedisConnection con) throws DataAccessException {
				byte[] key = (KEY_UID_TOKEN + uid).getBytes();
				byte[] value = con.get(key);
				if (value != null && value.length > 0) {
					return new String(value);
				}
				return null;
			}

		});
	}

	@Override
	public boolean clearTokenAndUid(String uid) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection con) throws DataAccessException {
				byte[] key = (KEY_UID_TOKEN + uid).getBytes();
				byte[] value = con.get(key);
				if (value != null && value.length > 0) {
					byte[] key2 = (KEY_TOKEN_UID + new String(value)).getBytes();
					con.del(key, key2);
				}
				return true;
			}

		});
	}

	@Override
	public boolean setCheckPhoneToken(int type, String phone, String checkToken) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection con) throws DataAccessException {
				byte[] key = (KEY_PHONE_CHECK_TOKEN + ":" + type + ":" + phone).getBytes();
				byte[] value = con.get(key);
				if (value != null && value.length > 0) {
					con.del((KEY_CHECK_TOKEN_PHONE + ":" + type + ":" + new String(value)).getBytes());
				}

				con.set(key, checkToken.getBytes());
				con.expire(key, 15 * 60);

				key = (KEY_CHECK_TOKEN_PHONE + ":" + type + ":" + checkToken).getBytes();
				con.set(key, phone.getBytes());
				con.expire(key, 15 * 60);

				return true;
			}

		});
	}

	@Override
	public String getPhoneByCheckToken(int type, String checkToken) {
		return redisTemplate.execute(new RedisCallback<String>() {

			@Override
			public String doInRedis(RedisConnection con) throws DataAccessException {
				byte[] key = (KEY_CHECK_TOKEN_PHONE + ":" + type + ":" + checkToken).getBytes();
				byte[] value = con.get(key);
				if (value != null && value.length > 0) {
					return new String(value);
				}
				return null;
			}

		});
	}

	@Override
	public boolean clearPhoneCheckToken(String checkToken) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection con) throws DataAccessException {
				int type = 1;
				byte[] key = (KEY_CHECK_TOKEN_PHONE + ":" + type + ":" + checkToken).getBytes();
				byte[] value = con.get(key);
				if (value != null && value.length > 0) {
					con.del((KEY_PHONE_CHECK_TOKEN + ":" + type + ":" + new String(value)).getBytes());
				}
				con.del(key);
				return true;
			}

		});
	}

	@Override
	public boolean setOrderToken(String token, String uid, long expireTime) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection con) throws DataAccessException {

				byte[] key = (KEY_ORDER_UID_TOKEN + uid).getBytes();
				byte[] value = con.get(key);
				if (value != null && value.length > 0) {
					con.del((KEY_ORDER_TOKEN_UID + new String(value)).getBytes());
				}

				con.set(key, token.getBytes());
				con.expire(key, expireTime);

				key = (KEY_ORDER_TOKEN_UID + token).getBytes();
				con.set(key, uid.getBytes());
				con.expire(key, expireTime);

				return true;
			}

		});
	}

	@Override
	public String getUidByOrderToken(String token) {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] key = (KEY_ORDER_TOKEN_UID + token).getBytes();
				byte[] value = connection.get(key);
				String uid = null;
				if (value != null && value.length > 0) {
					uid = new String(value);
				}
				return uid;
			}
		});
	}

	@Override
	public String getUidByOrderToken(String token, Long delayTime) {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection con) throws DataAccessException {
				byte[] key = (KEY_ORDER_TOKEN_UID + token).getBytes();
				byte[] value = con.get(key);

				long expire = 0;
				if (delayTime == null) {
					expire = 7 * 24 * 3600l;
				} else {
					expire = delayTime;
				}

				if (value != null && value.length > 0) {

					con.expire(key, expire);
					String uid = new String(value);

					key = (KEY_ORDER_UID_TOKEN + uid).getBytes();
					con.expire(key, expire);

					return uid;
				}
				return null;
			}
		});
	}

	@Override
	public boolean clearOrderTokenAndUid(String uid) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection con) throws DataAccessException {
				byte[] key = (KEY_ORDER_UID_TOKEN + uid).getBytes();
				byte[] value = con.get(key);
				if (value != null && value.length > 0) {
					byte[] key2 = (KEY_ORDER_TOKEN_UID + new String(value)).getBytes();
					con.del(key, key2);
				}
				return true;
			}

		});
	}

	@Override
	public boolean setSecToken(String token, String secId, long expireTime) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection con) throws DataAccessException {

				byte[] key = (KEY_SID_TOKEN + secId).getBytes();
				byte[] value = con.get(key);
				if (value != null && value.length > 0) {
					con.del((KEY_TOKEN_SID + new String(value)).getBytes());
				}

				con.set(key, token.getBytes());
				con.expire(key, expireTime);

				key = (KEY_TOKEN_SID + token).getBytes();
				con.set(key, secId.getBytes());
				con.expire(key, expireTime);

				return true;
			}

		});
	}

	@Override
	public String getSecIdByToken(String token) {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] key = (KEY_TOKEN_SID + token).getBytes();
				byte[] value = connection.get(key);
				String secId = null;
				if (value != null && value.length > 0) {
					secId = new String(value);
				}
				return secId;
			}
		});
	}

	@Override
	public String getSecIdByToken(String token, Long delayTime) {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection con) throws DataAccessException {
				byte[] key = (KEY_TOKEN_SID + token).getBytes();
				byte[] value = con.get(key);

				long expire = 0;
				if (delayTime == null) {
					expire = 7 * 24 * 3600l;
				} else {
					expire = delayTime;
				}

				if (value != null && value.length > 0) {

					con.expire(key, expire);
					String secId = new String(value);

					key = (KEY_SID_TOKEN + secId).getBytes();
					con.expire(key, expire);

					return secId;
				}
				return null;
			}
		});
	}

	@Override
	public String getTokenBySecId(String secId) {
		return redisTemplate.execute(new RedisCallback<String>() {

			@Override
			public String doInRedis(RedisConnection con) throws DataAccessException {
				byte[] key = (KEY_SID_TOKEN + secId).getBytes();
				byte[] value = con.get(key);
				if (value != null && value.length > 0) {
					return new String(value);
				}
				return null;
			}

		});
	}

	@Override
	public boolean clearTokenAndSecId(String secId) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection con) throws DataAccessException {
				byte[] key = (KEY_SID_TOKEN + secId).getBytes();
				byte[] value = con.get(key);
				if (value != null && value.length > 0) {
					byte[] key2 = (KEY_TOKEN_SID + new String(value)).getBytes();
					con.del(key, key2);
				}
				return true;
			}

		});
	}

	@Override
	public boolean setSecVCode(int type, String phone, String vcode, long expireTime) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection con) {
				byte[] key = (KEY_SEC_VCODE + type + ":" + phone).getBytes();
				byte[] value = vcode.getBytes();
				con.set(key, value);
				con.expire(key, expireTime);
				return true;
			}
		});
	}

	@Override
	public String getSecVCode(int type, String phone) {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection con) {
				byte[] key = (KEY_SEC_VCODE + type + ":" + phone).getBytes();
				byte[] value = con.get(key);
				if (value != null && value.length > 0) {
					return new String(value);
				}
				return null;
			}
		});
	}

	@Override
	public boolean setSecCheckPhoneToken(int type, String phone, String checkToken) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection con) throws DataAccessException {
				byte[] key = (KEY_SEC_PHONE_CHECK_TOKEN + ":" + type + ":" + phone).getBytes();
				byte[] value = con.get(key);
				if (value != null && value.length > 0) {
					con.del((KEY_SEC_CHECK_TOKEN_PHONE + ":" + type + ":" + new String(value)).getBytes());
				}

				con.set(key, checkToken.getBytes());
				con.expire(key, 15 * 60);

				key = (KEY_SEC_CHECK_TOKEN_PHONE + ":" + type + ":" + checkToken).getBytes();
				con.set(key, phone.getBytes());
				con.expire(key, 15 * 60);

				return true;
			}

		});
	}

	@Override
	public String getSecPhoneByCheckToken(int type, String checkToken) {
		return redisTemplate.execute(new RedisCallback<String>() {

			@Override
			public String doInRedis(RedisConnection con) throws DataAccessException {
				byte[] key = (KEY_SEC_CHECK_TOKEN_PHONE + ":" + type + ":" + checkToken).getBytes();
				byte[] value = con.get(key);
				if (value != null && value.length > 0) {
					return new String(value);
				}
				return null;
			}

		});
	}

	@Override
	public boolean clearSecPhoneCheckToken(String checkToken) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection con) throws DataAccessException {
				int type = 1;
				byte[] key = (KEY_SEC_CHECK_TOKEN_PHONE + ":" + type + ":" + checkToken).getBytes();
				byte[] value = con.get(key);
				if (value != null && value.length > 0) {
					con.del((KEY_SEC_PHONE_CHECK_TOKEN + ":" + type + ":" + new String(value)).getBytes());
				}
				con.del(key);
				return true;
			}

		});
	}

}
