# crocodiles-restassured-tests

### Run Tests

#### Using `Maven`
```sh
mvn -Dtest.baseURI="https://test-api.k6.io" test
```

#### Using `org.testng.TestNG`
```sh
mvn package
java -Dtest.baseURI="https://test-api.k6.io" -cp target/test-classes:target/lib/* org.testng.TestNG -testclass api.test.restassured.ListPublicCrocodilesTests
java -Dtest.baseURI="https://test-api.k6.io" -cp target/test-classes:target/lib/* org.testng.TestNG testng.xml
```

#### Using `Maven Plugin`
```sh
mvn exec:exec
mvn exec:java
```

#### Using `App`
```sh
mvn package
java -cp target/classes/:target/lib/* api.test.restassured.App
```
