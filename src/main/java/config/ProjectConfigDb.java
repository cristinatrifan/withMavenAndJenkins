package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("repositories")
public class ProjectConfigDb {

    @Bean
    //bean type is an abstraction/interface, the implementation is
    //mentioned in the method body
    public DataSource getDataSource() {
        var dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/demo");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }

    public JdbcTemplate jdbcTemplate() {//insert with Autowired in repo
        return new JdbcTemplate(getDataSource());
    }
}
