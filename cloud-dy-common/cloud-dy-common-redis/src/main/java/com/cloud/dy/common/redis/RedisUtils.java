package com.cloud.dy.common.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.dy.common.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.*;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @ClassName : RedisUtils
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:17
 * @Description :REDIS 工具类 基于spring和redis的redisTemplate工具类 针对所有的hash 都是以h开头的方法 针对所有的Set
 * 都是以s开头的方法 不含通用方法 针对所有的List 都是以l开头的方法
 **/
@Configuration
public class RedisUtils {

    /**
     * 登录标识默认有效时长
     */
    @Value("${token.expire:86400}")
    private long expire;

    /**
     * #redis 环境剥离，前置key test_:测试, dev_:开发, 正是环境:prod_, 默认是def_
     */
    @Value("${spring.redis.prekey:'def'}")
    private String prefix;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ValueOperations<String, String> valueOperations;

    @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    private ListOperations<String, Object> listOperations;

    @Autowired
    private SetOperations<String, Object> setOperations;

    /**
     * 默认过期时长，单位：秒
     */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;

    /**
     * 不设置过期时长
     */
    public final static long NOT_EXPIRE = -1;

    /**
     * hmgetToken 用于获取用户登录标识
     *
     * @param key 键
     * @return 对应的多个键值
     */
    public Map<String, Object> hmgetToken(String key) {
        Map<String, Object> entries = hashOperations.entries(prefix + Constants.REDIS_API_PREFIX + key);
        if (expire != DEFAULT_EXPIRE) {
            expire(prefix + Constants.REDIS_API_PREFIX + key, expire);
        }
        return entries;
    }

