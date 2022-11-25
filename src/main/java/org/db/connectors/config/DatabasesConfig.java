package org.db.connectors.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class DatabasesConfig {

    @Bean
    public Jedis redisStore(){
        return new Jedis();
    }
}
