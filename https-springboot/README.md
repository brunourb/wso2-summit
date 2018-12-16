# Generate Keystore
```
keytool -genkey -keystore keystore.jks -keyalg RSA -storetype PKCS12 -alias demo
```
# Export public certificate
```
keytool -export -file temp.crt -alias demo -keystore keystore.jks
```
