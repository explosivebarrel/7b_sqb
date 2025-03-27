package it.sevenbits.courses.springbootexample.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Database configuration
 */
@Configuration
public class DatabaseConfig {
    /**
     *
     * @return dataSource
     */
    @Bean
    @FlywayDataSource
    @Qualifier("dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     *
     * @param dataSource dataSource
     * @return JdbcOperations
     */
    @Bean
    @Qualifier("squizzesJdbcOperations")
    public JdbcOperations jdbcTemplate(
        @Qualifier("dataSource")
        final DataSource dataSource
    ) {
        return new JdbcTemplate(dataSource);
    }
}