# RAG Demo

A Java 17, Spring Boot REST demo that answers questions using the company policy
document in `ragdemo-core/src/main/resources/docs/company-policy.txt`. The
service sends the document and question to an OpenAI chat model through
LangChain4j.

## Project structure

- `ragdemo-parent/` - Maven parent and reactor aggregator.
- `ragdemo-core/` - Spring Boot application, chat endpoint, and policy document.

## Requirements

- Java 17
- Maven
- An OpenAI API key to use the chat endpoint

## Run the application

From the repository root, set the API key in PowerShell and start the core
module:

```powershell
$env:OPENAI_API_KEY = "your-api-key"
mvn -f .\ragdemo-parent\pom.xml -pl com.nan:ragdemo-core spring-boot:run
```

The application starts on `http://localhost:8080`. Ask a question with:

```text
GET http://localhost:8080/chat?question=What%20is%20the%20annual%20leave%20entitlement%3F
```

The endpoint requires a `question` query parameter. The API key is needed when
calling the endpoint, not for running the tests.

## Run tests

From the repository root, run the Maven test lifecycle for the reactor:

```powershell
mvn -f .\ragdemo-parent\pom.xml test
```

This runs the JUnit tests in `ragdemo-core`.