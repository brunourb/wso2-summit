# System Configuration
Let's define hosts in /etc/hosts file (MacOS)

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
