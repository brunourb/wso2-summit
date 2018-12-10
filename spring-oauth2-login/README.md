# System Configuration
The URLs,
```
Identity Server: https://local.idp:9443
Springboot Application: http://local.app:8081
```


Let's define hosts in **/etc/hosts** file (MacOS)
![](https://github.com/anupamgogoi-wso2/wso2-summit/blob/master/spring-oauth2-login/docs/hosts-config.png?raw=true)

# Create Springboot applicatin

Create a Springboot application with Web and Security modules using https://start.spring.io/
Once the project is downloaded, open the pom.xml in its root and add the following dependency,
```
<dependency>
     <groupId>org.springframework.security</groupId>
      <artifactId>spring-security-oauth2-jose</artifactId>
</dependency>
```
This module adds the OpenID Connect libraries etc.

# Implementation
SSO with WSO2 Identity Server can be implemented in the Springboot application either programmatically or by configuring certain properties in **application.yaml** (**application.properties**).

## Programmatic Approach
Create a class and annonate with @Configuration. E.g,
```
@Configuration
public class OAuth2LoginConfig {


    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {

        return new InMemoryClientRegistrationRepository(this.WSO2ClientRegistration());
    }

    private ClientRegistration WSO2ClientRegistration() {
        return ClientRegistration.withRegistrationId("wso2")
                .clientId("lVKMPDEnQw5wS5wVZ7EtMmV_o9ka")
                .clientSecret("wdN1ExXIDG8NUoefl4nV13B8uH4a")
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUriTemplate("{baseUrl}/login/oauth2/code/{registrationId}")
                .scope("openid", "profile", "email", "address", "phone")
                .authorizationUri("http://local.idp:9763/oauth2/authorize")
                .tokenUri("http://local.idp:9763/oauth2/token")
                .userInfoUri("http://local.idp:9763/oauth2/userinfo")
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .jwkSetUri("http://local.idp:9763/oauth2/jwks")
                .clientName("WSO2")
                .build();
    }
}
```
**clientId** and **clientSecret** are generated when you configure a Service Provider in IS.
You are done.

## Configuring application.yaml
Here is the same configuration fot the above approach in **application.yaml**
```
server:
  port: 8081

spring:
  security:
    oauth2:
      client:
        registration:
          wso2:
            clientId: lVKMPDEnQw5wS5wVZ7EtMmV_o9ka
            clientSecret: wdN1ExXIDG8NUoefl4nV13B8uH4a
            redirectUri: http://local.app:8081/login/oauth2/code/wso2
            authorizationGrantType: authorization_code
            scope:
              - openid
              - profile
        provider:
          wso2:
            authorizationUri: http://local.idp:9763/oauth2/authorize
            tokenUri: http://local.idp:9763/oauth2/token
            userInfoUri: http://local.idp:9763/oauth2/userinfo
            jwkSetUri: http://local.idp:9763/oauth2/jwks
            userNameAttribute: sub

```

# Running the application
Running the application straight forward. Either you can run the application from IDE or using maven.
```
mvn spring-boot:run
```
Once the application is up, it can be accessible at the following URl,
```
http://local.app:8081
```
# Identity Server Configuration
Here is a screen-shot,
![](https://github.com/anupamgogoi-wso2/wso2-summit/blob/master/spring-oauth2-login/docs/is-service-provider.png?raw=true)

The important part is CallbackUrl. For detail information, please read this [link](https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#oauth2login-sample-redirect-uri).

