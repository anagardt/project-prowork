package com.draganatasevska.finki.prowork.app;

import com.draganatasevska.finki.prowork.web.backend.security.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * Starts the ProWOrk application.
 */
@SpringBootApplication
@EnableJpaRepositories("com.draganatasevska.finki.prowork.web.backend.repository")
public class ProWorkApp {

    /**
     *
     * Main method that is executed.
     * @param args passing argument
     */
    public static void main(String[] args){
        SpringApplication.run(ProWorkApp.class, args);
    }
    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new JwtFilter());
        filterRegistrationBean.addUrlPatterns("/api/issue/*");
        filterRegistrationBean.addUrlPatterns("/api/user/*");
        filterRegistrationBean.addUrlPatterns("/api/comment/*");
        filterRegistrationBean.addUrlPatterns("/api/project/*");
        return filterRegistrationBean;
    }
}
