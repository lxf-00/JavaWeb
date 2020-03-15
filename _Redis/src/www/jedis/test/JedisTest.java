package www.jedis.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import www.jedis.util.JedisPoolUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis测试类
 */
public class JedisTest {
    /**
     * 快速入门
     */
    private static Jedis jedis = new Jedis("172.16.36.164", 6379);
    @Test
    public void test1(){
        // 1， 获取连接

        // 2， 操作
        jedis.set("username", "张三");
        // 3, 关闭连接
        jedis.close();
    }

    /**
     * string 数据结构操作
     */
    @Test
    public void test2(){
        // 1，获取连接

        // 2, 操作
        // 存储
        jedis.set("username", "张三");

        // 获取
        String username = jedis.get("username");
        System.out.println("username: " + username);

        // setex 设置过期时间
        jedis.setex("activecode", 20, "hehe");

        // 3, 关闭连接
        jedis.close();
    }

    /**
     * hash 数据结构操作
     */
    @Test
    public void test3(){
        // 1， 获取连接

        // 2， 操作
        // 存储
        jedis.hset("user","name","lisi");
        jedis.hset("user", "age", "23");
        jedis.hset("user","gender","female");

        // 获取
        String name = jedis.hget("user", "name");
        System.out.println(name);

        // 获取hash的所有map中的数据 user {"name": xxx, "age":xxx, "gender":xxx}
        Map<String, String> map =  jedis.hgetAll("user");
        // 遍历集合
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            System.out.println(key + "......" + map.get(key));
        }

        // 3, 关闭连接
        jedis.close();
    }

    /**
     * list 数据结构操作
     */
    @Test
    public void test4(){
        // 1， 获取连接

        // 2，操作
        // 存储
        jedis.lpush("mylist", "a", "b", "c", "d");   // 从左边存
        jedis.rpush("mylist1", "a", "b", "c", "d");  // 从右边存

        // 获取
        List<String> list = jedis.lrange("mylist", 0, -1);
        System.out.println(list);

        List<String> mylist1 = jedis.lrange("mylist1", 0, -1);
        System.out.println(mylist1);

        // 弹出
        String value = jedis.lpop("mylist");  // 从头部删除元素，并返回该元素
        System.out.println(value);

        String value1 = jedis.rpop("mylist1");  // 从尾部删除元素，并返回该元素
        System.out.println(value1);


        // 3, 关闭连接
        jedis.close();
    }

    /**
     * set 数据结构操作
     */
    @Test
    public void test5(){
        // 1， 获取连接

        // 2， 操作
        // 存储  myset {"xxx", "xxxx", "xxxx"}
        jedis.sadd("myset", "java", "php", "c++");
        // 获取
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

        // 3， 关闭连接
        jedis.close();
    }

    /**
     * zset 数据结构操作
     */
    @Test
    public void test6(){
        // 1， 获取连接

        // 2， 操作
        // 存储
        jedis.zadd("mzet", 3, "盖伦");
        jedis.zadd("mzet", 4, "泰里克");
        jedis.zadd("mzet", 5, "沃里克");

        // 获取
        Set<String> mzet = jedis.zrange("mzet", 0, -1);
        System.out.println(mzet);

        // 3， 关闭连接
        jedis.close();
    }


    /**
     * Jedis 连接池的使用
     */
    @Test
    public void test7(){
        // 0， 创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);   //最大连接数, 默认50个
        config.setMaxIdle(10);   //最大空闲连接数, 默认10个

        // 1, 创建jedis连接池对象
        JedisPool jedisPool = new JedisPool(config, "172.16.36.164", 6379);

        // 2，获取连接
        Jedis jedis1 = jedisPool.getResource();

        // 3, 使用
        jedis1.set("hehe", "haha");

        // 4， 关闭，归还到连接池中
        jedis1.close();

    }

    /**
     * jedis 连接池工具类
     */
    @Test
    public void test8(){

        // 获取连接对象
        Jedis jedis2 = JedisPoolUtils.getJedis();
        // 操作
        jedis2.set("weather", "sunny");

        // 获取
        String weather = jedis2.get("weather");
        System.out.println(weather);

        // 关闭归还
        jedis2.close();
    }

}
