# Introduction 
Create a simple Spring Boot web application with two pages **index.html** and **restricted.html**. To access the **restricted.html**.
the user must be authenticated. The application is configured in the WSO2 Identity Server as **Service Provider**. Facebook is 
configured as **Federated Identity Server** in the WSO2 Identity Server.

# Brief About Spring Boot
You can skip this step. This is only an informative section to give an insight of Spring Boot. We are using the following annotation in the applicagion,
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
