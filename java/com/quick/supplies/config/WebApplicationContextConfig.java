package com.quick.supplies.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


@Configuration
@EnableWebMvc
@ComponentScan("com.quick.supplies")
public class WebApplicationContextConfig extends
WebMvcConfigurerAdapter{

	@Override
	public void configureDefaultServletHandling
	(DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
	}
	
	@Bean
	public InternalResourceViewResolver
	getInternalResourceViewResolver() {
	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	resolver.setViewClass(JstlView.class);
	resolver.setPrefix("/WEB-INF/view/");
	resolver.setSuffix(".jsp");
	return resolver;
	}
	
	@Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 registry.addResourceHandler("/resources/**").addResourceLocations("/resources/bootstrap");
	 registry.addResourceHandler("/img/**").addResourceLocations("/resources/images/");
	 registry.addResourceHandler("/pdf/**").addResourceLocations("/resources/pdf/");
	 registry.addResourceHandler("/resources/**").addResourceLocations("/resources/js/");

	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
	CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	resolver.setDefaultEncoding("utf-8");
	return resolver;
	}
	
	@Bean
	 public MappingJackson2JsonView jsonView() {
	 MappingJackson2JsonView jsonView = new 
	 MappingJackson2JsonView();
	 jsonView.setPrettyPrint(true);
	 return jsonView;
	 }
	
	@Bean
	 public ViewResolver contentNegotiatingViewResolver(
	 ContentNegotiationManager manager) {
	 ContentNegotiatingViewResolver resolver = new 
	 ContentNegotiatingViewResolver();
	 resolver.setContentNegotiationManager(manager);
	 ArrayList<View> views = new ArrayList<>();
	 views.add(jsonView());
	 resolver.setDefaultViews(views);
	 return resolver;
	 }
	
}
