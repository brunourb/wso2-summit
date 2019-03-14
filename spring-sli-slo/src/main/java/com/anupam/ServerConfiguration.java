package com.anupam;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
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
                    .antMatchers("/me")
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
        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
            SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
            System.out.println(savedRequest.getRedirectUrl());
            response.sendRedirect(savedRequest.getRedirectUrl());
        }

    }

    /**
     * Cookie repository.
     * Note: We are doing nothing here. You can get details of the Authorization request.
     */
    @Component
    public class MyAuthRequestRepository implements AuthorizationRequestRepository<OAuth2AuthorizationRequest> {
        OAuth2AuthorizationRequest oAuth2AuthorizationRequest;
        @Override
        public OAuth2AuthorizationRequest loadAuthorizationRequest(HttpServletRequest httpServletRequest) {
            System.out.println();
            return null;
        }

        @Override
        public void saveAuthorizationRequest(OAuth2AuthorizationRequest oAuth2AuthorizationRequest, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
            this.oAuth2AuthorizationRequest=oAuth2AuthorizationRequest;
            System.out.println();
        }

        @Override
        public OAuth2AuthorizationRequest removeAuthorizationRequest(HttpServletRequest httpServletRequest) {
            System.out.println();
            return this.oAuth2AuthorizationRequest;
        }
    }
}
