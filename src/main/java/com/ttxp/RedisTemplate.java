package com.ttxp;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RedisTemplate {

    public static void main(String[] args) {
        InputStream resourceAsStream = RedisTemplate.class.getClassLoader().getResourceAsStream("redis.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Jedis jedis = new Jedis(properties.get("host").toString(),Integer.parseInt(properties.get("port").toString()));
        jedis.connect();

        String s = jedis.get("111");
        System.out.println(s);
        jedis.disconnect();
    }
}
