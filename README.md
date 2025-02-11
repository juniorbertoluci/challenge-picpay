# Challenge Picpay Repository
### Description
This app simulates a finance transaction between two people, that were registered before. 
The type of people can be 'COMMON' or 'MERCHANT'.
This application was developed in Java version 23 and is part of my portfolio.
### Requirements:
- It is not allowed to include more than one person with the same document or email.
- When people type is 'COMMON', they can do transactions for all person type, send or receive.
- When people type is 'MERCHANT', they can't send resources, only receive.
- Exist a validation to ensure that the people that send resources have balance for this.
- When a transaction is executed, is started a transaction validation in url: https://util.devi.tools/api/v2/authorize. This validation simulate a authorization for send resource.
### About the test
- The test for inserting person will be carried out by inserting three people, one as COMMON, another as MERCHANT and the last will be inserted to validate the first requirement condition.
- When we do the test to validate the transactions, we will perform five operations:
1 – When the sending of resources is carried out by a COMMON type person and the transaction is unauthorized
2 – When the sending of resources is carried out by a COMMON type person, the transaction is authorized and exist balance
3 – When the sending of resources is carried out by a COMMON type person, the transaction is authorized and not exist balance
4 – When the sending of resources is carried out by a MERCHANT type person
5 - When the person is not exist
### Instructions
#### Prerequisites
##### 1 - Java JDK 23
##### 2 - Apache Maven
##### 3 - RESTFull application tool
#### Setup
##### Clone, Clean, compile and create and execute the package 
###### 1.1 - git clone "https://github.com/juniorbertoluci/challenge-picpay"
###### 1.2 - cd challenge-picpay/picpaysimplificado
###### 2 - mvn clean
###### 3 - mvn install
###### 4 - mvn compiler:compile
###### 5 - mvn org.apache.maven.plugins:maven-compiler-plugin:compile
###### 6 - mvn org.apache.maven.plugins:maven-compiler-plugin:2.0.2:compile
###### 7 - java -jar target\picpaysimplificado-0.0.1-SNAPSHOT.jar
#### Testing the application
##### POST Users
###### url: "http://localhost:8080/users"
###### Example Body JSON (Data Obtained from "https://www.4devs.com.br/")
###### JSON 1:
###### {
######	"firstName": "Andre Pedro",
######  "lastName": "Santos",
######  "document": "43226220896",
######  "email": "andre.pedro.santos@renovacao.com.br",
######  "password": "password",
######  "balance": 100,
######  "userType": "COMMON"
###### }
###### Return JSON 1 from the example:
###### {
######  "id": 1,
######  "firstName": "Andre Pedro",
######  "lastName": "Santos",
######  "document": "43226220896",
######  "email": "andre.pedro.santos@renovacao.com.br",
######  "password": "password",
######  "balance": 100,
######  "userType": "COMMON"
###### }
###### JSON 2:
###### {
######  "firstName": "Carolina Heloisa",
######  "lastName": "Duarte",
######  "document": "34932979800",
######  "email": "carolina-duarte74@comunikapublicidade.com.br",
######  "password": "password",
######  "balance": 100,
######  "userType": "MERCHANT"
###### }
###### Return JSON 2 from the example:
###### {
######  "id": 2,
######  "firstName": "Carolina Heloisa",
######  "lastName": "Duarte",
######  "document": "34932979800",
######  "email": "carolina-duarte74@comunikapublicidade.com.br",
######  "password": "password",
######  "balance": 100,
######  "userType": "MERCHANT"
###### }
###### JSON 3:
###### {
######  "firstName": "Carolina Heloisa",
######  "lastName": "Duarte",
######  "document": "34932979800",
######  "email": "carolina-duarte74@comunikapublicidade.com.br",
######  "password": "password",
######  "balance": 100,
######  "userType": "MERCHANT"
###### }
###### Return JSON 3 from the example:
###### {
###### "message": "User already registered!",
###### "statusCode": "400"
###### }
##### GET Users
###### url: "http://localhost:8080/users"
###### Return JSON from the example:
###### {
######  "id": 1,
######  "firstName": "Andre Pedro",
######  "lastName": "Santos",
######  "document": "43226220896",
######  "email": "andre.pedro.santos@renovacao.com.br",
######  "password": "password",
######  "balance": 100,
######  "userType": "COMMON"
###### }
###### {
######  "id": 2,
######  "firstName": "Carolina Heloisa",
######  "lastName": "Duarte",
######  "document": "34932979800",
######  "email": "carolina-duarte74@comunikapublicidade.com.br",
######  "password": "password",
######  "balance": 100,
######  "userType": "MERCHANT"
###### }
##### POST Transactions
###### url: "http://localhost:8080/transactions"
###### Example Body JSON from the test 1:
###### Transaction Not authorized
###### {
######  "senderId": 1,
###### 	"receiverId": 2,
###### 	"value": 10
###### } 
###### Return JSON from the test 1:
###### {
###### "message": "Transaction Not authorized!",
###### "statusCode": "400"
###### }
###### Example Body JSON from the test 2:
###### Transaction is authorized and exist balance
###### {
######  "senderId": 1,
###### 	"receiverId": 2,
###### 	"value": 10
###### }
###### Return JSON from the test 2:
###### {
###### "id": 1,
###### "amount": 10,
###### "sender": {
###### "id": 1,
###### "firstName": "Andre Pedro",
###### "lastName": "Santos",
###### "document": "43226220896",
###### "email": "andre.pedro.santos@renovacao.com.br",
###### "password": "password",
###### "balance": 90.00,
###### "userType": "COMMON"
###### },
###### "receiver": {
###### "id": 2,
###### "firstName": "Carolina Heloisa",
###### "lastName": "Duarte",
###### "document": "34932979800",
###### "email": "carolina-duarte74@comunikapublicidade.com.br",
###### "password": "password",
###### "balance": 110.00,
###### "userType": "MERCHANT"
###### },
###### "timestamp": "2025-02-11T14:35:47.5069575"
###### }
###### Example Body JSON from the test 3:
###### Transaction is authorized and not exist balance
###### {
######  "senderId": 1,
###### 	"receiverId": 2,
###### 	"value": 100
###### }
###### Return JSON from the test 3:
###### {
###### "message": "User balance is not sufficient!",
###### "statusCode": "400"
###### }
###### Example Body JSON from the test 4:
###### Send transaction is carried out for MERCHANT people type 
###### {
######  "senderId": 2,
###### 	"receiverId": 1,
###### 	"value": 100
###### }
###### Return JSON from the test 4:
###### {
###### "message": "User not authorized to perform transaction!",
###### "statusCode": "400"
###### }
###### Example Body JSON from the test 5:
###### Send transaction is carried out for MERCHANT people type
###### {
######  "senderId": 3,
###### 	"receiverId": 1,
###### 	"value": 100
###### }
###### Return JSON from the test 5:
###### {
###### "message": "User not found!",
###### "statusCode": "400"
###### }

#### This is all for the time.
#### Thank you for visiting my portfolio.
#### See you, have a nice day.