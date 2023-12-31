package com.lanai.lanaiBI.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: lanaiBI
 * @CreateTime: 2023-12-27  21:24
 * @Author: lanai
 * @Description: 配置Redisson,并生成其客户端
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedissonConfig {
    private Integer database;
    private String host;
    private String port;
    private String password;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://"+host+":"+port)
                .setDatabase(database);
//                .setPassword(password);
        RedissonClient client = Redisson.create(config);
        return client;
    }
}
