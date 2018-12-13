# Introduction 
Create a simple Spring Boot web application with two pages **index.html** and **restricted.html**. To access the **restricted.html**.
the user must be authenticated. The application is configured in the WSO2 Identity Server as **Service Provider**. Facebook is 
configured as **Federated Identity Server** in the WSO2 Identity Server.

# Brief About Spring Boot (Skip this)
You can skip this step. This is only an informative section to give an insight of Spring Boot. We are using the following annotation in the application,
```
@org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso
```

To use this annotation, you must include the following maven dependency,
```
<dependency>
    <groupId>org.springframework.security.oauth.boot</groupId>
    <artifactId>spring-security-oauth2-autoconfigure</artifactId>
    <version>2.1.1.RELEASE</version>
</dependency>
```

When you use **@EnableOAuth2Sso** annotation, it's necessary to configure the following properties in **application.yaml** file,

```
security:
  basic:
    enabled: false
  oauth2:
    client:
      clientId: lVKMPDEnQw5wS5wVZ7EtMmV_o9ka
      clientSecret: wdN1ExXIDG8NUoefl4nV13B8uH4a
      scope:
        - openid
      accessTokenUri: http://local.idp:9763/oauth2/token
      userAuthorizationUri: http://local.idp:9763/oauth2/authorize
    resource:
      userInfoUri: http://local.idp:9763/oauth2/userinfo
```
But, how will you figure out these properties? So, here is a clue. 

Here is the location of the @EnableOAuth2Sso,

<p>
    <img src="https://github.com/anupamgogoi-wso2/wso2-summit/blob/master/sso-facebook/docs/EnableOAuth2Sso.png?raw=true" alt="Smiley face" height="400" width="700">
</p>

When **EnableOAuth2Sso** annotation is executed the following **Configuration** classes are executed,

## 1. OAuth2AutoConfiguration

<p>
    <img src="https://github.com/anupamgogoi-wso2/wso2-summit/blob/master/sso-facebook/docs/OAuth2AutoConfiguration.png?raw=true" height="400" width="700">
</p>

This configuration class wires the **OAuth2ClientProperties** bean which contains **clientId** and **clientSecret** properties.

![](https://github.com/anupamgogoi-wso2/wso2-summit/blob/master/sso-facebook/docs/OAuth2ClientProperties.png?raw=true)

## 2. OAuth2ProtectedResourceDetailsConfiguration

![](https://github.com/anupamgogoi-wso2/wso2-summit/blob/master/sso-facebook/docs/OAuth2ProtectedResourceDetailsConfiguration.png?raw=true)

Browse to the parent class of the underlined class and you will see these properties.

![](https://github.com/anupamgogoi-wso2/wso2-summit/blob/master/sso-facebook/docs/BaseOAuth2ProtectedResourceDetails.png?raw=true)


# Configure A Facebook Application

![](https://github.com/anupamgogoi-wso2/wso2-summit/blob/master/sso-facebook/docs/FacebookApp.png?raw=true)

# Configure Facebook as Identity Provider in WSO2 IS

![](https://github.com/anupamgogoi-wso2/wso2-summit/blob/master/sso-facebook/docs/ConfigureFacebookAsIDP.png?raw=true)

# Configure Spring Boot application as Service Provider in WSO2 IS

![](https://github.com/anupamgogoi-wso2/wso2-summit/blob/master/sso-facebook/docs/SP-Inbound.png?raw=true)

Detail configuration of the SP,

![](https://github.com/anupamgogoi-wso2/wso2-summit/blob/master/sso-facebook/docs/SP-Inbound-Detail.png?raw=true)

Outbound Authentication Configuration,

![](https://github.com/anupamgogoi-wso2/wso2-summit/blob/master/sso-facebook/docs/SP-Outbound.png?raw=true)

