package io.github.helloworlde.zebra.config;

import com.dianping.zebra.dao.mybatis.ZebraMapperScannerConfigurer;
import com.dianping.zebra.group.jdbc.GroupDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class ZebraConfiguration {
    //第1步：配置数据源，省略

    // @Bean
    // @Primary
    // @ConfigurationProperties(prefix = "spring.datasource.hikari")
    // public DataSource dataSource() {
    //     return DataSourceBuilder.create().build();
    // }


    @Bean(name = "zebraDataSource")
    public DataSource zebraDataSource() {
        // TODO 坑 名字是配置文件的名字 sample.properties
        GroupDataSource ds = new GroupDataSource("sample");
        ds.init();
        return ds;
    }

    //第2步：配置SqlSessionFactoryBean
    @Bean(name = "zebraSqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("zebraDataSource") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        ssfb.setMapperLocations(resolver.getResources("mappers/**.xml"));
        ssfb.setTypeAliasesPackage("io.github.helloworlde.zebra.model");
        return ssfb;
    }


    //第3步：配置ZebraMapperScannerConfigurer
    @Bean
    public ZebraMapperScannerConfigurer mapperScannerConfigurer() throws IOException {
        ZebraMapperScannerConfigurer configurer = new ZebraMapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("zebraSqlSessionFactory");
        configurer.setBasePackage("io.github.helloworlde.zebra.dao");
        return configurer;
    }
}