    /**
     * hmsetToken 用于设置用户登录标识
     *
     * @param key 键
     * @param map 对应多个键值
     * @return true 成功 false 失败
     */
    public boolean hmsetToken(String key, Map<String, Object> map) {
        try {
            hashOperations.putAll(String.valueOf(prefix + Constants.REDIS_API_PREFIX + key), map);
            expire(prefix + Constants.REDIS_API_PREFIX + key, expire != DEFAULT_EXPIRE ? expire : DEFAULT_EXPIRE);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 用于设置用户登录标识
     *
     * @param key
     * @param value
     */
    public void setToken(String key, Object value) {
        valueOperations.set(prefix + Constants.REDIS_API_PREFIX + key, toJson(value));
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(prefix + Constants.REDIS_API_PREFIX + key, expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 用于获取用户登录标识
     *
     * @param key
     * @param clazz
     * @return
     */
    public <T> T getToken(String key, Class<T> clazz) {
        String value = valueOperations.get(prefix + Constants.REDIS_API_PREFIX + key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(prefix + Constants.REDIS_API_PREFIX + key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : fromJson(value, clazz);
    }

    public void deleteToken(String key) {
        redisTemplate.delete(prefix + Constants.REDIS_API_PREFIX + key);
    }


    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(prefix + key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key 获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(prefix + key, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(prefix + key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(prefix + key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(CollectionUtils.arrayToList(key).stream().map(val -> {
                    return prefix + val;
                }).collect(Collectors.toList())));
            }
        }
    }

    // ============================String=============================

    /**
     * 用于设置对象信息
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        valueOperations.set(prefix + "@@MiaoObject" + key, toJson(value));
    }

    /**
     * 用于获取对象信息
     *
     * @param key
     * @param clazz
     * @return
     */
    public <T> T get(String key, Class<T> clazz) {
        String value = valueOperations.get(prefix + "@@MiaoObject" + key);
        return value == null ? null : fromJson(value, clazz);
    }

    public Object get(String key) {
        return key == null ? null : valueOperations.get(prefix + key);
    }

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key, String value) {
        try {
            valueOperations.set(prefix + key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public boolean set(String key, String value, long time) {
        try {
            if (time > 0) {
                valueOperations.set(prefix + key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递增
     *
     * @param key   键
     * @param delta 要增加几(大于0)
     * @return
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return valueOperations.increment(prefix + key, delta);
    }

    /**
     * 递减
     *
     * @param key   键
     * @param delta 要减少几(小于0)
     * @return
     */
    public long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return valueOperations.increment(prefix + key, -delta);
    }

    // ================================Map=================================

    /**
     * HashGet
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    public Object hget(String key, String item) {
        return hashOperations.get(prefix + key, item);
    }

    /**
     * 获取hashKey对应的所有键值
     *
     * @param key 键
     * @return 对应的多个键值
     */
    public Map<String, Object> hmget(String key) {
        return hashOperations.entries(prefix + key);
    }

    /**
     * HashSet
     *
     * @param key 键
     * @param map 对应多个键值
     * @return true 成功 false 失败
     */
    public boolean hmset(String key, Map<String, Object> map) {
        try {
            hashOperations.putAll(prefix + key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * HashSet 并设置时间
     *
     * @param key  键
     * @param map  对应多个键值
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    public boolean hmset(String key, Map<String, Object> map, long time) {
        try {
            hashOperations.putAll(prefix + key, map);
            if (time > 0) {
                expire(prefix + key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @return true 成功 false失败
     */
    public boolean hset(String key, String item, Object value) {
        try {
            hashOperations.put(prefix + key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @param time  时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return true 成功 false失败
     */
    public boolean hset(String key, String item, Object value, long time) {
        try {
            hashOperations.put(prefix + key, item, value);
            if (time > 0) {
                expire(prefix + key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除hash表中的值
     *
     * @param key  键 不能为null
     * @param item 项 可以使多个 不能为null
     */
    public void hdel(String key, Object... item) {
        hashOperations.delete(prefix + key, item);
    }

    /**
     * 判断hash表中是否有该项的值
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    public boolean hHasKey(String key, String item) {
        return hashOperations.hasKey(prefix + key, item);
    }

    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几(大于0)
     * @return
     */
    public double hincr(String key, String item, double by) {
        return hashOperations.increment(prefix + key, item, by);
    }

    /**
     * hash递减
     *
     * @param key  键
     * @param item 项
     * @param by   要减少记(小于0)
     * @return
     */
    public double hdecr(String key, String item, double by) {
        return hashOperations.increment(prefix + key, item, -by);
    }

    // ============================set=============================

    /**
     * 根据key获取Set中的所有值
     *
     * @param key 键
     * @return
     */
    public Set<Object> sGet(String key) {
        try {
            return setOperations.members(prefix + key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key   键
     * @param value 值
     * @return true 存在 false不存在
     */
    public boolean sHasKey(String key, Object value) {
        try {
            return setOperations.isMember(prefix + key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将数据放入set缓存
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSet(String key, Object... values) {
        try {
            return setOperations.add(prefix + key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 将set数据放入缓存
     *
     * @param key    键
     * @param time   时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSetAndTime(String key, long time, Object... values) {
        try {
            Long count = setOperations.add(prefix + key, values);
            if (time > 0)
                expire(prefix + key, time);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取set缓存的长度
     *
     * @param key 键
     * @return
     */
    public long sGetSetSize(String key) {
        try {
            return setOperations.size(prefix + key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 移除值为value的
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    public long setRemove(String key, Object... values) {
        try {
            Long count = setOperations.remove(prefix + key, values);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // ===============================list=================================

    /**
     * 获取list缓存的内容
     *
     * @param key   键
     * @param start 开始
     * @param end   结束 0 到 -1代表所有值
     * @return
     */
    public List<Object> lGet(String key, long start, long end) {
        try {
            return listOperations.range(prefix + key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取list缓存的长度
     *
     * @param key 键
     * @return
     */
    public long lGetListSize(String key) {
        try {
            return listOperations.size(prefix + key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 通过索引 获取list中的值
     *
     * @param key   键
     * @param index 索引 index>=0时， 0 表头，1
     *              第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    public Object lGetIndex(String key, long index) {
        try {
            return listOperations.index(prefix + key, index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public boolean lSet(String key, Object value) {
        try {
            listOperations.rightPush(prefix + key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public boolean lSet(String key, Object value, long time) {
        try {
            listOperations.rightPush(prefix + key, value);
            if (time > 0)
                expire(key, time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public boolean lSet(String key, List<Object> value) {
        try {
            listOperations.rightPushAll(prefix + key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public boolean lSet(String key, List<Object> value, long time) {
        try {
            listOperations.rightPushAll(prefix + key, value);
            if (time > 0)
                expire(prefix + key, time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据索引修改list中的某条数据
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return
     */
    public boolean lUpdateIndex(String key, long index, Object value) {
        try {
            listOperations.set(prefix + key, index, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除N个值为value
     *
     * @param key   键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    public long lRemove(String key, long count, Object value) {
        try {
            Long remove = listOperations.remove(prefix + key, count, value);
            return remove;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 批量删除，根据key模糊匹配
     *
     * @param pattern
     */
    public void delpn(final String... pattern) {
        for (String kp : pattern) {
            redisTemplate.delete(redisTemplate.keys(prefix + kp + "*"));
        }
    }

    /**
     * Object转成JSON数据
     */
    private String toJson(Object object) {
        if (object instanceof Integer || object instanceof Long || object instanceof Float || object instanceof Double || object instanceof Boolean || object instanceof String) {
            return String.valueOf(object);
        }
        return JSON.toJSONString(object);
    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * 获取JSONObect的值
     *
     * @param jsonObject
     * @param key
     * @return
     */
    public static String get(JSONObject jsonObject, String key) {
        try {
            if (jsonObject.containsKey(key)) {
                return jsonObject.getString(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}