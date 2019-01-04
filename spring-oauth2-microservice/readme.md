
# Introduction
A demo spring boot application to show how to access resources protected by OAuth2. The OAuth2 server used in the demo is WSO2 Identity Server

# Resource Owner Password Credentials
![](https://github.com/anupamgogoi-wso2/wso2-summit/blob/master/spring-oauth2-microservice/docs/password-grant-type.png?raw=true)

"Resource Owner Password Credentials flow has the following requirements:

The client must be highly trusted, as it directly handles user credentials. In most cases, the client should be a first-party app.
The flow includes the following steps:

1. The **client** prompts **user** to enter their credentials (for instance, a username/password combination).
2. The **client** sends the credentials and its own identification to the **authorization server**. The **authorization server** validates the information, then returns an access token and optionally a refresh token.
3. The **client** uses the access token to access resources on the **resource server**."
For details please go through this [page](https://medium.com/google-cloud/understanding-oauth2-and-building-a-basic-authorization-server-of-your-own-a-beginners-guide-cf7451a16f66).

# Building The Application
Navigate to the root of the application (.pom) file and execute 
```
mvn clean install
```

# Running The Application
To run the application, you will need to provide the SSL certificate of the WSO2 Identity server. Use the following command,
```
java  -Djavax.net.ssl.trustStore=/Users/anupamgogoi/softwares/wso2/is/wso2is-5.7.0/repository/resources/security/client-truststore.jks \
-Djavax.net.ssl.trustStorePassword=wso2carbon \
-jar /Users/anupamgogoi/git/wso2-summit/spring-oauth2-microservice/target/spring-oauth2-microservice-1.0.0.jar
```
Remember to change the paths

# Protected Resource
We have a single OAuth2 protected resource in the demo application,
```
GET /app/products
```
To access the resource, we must provide the Bearer token in the Authorization header of the request. The Bearer token is generated using the WSO2 Identity Server.

# Configure WSO2 Identity Server

# Generate Access Token
After generating the clientId & clientSecret in IS, use them to get the access token as shown below,
```
curl -u <CLIENT_ID>:<CLIENT_SECRET> -k \
-d "grant_type=password&username=admin&password=admin" -H "Content-Type:application/x-www-form-urlencoded" \
https://localhost:9443/oauth2/token
```

# Make Request With Access Token
Once access token is in hand from the previous step, send it in the Authorization header as shown below,
```
curl -k http://localhost:8080/app/products -H "Authorization: Bearer 87a315a7-0819-3747-817f-dc057d2b1a1c"
```
You should get a list of products.
