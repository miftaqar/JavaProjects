package com.primetgi.springdemo.config;

import java.util.Locale;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.primetgi.org.dao.ContactDAO;
import com.primetgi.org.dao.ContactDAOImpl;
import com.primetgi.org.dao.UserDAO;
import com.primetgi.org.dao.UserDAOImpl;
import com.primetgi.springdemo.mvc.validation.FormValidator;

@Configuration
@EnableWebMvc
@PropertySource("classpath:../subjects.properties")
@ComponentScan(basePackages = { "com.primetgi.org.controller", "com.primetgi.springdemo" })
public class DemoConfigApp implements WebMvcConfigurer {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	// load the custom message resources
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasenames("resources/messages", "resources/formValidation", "resources/log4j");
		resourceBundleMessageSource.setDefaultEncoding("UTF-8");
		resourceBundleMessageSource.setUseCodeAsDefaultMessage(true);
		return resourceBundleMessageSource;

	}

	@Bean()
	public FormValidator formValidator() {
		return new FormValidator();
	}

	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		interceptorRegistry.addInterceptor(localeChangeInterceptor);
	}

	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("en"));
		return localeResolver;

	}

	@Bean
	public UserDAO userDAO() throws NamingException {
		return new UserDAOImpl(dataSource());
	}

	@Bean
	public ContactDAO contactDAO() throws NamingException {
		return new ContactDAOImpl(dataSource());
	}

	@Bean
	public DataSource dataSource() throws NamingException {
		final JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		dataSourceLookup.setResourceRef(true);
		DataSource dataSource = dataSourceLookup.getDataSource("java:comp/env/jdbc/UserDB");
		return dataSource;
	}
}
