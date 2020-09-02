package by.ceramogrand.processes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "by.ceramogrand.processes.service",
        "by.ceramogrand.processes.repository"
})
public class AppConfig {

}
