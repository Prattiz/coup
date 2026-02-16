package com.back.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class RedisConfig {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration config =
            new RedisStandaloneConfiguration(
                GetEnv.redisHost(),
                GetEnv.redisPort()
            );
        System.out.println("Redis");

        return new LettuceConnectionFactory(config);
    }
}
