# Introduction 
Create a simple Spring Boot web application with two pages **index.html** and **restricted.html**. To access the **restricted.html**.
the user must be authenticated. The application is configured in the WSO2 Identity Server as **Service Provider**. Facebook is 
configured as **Federated Identity Server** in the WSO2 Identity Server.

# Brief About Spring Boot
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

![](https://github.com/anupamgogoi-wso2/wso2-summit/blob/master/sso-facebook/docs/EnableOAuth2Sso.png?raw=true)

When **EnableOAuth2Sso** annotation is executed the following **Configuration** classes are executed,

## 1. OAuth2AutoConfiguration

![](https://github.com/anupamgogoi-wso2/wso2-summit/blob/master/sso-facebook/docs/OAuth2AutoConfiguration.png?raw=true)




