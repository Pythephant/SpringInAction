package spittr.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import net.sf.ehcache.CacheManager;

@Configuration
@EnableCaching
public class CachingConfig {

	@Bean
	public EhCacheCacheManager cacheManager(CacheManager cm) {
		return new EhCacheCacheManager(cm);
	}

	@Bean
	public EhCacheManagerFactoryBean ehcache() {
		EhCacheManagerFactoryBean ehCacheFactoryBean = new EhCacheManagerFactoryBean();
		ehCacheFactoryBean.setConfigLocation(new ClassPathResource("spittr/config/ehcache.xml"));
		return ehCacheFactoryBean;
	}

}
