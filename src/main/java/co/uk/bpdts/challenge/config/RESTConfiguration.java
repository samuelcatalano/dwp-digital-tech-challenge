package co.uk.bpdts.challenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Samuel Catalano
 * @since Jul 10, 2020
 */

@Configuration
public class RESTConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}