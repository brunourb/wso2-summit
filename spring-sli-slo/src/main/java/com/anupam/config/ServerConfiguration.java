package com.anupam.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@EnableWebSecurity
public class ServerConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @Autowired
    MyAuthRequestRepository myAuthRequestRepository;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .disable()
                .formLogin()
                .disable()
                .httpBasic()
                .disable()
                .authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .antMatchers("/me", "/exit")
                .authenticated()
                .and()
                .oauth2Login()
                .authorizationEndpoint()
                .authorizationRequestRepository(myAuthRequestRepository)
                .and()
                .redirectionEndpoint()
                .baseUri("/login/oauth2/code/*")
                .and()
                .successHandler(oAuth2AuthenticationSuccessHandler);


    }

    /**
     * OAuth2 authentication success handler class
     */
    @Component
    public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
        private String SESSION_STATE;

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
            this.SESSION_STATE = request.getParameter("session_state");
            SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
            System.out.println(savedRequest.getRedirectUrl());
            response.sendRedirect(savedRequest.getRedirectUrl());
        }

        public String getSESSION_STATE() {
            return SESSION_STATE;
        }
    }

}
