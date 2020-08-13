# Integration Testing

## Problem Statement

A good unit test isolates the code that it tests from dependencies on outside resources. This is desirable because it usually makes the test more reliable and also easier to debug when it fails. However, interactions with outside resources are a potential source of bugs and bad assumptions and should definitely be tested. In fact, there are classes whose primary function is to interact with outside resources. Data Access Objects are an example of this. In order to validate that a DAO is functioning correctly, we really need to test it against a database. This is an example of an "integration test".

## Objectives
* What is an Integration Test?
* DAO Integration Testing

## Notes and Examples

### What is an Integration Test?

<div class="definition note">

**Integration Testing** is a broad category of tests that validate the integration between units of code or code and outside dependencies such as databases or network resources.

</div>

- **Integration tests:**
    - Use the same tools as unit tests (i.e. JUnit or MSTest)
    - Usually slower than unit tests (but often still measured in ms)
    - More complex to write and debug
    - Can have dependencies on outside resources like files or a database

### DAO Integration Testing

- Since DAOs exist solely for the purpose of interacting with a database, they are often best tested using an integration test

- **Tests (including integration tests) should be:**
    - *Repeatable:* If the test passes/fails on first execution, it should pass/fail on second execution if no code has changed.
    - *Independent:* A test should be able to be run on it's own, independently of other tests, OR together with other tests and have the same result either way.
    - *Obvious:* When a test fails, it should be as obvious as possible why it failed.

- **Approaches for Managing Test Data**

    - ***Remotely Hosted Shared Test Database***
        
        *An RDBMS is installed on a remote server and shared by all developers on the team for testing.* 
        
        - *Advantages:*
            - Easy setup, often already exists
            - Production-like software and (possibly) hardware
        - *Disadvantages:*
            - Unreliable and brittle
            - Lack of test isolation
            - Temptation to rely on existing data (which can change)
    
    - ***Locally Hosted Test Databse***

        *An RDBMS is installed and hosted locally on each developer's machine. (This is the approach we will use)*

        - *Advantages:*
            - Production-like software
            - Reliable (local control)
            - Isolation
        - *Disadvantages:*
            - Requires local hardware resources
            - RDBMS needs to be installed and managed

    - ***Embedded, In-memory Database***

        *An in-memory, embedded database server is started and managed by test code while running integration tests.*

        - *Advantages:*
            - Very reliable
            - Consistent across development machines (managed by source control)
            - Lightweight
        - *Disadvantages:*
            - Not the same software used in production
            - Cannot use proprietary features of production RDBMS
   
## Code

The point of our unit tests against a database will be to:
* Ensure that our DAL code functions correctly
    * We test our SELECT statements by inserting dummy data before the test
    * We test our INSERT statements by searching for the data
    * We test our UPDATE statements by verifying dummy data changed or that rowsaffected = expectedResult
    * We test our DELETE statements by seeing if dummy data is missing or that rowsAffected = expectedResult

This involves the process of using the DAL class along with some SQL statements to "mock" the data.

To do this, we need to restore our database to its original state so that no data is permanently modified.

We can create a **Transaction Scope** object so that we don't make any permanent changes to our database. This can be created before the tests run and rolled back after the tests complete.

