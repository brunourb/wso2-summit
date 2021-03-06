package com.anupam.config;

import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie repository.
 * Note: We are doing nothing here. You can get details of the Authorization request.
 */
@Component
public class MyAuthRequestRepository implements AuthorizationRequestRepository<OAuth2AuthorizationRequest> {
    OAuth2AuthorizationRequest oAuth2AuthorizationRequest;

    @Override
    public OAuth2AuthorizationRequest loadAuthorizationRequest(HttpServletRequest httpServletRequest) {
        return null;
    }

    @Override
    public void saveAuthorizationRequest(OAuth2AuthorizationRequest oAuth2AuthorizationRequest, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        this.oAuth2AuthorizationRequest = oAuth2AuthorizationRequest;
    }

    @Override
    public OAuth2AuthorizationRequest removeAuthorizationRequest(HttpServletRequest httpServletRequest) {
        return this.oAuth2AuthorizationRequest;
    }

}
