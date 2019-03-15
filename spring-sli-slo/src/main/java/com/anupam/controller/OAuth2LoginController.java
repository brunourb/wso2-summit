package com.anupam.controller;


import com.anupam.config.MyAuthRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class OAuth2LoginController {

    @Autowired
    MyAuthRequestRepository myAuthRequestRepository;

    @GetMapping("/me")
    public String index(Model model,
                        @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
                        @AuthenticationPrincipal OAuth2User oauth2User) {
        model.addAttribute("userName", oauth2User.getName());
        model.addAttribute("clientName", authorizedClient.getClientRegistration().getClientName());
        model.addAttribute("userAttributes", oauth2User.getAttributes());
        return "me.html";
    }

    @GetMapping("/exit")
    public void logout(@AuthenticationPrincipal OAuth2User oauth2User, HttpServletResponse httpServletResponse) throws Exception {
        String url = "http://local.idp:9763/oidc/logout?id_token_hint=" + ((DefaultOidcUser) oauth2User).getIdToken().getTokenValue()
                + "&post_logout_redirect_uri=" + "http://local.app:8081/login/oauth2/code/wso2"
                + "&state=" + myAuthRequestRepository.getSTATE();
        System.out.println(url);
        httpServletResponse.sendRedirect(url);
    }
}
