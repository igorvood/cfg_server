#!/bin/sh

## 1. Run the date command ##
mvn clean package > 1_compile.log

if [ $? -eq 0 ]
then
  echo "Success: Compile."
else
  echo "Failure: Compile" >&2
  exit 1
fi

java -jar -Dspring.profiles.active=drop ./target/migration-sql-1.0.2.jar > 2_drop.log

if [ $? -eq 0 ]
then
  echo "Success: drop."
else
  echo "Failure: drop" >&2
  exit 1
fi

java -jar -Dspring.profiles.active=reinst ./target/migration-sql-1.0.2.jar > 3_reinst.log

if [ $? -eq 0 ]
then
  echo "Success: reinst."
else
  echo "Failure: reinst" >&2
  exit 1
fi

java -jar -Dspring.profiles.active=test ./target/migration-sql-1.0.2.jar > 4_test.log

if [ $? -eq 0 ]
then
  echo "Success: test."
else
  echo "Failure: test" >&2
  exit 1
fi
