package spittr.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {

	// @Bean
	// public ViewResolver viewResolver() {
	// InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	// resolver.setPrefix("/WEB-INF/views/");
	// resolver.setSuffix(".jsp");
	// resolver.setExposeContextBeansAsAttributes(true);
	// return resolver;
	// }

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		super.addResourceHandlers(registry);
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("ValidationMessages");
		messageSource.setCacheSeconds(20);
		return messageSource;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions("/WEB-INF/layout/tiles.xml");
		tiles.setCheckRefresh(true);
		return tiles;
	}

	@Bean
	public TilesViewResolver viewResolver() {
		TilesViewResolver resolver = new TilesViewResolver();
		return resolver;
	}

	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

}
