package org.innovation.day;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"org.innovation.day"})
@MapperScan("org.innovation.day.mappers")
public class ProprietaryConfig extends WebMvcConfigurerAdapter {

    @Bean
    public DataSource dataSource() throws Exception {
//        SQLServerDataSource ds = new SQLServerDataSource();
//        ds.setServerName("13.58.132.216");
//        ds.setPassword("yourStrong(!)Password");
//        ds.setUser("sa");
//        ds.setDatabaseName("prod");
//        ds.setPortNumber(1433);
        DriverManagerDataSource ds = new DriverManagerDataSource("jdbc:db2://13.58.132.216:50000", "sa", "inn0db2");
        ds.setDriverClassName("com.ibm.db2.jcc.DB2Driver");
        return ds;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setTransactionFactory(new SpringManagedTransactionFactory());
        bean.setDataSource(dataSource());
        return bean;
    }

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
