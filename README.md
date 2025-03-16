# MS 1 - rpcarteira -
This is a sample test of a first microservice (RPCARTEIRA) that will consume a second microservice via rest json. Access to the database happens in the second microservice (RPCADASTRO). This example was made with Spring Boot Java.
## Spring Boot - Maven
This project illustrates the structure generated in Spring Initializr, through the use of the Maven archetype and JDK17.


## Getting started

To run the project, you will need to install the following programs:
- [JDK 17: Required to run the Java project](https://download.oracle.com/java/17/archive/jdk-17_windows-x64_bin.exe)
- [Maven 3.9.6: Required to build the Java project](https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.6/apache-maven-3.9.6-bin.zip)
- Intellij or Eclipse: For project development.


## Development

To start development, you need to clone the GitHub project into a directory of your choice:
```shell
cd "directory of your preference"
git clone https://github.com/mpazin/rpcarteira
```


## Build

To build the project with Maven, run the commands below:
```shell
mvn clean install
```

The command will download all project dependencies and create a *target* directory with the built artifacts, which include the project jar file. Maven will display this information in the console.

## Features

This project is a sample of a service for orchestrating operations in a financial portfolio. Each selected operation communicates via REST with a second microservice, rpcadastro, which receives the data, executes the business rules, accesses the database and returns the information to this microservice, rpcarteira.
#### Available operations:
- Account and portfolio registration;
- Account balance query;
- Deposit of Amount into the Wallet;
- Withdrawal of Amount from Wallet;
- Transfer of Values between Wallets;
- Querying balance history by date;
- Custom exception messages.

## Configuration

To run the project, you need to use Intellij, so that it identifies the dependencies required for execution in the *Maven .m2 repository*. Once the project is imported, a *.classpath* file
will be created that will inform which is the main class for execution. The project must run locally and add the environment variable *SPRING_PROFILES_ACTIVE=local*. This microservice is 
already configured to run locally with *port 8090* in the *application.yaml* file. Calls to operations can be tested by postman - https://www.postman.com/downloads/

## Contact
- LinkedIn: https://www.linkedin.com/in/marcio-pazin-ab178523/
- e-mail: marciopazin@gmail.com


## License

Not apply
