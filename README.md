# Issue Tracking System Backend

REST API for an issue tracker for a small team of developers.

## Tech Stack
* Java 8
* Spring Boot 2
* Gradle

## Setup Instructions
1. Clone the repository
   ```
   git clone https://github.com/mmafrar/issue-tracking-system-backend.git
   ```
2. Build the project
   ```
   ./gradlew clean assemble
   ```
3. Run the application
   ```
   java -jar build/libs/issue-tracking-system-backend-0.0.1-SNAPSHOT.jar
   ```
4. Accessing H2 console
   ```
   http://localhost:8080/h2-console
   ```

## Tables
Issue table (issue) and Developer table (developer) are created on start-up.

### Issue Table
![Issue Table](README/issue-table.png)

### Developer Table
![Developer Table](README/developer-table.png)
