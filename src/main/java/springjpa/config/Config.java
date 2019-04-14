package springjpa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"springjpa.repository", "springjpa.service", "springjpa.ui"})
public class Config {


}
