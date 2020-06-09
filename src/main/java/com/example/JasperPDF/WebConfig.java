package com.example.JasperPDF;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan
public class WebConfig implements WebMvcConfigurer {

@Value("${spring.mvc.view.prefix}")
private String prefix;

@Value("${spring.mvc.view.suffix}")
private String suffix;

/**
 * Configures view resolver for jsp views.
 */
@Bean
public InternalResourceViewResolver setupViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix(prefix);
    resolver.setSuffix(suffix);
    resolver.setViewClass(JstlView.class);
    return resolver;
	}

@Override
public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("your cross origin url")
          .allowedOrigins("your cross origin host/url")
          .allowedHeaders("Access-Control-Allow-Origin", "*")
          .allowedHeaders("Access-Control-Allow-Headers", "Content-Type,x-requested-with").maxAge(20000)
          .allowCredentials(false)
          .allowedMethods("PUT");
    
    registry.addMapping("/**")
    	.allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
    .allowedHeaders("*");
}

@Override
public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
}

@Override
public void configureViewResolvers(ViewResolverRegistry registry) {
   registry.jsp("/WEB-INF/", ".jsp");
}
}