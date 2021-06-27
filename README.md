
## Exercise 2

### To run native tests:
`mvn test -P native`

### To run web tests:
`mvn test -P web`

## Exercise 3

###  To run native tests Android:
1. Install app
2. Create file ./src/test/resources/token.properties
   ` token=YOUR_SECRET_TOKEN `
3. `mvn test -P cloudAndroidNative`

###  To run native tests iOS:
1. Install app
2. Create file ./src/test/resources/token.properties
       ` token=YOUR_SECRET_TOKEN `
3. `mvn test -P cloudIOsNative`

### To run web tests Android:
`mvn test -P cloudAndroidWeb`

### To run web tests iOS:
`mvn test -P cloudIOsWeb`