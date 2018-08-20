package com.niit.jobzzz;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.niit.jobzzz")
@EnableTransactionManagement
public class DBConfig 
{
	@Bean(name="dataSource")
	DataSource getDataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:~/project2");
		ds.setUsername("sa");
		ds.setPassword("sa");
		return ds;
	}
	
	
@Bean(name="myprop")
Properties hibernateProperties()
{
	Properties p=new Properties();
	p.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	p.setProperty("hibernate.show_sql", "true");
	p.setProperty("hibernate.hbm2ddl.auto", "update");
	return p;
}


@Autowired
@Bean(name="sessionFactory")
LocalSessionFactoryBean sessionFactory(DataSource dataSource,Properties myprop)
{
	LocalSessionFactoryBean lsfb=new LocalSessionFactoryBean();
	lsfb.setDataSource(dataSource);
	lsfb.setHibernateProperties(myprop);
	lsfb.setPackagesToScan("com.niit.jobzzz");
	return lsfb;
}

@Bean(name="mytrans")
@Autowired
HibernateTransactionManager hibTransManagement(SessionFactory sessionFactory)
{
	HibernateTransactionManager htm=new HibernateTransactionManager();
	htm.setSessionFactory(sessionFactory);
	return htm;
	
}
	
}
