package diplom.db;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .url("jdbc:postgresql://localhost:5432/mynote")
                .username("mynotes")
                .password("mypassword")
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}
