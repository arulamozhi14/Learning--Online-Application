package com.synergisticit.onlinebanking.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

//import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;

import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.XmlViewResolver;

import com.synergisticit.onlinebanking.domain.Account;
import com.synergisticit.onlinebanking.domain.Branch;
import com.synergisticit.onlinebanking.domain.Customer;
import com.synergisticit.onlinebanking.domain.Loan;
import com.synergisticit.onlinebanking.domain.Role;
import com.synergisticit.onlinebanking.domain.Transaction;
import com.synergisticit.onlinebanking.domain.User;
import com.synergisticit.onlinebanking.view.AccountExcelViewResolver;
import com.synergisticit.onlinebanking.view.AccountPdfViewResolver;

@Configuration
public class Config {
	
	
/*	@Bean
	public InternalResourceViewResolver resolver()
	{
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		resolver.setOrder(1);
		return resolver;
	}
	
	@Bean
	public XmlViewResolver xmlViewResolver() {
		XmlViewResolver resolvers = new XmlViewResolver();
		resolvers.setLocation(new ClassPathResource("sview1.xml"));
		resolvers.setOrder(0);
		return resolvers;
	}*/

	
	
	@Bean
	public ContentNegotiatingViewResolver contentNegotatingViewResolver(ContentNegotiationManager cnmanager){
		ContentNegotiatingViewResolver contentNegotatingViewResolver=new ContentNegotiatingViewResolver();
		contentNegotatingViewResolver.setContentNegotiationManager(cnmanager);
	
		AccountPdfViewResolver accountpdf=new AccountPdfViewResolver();
		//AccountCsvViewResolver accountcsv=new AccountCsvViewResolver();
		AccountExcelViewResolver accountxcelsheet=new AccountExcelViewResolver();
		
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		
		List<ViewResolver> viewresolver=new ArrayList<ViewResolver>();
		viewresolver.add(accountpdf);
		//viewresolver.add(accountcsv);
		viewresolver.add(accountxcelsheet);
		
		viewresolver.add(resolver);
		contentNegotatingViewResolver.setViewResolvers(viewresolver);
		return contentNegotatingViewResolver;
		
	}
	
	public void ConfigureContentNegotation (ContentNegotiationConfigurer configurer){
		configurer.defaultContentType(MediaType.TEXT_HTML).favorPathExtension(true).favorParameter(false);
		
	}
	
	
	
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/bankingdb?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("rootpuru");
		return dataSource;
		
	}
	
	@Bean (name="entityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
		
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan( new String[] {"com.synergisticit.onlinebanking" } );
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setJpaProperties(hibernateProperties());
		
		return entityManagerFactoryBean;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager()
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
//	
//	@Bean(name="transactionManager")
//	@Autowired
//	public PlatformTransactionManager getTransactionManager(EntityManagerFactory emf) throws NamingException{
//		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//		jpaTransactionManager.setEntityManagerFactory(emf);
//		return jpaTransactionManager;
//					
//	}
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		sessionFactory.setAnnotatedClasses(Account.class,Branch.class,Customer.class,Loan.class,Role.class,Transaction.class,User.class);
		return sessionFactory;
		
	}
	
	public Properties hibernateProperties(){
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		hibernateProperties.put("hibernate.show_sql", true);
		//hibernateProperties.put("hibernate.hbm2ddl.auto","update");
		return hibernateProperties;
		
	}
	
//message source is used used for validation
	@Bean
	public MessageSource messageSource(){  
		ReloadableResourceBundleMessageSource source=new ReloadableResourceBundleMessageSource();
		source.setBasenames("/WEB-INF/messages/validation");
		source.setFallbackToSystemLocale(true);
		
		return source;
		
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


	
	public void configureMessageConverters(java.util.List<HttpMessageConverter<?>> converters) {		
		Jaxb2RootElementHttpMessageConverter  jaxb2RootElementHttpMessageConverter = new Jaxb2RootElementHttpMessageConverter();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter = new MappingJackson2XmlHttpMessageConverter();
		
		converters.add(jaxb2RootElementHttpMessageConverter);
		converters.add(mappingJackson2HttpMessageConverter);
		converters.add(mappingJackson2XmlHttpMessageConverter);
		
	}
	
	@Bean
	public JavaMailSenderImpl mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("synergisticitsessionusc11@gmail.com");
		mailSender.setPassword("synergistic11");
		mailSender.setJavaMailProperties(javaMailProperties());
		
		return mailSender;
	}

	public Properties javaMailProperties() {
		Properties javaMailProperties = new Properties();
		javaMailProperties.setProperty("mail.transport.protocol", "smtp");
		javaMailProperties.setProperty("mail.smtp.auth", "true");
		javaMailProperties.setProperty("mail.debug", "true");
		javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
		return javaMailProperties;
	}
	
//	
	
	

}
