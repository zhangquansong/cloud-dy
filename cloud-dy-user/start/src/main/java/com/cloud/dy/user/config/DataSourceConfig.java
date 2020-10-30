package com.cloud.dy.user.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


/**
 * 数据源配置
 *
 * @author HelloWoodes
 */
@Slf4j
//@Configuration
public class DataSourceConfig {

    /*@Bean
    @ConfigurationProperties(prefix = "spring.shardingsphere.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean("dataSource")
    @Primary
    public DataSourceProxy dataSourceProxy(DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }

    @Bean("SqlSessionTemplate")
    public SqlSessionTemplate sessionTemplate(@Qualifier("SqlSessionFactory") SqlSessionFactory sessionFactory) throws Exception {
        return new SqlSessionTemplate(sessionFactory);
    }

    */

    /**
     * mybatis Sql Session 工厂
     *
     * @return
     * @throws Exception
     *//*
    @Bean("SqlSessionFactory")
    public SqlSessionFactory sessionFactory(@Qualifier("dataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        // 若通过配置文件实现mybatis的整合，需要设置配置文件的地址
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:/mapper/*.xml"));
        return sessionFactoryBean.getObject();
    }*/
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean("dataSource")
    @Primary
    public DataSourceProxy dataSourceProxy(DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }

}

