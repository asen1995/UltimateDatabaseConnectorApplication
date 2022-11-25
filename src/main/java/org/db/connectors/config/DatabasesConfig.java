package org.db.connectors.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class DatabasesConfig {

    @Value("${redis.host}")
    private String redisHost;

    @Value("${redis.port}")
    private int redisPort;

    @Bean
    @ConditionalOnExpression(
            "${redis.enabled:true}"
    )
    public Jedis redisStore() {
        return new Jedis(redisHost, redisPort);
    }
}
