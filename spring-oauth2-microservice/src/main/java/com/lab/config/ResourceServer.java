package com.lab.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;

@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(new RequestHeaderRequestMatcher("Authorization"))
                .authorizeRequests().anyRequest().fullyAuthenticated();
    }
}
