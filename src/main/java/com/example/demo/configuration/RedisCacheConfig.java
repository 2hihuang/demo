package com.example.demo.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

    /**
     * springboot2.x中，RedisCacheManager已经没有了单参数的构造方法
     * 1.x中通过参数redisTemplate配置的方式不可行
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofHours(1))  // 设置缓存有效期一小时
                .disableCachingNullValues();

        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(cacheConfiguration)
                .build();
    }

//    @Bean
//    public KeyGenerator keyGenerator() {
//        return (o, method, objects) -> {
//            StringBuilder sb = new StringBuilder();
//            sb.append(o.getClass().getName());
//            sb.append("." + method.getName() + "(");
//            for (Object obj : objects) {
//                sb.append(obj.toString());
//            }
//            sb.append(")");
//            return sb.toString();
//        };
//    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String,
                String>();
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }
}
