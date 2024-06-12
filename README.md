# crocodiles-restassured-tests

### Run Tests

#### Using `Maven`
```sh
mvn test
```

#### Using `org.testng.TestNG`
```sh
mvn package
java -cp target/test-classes:target/lib/* org.testng.TestNG -testclass api.test.restassured.ListPublicCrocodilesTests
java -cp target/test-classes:target/lib/* org.testng.TestNG testng.xml
```

#### Using `Maven`
```sh
mvn exec:java
```