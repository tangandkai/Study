package com.tang.study.redis;

import com.tang.study.redis.dao.redisStringDAO;

public class redisApp {

    public static void main(String[] args) {
        redisStringDAO redisStr = new redisStringDAO();
        redisStr.put("name","tangwenkai");
        redisStr.pipeline();
    }
}
