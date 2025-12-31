package com.zepto.product.config;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@Configuration
@EnableCaching
public class RedisConfig {

	@Bean
	RedisConnectionFactory redisConnectionFactory() {

		RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration("adequate-horse-27553.upstash.io",
				6379);
		redisConfig.setUsername("default");
		redisConfig.setPassword("AWuhAAIncDE1MDE3MWJiMmE0OTA0OGU1OWE2NGY5NzBkMDk5MzA4Y3AxMjc1NTM");

		LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
				.commandTimeout(Duration.ofSeconds(10)).shutdownTimeout(Duration.ofMillis(100)).useSsl().build();

		return new LettuceConnectionFactory(redisConfig, clientConfig);
	}

	@Bean
	CacheManager cacheManager(RedisConnectionFactory connectionFactory) {

		RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofMinutes(1)) // TTL
				.serializeValuesWith(RedisSerializationContext.SerializationPair
						.fromSerializer(new GenericJackson2JsonRedisSerializer()));

		return RedisCacheManager.builder(connectionFactory).cacheDefaults(cacheConfig).build();
	}
}