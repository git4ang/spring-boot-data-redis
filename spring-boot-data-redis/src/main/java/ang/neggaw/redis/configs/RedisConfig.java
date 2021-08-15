package ang.neggaw.redis.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.PreDestroy;

/**
 * Created by:
 *
 * @author ANG
 * @since 15-08-2021 18:33
 */

@Configuration
public class RedisConfig<T> {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() { return new JedisConnectionFactory(); }

    @Bean
    public RedisTemplate<String, T> redisTemplate() {
        final RedisTemplate<String, T> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

    @PreDestroy
    public void cleanRedisDB() {
        jedisConnectionFactory().getConnection().flushDb();
    }
}
