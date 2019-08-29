package io.github.uitests.config;

import io.github.uitests.common.Environment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(value = {"io.github.uitests"})
//@PropertySources(@PropertySource("config.properties"))
@Slf4j
public class Config {
    @Autowired
    private DatabaseConfig databaseConfig;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource(@Autowired ModuleConfig moduleConfig) {
        final Environment environment = moduleConfig.getEnvironment();
        log.info("Initializing datasource for environment " + environment + " ...");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl(environment.getDbUrlConnection(databaseConfig));
        dataSource.setUsername(environment.getDbUsername(databaseConfig));
        dataSource.setPassword(environment.getDbPassword(databaseConfig));
        log.info("Datasource has been initialized for environment " + environment);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
