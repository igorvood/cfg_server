#!/bin/sh

mvn clean package

java -jar -Dspring.profiles.active=drop ./target/migration-sql-1.0.2.jar

java -jar -Dspring.profiles.active=reinst ./target/migration-sql-1.0.2.jar

java -jar -Dspring.profiles.active=test ./target/migration-sql-1.0.2.jar
