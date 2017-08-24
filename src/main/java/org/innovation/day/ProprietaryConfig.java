package org.innovation.day;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"org.innovation.day"})
@MapperScan("org.innovation.day.mappers")
public class ProprietaryConfig extends WebMvcConfigurerAdapter {

//    @Bean
//    public Properties applicationProperties() throws Exception {
//        Properties props = new Properties();
//        props.load(new BufferedReader(new FileReader(new File("config.properties"))));
//        return props;
//    }

//    @Bean
//    public DataSource dataSource() throws Exception {
//        PGPoolingDataSource ds = new PGPoolingDataSource();
//        ds.setServerName(applicationProperties().getProperty("db.server"));
//        ds.setPassword(applicationProperties().getProperty("db.password"));
//        ds.setUser(applicationProperties().getProperty("db.user"));
//        ds.setDatabaseName(applicationProperties().getProperty("db.name"));
//        ds.setPortNumber(Integer.parseInt(applicationProperties().getProperty("db.port")));
//        return ds;
//    }

//    @Bean
//    public DataSourceTransactionManager transactionManager() throws Exception {
//        return new DataSourceTransactionManager(dataSource());
//    }

//    @Bean
//    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setTransactionFactory(new SpringManagedTransactionFactory());
//        bean.setDataSource(dataSource());
//        return bean;
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("/");
    }

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".html");
        return resolver;
    }
}
