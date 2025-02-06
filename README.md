# Challenge Picpay
## Description
This app simulates a finance transaction between two people, that were registered before.
The type people can be 'COMMON' or 'MERCHANT'.
Both can receive resources, 'MERCHANT' can't send resources and 'COMMON' can send resources.
This app was develop to create a portfolio, and was develop with Java in the version 21.
## Instructions
### Prerequisites
#### 1 - Java JDK 21
#### 2 - Apache Maven
#### 3 - RESTFull APP
### Setup
#### Clone, Clean, compile and create and execute the package 
##### 1.1 - git clone https://github.com/juniorbertoluci/challenge-picpay
##### 1.2 - cd challenge-picpay/picpaysimplificado
##### 2 - mvn clean
##### 3 - mvn install
##### 4 - mvn compiler:compile
##### 5 - mvn org.apache.maven.plugins:maven-compiler-plugin:compile
##### 6 - mvn org.apache.maven.plugins:maven-compiler-plugin:2.0.2:compile
##### 7 - java -jar target\picpaysimplificado-0.0.1-SNAPSHOT.jar
### Use REST-API